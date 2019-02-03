// CLogTransDlg.cpp : implementation file
//

#include "stdafx.h"
#include "ImageTool.h"
#include "CLogTransDlg.h"
#include "afxdialogex.h"


// CLogTransDlg dialog

IMPLEMENT_DYNAMIC(CLogTransDlg, CDialogEx)

CLogTransDlg::CLogTransDlg(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_LOG_TRANS, pParent)
	, m_LogConst(0)
{

}

CLogTransDlg::~CLogTransDlg()
{
}

void CLogTransDlg::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
	DDX_Text(pDX, IDC_LOG_CONST, m_LogConst);
	DDV_MinMaxDouble(pDX, m_LogConst, 0.0, DBL_MAX);
}


BEGIN_MESSAGE_MAP(CLogTransDlg, CDialogEx)
END_MESSAGE_MAP()


// CLogTransDlg message handlers


double CLogTransDlg::GetLogConst()
{
	// TODO: Add your implementation code here.
	return m_LogConst;
}
