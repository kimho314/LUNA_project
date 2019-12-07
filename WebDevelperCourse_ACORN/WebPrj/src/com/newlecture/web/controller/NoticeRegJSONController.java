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
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;
import com.newlecture.web.service.newlec.NewlecNoticeService;

@WebServlet("/notice/reg-json")
public class NoticeRegJSONController extends HttpServlet {
	

	private NoticeService noticeService;

	public NoticeRegJSONController() {
		noticeService = new NewlecNoticeService();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String title = request.getParameter("title");
		String writerId = request.getParameter("writerId");
		String regdate = request.getParameter("regdate");
		String hit = request.getParameter("hit");
		String content = "";
		String files = "";
		
		Notice notice = new Notice(title,content,writerId,files);
		
		System.out.println(notice.toString());
		int result = noticeService.insertNotice(notice);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}
	
}
