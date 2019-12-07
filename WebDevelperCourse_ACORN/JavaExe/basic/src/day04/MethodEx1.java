package day04;

import java.util.Scanner;
public class MethodEx1 {
	// printStar() : method
	// int count : parameter -> local variable
	static void printStar(int count) {
		//int count = 7;
		for(int i=1; i<=count; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	static void printGuGuDan(int dan) {
		// parameter, argument, 인자
		// 실행시킬 때 전달해 준 값이
		// dan 변수에 할당되어 있다.
		System.out.println("구구단" + dan + "단 출력");
		for (int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//int count = sc.nextInt();
		//printStar(5);
		//printStar(count);
		
		int dan = sc.nextInt();
		printGuGuDan(dan);
		
		sc.close();
	}
}
