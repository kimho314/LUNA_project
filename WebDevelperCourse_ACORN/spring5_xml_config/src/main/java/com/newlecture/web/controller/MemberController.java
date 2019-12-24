package com.newlecture.web.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController
{
	@Autowired
	private MemberService service;
	
	@GetMapping("login")
	public String login()
	{
		return "member.login";
	}
	
	@GetMapping("agree")
	public String agree()
	{
		return "member.agree";
	}
	
	@PostMapping("agree")
	public String agree(Boolean agree, HttpServletResponse resp)
	{
		Cookie agreeCookie = new Cookie("agree", agree.toString());
		resp.addCookie(agreeCookie);
		
		return "redirect:join";
	}
	
	@GetMapping("join")
	public String join(@CookieValue(value="agree", defaultValue="false") String agree)
	{
		if(agree.equals("false"))
		{
			return "redirect:agree";
		}
		
		return "member.join";
	}
	
	@PostMapping("join")
	public String join(Member member)
	{		
		service.insertMember(member);		
		
		return "redirect:confirm";
	}
	
	@GetMapping("pwd-reset")
	public String pwdReset()
	{
		return "member.pwd-reset";
	}
	
	@PostMapping("pwd-reset")
	public String pwdReset(String id, String email)
	{
		Member member = service.getMember(id);
		String name = member.getName();
		
		StringBuilder html = new StringBuilder();
		
		html.append("<html>");
		html.append("<h1>" + name +"</h1>");
		html.append("</html>");
		
		
		
		return "redirect:login";
	}
	
	
	@ResponseBody 
	@GetMapping("duplicated")
	public Boolean getMember(String id)
	{
		Boolean ret = service.isDuplicatedId(id);
		
		return ret;
	}
}
