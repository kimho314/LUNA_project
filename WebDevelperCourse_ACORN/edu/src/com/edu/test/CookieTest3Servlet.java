package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie3")
public class CookieTest3Servlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		int cnt = 0;
		Cookie[] list = req.getCookies();
		if(list != null)
		{
			for(Cookie c : list)
			{
				if(c.getName().equals("count"))
				{
					cnt = Integer.parseInt(c.getValue());
				}
			}
		}
		cnt++;
		
		Cookie c = new Cookie("count", cnt+"");
		c.setMaxAge(60);
		resp.addCookie(c);
		
		resp.setContentType("text/html;charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1>¹æ¹® È½¼ö : " + cnt);
		out.close();
	}
}
