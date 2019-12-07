package day06;

import java.util.Scanner;

public class Hw2 {
	static void judge(int userInput, int comInput, int[] retArr)
	{
		int[] userArr = new int[3];
		int[] comArr = new int[3];
		
		// 123 / 100 % 10 -> 1 : 100의 자리수
		// 123 / 10  % 10 -> 2 : 10의 자리수
		// 123 / 1   % 10 -> 3 : 1의 자리수
		for(int i=2; i>=0; i--)
		{
			 userArr[2-i] = (int) (userInput / Math.pow(10, i) % 10);
			 comArr[2-i] = (int)(comInput / Math.pow(10, i) % 10);
		}
		
		System.out.print("comArr : ");
		for(int i=0; i<3; i++)
		{
			System.out.print(comArr[i] + " ");
		}
		System.out.println();
		
		System.out.print("userArr : ");
		for(int i=0; i<3; i++)
		{
			System.out.print(userArr[i] + " ");
		}
		System.out.println();
		
		
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				if((comArr[i] == userArr[j]) && (i == j) && (comArr[i] != -1) && (userArr[j] != -1))
				{
					retArr[0]++;
					comArr[i] = -1;
					userArr[j] = -1;
				}
				if((comArr[i] == userArr[j]) && (i != j) && (comArr[i] != -1) && (userArr[j] != -1))
				{
					retArr[1]++;
					comArr[i] = -1;
					userArr[j] = -1;
				}
					
			}
		}		
	}
	
	public static void main(String[] args) {
		
		int comInput = 0;
		int cnt = 0;
		
		while(true)
		{
			comInput = (int)(Math.random() * 1000);
			if(comInput < 100)
				continue;
			else
				break;
		}
		//comInput = 233;
		
		System.out.println("comInput: " + comInput);
		
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("입력(세자릿수) : ");
			int userInput = sc.nextInt();

			int[] retArr = { 0, 0 };
			judge(userInput, comInput, retArr);
			cnt++;
			System.out.println(retArr[0] + "S" + retArr[1] + "B");
			if(retArr[0] >= 3)
				break;
			else
				continue;
		}
		
		System.out.println("정답 축하합니다. " + cnt + "회만에 성공하셨습니다.");
		sc.close();
	}
}
