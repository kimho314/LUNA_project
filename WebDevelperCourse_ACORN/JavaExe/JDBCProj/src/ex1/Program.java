package ex1;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Program {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
		
		// Class -> RTTI(Runtime Type Information) 클래스
		// Class 객체를 얻는 방법
		//ArrayList list = new ArrayList();
				
		//Class cls = list.getClass();
		//Class cls1 = ArrayList.class;
		
		/*
		Method[] methods = cls.getMethods();		
		for(Method m : methods)
		{
			System.out.println(m.getName());
		}
		*/
		/*
		Method[] methods = cls1.getMethods();
		for(Method m : methods)
		{
			System.out.println(m.getName());
		}
		*/
		/*
		String clsName = "ex1.Exam";
		Class cls = Class.forName(clsName);
		Exam exam = (Exam)cls.newInstance();
		exam.setKor(10);
		
		System.out.printf("total : %d, avg : %f\n", exam.total(), exam.avg());
		*/
		
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "SELECT TITLE, HIT+1 AS HIT FROM NOTICE";
		
		// new oracle.jdbc.driver.OracleDriver();
		// DriverManager.registerDriver(driver);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"ACORN","newlec");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
//		rs.next();
//		String title = rs.getString("title");
//		System.out.println(title);
		
		while(true)
		{
			boolean ret = rs.next();
			if(ret == false)
				break;
			
			String title = rs.getString("title");
			int hit = rs.getInt("HIT");
			System.out.println("title : " + title + " hit : " + hit);

		}
		
//		while(rs.next())
//		{			
//			String title = rs.getString("title");
//			System.out.println(title);
//		}
		
		/*
		DriverManager;
		Connection;
		Statement;
		ResultSet;
		*/
	}
}
