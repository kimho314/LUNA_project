#pragma once


// CLogTransDlg dialog

class CLogTransDlg : public CDialogEx
{
	DECLARE_DYNAMIC(CLogTransDlg)

public:
	CLogTransDlg(CWnd* pParent = nullptr);   // standard constructor
	virtual ~CLogTransDlg();

// Dialog Data
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_LOG_TRANS };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support

	DECLARE_MESSAGE_MAP()
public:
	double m_LogConst;
	double GetLogConst();
};
