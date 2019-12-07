package day03;

// 입력한 값이 3의 배수인지 아닌지 판별하여 출력
import java.util.Scanner;
public class StatementEx12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("input integer: ");
		int num = sc.nextInt();
		if(num % 3 == 0)
		{
			System.out.println("3의 배수입니다.");
		}
		else
		{
			System.out.println("3의 배수가 아닙니다.");
		}
		
		sc.close();
	}
}
