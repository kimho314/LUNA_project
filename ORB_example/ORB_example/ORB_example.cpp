// ORB_example.cpp: 콘솔 응용 프로그램의 진입점을 정의합니다.
//

#include "stdafx.h"
#include <iostream>
#include <fstream>
#include <string>
#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/opencv.hpp>
#include "opencv2/features2d/features2d.hpp"
#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/calib3d/calib3d.hpp"
#include <opencv2/xfeatures2d.hpp>
#include <opencv2/xfeatures2d/nonfree.hpp>

using namespace std;
using namespace cv;
using namespace cv::xfeatures2d;

int main()
{
	Mat objectImg;
	double ratio = 0.6;
	char escapeKey = 'a';

	objectImg = imread("컴퓨터 비전 프로그래밍_로버트 라가니에.jpg", CV_LOAD_IMAGE_GRAYSCALE);
	if (!objectImg.data)
	{
		cout << "can't open image";
		return -1;
	}

	namedWindow("ORB output", WINDOW_AUTOSIZE);

	vector<KeyPoint> keypoint_obj, keypoint_scene;
	Mat descriptor_obj, descriptor_scene;

	Ptr<ORB> orb = ORB::create();
	orb->detect(objectImg, keypoint_obj);
	orb->compute(objectImg, keypoint_obj, descriptor_obj);
	//drawKeypoints(objectImg, keypoint_obj, objectImg, Scalar(0,255,255));

	unsigned int thresholdGoodMatches = 4;

	VideoCapture cap(0);
	if (!cap.isOpened())
	{
		cout << "Couldn't open camera" << endl;
		return -1;
	}

	while (escapeKey != 'q')
	{
		Mat frame;
		Mat sceneImg(objectImg.size(), objectImg.type());		
		cap >> frame;
		cvtColor(frame, sceneImg, CV_RGB2GRAY);

		orb->detect(sceneImg, keypoint_scene);
		orb->compute(sceneImg, keypoint_scene, descriptor_scene);

		BFMatcher matcher;
		vector<vector<DMatch>> matches;
		vector<DMatch> good_matches;
		Mat img_matches;

		matcher.knnMatch(descriptor_obj, descriptor_scene, matches, 2);

		for (int i = 0; i < min(descriptor_scene.rows - 1, (int)matches.size()); i++)
		{
			if ((matches[i][0].distance < ratio * matches[i][1].distance) && ((int)matches[i].size() <= 2 && (int)matches[i].size() > 0))
			{
				good_matches.push_back(matches[i][0]);
			}
		}

		drawMatches(objectImg, keypoint_obj, sceneImg, keypoint_scene, good_matches, img_matches, Scalar(255, 0, 0), Scalar(255, 0, 0), vector<char>(), DrawMatchesFlags::NOT_DRAW_SINGLE_POINTS);

		if (good_matches.size() >= thresholdGoodMatches)
		{
			putText(img_matches, "Object Found", cvPoint(10, 50), FONT_HERSHEY_COMPLEX_SMALL, 2, cvScalar(0, 0, 250), 1, CV_AA);
		}

		imshow("ORB output", img_matches);
		escapeKey = cvWaitKey(1);
	}
	
	cap.release();
    return 0;
}

