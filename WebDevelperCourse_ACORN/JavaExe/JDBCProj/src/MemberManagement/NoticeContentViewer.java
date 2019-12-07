package CommunitySystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class NoticeContentViewer {
	
	public void printData(ResultSet _rs) throws SQLException
	{
		System.out.println("자유게시글 내용");

		while (true) {
			boolean ret = _rs.next();
			if (ret == false)
				break;

			int num = _rs.getInt("ROWNUM");
			String title = _rs.getString("TITLE");
			String writerId = _rs.getString("writer_id");
			String regDate = _rs.getString("REGDATE");
			int hit = _rs.getInt("hit");
			String content = _rs.getString("content");
			
			System.out.println("번호 : " + num);
			System.out.println("제목 : " + title);
			System.out.println("작성자 : " + writerId);
			System.out.println("작성일 : " + regDate);
			System.out.println("조회수 : " + hit);
			System.out.println("내용 : " + content);;
		}
		System.out.println("");
	}
	
	public int printMenu()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("1.댓글등록  2.목록  3.수정  4.삭제");
		System.out.print("> ");
		int sel = scan.nextInt();
		
		return sel;
	}
}
