#include "stdafx.h"
#include "CColorSeg.h"


CColorSeg::CColorSeg()
{
	memset(m_RectPoints, 0, sizeof(m_RectPoints));
}


CColorSeg::~CColorSeg()
{
}


void CColorSeg::SetRectPoints(int left_top_x, int left_top_y, int right_down_x, int right_down_y)
{
	// TODO: Add your implementation code here.
	m_RectPoints[0] = left_top_x;
	m_RectPoints[1] = left_top_y;
	m_RectPoints[2] = right_down_x;
	m_RectPoints[3] = right_down_y;
}


int* CColorSeg::GetRectPoints()
{
	// TODO: Add your implementation code here.
	return m_RectPoints;
}



void CColorSeg::GetMean(CDib *src)
{
	// TODO: Add your implementation code here.
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	RGBBYTE **src_ptr = src->GetRGBPtr();
	int cnt = 0;

	for (int j = m_RectPoints[1]; j < m_RectPoints[3]; j++)
	{
		for (int i = m_RectPoints[0]; i < m_RectPoints[2]; i++)
		{
			m_MeanVals[0] += src_ptr[j][i].r;
			m_MeanVals[1] += src_ptr[j][i].g;
			m_MeanVals[2] += src_ptr[j][i].b;
			cnt++;
		}
	}

	m_MeanVals[0] /= cnt;
	m_MeanVals[1] /= cnt;
	m_MeanVals[2] /= cnt;
}



void CColorSeg::GetDeviation(CDib *src)
{
	// TODO: Add your implementation code here.
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	RGBBYTE **src_ptr = src->GetRGBPtr();	

	for (int j = m_RectPoints[1]; j < m_RectPoints[3]; j++)
	{
		for (int i = m_RectPoints[0]; i < m_RectPoints[2]; i++)
		{
			m_DeviationVals[0] += pow((src_ptr[j][i].r - m_MeanVals[0]), 2);
			m_DeviationVals[1] += pow((src_ptr[j][i].g - m_MeanVals[1]), 2);
			m_DeviationVals[2] += pow((src_ptr[j][i].b - m_MeanVals[2]), 2);
		}
	}

	m_DeviationVals[0] = sqrt(m_DeviationVals[0]);
	m_DeviationVals[1] = sqrt(m_DeviationVals[1]);
	m_DeviationVals[2] = sqrt(m_DeviationVals[2]);
}


void CColorSeg::ImplementColorSegmentation(CDib *dst, CDib *src)
{
	// TODO: Add your implementation code here.
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	RGBBYTE **src_ptr = src->GetRGBPtr();
	RGBBYTE **dst_ptr = dst->GetRGBPtr();
	

	GetMean(src);
	GetDeviation(src);

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			if ((src_ptr[j][i].r >= (m_MeanVals[0] - (1.25 *m_DeviationVals[0]))) &&
				(src_ptr[j][i].r <= (m_MeanVals[0] + (1.25 *m_DeviationVals[0]))))
			{
				dst_ptr[j][i].r = 255;
			}
			else
			{
				dst_ptr[j][i].r = 0;
			}

			if ((src_ptr[j][i].g >= (m_MeanVals[1] - (1.25 *m_DeviationVals[1]))) &&
				(src_ptr[j][i].g <= (m_MeanVals[1] + (1.25 *m_DeviationVals[1]))))
			{
				dst_ptr[j][i].g = 255;
			}
			else
			{
				dst_ptr[j][i].g = 0;
			}

			if ((src_ptr[j][i].b >= (m_MeanVals[2] - (1.25 *m_DeviationVals[2]))) &&
				(src_ptr[j][i].b <= (m_MeanVals[2] + (1.25 *m_DeviationVals[2]))))
			{
				dst_ptr[j][i].b = 255;
			}
			else
			{
				dst_ptr[j][i].b = 0;
			}
		}
	}
}
