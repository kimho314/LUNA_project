package com.newlecture.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;
import com.newlecture.web.service.newlec.NewlecMemberService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet
{
	private MemberService memberService;
	
	public LoginController()
	{
		memberService = new NewlecMemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;UTF-8");		
		
		String returnUrl = req.getParameter("returnUrl");
		req.setAttribute("returnUrl", returnUrl);
		
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String id = ""; // 사용자가 전달한 내용
		String pwd = "";
				
		id = req.getParameter("username");
		pwd = req.getParameter("password");
		String returnUrl = req.getParameter("return-url");
		
		boolean isValid = memberService.isValidMember(id, pwd);
		
		if(!isValid)
		{
			// 오류가 포함된 로그인 페이지로 보내기
			resp.sendRedirect("login?error=1");
		}
		else
		{
			// 인증성공 + 권란 : Authentication and Authority
			// 이 유저가 현재 인증이 되었음을 알림 -> 인증 상태를 모든 서블릿이 알아야 함
			// 어떤 상태를 어디에 남겨야 할까?
			// index 또는 회원페이지로 보내기
			req.getSession().setAttribute("userName", id);
			
			if(returnUrl != null && !returnUrl.equals(""))
			{
				resp.sendRedirect(returnUrl);
			}
			else
			{
				resp.sendRedirect("/index");
			}
		}
	}
}
