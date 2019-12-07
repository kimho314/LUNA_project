package day03;

import java.util.Scanner;
public class StatementEx11 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 사용자로부터 태어난 연도를 입력받아
		System.out.print("년도를 입력하세요: ");
		int year = sc.nextInt();
		// 그 값에 12로 나눈 나머지를 구한다.
		year %= 12;
		System.out.println(year);
		// 나머지에 따라 현재 띠를 화면에 출력
		// 어떤 띠 인지 맞추는 프로그램 작성
		// 자축인묘진사오미신유술해
		// 쥐소호토용뱀말양원닭개돼
		switch(year)
		{
		case 0:
			System.out.println("원숭이띠");
			break;
		case 1:
			System.out.println("닭띠");
			break;
		case 2:
			System.out.println("개띠");
			break;
		case 3:
			System.out.println("돼지띠");
			break;
		case 4:
			System.out.println("쥐띠");
			break;
		case 5:
			System.out.println("소띠");
			break;
		case 6:
			System.out.println("호랑이띠");
			break;
		case 7:
			System.out.println("토끼띠");
			break;
		case 8:
			System.out.println("용띠");
			break;
		case 9:
			System.out.println("뱀띠");
			break;
		case 10:
			System.out.println("말띠");
			break;
		case 11:
			System.out.println("양띠");
			break;
			default:
				break;
		}
		sc.close();	
	}
}
