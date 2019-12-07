package CommunitySystem;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NoticeContentDManager {
	private String sql;
	private ResultSet rs;
	
	public NoticeContentDManager()
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
	
	
	public void requestDataToJDBC(String instructor, int _code) throws SQLException
	{
		if(instructor.equals("inquiry"))
		{
			sql =  "SELECT ROWNUM, TITLE, WRITER_ID, TO_CHAR(REGDATE,'YYYY-MM-DD') REGDATE, HIT, CONTENT "
					+ " FROM NOTICE"
					+ " WHERE WRITER_ID IS NOT NULL AND REGDATE IS NOT NULL AND ID = " + Integer.toString(_code)
					+ " ORDER BY REGDATE DESC";
		}
		
		JdbcContext.getInstance().setSql(sql);
		rs = JdbcContext.getInstance().executeQuery();
	}
}
