package day02;

import java.util.Scanner;

public class StatementEx10 {
	public static void main(String[] args) {
		// 사용자로부터 성적을 입력받는다.
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("성적을 입력합니다: ");
		int score = sc.nextInt();
		//System.out.println("성적 : " + score);
		
		switch(score/10)
		{
		case 10:
			System.out.println("A+ grade");
			break;
			
		case 9:
			System.out.println("A grade");
			break;
			
		case 8:
			System.out.println("B grade");
			break;
			
		case 7:
			System.out.println("C grade");
			break;
			
		default:
			System.out.println("D grade");
			break;
		}
	}
}
