
// ImageToolDoc.cpp: CImageToolDoc 클래스의 구현
//

#include "stdafx.h"
// SHARED_HANDLERS는 미리 보기, 축소판 그림 및 검색 필터 처리기를 구현하는 ATL 프로젝트에서 정의할 수 있으며
// 해당 프로젝트와 문서 코드를 공유하도록 해 줍니다.
#ifndef SHARED_HANDLERS
#include "ImageTool.h"
#endif

#include "ImageToolDoc.h"

#include <propkey.h>

#include "RGBBYTE.H"
#include <math.h>

#include "CFileNewDlg.h"
#include "CHistogramDlg.h"
#include "CGammaTransDlg.h"
#include "CLogTransDlg.h"
#include "CConvOp.h"

#ifdef _DEBUG
#define new DEBUG_NEW
#endif

#define PI	3.141592
#define TOTAL_INTENSITY_LEVEL	256

// CImageToolDoc

IMPLEMENT_DYNCREATE(CImageToolDoc, CDocument)

BEGIN_MESSAGE_MAP(CImageToolDoc, CDocument)
	ON_COMMAND(IDR_WINDOW_DUPLICATE, &CImageToolDoc::OnWindowDuplicate)
	ON_COMMAND(ID_EDIT_COPY, &CImageToolDoc::OnEditCopy)
	ON_COMMAND(ID_INVERSE, &CImageToolDoc::OnInverse)
	ON_COMMAND(ID_HISTO_EQ, &CImageToolDoc::OnHistoEq)		
	ON_COMMAND(ID_VIEW_HISTOGRAM, &CImageToolDoc::OnViewHistogram)
	ON_COMMAND(ID_HISTOGRAM, &CImageToolDoc::OnHistogram)
	ON_COMMAND(ID_HISTO_MATCH, &CImageToolDoc::OnHistoMatch)
	ON_COMMAND(ID_LOCAL_HIST_EQ, &CImageToolDoc::OnLocalHistEq)
	ON_COMMAND(ID_LOCAL_HIST_STATS, &CImageToolDoc::OnLocalHistStats)
	ON_COMMAND(ID_GAMMA_TRANS, &CImageToolDoc::OnGammaTrans)
	ON_COMMAND(ID_LOG_TRANS, &CImageToolDoc::OnLogTrans)
	
	ON_COMMAND(ID_BOXFILTER, &CImageToolDoc::OnBoxfilter)
	ON_COMMAND(ID_GAUSSIANFILTER, &CImageToolDoc::OnGaussianfilter)
	ON_COMMAND(ID_ZERO_PADDING, &CImageToolDoc::OnZeroPadding)
	ON_COMMAND(ID_REPLICATE_PADDING, &CImageToolDoc::OnReplicatePadding)
	ON_COMMAND(ID_MIRROR_PADDING, &CImageToolDoc::OnMirrorPadding)
	ON_COMMAND(ID_SPATIALFILTERING, &CImageToolDoc::OnSpatialfiltering)
	ON_COMMAND(ID_RGB_TO_HSI, &CImageToolDoc::OnRgbToHsi)
	ON_COMMAND(ID_COLOR_COMPLEMENT, &CImageToolDoc::OnColorComplement)
	ON_COMMAND(ID_COLOR_SLICING, &CImageToolDoc::OnColorSlicing)
END_MESSAGE_MAP()


// CImageToolDoc 생성/소멸

CImageToolDoc::CImageToolDoc() noexcept
{
	// TODO: 여기에 일회성 생성 코드를 추가합니다.

}

CImageToolDoc::~CImageToolDoc()
{
}

BOOL CImageToolDoc::OnNewDocument()
{
	if (!CDocument::OnNewDocument())
		return FALSE;

	// TODO: 여기에 재초기화 코드를 추가합니다.
	// SDI 문서는 이 문서를 다시 사용합니다.
	if (theApp.m_pNewDib != NULL)
	{
		m_Dib.Copy(theApp.m_pNewDib);
		theApp.m_pNewDib = NULL;
	}
	else
	{
		//m_Dib.CreateRGBImage(256, 256);
		BOOL ret = TRUE;
		CFileNewDlg dlg;
		if (dlg.DoModal() == IDOK)
		{
			if (dlg.m_nType == 0)
			{
				ret = m_Dib.CreateGrayImage(dlg.m_nWidth, dlg.m_nHeight);
			}
			else
			{
				ret = m_Dib.CreateRGBImage(dlg.m_nWidth, dlg.m_nHeight);
			}
		}
	}
	
	return TRUE;
}




// CImageToolDoc serialization

void CImageToolDoc::Serialize(CArchive& ar)
{
	if (ar.IsStoring())
	{
		// TODO: 여기에 저장 코드를 추가합니다.
	}
	else
	{
		// TODO: 여기에 로딩 코드를 추가합니다.
	}
}

#ifdef SHARED_HANDLERS

// 축소판 그림을 지원합니다.
void CImageToolDoc::OnDrawThumbnail(CDC& dc, LPRECT lprcBounds)
{
	// 문서의 데이터를 그리려면 이 코드를 수정하십시오.
	dc.FillSolidRect(lprcBounds, RGB(255, 255, 255));

	CString strText = _T("TODO: implement thumbnail drawing here");
	LOGFONT lf;

	CFont* pDefaultGUIFont = CFont::FromHandle((HFONT) GetStockObject(DEFAULT_GUI_FONT));
	pDefaultGUIFont->GetLogFont(&lf);
	lf.lfHeight = 36;

	CFont fontDraw;
	fontDraw.CreateFontIndirect(&lf);

	CFont* pOldFont = dc.SelectObject(&fontDraw);
	dc.DrawText(strText, lprcBounds, DT_CENTER | DT_WORDBREAK);
	dc.SelectObject(pOldFont);
}

// 검색 처리기를 지원합니다.
void CImageToolDoc::InitializeSearchContent()
{
	CString strSearchContent;
	// 문서의 데이터에서 검색 콘텐츠를 설정합니다.
	// 콘텐츠 부분은 ";"로 구분되어야 합니다.

	// 예: strSearchContent = _T("point;rectangle;circle;ole object;");
	SetSearchContent(strSearchContent);
}

void CImageToolDoc::SetSearchContent(const CString& value)
{
	if (value.IsEmpty())
	{
		RemoveChunk(PKEY_Search_Contents.fmtid, PKEY_Search_Contents.pid);
	}
	else
	{
		CMFCFilterChunkValueImpl *pChunk = nullptr;
		ATLTRY(pChunk = new CMFCFilterChunkValueImpl);
		if (pChunk != nullptr)
		{
			pChunk->SetTextValue(PKEY_Search_Contents, value, CHUNK_TEXT);
			SetChunkValue(pChunk);
		}
	}
}

#endif // SHARED_HANDLERS

// CImageToolDoc 진단

#ifdef _DEBUG
void CImageToolDoc::AssertValid() const
{
	CDocument::AssertValid();
}

void CImageToolDoc::Dump(CDumpContext& dc) const
{
	CDocument::Dump(dc);
}
#endif //_DEBUG


// CImageToolDoc 명령


BOOL CImageToolDoc::OnOpenDocument(LPCTSTR lpszPathName)
{
	if (!CDocument::OnOpenDocument(lpszPathName))
		return FALSE;

	// TODO:  여기에 특수화된 작성 코드를 추가합니다.
	if (!m_Dib.Load(lpszPathName))
	{
		return FALSE;
	}

	return TRUE;
}


BOOL CImageToolDoc::OnSaveDocument(LPCTSTR lpszPathName)
{
	// TODO: 여기에 특수화된 코드를 추가 및/또는 기본 클래스를 호출합니다.

	return CDocument::OnSaveDocument(lpszPathName);
}


void CImageToolDoc::OnWindowDuplicate()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	CDib dib(m_Dib);
	theApp.m_pNewDib = &dib;
	AfxGetMainWnd()->SendMessage(WM_COMMAND, ID_FILE_NEW);
}


void CImageToolDoc::OnEditCopy()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	if (m_Dib.IsValid())
	{
		m_Dib.CopyToClipboard();
	}
}


