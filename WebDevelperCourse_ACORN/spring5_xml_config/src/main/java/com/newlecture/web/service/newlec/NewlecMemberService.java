package com.newlecture.web.service.newlec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

@Service
public class NewlecMemberService implements MemberService
{
	@Autowired 
	private MemberDao memberDao; 
	
	@Override
	public boolean isValidMember(String id, String pwd)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDuplicatedId(String id)
	{
		// TODO Auto-generated method stub
		Member member = memberDao.get(id);
		
		if(member != null)
		{
			return true; 
		}
		
		return false;
	}

	@Override
	public int insertMember(Member member)
	{
		// TODO Auto-generated method stub
		// 1. 비번을 암호화하자.
		String pwd = member.getPwd();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPwd = encoder.encode(pwd);
		member.setPwd(hashedPwd);
		
		
		return 0;
	}

	@Override
	public Member getMember(String id)
	{
		// TODO Auto-generated method stub
		return memberDao.get(id);
	}

}
