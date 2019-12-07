package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;
import com.newlecture.web.service.newlec.NewlecNoticeService;

@WebServlet("/notice/list-json")
public class NoticeListJSONController extends HttpServlet {
	

	private NoticeService noticeService;

	public NoticeListJSONController() {
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
			System.out.println(request.getParameter("p"));
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
		
		List<NoticeView> list = noticeService.getNoticeList(page);
		
		
//		StringBuilder builder = new StringBuilder();
//		builder.append("[");
		
		/*
		 * String item = String.format("{\"id\":%d,\"title\":\"%s\"}", list.get(0).get("id"),
		 * list.get(0).get("title")); builder.append(item);
		 */
		
//		for(int i=0; i<list.size(); i++)
//		{
//			String item = String.format("{\"id\":%d,\"title\":\"%s\"}", list.get(i).get("id"), list.get(i).get("title"));
//			if(i<list.size()-1)
//			{
//				item += ",";
//			}
//			builder.append(item);
//		}
		
//		for(Map<String, Object> item : list)
//		{
//			String tmpItem = String.format("{\"id\":%d,\"title\":\"%s\"}", item.get("id"), item.get("title"));
//					
//			if(list.indexOf(item) < list.size()-1)
//			{
//				tmpItem += ",";
//			}
//			builder.append(tmpItem);
//		}
//		
//		builder.append("]");
//		
//		String json = builder.toString();

//		try
//		{
//			Thread.sleep(3000);
//		}
//		catch (InterruptedException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.write(json);
	}
}
