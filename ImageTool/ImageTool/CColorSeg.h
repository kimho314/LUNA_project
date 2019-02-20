#pragma once
#include "Dib.h"
#include "RGBBYTE.H"

class CColorSeg
{
public:
	CColorSeg();
	~CColorSeg();

	// 0 : left-top x , 1 : left-top y, 2 : right-down x, 3 : right-down y
	int m_RectPoints[4];
	void SetRectPoints(int left_top_x, int left_top_y, int right_down_x, int right_down_y);
	int* GetRectPoints();
	double m_MeanVals[3]; // r,g,b
	double m_DeviationVals[3]; // r,g,b
	void GetMean(CDib *src);	
	void GetDeviation(CDib *src);
	void ImplementColorSegmentation(CDib *dst, CDib *src);
};


