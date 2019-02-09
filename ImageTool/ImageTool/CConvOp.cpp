#include "stdafx.h"
#include "CConvOp.h"
#include "ImageTool.h"


CConvOp::CConvOp()
{
}


CConvOp::~CConvOp()
{
}


void CConvOp::Convolution(CDib *dst, CDib *src, double **kernel, int kernel_size, int padding_op, int scale_op)
{
	// TODO: Add your implementation code here.
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	int dst_w = src_w + (kernel_size - 1);
	int dst_h = src_h + (kernel_size - 1);	
	int half_ker_size = (kernel_size - 1) / 2; 

	dst->CreateGrayImage(src_w, src_h, 0);
	dst->Copy(src);
	BYTE** src_ptr = src->GetPtr();
	BYTE** dst_ptr = dst->GetPtr();

	CDib tmp_dib;
	tmp_dib.CreateGrayImage(dst_w, dst_h, 0);
	BYTE** tmp_ptr = tmp_dib.GetPtr();
	

	// create full padded image
	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			int py = j + half_ker_size;
			int px = i + half_ker_size;
			tmp_ptr[py][px] = src_ptr[j][i];
		}
	}
	

	// padding
	if (padding_op == MIRROR)
	{		
		MirrorPadFunc(&tmp_dib, src, kernel_size);
	}
	else if (padding_op == REPLICATE)
	{		
		ReplicatePadFunc(&tmp_dib, src, kernel_size);
	}

	double **sum_arr = nullptr;
	sum_arr = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		sum_arr[i] = new double[dst_w];
	

	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			sum_arr[j][i] = 0.0f;			
		}
	}		
	


	// operate convolution
	for (int j = half_ker_size; j < src_h + half_ker_size; j++)
	{
		for (int i = half_ker_size; i < src_w + half_ker_size; i++)
		{
			double sum = 0.0f;
			
			for (int s = -half_ker_size; s <= half_ker_size; s++)
			{
				for (int t = -half_ker_size; t <= half_ker_size; t++)
				{
					sum += kernel[s + half_ker_size][t + half_ker_size] * tmp_ptr[j - s][i - t];
				}
			}	
			

			if (scale_op == 1)
			{
				sum_arr[j][i] = sum;
			}

			if (sum < 0.0)
				sum = 0.0;
			if (sum > 255.0)
				sum = 255.0;
			
			dst_ptr[j - half_ker_size][i - half_ker_size] = sum;
		}
	}		
	
	// scaling values over range [0,255]
	if (scale_op == 1)
	{
		CDib tmp_dib2;		
		tmp_dib2.CreateGrayImage(src_w, src_h);
		ScaleImageValue(&tmp_dib2, sum_arr);		

		AfxNewImage(tmp_dib2);		
	}

	for (int i = 0; i < dst_h; i++)
	{
		delete(sum_arr[i]);		
	}	
	delete(sum_arr);	
}

void CConvOp::ReplicatePadFunc(CDib *dst, CDib *src, int kernel_size)
{
	// TODO: Add your implementation code here.
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	BYTE** src_ptr = src->GetPtr();
	int dst_w = dst->GetWidth();
	int dst_h = dst->GetHeight();
	BYTE** dst_ptr = dst->GetPtr();

	int a = (kernel_size - 1) / 2;
	int b = (kernel_size - 1) / 2;

	for (int j = 0; j < a; j++)
	{
		// 1 region
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a - 1 - j][b - 1 - i] = dst_ptr[a][b];
		}

		// 3 region
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a - 1 - j][b + src_w + i] = dst_ptr[a][b + src_w - 1];
		}

		// 6 region
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a + src_h + j][b -1 - i] = dst_ptr[a + src_h - 1][b];
		}

		// 8 region
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a + src_h + j][b + src_w + i] = dst_ptr[a + src_h - 1][b + src_w - 1];
		}				
	}

	// 2 region
	for (int j = 0; j < a; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			dst_ptr[a - 1 - j][b + i] = dst_ptr[a][b + i];
		}
	}

	// 4 region
	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a + j][b - 1 - i] = dst_ptr[a + j][b];
		}
	}

	// 5 region
	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a + j][b + src_w + i] = dst_ptr[a + j][b + src_w - 1];
		}
	}

	// 7 region
	for (int j = 0; j < a; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			dst_ptr[a + src_h + j][b + i] = dst_ptr[a + src_h - 1][b + i];
		}
	}
}


void CConvOp::MirrorPadFunc(CDib *dst, CDib *src, int kernel_size)
{
	// TODO: Add your implementation code here.
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	BYTE** src_ptr = src->GetPtr();
	int dst_w = dst->GetWidth();
	int dst_h = dst->GetHeight();
	BYTE** dst_ptr = dst->GetPtr();

	int a = (kernel_size - 1) / 2;
	int b = (kernel_size - 1) / 2;

	for (int j = 0; j < a; j++)
	{
		// 1 region
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a - 1 - j][b - 1 - i] = dst_ptr[a + j][b + i];
		}

		// 3 region
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a - 1 - j][b + src_w + i] = dst_ptr[a + j][b + src_w - 1 - i];
		}

		// 6 region
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a + src_h + j][b - 1 - i] = dst_ptr[a + src_h - 1 - j][b + i];
		}

		// 8 region
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a + src_h + j][b + src_w + i] = dst_ptr[a + src_h - 1 - j][b + src_w - 1 - i];
		}

		
	}

	// 2 region
	for (int j = 0; j < a; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			dst_ptr[a - 1 - j][b + i] = dst_ptr[a + j][b + i];
		}
	}

	// 4 region
	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a + j][b - 1 - i] = dst_ptr[a + j][b];
		}
	}

	// 5 region
	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < b; i++)
		{
			dst_ptr[a + j][b + src_w + i] = dst_ptr[a + j][b + src_w - 1];
		}
	}

	// 7 region
	for (int j = 0; j < a; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			dst_ptr[a + src_h + j][b + i] = dst_ptr[a + src_h - 1][b + i];
		}
	}
}


void CConvOp::ScaleImageValue(CDib *dst, double **src)
{
	// TODO: Add your implementation code here.
	const int k = 255;	
	int dst_w = dst->GetWidth();
	int dst_h = dst->GetHeight();
	BYTE** dst_ptr = dst->GetPtr();

	double min_val = 0.0f; // minimum value from image
	double max_val = 0.0f; // maximum value from g_m

	double** gm_arr = nullptr;
	gm_arr = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		gm_arr[i] = new double[dst_w];

	double ** gs_arr = nullptr;
	gs_arr = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		gs_arr[i] = new double[dst_w];

	// scale image values so as to span from 0 to 255
	
	// find the min value from image
	min_val = src[0][0];
	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			if ((min_val > src[j][i]) && (i != 0 && j != 0))
				min_val = src[j][i];
		}
	}

	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			gm_arr[j][i] = src[j][i] - min_val;
		}
	}

	// find the max value from g_m
	max_val = gm_arr[0][0];
	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			if ((max_val < gm_arr[j][i]) && (i != 0 && j != 0))
				max_val = gm_arr[j][i];
		}
	}

	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			gs_arr[j][i] = k * (gm_arr[j][i] / max_val);
			dst_ptr[j][i] = gs_arr[j][i];
		}
	}


	for (int i = 0; i < dst_h; i++)
	{
		delete(gm_arr[i]);
		delete(gs_arr[i]);
	}
	delete(gm_arr);
	delete(gs_arr);
}
