package com.newlecture.web.controller.admin.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.newlecture.web.service.NoticeService;
import com.newlecture.web.service.newlec.NewlecNoticeService;

// 공지 사항 목록을 줘

@WebServlet("/admin/board/notice/list")
public class NoticeListController extends HttpServlet {

	private NoticeService noticeService;

	public NoticeListController() {
		noticeService = new NewlecNoticeService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int page = 1;
		String field = "title";
		String query = "";
		
		String _page = request.getParameter("p");
		if(_page != null && !_page.equals(""))
		{
			page = Integer.parseInt(_page);
		}
		
		String _field = request.getParameter("f");
		if(_field != null && !_field.equals(""))
		{
			field = _field;
		}
		
		String _query = request.getParameter("q");
		if(_query != null && !_query.equals(""))
		{
			query = _query;
		}
		
		// 컨트롤러가 할 일은 데이터 준비하는 일		
		request.setAttribute("list",noticeService.getNoticeList(page, field, query));
		request.setAttribute("listCount",noticeService.getNoticeListCount(field, query));
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String cmd = "";
		cmd = req.getParameter("cmd");
		
		switch(cmd)
		{
		case "일괄공개":
			break;
			
		case "일괄삭제":
			String[] _ids = req.getParameterValues("del");
			
			int[] ids = new int[_ids.length];
			for(int i=0; i<ids.length; i++)
			{
				ids[i] = Integer.parseInt(_ids[i]);
			}
			
			noticeService.deleteNoticeList(ids);			
			break;
		}		
		
		resp.sendRedirect("list");
	}
}
