#pragma once
class CColorSeg
{
public:
	CColorSeg();
	~CColorSeg();

	// 0 : left-top x , 1 : left-top y, 2 : right-down x, 3 : right-down y
	int m_RectPoints[4];
	void SetRectPoints(int left_top_x, int left_top_y, int right_down_x, int right_down_y);
	int* GetRectPoints();
};


