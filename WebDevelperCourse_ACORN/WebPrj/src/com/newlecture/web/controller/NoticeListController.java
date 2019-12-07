package com.newlecture.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice/list")
public class NoticeListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "select * FROM NOTICE order by id desc";
		List<Map<String, Object>> list = new ArrayList<>();
//		List<Integer> list2 = new ArrayList<>();
//		List<Notice> list3 = new ArrayList<>();
//		int[] x = new int[10]; 
//		Notice[] n = new Notice()[10];

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url, "ACORN", "newlec");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Map<String, Object> notice = new HashMap<>();

				notice.put("id", rs.getInt("id"));
				notice.put("title", rs.getString("title"));
				notice.put("writer_id", rs.getString("writer_id"));
				notice.put("regdate", rs.getDate("regdate"));
				notice.put("hit", rs.getInt("hit"));

				list.add(notice);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);		
		

		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp") // 이 page가 요청이 왔을때의 url기반으로 요청을 함
		.forward(request, response);

	}
}
