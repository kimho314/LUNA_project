package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
		
	@GetMapping("list")
	public String list() {
		
		return "notice.list";
	}
	
	@GetMapping("detail")
	public String detail() {
		
		return "notice.detail";
	}
}
