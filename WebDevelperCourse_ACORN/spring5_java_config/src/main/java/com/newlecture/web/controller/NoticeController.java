package com.newlecture.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
		
	@GetMapping("list")
	public String list(@RequestParam(defaultValue="1", name="p") Integer page, Model model) {
		
		List<NoticeView> list = service.getNoticeList(page);
		model.addAttribute("list", list);
		
		return "notice.list";
	}
	
	@GetMapping("{id}/detail")
	public String detail(@PathVariable("id") Integer id, Model model) {
		
		Notice notice = service.getNotice(id);
		model.addAttribute("notice", notice);
		
		return "notice.detail";
	}
}