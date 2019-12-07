package com.newlecture.web.service.newlec;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.jdbc.JdbcMemberDao;
import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

public class NewlecMemberService implements MemberService
{
	private MemberDao memberDao;
	
	public NewlecMemberService()
	{
		memberDao = new JdbcMemberDao();
	}
	
	@Override
	public boolean isValidMember(String id, String pwd)
	{
		// TODO isValidMember
		boolean ret = true;
		Member member = memberDao.get(id);
		
		System.out.println(member.toString());
		
		if(member == null)
		{
			ret =  false;
		}
		else if(!member.getPwd().equals(pwd))
		{
			ret =  false;
		}
		else
		{
			ret = true;
		}
		
		
		return ret;
	}

	@Override
	public boolean isDupId(String id)
	{
		// TODO isDupId
		return false;
	}

	@Override
	public int insertMember(Member member)
	{
		// TODO insertMember
		return 0;
	}

}