void CImageToolDoc::OnInverse()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	int i, j;
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	if (m_Dib.GetBitCount() == 8)
	{
		CDib dib = m_Dib;
		BYTE** ptr = dib.GetPtr();

		for (j = 0; j < h; j++)
		{
			for (i = 0; i < w; i++)
			{
				ptr[j][i] = 255 - ptr[j][i];
			}
		}
		AfxNewImage(dib);
	}
	else if (m_Dib.GetBitCount() == 24)
	{
		CDib dib = m_Dib;
		RGBBYTE** ptr = dib.GetRGBPtr();

		for (j = 0; j < h; j++)
		{
			for (i = 0; i < w; i++)
			{
				ptr[j][i].r = 255 - ptr[j][i].r;
				ptr[j][i].g = 255 - ptr[j][i].g;
				ptr[j][i].b = 255 - ptr[j][i].b;
			}
		}
		AfxNewImage(dib);
	}
	else
	{
		AfxMessageBox((LPCTSTR)"It's not supported");
	}
}


void CImageToolDoc::OnHistoEq()
{
	// TODO: 여기에 명령 처리기 코드를 추가합니다.
	
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib = m_Dib;
	BYTE** src_ptr = dib.GetPtr();
	CDib des_dib;
	des_dib.CreateGrayImage(w, h, 255);
	BYTE** des_ptr = des_dib.GetPtr();

	CHistogramDlg dlg;
	// compute histogram
	dlg.SetImage(&m_Dib);
	

	int total_num_pixels = w * h;	
	float *normalized_hist = NULL;	

	// get normalzied histogram
	normalized_hist = dlg.GetHistogram();
		
	// show origian image's histogram	
	//dlg.DoModal();

	// implement histogram equalization
	float sum_of_histo[TOTAL_INTENSITY_LEVEL] = { 0.0f };
	float s_k[TOTAL_INTENSITY_LEVEL] = { 0, }; // result intensity after equalization

	// implement equalization
	s_k[0] = normalized_hist[0];
	for (int i = 1; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		s_k[i] = (TOTAL_INTENSITY_LEVEL - 1) * normalized_hist[i] + s_k[i - 1];
		//printf("idx : %3d s_k : %.5f\n", i, s_k[i]);
	}

	// get CDF of histogram
	int eq_hist[TOTAL_INTENSITY_LEVEL] = { 0 };
	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)                                    
	{
		eq_hist[i] = (int)round(s_k[i]);
		//printf("idx : %3d eq : %3d\n", i, eq_hist[i]);
	}

	// show CDF
	//dlg.UpdateHistogram(eq_hist);
	//dlg.DoModal();

	// get equalized image
	for (int j = 0; j < h; j++)
	{
		for (int i = 0; i < w; i++)
		{
			for (int k = 0; k < TOTAL_INTENSITY_LEVEL; k++)
			{
				if (src_ptr[j][i] == k)
				{
					des_ptr[j][i] = eq_hist[k];
				}
			}
		}
	}
	
	AfxNewImage(des_dib);
	// show equalized histogram
	dlg.SetImage(&des_dib);
	dlg.DoModal();
}


void CImageToolDoc::OnViewHistogram()
{
	// TODO: Add your command handler code here
	CHistogramDlg dlg;
	dlg.SetImage(&m_Dib);
	dlg.DoModal();
}


void CImageToolDoc::OnHistogram()
{
	// TODO: Add your command handler code here
	CHistogramDlg dlg;
	dlg.SetImage(&m_Dib);
	dlg.DoModal();
}


void CImageToolDoc::OnHistoMatch()
{
	// TODO: Add your command handler code here
	
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib = m_Dib;
	BYTE** src_ptr = dib.GetPtr();
	CDib des_dib;
	des_dib.CreateGrayImage(w, h);
	BYTE** des_ptr = des_dib.GetPtr();

	CHistogramDlg dlg;
	// compute histogram
	dlg.SetImage(&m_Dib);

	int total_num_pixels = w * h;
	float *normalized_hist = NULL;

	// get normalzied histogram
	normalized_hist = dlg.GetHistogram();

	// show origian image's histogram	
	//dlg.DoModal();

	// implement histogram equalization	
	float s_k[TOTAL_INTENSITY_LEVEL] = { 0, }; // result intensity after equalization

	// implement equalization
	s_k[0] = normalized_hist[0];
	for (int i = 1; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		s_k[i] = (TOTAL_INTENSITY_LEVEL - 1) * normalized_hist[i] + s_k[i - 1];
		//printf("idx : %3d s_k : %.5f\n", i, s_k[i]);
	}

	// get CDF of histogram
	int eq_hist[TOTAL_INTENSITY_LEVEL] = { 0 };
	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		eq_hist[i] = (int)round(s_k[i]);
		//printf("idx : %3d eq : %3d\n", i, eq_hist[i]);
	}

	// show CDF
	/*dlg.UpdateHistogram(eq_hist);
	dlg.DoModal();*/

	// get unnormalized histogram of specified PDF
	int unnor_pz[TOTAL_INTENSITY_LEVEL] = { 0 };
	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		if ((i >= 0) && (i <= 128))
		{
			unnor_pz[i] = (int)((float)(-1 * (float)(510 / (float)128)) * i + 510);
		}
		else
		{
			unnor_pz[i] = (int)((float)(510 / (float)127) * i - ((510 * 128) / 127));
		}
	}

	/*for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		printf("idx : %3d pz : %3d\n", i, unnor_pz[i]);
	}*/

	// get normalzied histogram of specified PDF
	float  nor_pz[TOTAL_INTENSITY_LEVEL] = { 0.0f };
	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		nor_pz[i] = (float)unnor_pz[i] / (float)total_num_pixels;
	}
	
	/*dlg.PrintHistogram(nor_pz);
	dlg.DoModal();*/
	/*for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		printf("idx : %3d pz : %.5f\n", i, nor_pz[i]);
	}*/
	

	// implement equalization
	float g_z[TOTAL_INTENSITY_LEVEL] = { 0, }; // result intensity after equalization
	g_z[0] = nor_pz[0];
	for (int i = 1; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		g_z[i] = (TOTAL_INTENSITY_LEVEL - 1) * nor_pz[i] + g_z[i - 1];
		//printf("idx : %3d g_z : %.5f\n", i, g_z[i]);
	}
	

	// get CDF of histogram
	int eq_gz[TOTAL_INTENSITY_LEVEL] = { 0 };
	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		eq_gz[i] = (int)round(g_z[i]);
		//printf("idx : %3d eq_gz : %3d\n", i, eq_gz[i]);
	}

	// show CDF
	/*dlg.UpdateHistogram(eq_gz);
	dlg.DoModal();*/
	

	/*for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		printf("idx : %3d eq_hist : %3d eq_gz : %3d\n", i, eq_hist[i], eq_gz[i]);
	}*/

	// mapping eq_gz into the closest s_k
	int min_diff = 0;
	int min_idx = 0;
	int diff_arr[TOTAL_INTENSITY_LEVEL] = { 0 };
	int hist_match_arr[TOTAL_INTENSITY_LEVEL] = { 0 }; // idx = eq_hist, val = eq_gz
	int hist_inv_match_arr[TOTAL_INTENSITY_LEVEL] = { 0 };

	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++) // index of s_k
	{
		for (int j = 0; j < TOTAL_INTENSITY_LEVEL; j++) // index of z_q
		{
			diff_arr[j] = abs(eq_hist[i] - eq_gz[j]); // eq_hist = s_k, eq_gz = g(z)
		}

		min_diff = diff_arr[0];
		for (int j = 1; j < TOTAL_INTENSITY_LEVEL - 1; j++)
		{
			if (min_diff > diff_arr[j])
			{
				min_diff = diff_arr[j];
				min_idx = j;
			}
		}		

		hist_match_arr[i] = eq_gz[min_idx]; // s_k -> G(z_q)
		// i : index of s_k, hist_inv_match_arr : z_q corresponding to s_k
		hist_inv_match_arr[i] = min_idx; // s_k -> G(z_q) -> z_q
		memset(diff_arr, 0, sizeof(diff_arr));
	}

	
	/*for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		printf("s_k : %3d G(z_q) : %3d z_q : %3d\n", eq_hist[i], hist_match_arr[i], hist_inv_match_arr[i]);
	}*/
	

	// inverse mapping
	float new_specified_hist[TOTAL_INTENSITY_LEVEL] = { 0 };
	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		new_specified_hist[hist_inv_match_arr[i]] += normalized_hist[i];
	}

	/*dlg.PrintHistogram(new_specified_hist);
	dlg.DoModal();
	*/
	int result_new_hist[TOTAL_INTENSITY_LEVEL] = { 0 };
	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		result_new_hist[i] = (int)round(new_specified_hist[i]);
	}

	// get equalized image
	for (int j = 0; j < h; j++)
	{
		for (int i = 0; i < w; i++)
		{
			for (int k = 0; k < TOTAL_INTENSITY_LEVEL; k++)
			{
				if (src_ptr[j][i] == k)
				{
					des_ptr[j][i] = eq_hist[hist_inv_match_arr[k]];
				}
			}
		}
	}	

	AfxNewImage(des_dib);
	dlg.SetImage(&des_dib);
	dlg.DoModal();
}


