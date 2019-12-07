package CommunitySystem;

import java.util.Scanner;

public class CommunitySystemViewer {
	
	public int printMenu()
	{
		int sel = 0;
		System.out.println("==== 메인 메뉴 ====");
		System.out.println("1. 회원 관리");
		System.out.println("2. 게시글 관리");
		System.out.println("3. 종료");
		
		Scanner scan = new Scanner(System.in);
		System.out.print("> ");
		sel = scan.nextInt();
		
		return sel;
	}
}
