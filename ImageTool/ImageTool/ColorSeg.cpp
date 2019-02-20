#include "stdafx.h"
#include "ColorSeg.h"

int g_lt_x = 0;
int g_lt_y = 0;
int g_rd_x = 0;
int g_rd_y = 0;

void SetRectPoints(int left_top_x, int left_top_y, int right_down_x, int right_down_y)
{
	g_lt_x = left_top_x;
	g_lt_y = left_top_y;
	g_rd_x = right_down_x;
	g_rd_y = right_down_y;
}

void GetMean(CDib *src, bounding_box *bb)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	RGBBYTE **src_ptr = src->GetRGBPtr();
	int cnt = 0;

	for (int j = g_lt_y; j < g_rd_y; j++)
	{
		for (int i = g_lt_x; i < g_rd_x; i++)
		{
			bb->mean_r += src_ptr[j][i].r;
			bb->mean_g += src_ptr[j][i].g;
			bb->mean_b += src_ptr[j][i].b;
			cnt++;
		}
	}

	bb->mean_r /= cnt;
	bb->mean_g /= cnt;
	bb->mean_b /= cnt;
}

void GetDeviation(CDib *src, bounding_box *bb)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	RGBBYTE **src_ptr = src->GetRGBPtr();
	int cnt = 0;

	for (int j = g_lt_y; j < g_rd_y; j++)
	{
		for (int i = g_lt_x; i < g_rd_x; i++)
		{
			bb->devia_r += pow(((double)src_ptr[j][i].r - bb->mean_r), 2);
			bb->devia_g += pow(((double)src_ptr[j][i].g - bb->mean_g), 2);
			bb->devia_b += pow(((double)src_ptr[j][i].b - bb->mean_b), 2);
			cnt++;
		}
	}

	bb->devia_r = sqrt(bb->devia_r / (double)cnt);
	bb->devia_g = sqrt(bb->devia_g / (double)cnt);
	bb->devia_b = sqrt(bb->devia_b / (double)cnt);
}

void ImplementColorSegmentation(CDib *dst, CDib *src, bounding_box *bb)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	RGBBYTE **src_ptr = src->GetRGBPtr();
	RGBBYTE **dst_ptr = dst->GetRGBPtr();

	GetMean(src, bb);
	GetDeviation(src, bb);

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			if ((src_ptr[j][i].r >= (bb->mean_r - (1.25 * bb->devia_r))) &&
				(src_ptr[j][i].r <= (bb->mean_r + (1.25 * bb->devia_r))) &&
				(src_ptr[j][i].g >= (bb->mean_g - (1.25 * bb->devia_g))) &&
				(src_ptr[j][i].g <= (bb->mean_g + (1.25 * bb->devia_g))) &&
				(src_ptr[j][i].b >= (bb->mean_b - (1.25 * bb->devia_b))) &&
				(src_ptr[j][i].b <= (bb->mean_b + (1.25 * bb->devia_b))))
			{
				dst_ptr[j][i].r = 255;
				dst_ptr[j][i].g = 255;
				dst_ptr[j][i].b = 255;
			}			
			else
			{
				dst_ptr[j][i].r = 0;
				dst_ptr[j][i].g = 0;
				dst_ptr[j][i].b = 0;
			}
			
		}
	}
}