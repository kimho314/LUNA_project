package test3;

import java.util.Scanner;

public class Exam {
	private int kor;
	private int eng;
	private int math;
	
	public Exam()
	{
		this(0,0,0);
	}
	
	public Exam(int kor, int eng, int math)
	{
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void input()
	{
		System.out.print("±¹¾î : ");
		Scanner sc = new Scanner(System.in);
		kor = sc.nextInt();
	}	
		
	
	public void print()
	{
		System.out.println("eng : " + eng);
		System.out.println("kor : " + kor);
		System.out.println("math : " + math);
	}
}