void CImageToolDoc::OnLocalHistEq()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib = m_Dib;
	BYTE** src_ptr = dib.GetPtr();
	CDib des_dib;
	des_dib.CreateGrayImage(w, h);
	BYTE** des_ptr = des_dib.GetPtr();

	int window_size = 3;
	int half_w_size = window_size / 2; // 1
	int local_histogram[TOTAL_INTENSITY_LEVEL] = { 0 };
	int local_hist_cdf[TOTAL_INTENSITY_LEVEL] = { 0 };
	double norm_local_hist_cdf[TOTAL_INTENSITY_LEVEL] = { 0 };
	

	for (int j = 1; j < h-1; j++)
	{
		for (int i = 1; i < w-1; i++)
		{			
			memset(local_histogram, 0, sizeof(local_histogram));
			int n_cnt = window_size * window_size;

			// get local unnormalized histogram
			for (int y = -half_w_size; y <= half_w_size; y++)
			{
				for (int x = -half_w_size; x <= half_w_size; x++)
				{
					int px = i + x;
					int py = j + y;

					local_histogram[src_ptr[py][px]]++;					
				}
			}			
			
			// get local cdf
			double norm_factor = 255.0 / n_cnt;

			for (int k = 0; k < TOTAL_INTENSITY_LEVEL; k++)
			{
				norm_local_hist_cdf[k] = local_histogram[k] * norm_factor;
			}

			local_hist_cdf[0] = (int)round(norm_local_hist_cdf[0]);
			for (int k = 1; k < TOTAL_INTENSITY_LEVEL; k++)
			{
				local_hist_cdf[k] = norm_local_hist_cdf[k] + norm_local_hist_cdf[k - 1];
			}
			
			// implement local histogram equalization
			for (int y = -half_w_size; y <= half_w_size; y++)
			{
				for (int x = -half_w_size; x <= half_w_size; x++)
				{
					int px = i + x;
					int py = j + y;

					des_ptr[py][px] = local_hist_cdf[src_ptr[py][px]];
				}
			}
		}
	}

	AfxNewImage(des_dib);
}


void CImageToolDoc::OnLocalHistStats()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();
	int total_num_pixels = w * h;

	CDib dib = m_Dib;
	BYTE** src_ptr = dib.GetPtr();
	CDib des_dib;
	des_dib.CreateGrayImage(w, h);	
	des_dib.Copy(&dib);
	BYTE** des_ptr = des_dib.GetPtr();	
	

	CHistogramDlg dlg;
	// compute histogram
	//dlg.SetImage(&m_Dib);
	dlg.SetImage(&des_dib);
	
	float *norm_hist = NULL;

	// get normalzied histogram
	norm_hist = dlg.GetHistogram();	
		

	double global_mean = 0.0;
	double global_variance = 0.0;
	double global_standard_deviation = 0.0;

	for (int i = 0; i < TOTAL_INTENSITY_LEVEL; i++)
	{
		global_mean += (double)i * (double)norm_hist[i];
		global_variance += pow((i - global_mean), 2) * norm_hist[i];
	}
	global_standard_deviation = sqrt(global_variance);	
	//printf("global_mean : %.5f globaL_var : %.5f", global_mean, global_variance);

	int window_size = 3;
	int half_window_size = window_size / 2; // 1

	const double c = 22.8;
	const double k0 = 0.0;
	const double k1 = 0.1;
	const double k2 = 0.0;
	const double k3 = 0.1;

	for (int j = half_window_size; j < h - half_window_size; j++)
	{
		for (int i = half_window_size; i < w - half_window_size; i++)
		{
			int n_cnt = window_size * window_size;
			double local_mean = 0.0;
			double local_variance = 0.0;
			double local_standard_deviation = 0.0;

			int local_hist[TOTAL_INTENSITY_LEVEL] = { 0 };
			double norm_local_hist[TOTAL_INTENSITY_LEVEL] = { 0 };

			// windowing for getting local normalized histogram
			for (int y = -half_window_size; y <= half_window_size; y++)
			{
				for (int x = -half_window_size; x <= half_window_size; x++)
				{
					// coordinate of the center pixel
					int px = i + x; 
					int py = j + y;

					// get unnormalized histogram in the neighthood
					local_hist[des_ptr[py][px]]++;
					// get normalized histogram in the neighborhood
					norm_local_hist[des_ptr[py][px]] = (double)local_hist[des_ptr[py][px]] / (double)n_cnt;
				}
			}			

			for (int k = 0; k < TOTAL_INTENSITY_LEVEL; k++)
			{
				local_mean += (double)k * (double)norm_local_hist[i];
				local_variance += pow((k - local_mean), 2) * norm_local_hist[i];
			}
			local_standard_deviation = sqrt(local_variance);
			

			if (((k0 * global_mean) <= local_mean) && ((k1 * global_mean) >= local_mean) &&
				((k2 * global_standard_deviation) <= local_standard_deviation) && 
				((k3 * global_standard_deviation) >= local_standard_deviation))
			{
				des_ptr[j][i] = (int)(c * des_ptr[j][i]);
			}
			else
			{
				des_ptr[j][i] = des_ptr[j][i];
			}			
		}
	}	

	AfxNewImage(des_dib);
}


void CImageToolDoc::OnGammaTrans()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib = m_Dib;
	BYTE** ptrSrc = dib.GetPtr();

	CDib dib_des;
	dib_des.CreateGrayImage(w, h);
	BYTE** desSrc = dib_des.GetPtr();

	CGammaTransDlg dlg;

	if (dlg.DoModal() == IDOK)
	{		
		double c = dlg.GetConst();
		double gamma = dlg.GetGamma();

		double inv_gamma = 1.0f / gamma;

		// get the result of the gamma transformation
		for (int j = 0; j < h; j++)
		{
			for (int i = 0; i < w; i++)
			{
				desSrc[j][i] = c * pow((ptrSrc[j][i] / 255.0f), gamma) * 255; // c*r^gamma			
			}
		}
		AfxNewImage(dib_des);
	}
}


void CImageToolDoc::OnLogTrans()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib = m_Dib;
	BYTE** ptrSrc = dib.GetPtr();

	CDib dib_des;
	dib_des.CreateGrayImage(w, h);
	BYTE** desSrc = dib_des.GetPtr();

	CLogTransDlg dlg;

	if (dlg.DoModal() == IDOK)
	{
		double c = dlg.GetLogConst();

		// get the result of the log transformation
		for (int j = 0; j < h; j++)
		{
			for (int i = 0; i < w; i++)
			{
				desSrc[j][i] = c * log((double)((double)1 + (double)ptrSrc[j][i] / 255.0f)) * 255;				
			}
		}

		AfxNewImage(dib_des);
	}
}


