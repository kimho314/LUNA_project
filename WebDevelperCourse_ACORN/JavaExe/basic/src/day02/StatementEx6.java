package day02;

public class StatementEx6 {
	public static void main(String[] args) {
		
		// 2´Ü Ãâ·Â
		/*
		for(int i=1; i<=9; i++)
		{
			System.out.println(" 2 * " + i + " = " + (2*i));
		}
		*/
		
		for(int i=2; i<=9; i++) 
		{
			for(int j=1; j<=9; j++)
			{
				System.out.println(i + " * " + j + " = " + (i*j));
			}
		}
	}
}
