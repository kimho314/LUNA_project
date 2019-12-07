package com.newlecture.web.entity;

import java.util.Date;

public class Member {
	private String id;
	private String pwd;
	private String name;
	private String phone;
	private String birthday;
	private Date regdate;
	private String gender;
	private String email;
	
	public Member() {
	}
	
	public Member(String id, String pwd, String name, String phone, String birthday, Date regdate,
			String gender, String email) {
		
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		this.birthday = birthday;
		this.regdate = regdate;
		this.gender = gender;
		this.email = email;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString()
	{
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", phone=" + phone + ", birthday=" + birthday
				+ ", regdate=" + regdate + ", gender=" + gender + ", email=" + email + "]";
	}

	
}