void CImageToolDoc::OnBoxfilter()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib_src = m_Dib;	
	CDib dib_des3;	
	CDib dib_des11;	
	CDib dib_des21;	
	
	
	double **box_filter3 = nullptr;
	double **box_filter11 = nullptr;
	double **box_filter21 = nullptr;

	// create box filters (3x3, 11x11, 21,x21)
	box_filter3 = new double*[3];
	for (int i = 0; i < 3; i++)
		box_filter3[i] = new double[3];

	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			box_filter3[i][j] = 1.0f / (3 * 3);
		}
	}

	box_filter11 = new double*[11];
	for (int i = 0; i < 11; i++)
		box_filter11[i] = new double[11];

	for (int i = 0; i < 11; i++)
	{
		for (int j = 0; j < 11; j++)
		{
			box_filter11[i][j] = 1.0f / (11 * 11);
		}
	}

	box_filter21 = new double*[21];
	for (int i = 0; i < 21; i++)
		box_filter21[i] = new double[21];

	for (int i = 0; i < 21; i++)
	{
		for (int j = 0; j < 21; j++)
		{
			box_filter21[i][j] = 1.0f / (21 * 21);
		}
	}

	// operate convolution a image with box filters
	CConvOp conv;
	conv.Convolution(&dib_des3, &dib_src, box_filter3, 3);
	AfxNewImage(dib_des3);

	conv.Convolution(&dib_des11, &dib_src, box_filter11, 11);
	AfxNewImage(dib_des11);

	conv.Convolution(&dib_des21, &dib_src, box_filter21, 21);
	AfxNewImage(dib_des21);

	// release memories allocated in box filters
	for (int i = 0; i < 3; i++)
		delete(box_filter3[i]);
	delete(box_filter3);

	for (int i = 0; i < 11; i++)
		delete(box_filter11[i]);
	delete(box_filter11);

	for (int i = 0; i < 21; i++)
		delete(box_filter21[i]);
	delete(box_filter21);
		
}

void CreateGaussainKernel(double **kernel, int kernel_size, double k, double sigma)
{		
	int half_size = kernel_size / 2;
	double sum = 0.0f;
	
	for (int s = -half_size; s <= half_size; s++)
	{
		for (int t = -half_size; t <= half_size; t++)
		{
			kernel[s + half_size][t + half_size] = k * exp((double)-1 * (pow((double)s, 2) + pow((double)t, 2)) / (2.0 * pow(sigma, 2)));
			sum += kernel[s + half_size][t + half_size];
		}
	}
	
	
	for (int s = 0; s < kernel_size; s++)
	{
		for (int t = 0; t < kernel_size; t++)
		{
			kernel[s][t] /= (double)sum;			
		}		
	}	
}

void CImageToolDoc::OnGaussianfilter()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib_src = m_Dib;
	CDib dib_des21;
	CDib dib_des43;

	double **Gaussian_filter21 = nullptr;
	Gaussian_filter21 = new double*[21];
	for (int i = 0; i < 21; i++)
		Gaussian_filter21[i] = new double[21];

	double **Gaussian_filter43 = nullptr;
	Gaussian_filter43 = new double*[43];
	for (int i = 0; i < 43; i++)
		Gaussian_filter43[i] = new double[43];

	// create Gaussian kernel
	CreateGaussainKernel(Gaussian_filter21, 21, 1.0, 3.5);
	CreateGaussainKernel(Gaussian_filter43, 43, 1.0, 7.0);	

	// operate convolution a image with box filters
	CConvOp conv;
	conv.Convolution(&dib_des21, &dib_src, Gaussian_filter21, 21);
	AfxNewImage(dib_des21);

	conv.Convolution(&dib_des43, &dib_src, Gaussian_filter43, 43);
	AfxNewImage(dib_des43);

	for (int i = 0; i < 21; i++)
		delete(Gaussian_filter21[i]);
	delete(Gaussian_filter21);

	for (int i = 0; i < 43; i++)
		delete(Gaussian_filter43[i]);
	delete(Gaussian_filter43);
}


void CImageToolDoc::OnZeroPadding()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib_src = m_Dib;
	CDib dib_des187;	

	double **Gaussian_filter187 = nullptr;
	Gaussian_filter187 = new double*[187];
	for (int i = 0; i < 187; i++)
		Gaussian_filter187[i] = new double[187];
	

	// create Gaussian kernel
	CreateGaussainKernel(Gaussian_filter187, 187, 1.0, 31.0);	

	// operate convolution a image with box filters
	CConvOp conv;
	conv.Convolution(&dib_des187, &dib_src, Gaussian_filter187, 187);
	AfxNewImage(dib_des187);	


	for (int i = 0; i < 187; i++)
		delete(Gaussian_filter187[i]);
	delete(Gaussian_filter187);	
}


void CImageToolDoc::OnReplicatePadding()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib_src = m_Dib;
	CDib dib_des187;	

	double **Gaussian_filter187 = nullptr;
	Gaussian_filter187 = new double*[187];
	for (int i = 0; i < 187; i++)
		Gaussian_filter187[i] = new double[187];	

	// create Gaussian kernel
	CreateGaussainKernel(Gaussian_filter187, 187, 1.0, 31.0);	

	// operate convolution a image with box filters
	CConvOp conv;
	conv.Convolution(&dib_des187, &dib_src, Gaussian_filter187, 187, conv.REPLICATE);	
		
	AfxNewImage(dib_des187);
	
	for (int i = 0; i < 187; i++)
		delete(Gaussian_filter187[i]);
	delete(Gaussian_filter187);

	
}


void CImageToolDoc::OnMirrorPadding()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib_src = m_Dib;
	CDib dib_des187;

	double **Gaussian_filter187 = nullptr;
	Gaussian_filter187 = new double*[187];
	for (int i = 0; i < 187; i++)
		Gaussian_filter187[i] = new double[187];

	// create Gaussian kernel
	CreateGaussainKernel(Gaussian_filter187, 187, 1.0, 31.0);

	// operate convolution a image with box filters
	CConvOp conv;
	conv.Convolution(&dib_des187, &dib_src, Gaussian_filter187, 187.0, conv.MIRROR);	

	AfxNewImage(dib_des187);
	
	for (int i = 0; i < 187; i++)
		delete(Gaussian_filter187[i]);
	delete(Gaussian_filter187);
}

void CreateBoxFilter(double **kernel, int kernel_size)
{
	for (int i = 0; i < kernel_size; i++)
	{
		for (int j = 0; j < kernel_size; j++)
		{
			kernel[i][j] = 1.0f / (kernel_size * kernel_size);
		}
	}
}

void CreateLaplacian(double **kernel)
{
	kernel[0][0] = -1.0f;
	kernel[0][1] = -1.0f;
	kernel[0][2] = -1.0f;
	kernel[1][0] = -1.0f;
	kernel[1][1] = 8.0f;
	kernel[1][2] = -1.0f;
	kernel[2][0] = -1.0f;
	kernel[2][1] = -1.0f;
	kernel[2][2] = -1.0f;
}

enum SobelDir
{
	DIR_X,
	DIR_Y,
};

void CreateSobel(double **kernel, int dir)
{
	if (dir == DIR_X)
	{
		kernel[0][0] = -1.0f;
		kernel[0][1] = -2.0f;
		kernel[0][2] = -1.0f;
		kernel[1][0] = 0.0f;
		kernel[1][1] = 0.0f;
		kernel[1][2] = 0.0f;
		kernel[2][0] = 1.0f;
		kernel[2][1] = 2.0f;
		kernel[2][2] = 1.0f;
	}
	if (dir == DIR_Y)
	{
		kernel[0][0] = -1.0f;
		kernel[0][1] = 0.0f;
		kernel[0][2] = 1.0f;
		kernel[1][0] = -2.0f;
		kernel[1][1] = 0.0f;
		kernel[1][2] = 2.0f;
		kernel[2][0] = -1.0f;
		kernel[2][1] = 0.0f;
		kernel[2][2] = 1.0f;
	}
}

