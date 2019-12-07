package ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
			int sel = 0;
			
			Scanner sc = new Scanner(System.in);
			sel = sc.nextInt();
			
			String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
			String sql = "SELECT ROWNUM NUM, TITLE, WRITER_ID, TO_CHAR(REGDATE,'YYYY-MM-DD') REGDATE, HIT, CONTENT "
					+ "FROM (SELECT ROWNUM RN, NOTICE.* FROM NOTICE) "
					+ "WHERE WRITER_ID IS NOT NULL AND REGDATE IS NOT NULL AND RN = " + Integer.toString(sel) + " "
					+ "ORDER BY REGDATE DESC";
			
			System.out.println(sql);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"ACORN","newlec");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(true)
			{
				boolean ret = rs.next();
				if(ret == false)
					break;
				
				int num = rs.getInt("num");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("writer_id");
				String regDate = rs.getString("REGDATE");
				int hit = rs.getInt("hit");
				String content = rs.getString("content");
				System.out.println(num + ", " + title + ", " + writerId + ", " + hit + ", " + regDate + ", " 
							+ hit +", " + content );
			}
			System.out.println("");
		}
}
