package com.newlecture.web.service;

import com.newlecture.web.entity.Member;

public interface MemberService
{
	boolean isValidMember(String id, String pwd);
	boolean isDupId(String id);
	int insertMember(Member member);
}
