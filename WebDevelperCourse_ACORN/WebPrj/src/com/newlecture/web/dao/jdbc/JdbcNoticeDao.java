package com.newlecture.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {

	@Override
	public int insert(Notice notice) {
		int result = 0;
		String sql = "INSERT INTO NOTICE(TITLE,CONTENT,WRITER_ID, FILES) VALUES(?,?,?,?)";
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getWriterId());
			st.setString(4, notice.getFiles());
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
	public List<NoticeView> getList() {
	
		return getList(1, "title", "");
	}

	@Override
	public List<NoticeView> getList(int page) {
		
		return getList(page, "title", "");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) {
		List<NoticeView> list = new ArrayList<>();
		NoticeView NoticeView = null;

		String sql = "select * from" 
				+ "(select rownum num, n.*" 
				+ "from (select * from notice_view where " + field
				+ " like ? order by regdate desc ) n )" 
				+ "where num between ? and ?";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			st.setInt(2, (page - 1) * 10 + 1);
			st.setInt(3, page * 10);

			ResultSet rs = st.executeQuery();

			while (rs.next()) 
			{
				NoticeView = new NoticeView(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer_id"), rs.getDate("regdate"), rs.getString("files"), rs.getInt("hit"),
						rs.getBoolean("open"), rs.getInt("CMT_COUNT"));

				list.add(NoticeView);
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
	public Notice get(int id) {

		Notice notice = null;

		String sql = "select * FROM NOTICE where id = ? ";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer_id"), rs.getDate("regdate"), rs.getString("files"), rs.getInt("hit"),
						rs.getBoolean("open"));
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}

	@Override
	public int update(Notice notice) {
		int result = 0;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String sql = "update notice set title = ?, content = ?, files = ?, hit = ?, writer_id = ? where id = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, notice.getTitle());
			st.setString(2, notice.getContent());
			st.setString(3, notice.getFiles());
			st.setInt(4, notice.getHit());
			st.setInt(5, notice.getId());

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
	public int delete(int id) {
		int result = 0;
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String sql = "delete from notice where id = ? ";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
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
	public int openList(int[] ids) {
		int result = 0;

		String values = "";
		for (int i = 0; i < ids.length; i++) {
			values += ids[i];
			if (i < ids.length - 1)
				values += ",";
		}
		
		System.out.println(values);
		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String sql = "update notice set open = 1 where id in (" + values + ") ";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
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
	public Notice getPrevById(int id) {
		
		Notice notice = null;

		String sql = "select * " + "from (select * from notice_view order by regdate desc) "
				+ "where regdate < (select regdate from notice where id = ?) " + "and rownum = 1";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer_id"), rs.getDate("regdate"), rs.getString("files"), rs.getInt("hit"),
						rs.getBoolean("open"));
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}

	@Override
	public Notice getNextById(int id) {

		Notice notice = null;

		String sql = "select * " + "from (select * from notice_view order by regdate asc) "
				+ "where regdate > (select regdate from notice where id = ?) " + "and rownum = 1";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				notice = new Notice(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
						rs.getString("writer_id"), rs.getDate("regdate"), rs.getString("files"), rs.getInt("hit"),
						rs.getBoolean("open"));
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notice;
	}

	@Override
	public int getListCount(String field, String query)
	{
		// TODO getListCount
		int count = 0;

		String sql = "SELECT COUNT(ID) COUNT FROM NOTICE WHERE "
				+ field + " LIKE ?";
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, "%" + query + "%");
			ResultSet rs = st.executeQuery();

			if (rs.next())
			{
				count = rs.getInt("COUNT");
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}
}
