package day03;

import java.util.Scanner;
public class ConvertTime {
	public static void main(String[] args) {
		// 사용자가 입력한 값을 (초) 시간단위로 환산하는 코드를 작성
		Scanner sc = new Scanner(System.in);
		System.out.print("몇초? : ");
		int sec = sc.nextInt();
		int day = sec / (24*60*60);
		int hour = sec % (24*60*60) / (60*60);
		int min = sec % (24*60*60) % (60*60) / 60;
		sec = sec % (24*60*60) % (60*60) % 60;
		
		System.out.println(day + "월 " + hour + "시 " + min + "분 " + sec + "초");		
		
		sc.close();
	}
}
