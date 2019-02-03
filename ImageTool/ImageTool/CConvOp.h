#pragma once

#include "Dib.h"

class CConvOp
{
public:
	CConvOp();
	~CConvOp();
	void Convolution(CDib *dst, CDib *src, double **kernel, int kernel_size, int padding_op = ZERO, int scale_op = 0);	
	void ReplicatePadFunc(CDib *dst, CDib *src, int kernel_size);
	void MirrorPadFunc(CDib *dst, CDib *src, int kernel_size);

	enum PaddingOp
	{
		ZERO,
		MIRROR,
		REPLICATE,
	};
	void ScaleImageValue(CDib *dst, double **src);
};

