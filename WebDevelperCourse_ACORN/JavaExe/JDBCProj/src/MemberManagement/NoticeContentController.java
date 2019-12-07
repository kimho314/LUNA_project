package CommunitySystem;

import java.sql.SQLException;
import java.util.Scanner;

public class NoticeContentController {
	private NoticeContentDManager ncDManager;
	private NoticeContentViewer ncViewer;
	
	public NoticeContentController()
	{
		ncDManager = new NoticeContentDManager();
		ncViewer = new NoticeContentViewer();
	}
	
	public void start() throws SQLException
	{
		System.out.print("ÄÚµå> ");
		Scanner scan = new Scanner(System.in);
		int code = scan.nextInt();
		
		ncDManager.requestDataToJDBC("inquiry", code);
		ncViewer.printData(ncDManager.getSqlResultSet());
		int sel = ncViewer.printMenu();
		
		switch(sel)
		{
		case 1:
			break;
			
		case 2:
			JdbcContext.getInstance().closeJdbcQuery();
			return;
			
		case 3:
			break;
			
		case 4:
			break;
			
		default:
			break;
		}
	}
}
