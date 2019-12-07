package CommunitySystem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeDManager {
	private String sql;
	private ResultSet rs;
	
	public NoticeDManager()
	{
		sql = "";
	}
	
	public void setSql(String _sql)
	{
		sql = _sql;
	}
	
	public String getSql()
	{
		return sql;
	}
	
	public void setSqlResultSet(ResultSet _rs)
	{
		rs = _rs;
	}
	
	public ResultSet getSqlResultSet()
	{
		return rs;
	}
	
	public void requestDataToJDBC(String instructor) throws SQLException
	{
		if(instructor.equals("list"))
		{
			sql =  "SELECT N2.* FROM"
					+ " (SELECT ROWNUM NUM, NOTICE.*, TO_CHAR(REGDATE,'YYYY-MM-DD') REGDATE2 FROM NOTICE "
					+ " WHERE WRITER_ID IS NOT NULL AND REGDATE IS NOT NULL ORDER BY REGDATE DESC) N2"
					+ " ORDER BY ID DESC";
		}
		
		JdbcContext.getInstance().setSql(sql);
		rs = JdbcContext.getInstance().executeQuery();
	}
	
}