void ElementwiseSum(CDib *dst, CDib *src1, CDib *src2, int kernel_size = 0)
{
	int src1_w = src1->GetWidth();
	int src1_h = src1->GetHeight();
	int src2_w = src2->GetWidth();
	int src2_h = src2->GetHeight();
	int dst_w = src1_w;
	int dst_h = src1_h;
	int half_ker_size = (kernel_size - 1) / 2;

	dst->CreateGrayImage(dst_w, dst_h, 0);
	BYTE** src2_ptr = src2->GetPtr();
	BYTE** src1_ptr = src1->GetPtr();
	BYTE** dst_ptr = dst->GetPtr();
	


	double** sum_arr = nullptr;
	sum_arr = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		sum_arr[i] = new double[dst_w];
	
	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{				
			sum_arr[j][i] = src2_ptr[j][i] + src1_ptr[j][i];
		}
	}
	

	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			dst_ptr[j][i] = sum_arr[j][i];
		}
	}

	for (int i = 0; i < dst_h; i++)
		delete(sum_arr[i]);
	delete(sum_arr);
}

void ElementwiseMulti(CDib *dst, CDib *src1, CDib *src2, int kernel_size = 0)
{
	int src1_w = src1->GetWidth();
	int src1_h = src1->GetHeight();
	int src2_w = src2->GetWidth();
	int src2_h = src2->GetHeight();
	int dst_w = src1_w;
	int dst_h = src1_h;	

	dst->CreateGrayImage(dst_w, dst_h, 0);
	BYTE** src2_ptr = src2->GetPtr();
	BYTE** src1_ptr = src1->GetPtr();
	BYTE** dst_ptr = dst->GetPtr();	

	double** multi_arr = nullptr;
	multi_arr = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		multi_arr[i] = new double[dst_w];

	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{					
			multi_arr[j][i] = src2_ptr[j][i] * src1_ptr[j][i];
		}
	}

	CConvOp conv;
	conv.ScaleImageValue(dst, multi_arr);
		

	for (int i = 0; i < dst_h; i++)
		delete(multi_arr[i]);
	delete(multi_arr);
}


void GetSobelMagnitude(CDib *dst, CDib *src1, CDib *src2)
{
	int src2_w = src2->GetWidth();
	int src2_h = src2->GetHeight();
	int src1_w = src1->GetWidth();
	int src1_h = src1->GetHeight();

	dst->CreateGrayImage(src2_w, src2_h, 0);
	int dst_w = dst->GetWidth();
	int dst_h = dst->GetHeight();

	BYTE** src1_ptr = src1->GetPtr();
	BYTE** src2_ptr = src2->GetPtr();
	BYTE** dst_ptr = dst->GetPtr();

	
	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			dst_ptr[j][i] = sqrt(pow((double)src1_ptr[j][i], 2) + pow((double)src2_ptr[j][i], 2));
		}
	}
}

void GammaTrans(CDib *dst, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	dst->CreateGrayImage(src_w, src_h, 0);
	BYTE** src_ptr = src->GetPtr();
	BYTE** dst_ptr = dst->GetPtr();

	double c = 1.0f;
	double gamma = 0.5f;

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			dst_ptr[j][i] = c * pow((src_ptr[j][i] / 255.0f), gamma) * 255;
		}
	}
}

void CImageToolDoc::OnSpatialfiltering()
{
	// TODO: Add your command handler code here
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	CDib dib_src = m_Dib;
	CDib dib_des_b; // Laplacian
	CDib dib_des_c; // src + b
	CDib dib_des_d; // sobel kernel
	CDib dib_sobel_x;
	CDib dib_sobel_y;
	CDib dib_des_e; // sobel smoothed by 5x5 box filter
	CDib dib_des_f; // e x b
	CDib dib_des_g; // a + f
	CDib dib_des_h; // Gamma transformation with c = 1, gamma = 0.5

	// create 3x3 laplician kernel
	double **laplacian = nullptr;
	laplacian = new double*[3];
	for (int i = 0; i < 3; i++)
		laplacian[i] = new double[3];
	
	CreateLaplacian(laplacian);
	
	
	// create 3x3 sobel kernel
	double **sobel_x = nullptr;
	sobel_x = new double*[3];
	for (int i = 0; i < 3; i++)
		sobel_x[i] = new double[3];

	CreateSobel(sobel_x, DIR_X);
	
	double **sobel_y = nullptr;
	sobel_y = new double*[3];
	for (int i = 0; i < 3; i++)
		sobel_y[i] = new double[3];
	
	CreateSobel(sobel_y, DIR_Y);
	
	// create 5x5 box filter
	double **box_filter5 = nullptr;
	box_filter5 = new double*[5];
	for (int i = 0; i < 5; i++)
		box_filter5[i] = new double[5];

	CreateBoxFilter(box_filter5, 5);	

	
	// Laplacian filtering
	CConvOp conv;
	conv.Convolution(&dib_des_b, &dib_src, laplacian, 3, 0, 1);	
	//AfxNewImage(dib_des_b); // (b)
	
	
	ElementwiseSum(&dib_des_c, &dib_des_b, &dib_src, 3);
	AfxNewImage(dib_des_c); // (c)

	// Sobel gradient
	conv.Convolution(&dib_sobel_x, &dib_src, sobel_x, 3);
	conv.Convolution(&dib_sobel_y, &dib_src, sobel_y, 3);
	//AfxNewImage(dib_sobel_x);
	//AfxNewImage(dib_sobel_y);

	// get Sobel image
	GetSobelMagnitude(&dib_des_d, &dib_sobel_x, &dib_sobel_y);
	AfxNewImage(dib_des_d); // (d)

	// smoothing Sobel image by 5x5 box filter
	conv.Convolution(&dib_des_e, &dib_des_d, box_filter5, 5);
	AfxNewImage(dib_des_e); // (e)

	// multiply smoothed Sobel image by Laplacian
	ElementwiseMulti(&dib_des_f, &dib_des_e, &dib_des_b);
	AfxNewImage(dib_des_f); // (f)

	// add input image and image (f)
	ElementwiseSum(&dib_des_g, &dib_des_f, &dib_src, 3);
	AfxNewImage(dib_des_g); // (g)

	// implement gamma transformation
	GammaTrans(&dib_des_h, &dib_des_g);
	AfxNewImage(dib_des_h); // (h)


	for (int i = 0; i < 3; i++)
		delete(laplacian[i]);
	delete(laplacian);
	
	for (int i = 0; i < 3; i++)
		delete(sobel_x[i]);
	delete(sobel_x);

	for (int i = 0; i < 3; i++)
		delete(sobel_y[i]);
	delete(sobel_y);

	for (int i = 0; i < 5; i++)
		delete(box_filter5[i]);
	delete(box_filter5);
}

void GetHueComponent(CDib *dst, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	int dst_w = dst->GetWidth();
	int dst_h = dst->GetHeight();

	BYTE** dst_ptr = dst->GetPtr();
	RGBBYTE** src_ptr = src->GetRGBPtr();

	double **tmp_arr = nullptr;
	tmp_arr = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_arr[i] = new double[src_w];

	double **tmp_r = nullptr;
	tmp_r = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_r[i] = new double[src_w];

	double **tmp_g = nullptr;
	tmp_g = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_g[i] = new double[src_w];

	double **tmp_b = nullptr;
	tmp_b = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_b[i] = new double[src_w];

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			tmp_arr[j][i] = 0.0;	
			
			tmp_r[j][i] = (double)src_ptr[j][i].r / 255.0;
			tmp_g[j][i] = (double)src_ptr[j][i].g / 255.0;
			tmp_b[j][i] = (double)src_ptr[j][i].b / 255.0;
		}
	}
	

	for (int j = 0; j < src_h; j++)
	{		
		for (int i = 0; i < src_w; i++)
		{
			double theta = 0.0f;

			double numer = ((tmp_r[j][i] - tmp_g[j][i]) + (tmp_r[j][i] - tmp_b[j][i])) / 2.0;
			double denomi = sqrt(pow((tmp_r[j][i] - tmp_g[j][i]), 2) +
				((tmp_r[j][i] - tmp_b[j][i]) * (tmp_g[j][i] - tmp_b[j][i])));
			
			theta = acos(numer / denomi); // rad to degree
						
			// convert in range [0,1]			
			if (tmp_b[j][i] <= tmp_g[j][i])
			{
				tmp_arr[j][i] = theta;
			}
			else
			{
				tmp_arr[j][i] = (2.0 * PI) - theta;
			}
			
			if (tmp_arr[j][i] < 0.0)
				tmp_arr[j][i] = 0.0;
			if (tmp_arr[j][i] > 2 * PI)
				tmp_arr[j][i] = 2 * PI;
		}
	}
	
	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			tmp_arr[j][i] = tmp_arr[j][i] * 180.0 / PI; // [0,360]
		}
	}

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			// convert in range [0, 255]
			dst_ptr[j][i] = (int)((tmp_arr[j][i] / 360.0) * 255.0);
		}
	}

	

	for (int i = 0; i < src_h; i++)
		delete(tmp_arr[i]);
	delete(tmp_arr);

	for (int i = 0; i < src_h; i++)
		delete(tmp_r[i]);
	delete(tmp_r);

	for (int i = 0; i < src_h; i++)
		delete(tmp_g[i]);
	delete(tmp_g);

	for (int i = 0; i < src_h; i++)
		delete(tmp_b[i]);
	delete(tmp_b);
}

