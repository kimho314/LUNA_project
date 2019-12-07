package CommunitySystem;

import java.sql.SQLException;

public class CommunitySystemController {
	private CommunitySystemViewer csViewer;
	private CommunitySystemDManager csDManager;
	
	public CommunitySystemController()
	{
		csViewer = new CommunitySystemViewer();
		csDManager = new CommunitySystemDManager();
	}
	
	public void start() throws SQLException
	{
		while(true)
		{
			int sel = csViewer.printMenu();
			
			if(sel == 1 || sel == 2)
			{
				csDManager.start(sel);
			}
			else if(sel == 3)
			{
				System.out.println("Exit");
				System.exit(0);
			}
			else
			{
				System.out.println("CommunitySystem" + "wrong input");
			}
		}
	}
}
