package day02;

import java.util.Scanner;
public class Hw12 {
	public static void main(String[] args) {
		
		System.out.print("ธ๎ มู?: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();
		for(int i=1; i<=line; i++)
		{
			for(int j=1; j<=i; j++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