void GetSatComponent(CDib *dst, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	int dst_w = dst->GetWidth();
	int dst_h = dst->GetHeight();

	BYTE** dst_ptr = dst->GetPtr();
	RGBBYTE** src_ptr = src->GetRGBPtr();	
	
	double **tmp_arr = nullptr;
	tmp_arr = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_arr[i] = new double[src_w];

	double **tmp_r = nullptr;
	tmp_r = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_r[i] = new double[src_w];

	double **tmp_g = nullptr;
	tmp_g = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_g[i] = new double[src_w];

	double **tmp_b = nullptr;
	tmp_b = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_b[i] = new double[src_w];

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			tmp_arr[j][i] = 0;			

			tmp_r[j][i] = (double)src_ptr[j][i].r / 255.0;
			tmp_g[j][i] = (double)src_ptr[j][i].g / 255.0;
			tmp_b[j][i] = (double)src_ptr[j][i].b / 255.0;
		}
	}


	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			int min_val = src_ptr[j][i].r;
			min_val = (min_val > src_ptr[j][i].g) ? src_ptr[j][i].g : min_val;
			min_val = (min_val > src_ptr[j][i].b) ? src_ptr[j][i].b : min_val;

			tmp_arr[j][i] = 1.0 - (3.0 * min_val / (tmp_r[j][i] + tmp_g[j][i] + tmp_b[j][i]));			
			
		}
	}

	CConvOp conv;
	conv.ScaleImageValue(dst, tmp_arr);	
	

	for (int i = 0; i < src_h; i++)
		delete(tmp_arr[i]);
	delete(tmp_arr);

	for (int i = 0; i < src_h; i++)
		delete(tmp_r[i]);
	delete(tmp_r);

	for (int i = 0; i < src_h; i++)
		delete(tmp_g[i]);
	delete(tmp_g);

	for (int i = 0; i < src_h; i++)
		delete(tmp_b[i]);
	delete(tmp_b);
}

void GetIntComponent(CDib *dst, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	int dst_w = dst->GetWidth();
	int dst_h = dst->GetHeight();

	BYTE** dst_ptr = dst->GetPtr();
	RGBBYTE** src_ptr = src->GetRGBPtr();
	
	double **tmp_arr = nullptr;
	tmp_arr = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_arr[i] = new double[src_w];		

	double **tmp_r = nullptr;
	tmp_r = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_r[i] = new double[src_w];

	double **tmp_g = nullptr;
	tmp_g = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_g[i] = new double[src_w];
	
	double **tmp_b = nullptr;
	tmp_b = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_b[i] = new double[src_w];

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			tmp_arr[j][i] = 0;

			tmp_r[j][i] = (double)src_ptr[j][i].r / 255.0;
			tmp_g[j][i] = (double)src_ptr[j][i].g / 255.0;
			tmp_b[j][i] = (double)src_ptr[j][i].b / 255.0;
			
		}
	}

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			tmp_arr[j][i] = ((tmp_r[j][i] + tmp_g[j][i] + tmp_b[j][i]) / 3.0);
		}
	}

	CConvOp conv;
	conv.ScaleImageValue(dst, tmp_arr);
		

	for (int i = 0; i < src_h; i++)
		delete(tmp_arr[i]);
	delete(tmp_arr);

	for (int i = 0; i < src_h; i++)
		delete(tmp_r[i]);
	delete(tmp_r);

	for (int i = 0; i < src_h; i++)
		delete(tmp_g[i]);
	delete(tmp_g);

	for (int i = 0; i < src_h; i++)
		delete(tmp_b[i]);
	delete(tmp_b);
}

void RGBtoHSI(CDib *hue, CDib *sat, CDib *inten, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();

	RGBBYTE** src_ptr = src->GetRGBPtr();
	BYTE** hue_ptr = hue->GetPtr();
	BYTE** sat_ptr = sat->GetPtr();
	BYTE** int_ptr = inten->GetPtr();

	double **tmp_r = nullptr;
	tmp_r = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_r[i] = new double[src_w];

	double **tmp_g = nullptr;
	tmp_g = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_g[i] = new double[src_w];

	double **tmp_b = nullptr;
	tmp_b = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_b[i] = new double[src_w];

	double **tmp_hue = nullptr;
	tmp_hue = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_hue[i] = new double[src_w];

	double **tmp_sat = nullptr;
	tmp_sat = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_sat[i] = new double[src_w];

	double **tmp_int = nullptr;
	tmp_int = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_int[i] = new double[src_w];


	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			tmp_r[j][i] = (double)src_ptr[j][i].r / 255.0;
			tmp_g[j][i] = (double)src_ptr[j][i].g / 255.0;
			tmp_b[j][i] = (double)src_ptr[j][i].b / 255.0;
		}
	}

	double epsillon = 0.000001;

	for (int j = 0; j < src_h; j++)
	{
		double theta = 0.0;
		double numer = 0.0;
		double denomi = 0.0;
		double min_val = 0.0;

		for (int i = 0; i < src_w; i++)
		{
			numer = ((tmp_r[j][i] - tmp_g[j][i]) + (tmp_r[j][i] - tmp_b[j][i])) / 2.0;
			denomi = sqrt(pow((tmp_r[j][i] - tmp_g[j][i]), 2) + ((tmp_r[j][i] - tmp_b[j][i]) * (tmp_g[j][i] - tmp_b[j][i])));
			theta = acos(numer / (denomi/* + epsillon*/));

			if (tmp_b[j][i] <= tmp_g[j][i])
			{
				tmp_hue[j][i] = theta;
			}
			else
			{
				tmp_hue[j][i] = 2 * PI - theta;
			}

			if (tmp_hue[j][i] < 0.0)
				tmp_hue[j][i] = 0.0;
			if (tmp_hue[j][i] > 2 * PI)
				tmp_hue[j][i] = 2 * PI;

			tmp_hue[j][i] = ((tmp_hue[j][i] * 180.0 / PI) / 360.0) * 255.0; // [0,255]			
			hue_ptr[j][i] = (int)round(tmp_hue[j][i]);

			min_val = tmp_r[j][i];
			min_val = (min_val > tmp_g[j][i]) ? tmp_g[j][i] : min_val;
			min_val = (min_val > tmp_b[j][i]) ? tmp_b[j][i] : min_val;

			tmp_sat[j][i] = 1.0 - ((3.0 / (tmp_r[j][i] + tmp_g[j][i] + tmp_b[j][i])) * min_val);
			tmp_sat[j][i] *= 255.0;
			if (tmp_sat[j][i] < 0.0)
				tmp_sat[j][i] = 0.0;
			if (tmp_sat[j][i] > 255.0)
				tmp_sat[j][i] = 255.0;
			sat_ptr[j][i] = (int)round(tmp_sat[j][i]);

			tmp_int[j][i] = (tmp_r[j][i] + tmp_g[j][i] + tmp_b[j][i]) / 3.0;
			tmp_int[j][i] *= 255.0;
			if (tmp_int[j][i] < 0.0)
				tmp_int[j][i] = 0.0;
			if (tmp_int[j][i] > 255.0)
				tmp_int[j][i] = 255.0;
			int_ptr[j][i] = (int)round(tmp_int[j][i]);

			
		}
	}
	

	for (int i = 0; i < src_h; i++)
		delete(tmp_hue[i]);
	delete(tmp_hue);

	for (int i = 0; i < src_h; i++)
		delete(tmp_sat[i]);
	delete(tmp_sat);

	for (int i = 0; i < src_h; i++)
		delete(tmp_int[i]);
	delete(tmp_int);
	
	
	for (int i = 0; i < src_h; i++)
		delete(tmp_r[i]);
	delete(tmp_r);

	for (int i = 0; i < src_h; i++)
		delete(tmp_g[i]);
	delete(tmp_g);

	for (int i = 0; i < src_h; i++)
		delete(tmp_b[i]);
	delete(tmp_b);
}

