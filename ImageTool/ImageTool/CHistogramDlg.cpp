// CHistogramDlg.cpp : implementation file
//

#include "stdafx.h"
#include "ImageTool.h"
#include "CHistogramDlg.h"
#include "afxdialogex.h"


// CHistogramDlg dialog

IMPLEMENT_DYNAMIC(CHistogramDlg, CDialogEx)

CHistogramDlg::CHistogramDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_HISTOGRAM, pParent)
{
	memset(m_Histogram, 0, sizeof(int) * 256);
	memset(m_norHistogram, 0, sizeof(int) * 256);
}

CHistogramDlg::~CHistogramDlg()
{
}

void CHistogramDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}


BEGIN_MESSAGE_MAP(CHistogramDlg, CDialogEx)
	ON_WM_PAINT()
END_MESSAGE_MAP()


// CHistogramDlg message handlers


void CHistogramDlg::SetImage(CDib *pDib)
{
	// TODO: Add your implementation code here.
	if (pDib != NULL)
	{
		BYTE** histoPtr = pDib->GetPtr();
		
		float histo[256] = { 0 };

		int w = pDib->GetWidth();
		int h = pDib->GetHeight();
		int size = w * h;
				

		int cnt[256] = { 0 };
		memset(cnt, 0, sizeof(int) * 256);
		
		// get unnormalized histogram
		for (int j = 0; j < h; j++)
		{
			for (int i = 0; i < w; i++)
			{				
				cnt[histoPtr[j][i]]++;				
			}
		}		

		// get normalized histogram
		for (int i = 0; i < 256; i++)
		{
			histo[i] = (float)((float)cnt[i] / size);
			m_norHistogram[i] = histo[i];
		}
		
		// find the maximum histogram
		float max_histo = histo[0];
		for (int i = 1; i < 256; i++)
		{
			if (histo[i] > max_histo)
			{
				max_histo = histo[i];
			}
		}

		for (int i = 0; i < 256; i++)
		{
			m_Histogram[i] = (int)((histo[i] * 100) / max_histo);
		}
	}
	else
	{
		memset(m_Histogram, 0, sizeof(int) * 256);
	}
}


void CHistogramDlg::OnPaint()
{
	CPaintDC dc(this); // device context for painting
					   // TODO: Add your message handler code here
					   // Do not call CDialogEx::OnPaint() for painting messages

	CGdiObject *pOldPen = dc.SelectStockObject(DC_PEN);

	// histogram box
	dc.SetDCPenColor(RGB(128, 128, 128));
	dc.MoveTo(20, 20);
	dc.LineTo(20, 120);
	dc.LineTo(275, 120);
	dc.LineTo(275, 20);

	dc.SetDCPenColor(RGB(0, 0, 0)); 
	for (int i = 0; i < 256; i++)
	{
		dc.MoveTo(20 + i, 120);
		dc.LineTo(20 + i, 120 - m_Histogram[i]);
	}

	for (int i = 0; i < 256; i++)
	{
		dc.SetDCPenColor(RGB(i, i, i));
		dc.MoveTo(20 + i, 130);
		dc.LineTo(20 + i, 145);
	}

	dc.SelectObject(pOldPen);
}


float* CHistogramDlg::GetHistogram()
{
	// TODO: Add your implementation code here.
	return m_norHistogram;
}


void CHistogramDlg::UpdateHistogram(int *histo)
{
	// TODO: Add your implementation code here.
	for (int i = 0; i < 256; i++)
	{
		m_Histogram[i] = histo[i];
	}
}


void CHistogramDlg::PrintHistogram(float *histo)
{
	// TODO: Add your implementation code here.
	// find the maximum histogram
	float max_histo = histo[0];
	for (int i = 1; i < 256; i++)
	{
		if (histo[i] > max_histo)
		{
			max_histo = histo[i];
		}
	}

	for (int i = 0; i < 256; i++)
	{
		m_Histogram[i] = (int)((histo[i] * 100) / max_histo);
	}
}
