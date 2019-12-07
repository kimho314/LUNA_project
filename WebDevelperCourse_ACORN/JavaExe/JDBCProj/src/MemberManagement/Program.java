package CommunitySystem;

import java.sql.SQLException;

public class Program {
	
	public static void main(String[] args) throws SQLException {
		JdbcContext jqc = JdbcContext.getInstance();
		CommunitySystemController csController = new CommunitySystemController();
		
		csController.start();
	}
}
