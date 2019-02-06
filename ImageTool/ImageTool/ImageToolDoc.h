
// ImageToolDoc.h: CImageToolDoc 클래스의 인터페이스
//


#pragma once

#include "Dib.h"

class CImageToolDoc : public CDocument
{
protected: // serialization에서만 만들어집니다.
	CImageToolDoc() noexcept;
	DECLARE_DYNCREATE(CImageToolDoc)

// 특성입니다.
public:

// 작업입니다.
public:
	 
// 재정의입니다.
public:
	virtual BOOL OnNewDocument();
	virtual void Serialize(CArchive& ar);
#ifdef SHARED_HANDLERS
	virtual void InitializeSearchContent();
	virtual void OnDrawThumbnail(CDC& dc, LPRECT lprcBounds);
#endif // SHARED_HANDLERS

// 구현입니다.
public:
	virtual ~CImageToolDoc();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// 생성된 메시지 맵 함수
protected:
	DECLARE_MESSAGE_MAP()

#ifdef SHARED_HANDLERS
	// 검색 처리기에 대한 검색 콘텐츠를 설정하는 도우미 함수
	void SetSearchContent(const CString& value);
#endif // SHARED_HANDLERS
public:
	virtual BOOL OnOpenDocument(LPCTSTR lpszPathName);
	virtual BOOL OnSaveDocument(LPCTSTR lpszPathName);
	CDib m_Dib;
	afx_msg void OnWindowDuplicate();
	afx_msg void OnEditCopy();
	afx_msg void OnInverse();
	afx_msg void OnHistoEq();
	
	afx_msg void OnViewHistogram();
	afx_msg void OnHistogram();
	afx_msg void OnHistoMatch();
	afx_msg void OnLocalHistEq();
	afx_msg void OnLocalHistStats();
	afx_msg void OnGammaTrans();
	afx_msg void OnLogTrans();
	afx_msg void OnTest();
	afx_msg void OnBoxfilter();
	afx_msg void OnGaussianfilter();
	afx_msg void OnZeroPadding();
	afx_msg void OnReplicatePadding();
	afx_msg void OnMirrorPadding();
	afx_msg void OnSpatialfiltering();
	afx_msg void OnRgbToHsi();
	afx_msg void OnColorComplement();
	afx_msg void OnColorSlicing();
};
