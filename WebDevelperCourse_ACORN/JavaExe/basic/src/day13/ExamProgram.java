package day13;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ExamProgram {
	
	public static void printSumAvg(int sum, int cnt)
	{
		double avg = 0.0;
		avg = (double)sum/cnt;
		
		System.out.println("sum : " + sum + ", " + "avg : " + avg);
	}
	
	public static int calcSum(int[] nums)
	{
		int ret = 0;
		
		for(int i=0; i<nums.length; i++)
			ret += nums[i];
		
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("src/res/data.txt");
		Scanner fscan = new Scanner(fin);
		
		int[] nums = new int[10];
		int i=0;
		int sum = 0;
		//double avg = 0.0;
		
		while(fscan.hasNext())
		{
			nums[i] = fscan.nextInt();
			//sum += nums[i];
			i++;
		}
		sum = calcSum(nums);
		printSumAvg(sum, i);
		//avg = (double)sum/i;
		//System.out.println("sum : " + sum + ", " + "avg : " + avg);
		
		fscan.close();
		fin.close();
	}
}
