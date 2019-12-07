package day13;

import java.util.Scanner;
import java.lang.Math;

public class LottoProgram {
	
	public static void main(String[] args) {
		
		// 데이터
		int[] lotto = new int[6];
		int[] res = new int[6];
		Scanner sc = new Scanner(System.in);	
		
		
		// 기능
		genLottoResult(res);
		printMenu();
		
		switch(inputMenu(sc))
		{
		case 1:
			inputLottoManual(lotto, res, sc);
			break;
			
		case 2:
			inputLottoAuto(lotto, res);
			break;
			
		case 3:
			exitProgram();
			break;		
			
		default:
			errorMessage();
			break;
		}
		
		sc.close();
	}

	private static void genLottoResult(int[] res) {
		// TODO Auto-generated method stub
		for(int i=0; i<res.length; i++)
		{
			res[i] = (int)(Math.random()*45) + 1; 
			
			while(true)
			{
				boolean flag = false;
				for(int j=0; j<i; j++)
				{
					if(res[i] == res[j])
					{
						flag = true;
						break;
					}
				}
				
				if(flag == true)
				{
					res[i] = (int)(Math.random()*45) + 1; 
					continue;
				}
				else
					break;
			}
		}
		
		System.out.println("로또 결과");
		for(int i=0; i<res.length; i++)
		{
			System.out.print("[" + res[i] + "]" + " ");
		}
		System.out.println("");
	}

	private static void errorMessage() {
		// TODO Auto-generated method stub
		System.out.println("잘목된 입력 에러");
	}

	private static void exitProgram() {
		// TODO Auto-generated method stub
		System.out.println("로또 프로그램 종료 ");
		System.exit(0);
	}

	private static void inputLottoAuto(int[] lotto, int[] res) {
		// TODO Auto-generated method stub
		System.out.println("로또 자동 입력");
		
		for(int i=0; i<lotto.length; i++)
		{
			lotto[i] = (int)(Math.random()*45) + 1; 
			while(true)
			{
				boolean flag = false;
				for(int j=0; j<i; j++)
				{
					if(lotto[i] == lotto[j])
					{
						flag = true;
						break;
					}
				}
				
				if(flag == true)
				{
					lotto[i] = (int)(Math.random()*45) + 1; 
					continue;
				}
				else
					break;
			}
		}
		
		for(int i=0; i<lotto.length; i++)
			System.out.println(lotto[i]);
		
		System.out.println("자동 입력 완료");
		
		boolean ret = checkLotto(lotto, res);
		if(ret)
			System.out.println("1등 당첨");
		else
			System.out.println("꽝");
	}

	private static boolean checkLotto(int[] lotto, int[] res) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i=0; i<lotto.length; i++)
		{
			if(lotto[i] == res[i])
				cnt++;
		}
		
		if(cnt == 6)
			return true;
		else
			return false;
	}

	private static void inputLottoManual(int[] lotto, int[] res, Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("로또 수동 입력");
		
		for(int i=0; i<lotto.length; i++)
		{
			lotto[i] = sc.nextInt();
		}
		
		for(int i=0; i<lotto.length; i++)
			System.out.print(lotto[i] + " ");
		System.out.println("");
		
		System.out.println("수동 입력 완료");
		
		boolean ret = checkLotto(lotto, res);
		if(ret)
			System.out.println("1등 당첨");
		else
			System.out.println("꽝");
	}

	private static int inputMenu(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("선택: ");		
		int ret = sc.nextInt();
		
		return ret;
	}

	private static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("=== 로또 메뉴 ===");
		System.out.println("   1. 수동");
		System.out.println("   2. 자동");
		System.out.println("   3. 종료");
		System.out.println("==============");
	}
}
