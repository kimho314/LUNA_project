// CGammaTransDlg.cpp : implementation file
//

#include "stdafx.h"
#include "ImageTool.h"
#include "CGammaTransDlg.h"
#include "afxdialogex.h"


// CGammaTransDlg dialog

IMPLEMENT_DYNAMIC(CGammaTransDlg, CDialogEx)

CGammaTransDlg::CGammaTransDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_GAMMA_TRANS, pParent)
	, m_Gamma(0)
	, m_Const(0)
{

}

CGammaTransDlg::~CGammaTransDlg()
{
}

void CGammaTransDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Text(pDX, IDC_GAMMA, m_Gamma);
	DDV_MinMaxDouble(pDX, m_Gamma, 0.0, DBL_MAX);
	DDX_Text(pDX, IDC_GAMMA_CONST, m_Const);
	DDV_MinMaxDouble(pDX, m_Const, 0.0, DBL_MAX);
}


BEGIN_MESSAGE_MAP(CGammaTransDlg, CDialogEx)
END_MESSAGE_MAP()


// CGammaTransDlg message handlers


double CGammaTransDlg::GetGamma()
{
	// TODO: Add your implementation code here.
	return m_Gamma;
}


double CGammaTransDlg::GetConst()
{
	// TODO: Add your implementation code here.
	return m_Const;
}
