package BoardSearching;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String url = "jdbc:oracle:thin:@192.168.0.3:1521/xepdb1";
		String sql = "SELECT ID, TITLE, WRITER_ID FROM NOTICE WHERE TITLE LIKE 'hi%'";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"ACORN","newlec");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(true)
		{
			boolean ret = rs.next();
			if(ret == false)
				break;
			
			String title = rs.getString("title");
			String id = rs.getString("id");
			System.out.println("title : " + title + " hit : " + id);

		}
	}
}
