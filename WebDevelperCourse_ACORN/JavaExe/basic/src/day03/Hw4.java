package day03;

import java.util.Scanner;
public class Hw4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("�⵵? ");
		int year = sc.nextInt();
		
		if(((year%4 == 0) && (year%100 != 0)) || (year%400 == 0))
			System.out.println(year + "���� �����Դϴ�.");
		else
			System.out.println(year + "���� ������ �ƴմϴ�.");
		
		sc.close();
	}
}
