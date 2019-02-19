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

