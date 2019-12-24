package com.newlecture.web.controller.admin.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

// Restful API
@RestController
@RequestMapping("/admin/board/notice/")
public class RestNoticeController {
	
	/*
	 * @Autowired
	 * private SqlSession sqlSession;
	 */
	
	@Autowired 
	private NoticeService noticeService;
	
	//@ResponseBody
	@GetMapping("list-json")
	public String listJSON() {
		
		//NoticeDao noticeDao = sqlSession.getMapper(NoticeDao.class);
		/* Notice n = noticeDao.get(1017); */
		
		List<NoticeView> list = noticeService.getNoticeList(1, "title", "");
		
		//String json = new Gson().toJson(n);
		String json = new Gson().toJson(list);
		
		return json;
	}
}
