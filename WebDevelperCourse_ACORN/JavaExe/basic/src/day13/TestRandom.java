package day13;

public class TestRandom {
	public static void main(String[] args) {
		int[] lotto = new int[100];
		
		for(int i=0; i<lotto.length; i++)
		{
			lotto[i] = (int)(Math.random()*45);
			System.out.println(lotto[i] + " ");
		}
	}
}
