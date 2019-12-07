package day12;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExamProgram {
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("src/res/data.txt");
		Scanner fscan = new Scanner(fin);
		
		int[] nums = new int[10];
		int i=0;
		int sum = 0;
		double avg = 0.0;
		
		while(fscan.hasNext())
		{
			nums[i] = fscan.nextInt();
			sum += nums[i];
			i++;
		}
		
		avg = (double)sum/i;
		System.out.println("sum : " + sum + ", " + "avg : " + avg);
		
		fscan.close();
		fin.close();
	}
}
