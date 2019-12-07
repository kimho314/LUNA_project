package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTestServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String env = this.getInitParameter("charset");
		System.out.println(env);
		req.setCharacterEncoding(env);
		PrintWriter out = resp.getWriter();

		out.print("<h3>¿Ã∏ß : " + req.getParameter("name"));
		out.close();
	}
}
