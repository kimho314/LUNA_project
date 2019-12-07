package CommunitySystem;

import java.sql.SQLException;

public class CommunitySystemDManager {
	private MemeberController mController;
	private NoticeController nController;
	
	public CommunitySystemDManager()
	{
		mController = new MemeberController();
		nController = new NoticeController();
	}
	
	public void start(int _sel) throws SQLException
	{
		switch(_sel)
		{
		case 1:
			System.out.println("회원관리");
			break;
			
		case 2:
			nController.start();
			break;
			
		default:
			break;
		}
	}
}
