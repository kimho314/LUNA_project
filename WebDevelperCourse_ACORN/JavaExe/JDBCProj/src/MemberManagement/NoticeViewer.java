package CommunitySystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NoticeViewer {
	
	public void printData(ResultSet _rs) throws SQLException
	{
		System.out.println("<게시글목록>");
		int cnt = 0;
		while (true) {
			boolean ret = _rs.next();
			if (ret == false)
				break;

			int id = _rs.getInt("id");
			String title = _rs.getString("TITLE");
			String writerId = _rs.getString("writer_id");
			String regDate = _rs.getString("REGDATE");
			System.out.println(id + ". " + title + "[" + writerId + "]" + " / " + regDate);
			cnt++;
			if(cnt == 5)
				break;
		}
		System.out.println("");
	}
	
	public int printMenu()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("1.조회 2.검색 3.등록 4.상위메뉴로");
		System.out.print("> ");
		int sel = scan.nextInt();
		
		return sel;
	}
}
