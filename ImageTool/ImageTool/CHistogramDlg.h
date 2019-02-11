#pragma once

#include "Dib.h"

// CHistogramDlg dialog

class CHistogramDlg : public CDialogEx
{
	DECLARE_DYNAMIC(CHistogramDlg)

public:
	CHistogramDlg(CWnd* pParent = nullptr);   // standard constructor
	virtual ~CHistogramDlg();

	int m_Histogram[256];
	double m_norHistogram[256];

// Dialog Data
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_HISTOGRAM };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support

	DECLARE_MESSAGE_MAP()
public:
	void SetImage(CDib *pDib);
	afx_msg void OnPaint();
	double* GetHistogram();
	void UpdateHistogram(int *histo);
	void PrintHistogram(float *histo);
};
