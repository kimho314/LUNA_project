package com.newlecture.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminHomeController")
@RequestMapping("/admin/")
public class HomeController
{
	@GetMapping("index")
	public String home()
	{
		
		return "admin.index";
	}
}