void CImageToolDoc::OnRgbToHsi()
{
	// TODO: Add your command handler code here	
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	if (m_Dib.GetBitCount() == 8)
	{
		CDib dib = m_Dib;
		BYTE** ptr = dib.GetPtr();
		CDib dst_dib;
		dst_dib.CreateGrayImage(w, h, 0);
		BYTE** dst_ptr = dst_dib.GetPtr();
		
		for (int j = 0; j < h; j++)
		{
			for (int i = 0; i < w; i++)
			{				
				dst_ptr[j][i] = ptr[j][i];
			}
		}
		

		AfxNewImage(dib);
	}
	else if (m_Dib.GetBitCount() == 24)
	{
		CDib src_dib = m_Dib;
		RGBBYTE** src_ptr = src_dib.GetRGBPtr();
		
		CDib hue_dib;
		CDib sat_dib;
		CDib int_dib;
		hue_dib.CreateGrayImage(w, h);
		sat_dib.CreateGrayImage(w, h);
		int_dib.CreateGrayImage(w, h);
		
		RGBtoHSI(&hue_dib, &sat_dib, &int_dib, &src_dib);

		
		AfxNewImage(hue_dib);		
		AfxNewImage(sat_dib);		
		AfxNewImage(int_dib);	

	}
	else
	{
		AfxMessageBox((LPCTSTR)"It's not supported");
	}

}


void RGBComplement(CDib *dst, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	RGBBYTE **src_ptr = src->GetRGBPtr();
	RGBBYTE **dst_ptr = dst->GetRGBPtr();

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			dst_ptr[j][i].r = 255 - src_ptr[j][i].r;
			dst_ptr[j][i].g = 255 - src_ptr[j][i].g;
			dst_ptr[j][i].b = 255 - src_ptr[j][i].b;
		}
	}
}

void HueComplement(CDib *dst, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	BYTE **src_ptr = src->GetPtr();
	BYTE **dst_ptr = dst->GetPtr();

	double **tmp_hue = nullptr;
	tmp_hue = new double*[src_h];
	for (int i = 0; i < src_h; i++)
		tmp_hue[i] = new double[src_w];

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			tmp_hue[j][i] = (double)src_ptr[j][i] / 255.0;
		}
	}

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			tmp_hue[j][i] += 0.5;
			if (tmp_hue[j][i] > 1)
				tmp_hue[j][i] -= 1.0;
						
			tmp_hue[j][i] *= 255.0;
			if (tmp_hue[j][i] > 255.0)
				tmp_hue[j][i] = 255.0;
			if (tmp_hue[j][i] < 0.0)
				tmp_hue[j][i] = 0.0;
			dst_ptr[j][i] = (int)round(tmp_hue[j][i]);
		}
	}

	
	for (int i = 0; i < src_h; i++)
		delete(tmp_hue[i]);
	delete(tmp_hue);
}

void SatComplement(CDib *dst, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	BYTE **src_ptr = src->GetPtr();
	BYTE **dst_ptr = dst->GetPtr();

	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			dst_ptr[j][i] = src_ptr[j][i];
		}
	}
}

void IntComplement(CDib *dst, CDib *src)
{
	int src_w = src->GetWidth();
	int src_h = src->GetHeight();
	BYTE **src_ptr = src->GetPtr();
	BYTE **dst_ptr = dst->GetPtr();
	for (int j = 0; j < src_h; j++)
	{
		for (int i = 0; i < src_w; i++)
		{
			dst_ptr[j][i] = 255 - src_ptr[j][i];
		}
	}
}

void HSItoRGB(CDib *dst, CDib *hue, CDib *sat, CDib *intensity)
{
	int dst_w = dst->GetWidth();
	int dst_h = dst->GetHeight();
	RGBBYTE **dst_ptr = dst->GetRGBPtr();
	BYTE **hue_ptr = hue->GetPtr();
	BYTE **sat_ptr = sat->GetPtr();
	BYTE **int_ptr = intensity->GetPtr();

	double **hue_tmp = nullptr;
	hue_tmp = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		hue_tmp[i] = new double[dst_w];

	double **sat_tmp = nullptr;
	sat_tmp = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		sat_tmp[i] = new double[dst_w];

	double **int_tmp = nullptr;
	int_tmp = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		int_tmp[i] = new double[dst_w];	

	double **tmp_r = nullptr;
	tmp_r = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		tmp_r[i] = new double[dst_w];

	double **tmp_g = nullptr;
	tmp_g = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		tmp_g[i] = new double[dst_w];

	double **tmp_b = nullptr;
	tmp_b = new double*[dst_h];
	for (int i = 0; i < dst_h; i++)
		tmp_b[i] = new double[dst_w];


	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			hue_tmp[j][i] = (((double)hue_ptr[j][i] / 255.0) * 360.0) * PI / 180.0; // [0,1] -> [0,360], degree -> radian [0,2*PI]
			sat_tmp[j][i] = sat_ptr[j][i] / 255.0;
			int_tmp[j][i] = int_ptr[j][i] / 255.0;			
			tmp_r[j][i] = 0.0;
			tmp_g[j][i] = 0.0;
			tmp_b[j][i] = 0.0;			
		}
	}

	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{
			double x = 0.0, y = 0.0, z = 0.0;			

			if ((hue_tmp[j][i] >= 0.0) && (hue_tmp[j][i] < (2.0 * PI / 3.0)))
			{				
				x = int_tmp[j][i] * (1.0 - sat_tmp[j][i]);
				y = int_tmp[j][i] * (1.0 + ((sat_tmp[j][i] * cos(hue_tmp[j][i]) / (cos((PI / 3.0) - hue_tmp[j][i])))));
				z = (3.0 * int_tmp[j][i]) - (x + y);

				tmp_b[j][i] = x;
				tmp_r[j][i] = y;
				tmp_g[j][i] = z;
			}
			else if ((hue_tmp[j][i] >= (2.0 * PI / 3.0)) && (hue_tmp[j][i] < (4.0 * PI / 3.0)))
			{				
				x = int_tmp[j][i] * (1.0 - sat_tmp[j][i]);
				hue_tmp[j][i] = hue_tmp[j][i] - (2.0 * PI / 3.0);
				y = int_tmp[j][i] * (1.0 + ((sat_tmp[j][i] * cos(hue_tmp[j][i]) / (cos((PI / 3.0) - hue_tmp[j][i])))));
				z = (3.0 * int_tmp[j][i]) - (x + y);
				
				tmp_r[j][i] = x;
				tmp_g[j][i] = y;
				tmp_b[j][i] = z;
			}
			else
			{				
				x = int_tmp[j][i] * (1.0 - sat_tmp[j][i]);
				hue_tmp[j][i] = hue_tmp[j][i] - (4.0 * PI / 3.0);
				y = int_tmp[j][i] * (1.0 + ((sat_tmp[j][i] * cos(hue_tmp[j][i]) / (cos((PI / 3.0) - hue_tmp[j][i])))));
				z = (3.0 * int_tmp[j][i]) - (x + y);
				
				tmp_g[j][i] = x;
				tmp_b[j][i] = y;
				tmp_r[j][i] = z;
			}			

			if (tmp_r[j][i] > 1.0)
				tmp_r[j][i] = 1.0;
			if (tmp_g[j][i] > 1.0)
				tmp_g[j][i] = 1.0;
			if (tmp_b[j][i] > 1.0)
				tmp_b[j][i] = 1.0;
			if (tmp_r[j][i] < 0.0)
				tmp_r[j][i] = 0.0;
			if (tmp_g[j][i] < 0.0)
				tmp_g[j][i] = 0.0;
			if (tmp_b[j][i] < 0.0)
				tmp_b[j][i] = 0.0;
		}
	}
		

	for (int j = 0; j < dst_h; j++)
	{
		for (int i = 0; i < dst_w; i++)
		{		
			tmp_r[j][i] *= 255.0;
			tmp_g[j][i] *= 255.0;
			tmp_b[j][i] *= 255.0;
			
			dst_ptr[j][i].r = (int)round(tmp_r[j][i]);
			dst_ptr[j][i].g = (int)round(tmp_g[j][i]);
			dst_ptr[j][i].b = (int)round(tmp_b[j][i]);
						
		}
	}

	for (int i = 0; i < dst_h; i++)
	{
		delete(hue_tmp[i]);
		delete(sat_tmp[i]);
		delete(int_tmp[i]);	
		delete(tmp_r[i]);
		delete(tmp_g[i]);
		delete(tmp_b[i]);
	}
	delete(hue_tmp);
	delete(sat_tmp);
	delete(int_tmp);
	delete(tmp_r);
	delete(tmp_g);
	delete(tmp_b);
}

