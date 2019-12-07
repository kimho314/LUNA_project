package day03;

public class Hw3 {
	public static void main(String[] args) {
		for(int i=1; i<=6; i++)
		{
			for(int j=1; j<=6; j++)
			{
				if(i+j == 4)
				{
					System.out.println("i[" + i + "] + " + "j[" + j + "] = " + (i+j));
				}
			}
		}
	}
}
