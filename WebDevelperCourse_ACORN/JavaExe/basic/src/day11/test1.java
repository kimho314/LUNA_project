package day11;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class test1 {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		int[] nums = new int[10];
		
		String filePath = "C:\\eclipse\\workspace\\basic\\src\\res\\data.txt";
		FileInputStream fin = new FileInputStream(filePath);
		
		int num = 0;
		int cnt = 0;
		int sum = 0;
		double avg = 0.0;
		Scanner fscan = new Scanner(fin);
		
		while(fscan.hasNext())
		{
			num = fscan.nextInt();
			sum += num;
			cnt++;
			//System.out.println(num);
		}
		avg = (double)sum / cnt;
		System.out.println("sum : " + sum + " avg : " + avg);
		
		fscan.close();
		fin.close();
	}

}
