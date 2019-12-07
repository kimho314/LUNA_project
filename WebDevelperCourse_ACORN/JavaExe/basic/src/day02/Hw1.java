package day02;

public class Hw1 {
	public static void main(String[] args) {
		// 1부터 100까지 누적 합을 출력
		int sum = 0;
		for(int i=1; i<=100; i++)
		{
			sum += i;
		}
		System.out.println(sum);
	}
}
