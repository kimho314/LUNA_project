package CommunitySystem;

import java.sql.SQLException;

public class NoticeController {
	private NoticeDManager	nDManager;
	private NoticeViewer	nViewer;
	private NoticeContentController ncController;
	
	public NoticeController()
	{
		nDManager = new NoticeDManager();
		nViewer = new NoticeViewer();
		ncController = new NoticeContentController();
	}
	
	public void start() throws SQLException
	{
		while (true) {
			nDManager.requestDataToJDBC("list");
			nViewer.printData(nDManager.getSqlResultSet());
			int sel = nViewer.printMenu();

			switch (sel) {
			case 1:
				ncController.start();
				break;

			case 2:
				System.out.println("search");
				break;

			case 3:
				System.out.println("register");
				break;

			case 4:
				System.out.println("back to the top menu");
				JdbcContext.getInstance().closeJdbcQuery();
				return;

			default:
				System.out.println("post" + "wrong input");
				break;
			}
		}
	}
}
