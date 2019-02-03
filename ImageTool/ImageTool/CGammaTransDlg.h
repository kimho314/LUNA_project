#pragma once


// CGammaTransDlg dialog

class CGammaTransDlg : public CDialogEx
{
	DECLARE_DYNAMIC(CGammaTransDlg)

public:
	CGammaTransDlg(CWnd* pParent = nullptr);   // standard constructor
	virtual ~CGammaTransDlg();

// Dialog Data
#ifdef AFX_DESIGN_TIME
	enum { IDD = IDD_GAMMA_TRANS };
#endif

protected:
	virtual void DoDataExchange(CDataExchange* pDX);    // DDX/DDV support

	DECLARE_MESSAGE_MAP()
public:
	double m_Gamma;
	double m_Const;
	double GetGamma();
	double GetConst();
};
