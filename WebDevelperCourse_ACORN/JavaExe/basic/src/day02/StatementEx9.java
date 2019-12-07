package day02;

import java.io.IOException;
import java.util.Scanner;
public class StatementEx9 {
	public static void main(String[] args)  throws IOException {
		// 1. 사용자로부터 숫자를 입력받는다.
		System.out.print("숫자를 입력하세요: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		System.out.println(score);
		
		// 2. 이 값을 판단하여 메세지를 출력한다.
		// 90 ==> A
		// 80 ==> B
		// 70 ==> C
		// 60 ==> D
		if(score >= 90)
		{
			System.out.println("A grade");
		}
		else if((score < 90) && (score >= 80))
		{
			System.out.println("B grade");
		}
		else if((score < 80) && (score >= 70))
		{
			System.out.println("C grade");
		}
		else
		{
			System.out.println("D grade");
		}
	}
}
