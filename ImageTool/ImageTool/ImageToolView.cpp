﻿
// ImageToolView.cpp: CImageToolView 클래스의 구현
//

#include "stdafx.h"
// SHARED_HANDLERS는 미리 보기, 축소판 그림 및 검색 필터 처리기를 구현하는 ATL 프로젝트에서 정의할 수 있으며
// 해당 프로젝트와 문서 코드를 공유하도록 해 줍니다.
#ifndef SHARED_HANDLERS
#include "ImageTool.h"
#endif

#include "ImageToolDoc.h"
#include "ImageToolView.h"
#include "ColorSeg.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif


// CImageToolView

IMPLEMENT_DYNCREATE(CImageToolView, CScrollView)

BEGIN_MESSAGE_MAP(CImageToolView, CScrollView)
	// 표준 인쇄 명령입니다.
	ON_COMMAND(ID_FILE_PRINT, &CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_DIRECT, &CScrollView::OnFilePrint)
	ON_COMMAND(ID_FILE_PRINT_PREVIEW, &CImageToolView::OnFilePrintPreview)
	ON_WM_CONTEXTMENU()
	ON_WM_RBUTTONUP()
	ON_WM_LBUTTONDOWN()
	ON_WM_LBUTTONUP()
END_MESSAGE_MAP()

// CImageToolView 생성/소멸

CImageToolView::CImageToolView() noexcept
{
	// TODO: 여기에 생성 코드를 추가합니다.
	m_mDragFlag = false;
	m_LeftTopX = 0;
	m_LeftTopY = 0;
	m_RightDownX = 0;
	m_RightDownY = 0;
}

CImageToolView::~CImageToolView()
{
}

BOOL CImageToolView::PreCreateWindow(CREATESTRUCT& cs)
{
	// TODO: CREATESTRUCT cs를 수정하여 여기에서
	//  Window 클래스 또는 스타일을 수정합니다.

	return CScrollView::PreCreateWindow(cs);
}

// CImageToolView 그리기

void CImageToolView::OnDraw(CDC* pDC)
{
	CImageToolDoc* pDoc = GetDocument();
	ASSERT_VALID(pDoc);
	if (!pDoc)
		return;

	// TODO: 여기에 원시 데이터에 대한 그리기 코드를 추가합니다.
	if (pDoc->m_Dib.IsValid())
	{
		pDoc->m_Dib.Draw(pDC->m_hDC);
	}
}

void CImageToolView::OnInitialUpdate()
{
	CScrollView::OnInitialUpdate();

	CSize sizeTotal;
	// TODO: 이 뷰의 전체 크기를 계산합니다.
	CImageToolDoc* pDoc = GetDocument();

	if (pDoc->m_Dib.IsValid())
	{
		sizeTotal.cx = pDoc->m_Dib.GetWidth();
		sizeTotal.cy = pDoc->m_Dib.GetHeight();
	}
	else
	{
		sizeTotal.cx = sizeTotal.cy = 100;
	}
	SetScrollSizes(MM_TEXT, sizeTotal);
	ResizeParentToFit(TRUE);
}


// CImageToolView 인쇄


void CImageToolView::OnFilePrintPreview()
{
#ifndef SHARED_HANDLERS
	AFXPrintPreview(this);
#endif
}

BOOL CImageToolView::OnPreparePrinting(CPrintInfo* pInfo)
{
	// 기본적인 준비
	return DoPreparePrinting(pInfo);
}

void CImageToolView::OnBeginPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 인쇄하기 전에 추가 초기화 작업을 추가합니다.
}

void CImageToolView::OnEndPrinting(CDC* /*pDC*/, CPrintInfo* /*pInfo*/)
{
	// TODO: 인쇄 후 정리 작업을 추가합니다.
}

void CImageToolView::OnRButtonUp(UINT /* nFlags */, CPoint point)
{
	ClientToScreen(&point);
	OnContextMenu(this, point);
}

void CImageToolView::OnContextMenu(CWnd* /* pWnd */, CPoint point)
{
#ifndef SHARED_HANDLERS
	theApp.GetContextMenuManager()->ShowPopupMenu(IDR_POPUP_EDIT, point.x, point.y, this, TRUE);
#endif
}


// CImageToolView 진단

#ifdef _DEBUG
void CImageToolView::AssertValid() const
{
	CScrollView::AssertValid();
}

void CImageToolView::Dump(CDumpContext& dc) const
{
	CScrollView::Dump(dc);
}

CImageToolDoc* CImageToolView::GetDocument() const // 디버그되지 않은 버전은 인라인으로 지정됩니다.
{
	ASSERT(m_pDocument->IsKindOf(RUNTIME_CLASS(CImageToolDoc)));
	return (CImageToolDoc*)m_pDocument;
}
#endif //_DEBUG


// CImageToolView 메시지 처리기


void CImageToolView::OnLButtonDown(UINT nFlags, CPoint point)
{
	// TODO: Add your message handler code here and/or call default
	if (!m_mDragFlag)
	{
		m_LeftTopX = point.x;
		m_LeftTopY = point.y;
		m_mDragFlag = true;
	}
	CScrollView::OnLButtonDown(nFlags, point);
}


void CImageToolView::OnLButtonUp(UINT nFlags, CPoint point)
{
	// TODO: Add your message handler code here and/or call default
	CImageToolDoc* pDoc = GetDocument();
	int src_w = pDoc->m_Dib.GetWidth();
	int src_h = pDoc->m_Dib.GetHeight();

	if (m_mDragFlag)
	{
		m_RightDownX = point.x;
		m_RightDownY = point.y;

		CClientDC dc(this);
		CBrush brush;
		brush.CreateStockObject(NULL_BRUSH);		
		CBrush *pOldBrush = dc.SelectObject(&brush);

		CPen myPen, *pOldPen;
		myPen.CreatePen(PS_SOLID, 1, RGB(255, 255, 255));
		pOldPen = dc.SelectObject(&myPen);
		

		dc.Rectangle(m_LeftTopX, m_LeftTopY, m_RightDownX, m_RightDownY);
		dc.SelectObject(pOldBrush);
		dc.SelectObject(pOldPen);

		SetRectPoints(m_LeftTopX, m_LeftTopY, m_RightDownX, m_RightDownY);
		
		m_mDragFlag = false;
	}

	CScrollView::OnLButtonUp(nFlags, point);
}
