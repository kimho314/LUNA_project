package com.newlecture.web.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.newlecture.web.dao.MemberDao;

public class MyHomeRedirectionHandler implements AuthenticationSuccessHandler
{
	@Autowired
	private MemberDao memberDao;
	
	private RedirectStrategy redirectStrategy;
	
	public MyHomeRedirectionHandler()
	{
		// TODO MyHomeRedirectionHandler()
		redirectStrategy = new DefaultRedirectStrategy();
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException
	{
		// TODO onAuthenticationSuccess()
		// 로그인된 유저의 정보를 얻는 방법
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String id = user.getUsername();
		String defaultRole = "ROLE_ADMIN"; // DB에서  role정보 가져와야 함
		
		if(defaultRole.equals("ROLE_ADMIN"))
		{
			redirectStrategy.sendRedirect(request, response, "/admin/index");
		}
		else if(defaultRole.equals("ROLE_STUDENT"))
		{
			redirectStrategy.sendRedirect(request, response, "/student/index");
		}
		else
		{
			HttpSession session = request.getSession();
			SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			
			if(savedRequest != null)
			{
				String returnURL = savedRequest.getRedirectUrl();
				redirectStrategy.sendRedirect(request, response, returnURL);
			}
			else
			{
				redirectStrategy.sendRedirect(request, response, "/member/home");
			}
		}
	}

}