void CImageToolDoc::OnColorComplement()
{
	// TODO: Add your command handler code here
	
	int w = m_Dib.GetWidth();
	int h = m_Dib.GetHeight();

	if (m_Dib.GetBitCount() == 24)
	{
		CDib src_dib = m_Dib;
		RGBBYTE** src_ptr = src_dib.GetRGBPtr();

		CDib complement_dib;
		complement_dib.CreateRGBImage(w, h);
		RGBComplement(&complement_dib, &src_dib);
		AfxNewImage(complement_dib);
		

		CDib hue_dib;
		CDib sat_dib;
		CDib int_dib;
		hue_dib.CreateGrayImage(w, h);
		sat_dib.CreateGrayImage(w, h);
		int_dib.CreateGrayImage(w, h);
		
		RGBtoHSI(&hue_dib, &sat_dib, &int_dib, &src_dib);
		
		CDib hue_complement;
		CDib sat_complement;
		CDib int_complement;
		hue_complement.CreateGrayImage(w, h);
		sat_complement.CreateGrayImage(w, h);
		int_complement.CreateGrayImage(w, h);

		HueComplement(&hue_complement, &hue_dib);
		SatComplement(&sat_complement, &sat_dib);
		IntComplement(&int_complement, &int_dib);

		CDib dst_dib;
		dst_dib.CreateRGBImage(w, h);
		HSItoRGB(&dst_dib, &hue_complement, &sat_complement, &int_complement);		
		AfxNewImage(dst_dib);
	}
	else
	{
		AfxMessageBox((LPCTSTR)"It's not supported");
	}
}


void CImageToolDoc::OnColorSlicing()
{
	// TODO: Add your command handler code here
	int src_w = m_Dib.GetWidth();
	int src_h = m_Dib.GetHeight();

	if (m_Dib.GetBitCount() == 24)
	{
		CDib src_dib = m_Dib;
		RGBBYTE** src_ptr = src_dib.GetRGBPtr();
		CDib dst_dib1; // cube-based color slicing
		dst_dib1.CreateRGBImage(src_w, src_h);
		RGBBYTE** dst_ptr1 = dst_dib1.GetRGBPtr();
		CDib dst_dib2; // sphere-based color slicing
		dst_dib2.CreateRGBImage(src_w, src_h);
		RGBBYTE** dst_ptr2 = dst_dib2.GetRGBPtr();

		const double w = 0.2549;
		const double r0 = 0.1765;

		// cube-based color sliving
		double **r_tmp1 = nullptr;
		r_tmp1 = new double*[src_h];
		double **g_tmp1 = nullptr;
		g_tmp1 = new double*[src_h];
		double **b_tmp1 = nullptr;
		b_tmp1 = new double*[src_h];
		for (int i = 0; i < src_h; i++)
		{
			r_tmp1[i] = new double[src_w];
			g_tmp1[i] = new double[src_w];
			b_tmp1[i] = new double[src_w];
		}

		for (int j = 0; j < src_h; j++)
		{
			for (int i = 0; i < src_w; i++)
			{
				r_tmp1[j][i] = src_ptr[j][i].r / 255.0f;
				g_tmp1[j][i] = src_ptr[j][i].g / 255.0f;
				b_tmp1[j][i] = src_ptr[j][i].b / 255.0f;
			}
		}

		for (int j = 0; j < src_h; j++)
		{
			double dist1 = 0.0;
			double dist2 = 0.0;
			double dist3 = 0.0;

			for (int i = 0; i < src_w; i++)
			{
				dist1 = abs(r_tmp1[j][i] - 0.6863);
				dist2 = abs(g_tmp1[j][i] - 0.1608);
				dist3 = abs(b_tmp1[j][i] - 0.1922);

				if ((dist1 > (w / 2)) || (dist2 > (w / 2)) || (dist3 > (w / 2)))
				{
					r_tmp1[j][i] = 0.5;
					g_tmp1[j][i] = 0.5;
					b_tmp1[j][i] = 0.5;
				}
				

				dst_ptr1[j][i].r = (int)round(r_tmp1[j][i] * 255.0);
				dst_ptr1[j][i].g = (int)round(g_tmp1[j][i] * 255.0);
				dst_ptr1[j][i].b = (int)round(b_tmp1[j][i] * 255.0);
			}
		}
		
		AfxNewImage(dst_dib1);

		for (int i = 0; i < src_h; i++)
		{
			delete(r_tmp1[i]);
			delete(g_tmp1[i]);
			delete(b_tmp1[i]);
		}
		delete(r_tmp1);
		delete(g_tmp1);
		delete(b_tmp1);

		// sphere-based color slicing
		double **r_tmp2 = nullptr;
		r_tmp2 = new double*[src_h];
		double **g_tmp2 = nullptr;
		g_tmp2 = new double*[src_h];
		double **b_tmp2 = nullptr;
		b_tmp2 = new double*[src_h];
		for (int i = 0; i < src_h; i++)
		{
			r_tmp2[i] = new double[src_w];
			g_tmp2[i] = new double[src_w];
			b_tmp2[i] = new double[src_w];
		}

		for (int j = 0; j < src_h; j++)
		{
			for (int i = 0; i < src_w; i++)
			{
				r_tmp2[j][i] = src_ptr[j][i].r / 255.0f;
				g_tmp2[j][i] = src_ptr[j][i].g / 255.0f;
				b_tmp2[j][i] = src_ptr[j][i].b / 255.0f;
			}
		}

		for (int j = 0; j < src_h; j++)
		{
			double dist1 = 0.0;
			double dist2 = 0.0;
			double dist3 = 0.0;
			double sum_dist = 0.0;

			for (int i = 0; i < src_w; i++)
			{
				dist1 = pow((r_tmp2[j][i] - 0.6863), 2);
				dist2 = pow((g_tmp2[j][i] - 0.1608), 2);
				dist3 = pow((b_tmp2[j][i] - 0.1922), 2);
				sum_dist = dist1 + dist2 + dist3;

				if (sum_dist > pow(r0, 2))
				{
					r_tmp2[j][i] = 0.5;
					g_tmp2[j][i] = 0.5;
					b_tmp2[j][i] = 0.5;
				}

				dst_ptr2[j][i].r = (int)round(r_tmp2[j][i] * 255.0);
				dst_ptr2[j][i].g = (int)round(g_tmp2[j][i] * 255.0);
				dst_ptr2[j][i].b = (int)round(b_tmp2[j][i] * 255.0);
			}
		}
				

		AfxNewImage(dst_dib2);

		for (int i = 0; i < src_h; i++)
		{
			delete(r_tmp2[i]);
			delete(g_tmp2[i]);
			delete(b_tmp2[i]);
		}
		delete(r_tmp2);
		delete(g_tmp2);
		delete(b_tmp2);
	}
	else
	{
		AfxMessageBox((LPCTSTR)"It's not supported");
	}
}
