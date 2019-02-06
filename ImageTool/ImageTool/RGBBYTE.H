//////////////////////////////////////////////////////////////////////
//                                                                  //
// RGBBYTE.h: interface for the RGBBYTE class.                      //
//                                                                  //
// Copyright (c) 2003~<current> Sun-Kyoo Hwang                      //
//             http://vision.hanyang.ac.kr/~kkokkal/                //
//             kkokkal@vision.hanayng.ac.kr                         //
//                                                                  //
// Last modified: Dec. 05, 2004                                     //
//                                                                  //
//////////////////////////////////////////////////////////////////////

#pragma once

class RGBBYTE  
{
//-----------------------------------------------------------------------------
// ��� ���� ����
//-----------------------------------------------------------------------------

public:
	BYTE b;
	BYTE g;
	BYTE r;

//-----------------------------------------------------------------------------
// ��� �Լ� ����
//-----------------------------------------------------------------------------

public:
	RGBBYTE(const BYTE& pixel = 0);     // �⺻ ������
	RGBBYTE(const BYTE& _r, const BYTE& _g, const BYTE& _b);
	RGBBYTE(const COLORREF& pixel);     
	RGBBYTE(const RGBBYTE& pixel);      // ���� ������
	~RGBBYTE();							// �Ҹ���

public:
	RGBBYTE&    operator=(const RGBBYTE& pixel);
	RGBBYTE&    operator=(const COLORREF& pixel);
	RGBBYTE&    operator=(const BYTE& pixel);

	int         operator==(const RGBBYTE& pixel);
	int         operator!=(const RGBBYTE& pixel);
};
