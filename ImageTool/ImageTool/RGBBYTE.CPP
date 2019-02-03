//////////////////////////////////////////////////////////////////////
//                                                                  //
// RGBBYTE.cpp: implementation of the RGBBYTE class.                //
//                                                                  //
// Copyright (c) 2003~<current> Sun-Kyoo Hwang                      //
//             http://vision.hanyang.ac.kr/~kkokkal/                //
//             kkokkal@vision.hanayng.ac.kr                         //
//                                                                  //
// Last modified: Dec. 05, 2004                                     //
//                                                                  //
//////////////////////////////////////////////////////////////////////

#include "stdafx.h"
#include "Dib.h"
#include "RGBBYTE.h"

#ifdef _DEBUG
#undef THIS_FILE
static char THIS_FILE[]=__FILE__;
#define new DEBUG_NEW
#endif

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

RGBBYTE::RGBBYTE(const BYTE& pixel) : r(pixel), g(pixel), b(pixel)
{
}

RGBBYTE::RGBBYTE(const BYTE& _r, const BYTE& _g, const BYTE& _b) 
: r(_r), g(_g), b(_b)
{
}

RGBBYTE::RGBBYTE(const COLORREF& pixel) 
{
	r = (BYTE)(pixel);                  // GetRValue(pixel);
	g = (BYTE)((WORD)(pixel) >> 8);     // GetGValue(pixel);
	b = (BYTE)((pixel)>>16);            // GetBValue(pixel);
}

RGBBYTE::RGBBYTE(const RGBBYTE& pixel) : r(pixel.r), g(pixel.g), b(pixel.b)
{
}

RGBBYTE::~RGBBYTE()
{
}

//////////////////////////////////////////////////////////////////////
// Operator overloading
//////////////////////////////////////////////////////////////////////

//-------------------------------------------------------------------------
// 치환 연산자
//-------------------------------------------------------------------------

RGBBYTE& RGBBYTE::operator=(const RGBBYTE& pixel)
{
	if( this == &pixel )
		return *this;

	this->r = pixel.r;
	this->g = pixel.g;
	this->b = pixel.b;

	return *this;
}

RGBBYTE& RGBBYTE::operator=(const COLORREF& pixel)
{
	r = (BYTE)(pixel);                  // GetRValue(pixel);
	g = (BYTE)((WORD)(pixel) >> 8);     // GetGValue(pixel);
	b = (BYTE)((pixel)>>16);            // GetBValue(pixel);

	return *this;
}

RGBBYTE& RGBBYTE::operator=(const BYTE& pixel)
{
	r = pixel;
	g = pixel;
	b = pixel;
	
	return *this;
}

//-------------------------------------------------------------------------
// 관계 연산자
//-------------------------------------------------------------------------

int RGBBYTE::operator==(const RGBBYTE& pixel)
{
	if( r == pixel.r && g == pixel.g && b == pixel.b ) return 1;
	else return 0;
}

int RGBBYTE::operator!=(const RGBBYTE& pixel)
{
	if( r != pixel.r || g != pixel.g || b != pixel.b ) return 1;
	else return 0;
}

