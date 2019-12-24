package com.newlecture.web.controller.admin.board;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeContoller {

	@Autowired
	private NoticeService noticeService;

	
	@GetMapping("{id}/edit")
	public String edit(@PathVariable("id") Integer id, Model model) {
		
		Notice notice = noticeService.getNotice(id);
		model.addAttribute("n", notice);
		
		return "admin.board.notice.edit";
	}
	
	@PostMapping("{id}/edit")
	public String edit(Integer id, String title, String content) {
		
		Notice notice = noticeService.getNotice(id);
		notice.setContent(content);
		notice.setTitle(title);
		
		noticeService.updateNotice(notice);
		
		return "redirect:../"+notice.getId();
	}
	
	@GetMapping("{id}/del")
	public String delete(@PathVariable("id") Integer id) {
		
		noticeService.deleteNotice(id);
		
		return "redirect:../list";
	}
	
	@GetMapping("reg")
	//@RequestMapping(value="reg", method=RequestMethod.GET)
	public String reg() {
		
		//return "admin/board/notice/reg";
		return "admin.board.notice.reg";
	}
	
	@PostMapping("reg")
	//@RequestMapping(value="reg", method=RequestMethod.POST)
	public String reg(Notice notice, Principal principal) {
				
		
		//notice.setWriterId("newlec");
		notice.setWriterId(principal.getName());
		noticeService.insertNotice(notice);
		
		return "redirect:list"; //-> "/WEB-INF/view/" + "list" + ".jsp";
	}
	
	@GetMapping("list")
	public String list(@RequestParam(defaultValue="1", name="p") Integer page, Model model) {
		
		System.out.println("page:" + page);
		//this.getClass().getMethods()[0].getParameters()[0].getName()
				
		List<NoticeView> list = noticeService.getNoticeList();
		model.addAttribute("list", list);
		
		return "admin.board.notice.list";
		//return "admin/board/notice/list";
	}
	
	@PostMapping("list")
	public String list(
			String cmd, 
			@RequestParam("del-id") int[] ids) {
		
		switch(cmd) {
		case "일괄삭제":
			noticeService.deleteNoticeList(ids);
			break;
		}
		
		System.out.println(cmd+", "+ids);		
		
		return "redirect:list";		
	}
	
	@GetMapping("{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		
		model.addAttribute("n", noticeService.getNotice(id));
		
		//return "admin/board/notice/detail";
		return "admin.board.notice.detail";
	}
}
