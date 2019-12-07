package day02;

// 제어문
//	반복문 : for, while, do~while
public class StatementEx1 {
	public static void main(String[] args) {
		
		// 3단 구구단 출력
		/*
		for(int i=1; i<=9; i++)
		{
			System.out.println("3 * " + i + " = " + (3*i));
		}
		*/
		
		
		// for loop : for(초기식; 조건식; 증강식)
		// 초기식 : for문에서 사용될 변수의 초기값을 할당
		// 조건식 : 조건식의 결과값은 논리값으로 true이면 수행문장을 실행하고
		// false이면 완전히 빠져나간다		
		// 증감식 : for문에서 사용될 변수를 증가, 감속 처리 해준다
		for(int i=1; i<=9; i++)
		{
			// i : 지역 변수
			System.out.println(" 3 * " + i + " = " + (3 * i));
		}
		
		// 19단 출력
		for(int i=1; i<=10; i++)
		{
			System.out.println(" 19 * " + i + " = " + (19 * i));
		}
		
		
	}
}
