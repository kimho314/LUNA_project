package com.newlecture.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.service.MemberService;
import com.newlecture.web.service.newlec.NewlecMemberService;

@WebServlet("/member/logout")
public class LogoutController extends HttpServlet
{
	private MemberService memberService;
	
	public LogoutController()
	{
		memberService = new NewlecMemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		HttpSession session = req.getSession();
		session.invalidate(); // seesionÀ» ºñ¿ò
		
		resp.sendRedirect("../index");
	}
}
