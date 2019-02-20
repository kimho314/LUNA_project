#pragma once

#include "Dib.h"
#include "RGBBYTE.H"
#include <math.h>


typedef struct
{
	double mean_r = 0.0;
	double mean_g = 0.0;
	double mean_b = 0.0;
	double devia_r = 0.0;
	double devia_g = 0.0;
	double devia_b = 0.0;
} bounding_box;

void SetRectPoints(int left_top_x, int left_top_y, int right_down_x, int right_down_y);
void GetMean(CDib *src, bounding_box *bb);
void GetDeviation(CDib *src, bounding_box *bb);
void ImplementColorSegmentation(CDib *dst, CDib *src, bounding_box *bb);