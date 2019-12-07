package day03;

import java.util.Scanner;
public class VendingMachine {
	public static void main(String[] args) {
		// 자판기
		
		// 1. 레드불   2. 둘둘 다방커피   3. 봉봉
		// 4. 식혜      5. 사이다
		System.out.println("-------------------");
		System.out.println("먹어봐 자판기");
		System.out.println("메뉴");
		System.out.println("1. 레드불   2. 둥둥다방커피   3. 봉봉");
		System.out.println("  2000원           500원              1200원");
		System.out.println("4. 식혜       5. 사이다");
		System.out.println("  1000원           900원");
		System.out.println("-------------------");
		
		// 2.사용자로부터 돈을 입력받는다.
		Scanner sc = new Scanner(System.in);
		System.out.print("돈을 입력 하시오: ");
		int money = sc.nextInt();;
		// 3.사용자가 메뉴를 선택한다.
		System.out.print("메뉴 선택: ");
		int menu = sc.nextInt();
		// 4.수량을 선택한다
		System.out.print("수량 선택: ");
		int amount = sc.nextInt();
		// 5.잔액이 충분하다면 6번으로 부족하다면 7번으로
		int exchange = 10000;
		int price = 0;
		switch(menu)
		{
		case 1:
			price = 2000;
			break;
		case 2:
			price = 500;
			break;
		case 3:
			price = 1200;
			break;
		case 4:
			price = 1000;
			break;
		case 5:
			price = 900;
			break;
			default:
				System.out.println("menu corrupted input");
				break;
		}
		
		boolean money_flag = false;
		if(money - (price*amount) >= 0)
		{
			money_flag = true;
		}
		else
		{
			money_flag = false;
			System.out.println("돈이 부족합니다.");
		}
		
		if (money_flag) {
			if (exchange >= (money - (price * amount))) {
				switch (menu) {
				case 1:
					System.out.println("레드불");
					break;
				case 2:
					System.out.println("둥둥다방커피");
					break;
				case 3:
					System.out.println("봉봉");
					break;
				case 4:
					System.out.println("식혜");
					break;
				case 5:
					System.out.println("사이다");
					break;
				default:
					break;
				}
				System.out.println(money - (price * amount) + "의 잔돈이 거슬려 졌습니다.");
			} else {
				System.out.println("잔돈이 부족합니다.");
			}
		}
		// 6.선택한 음료를 제공한다
		
		// 7.잔액이 부족하다는 메세지를 출력
		
		// 8.잔돈을 준다.
		sc.close();
	}
}
