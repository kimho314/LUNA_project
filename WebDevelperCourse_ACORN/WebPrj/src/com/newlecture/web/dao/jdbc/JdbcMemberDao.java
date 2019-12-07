package com.newlecture.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;

public class JdbcMemberDao implements MemberDao {

	@Override
	public List<Member> getList() {
		List<Member> list = new ArrayList<>();
		Member member = null;

		String sql = "select * from member";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				member = new Member(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("phone"), rs.getString("birthday"), rs.getDate("regdate"),
						rs.getString("gender"), rs.getString("email"));
				
				list.add(member);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public Member get(String id) {
		
		Member member = null;

		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE ID = ? ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				member = new Member(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
						rs.getString("phone"), rs.getString("birthday"), rs.getDate("regdate"),
						rs.getString("gender"), rs.getString("email"));
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public int insert(Member member) {
		int result = 0;

		String sql = "INSERT INTO MEMBER(ID,PWD,NAME,GENDER,BIRTHDAY,PHONE,EMAIL) VALUES(?,?,?,?,?,?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, member.getId());
			st.setString(2, member.getPwd());
			st.setString(3, member.getName());
			st.setString(4, member.getGender());
			st.setString(5, member.getBirthday());
			st.setString(6, member.getPhone());
			st.setString(7, member.getEmail());
			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(Member member) {
		int result = 0;

		String sql = "UPDATE MEMBER SET pwd = ?, name = ?, gender = ?, birthday = ?, phone = ?, eamil = ?";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, member.getPwd());
			st.setString(2, member.getName());
			st.setString(3, member.getGender());
			st.setString(4, member.getBirthday());
			st.setString(5, member.getPhone());
			st.setString(6, member.getEmail());
			result = st.executeUpdate();

			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public int delete(String id) {
		int result = 0;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String sql = "delete from member where id = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			result = st.executeUpdate();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
