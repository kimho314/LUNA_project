package day06;

public class Hw1 {
	public static void main(String[] args) {
		int[][] score = {
				{80,80,80,0,0},
				{60,50,80,0,0},
				{50,90,90,0,0},
				{40,50,60,0,0},
				{90,90,95,0,0},
				{85,95,100,0,0},
		};
		
		for(int i=0; i<score.length; i++)
		{
			int sum = 0;
			float avg = 0.0f;
			for(int j=0; j<score[i].length-2; j++)
			{
				sum += score[i][j];
			}
			avg = (sum / (float)(score[i].length-2));
			score[i][score[i].length-2] = sum;
			score[i][score[i].length-1] = (int)avg;
		}
		
		for(int i=0; i<score.length; i++)
		{
			for(int j=0; j<score[i].length; j++)
			{
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}
	}
}
