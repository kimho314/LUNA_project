package CommunitySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcContext {
	private String url;
	private String sql;
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public static JdbcContext jqc;
	
	
	private JdbcContext()
	{
		url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		sql = "";
	}
	
	public void setUrl(String _url)
	{
		url = _url;
	}
	
	public void setSql(String _sql)
	{
		sql = _sql;
	}
	
	public static JdbcContext getInstance()
	{
		if(jqc == null)
		{
			jqc = new JdbcContext();
		}
		return jqc;
	}

	
	public ResultSet executeQuery() throws SQLException
	{
		con = DriverManager.getConnection(url, "ACORN", "newlec");
		st = con.createStatement();
		rs = st.executeQuery(sql);
		
		return rs;
	}	
	
	public void closeJdbcQuery() throws SQLException
	{
		con.close();
		st.close();
		rs.close();
	}
}
