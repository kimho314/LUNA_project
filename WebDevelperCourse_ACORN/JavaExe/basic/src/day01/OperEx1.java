package day01;

// 연산자 : 자료 가공을 위해 정해진 방식에 따라 계산하고
// 그 결과를 얻기 위한 행위를 의미하는 기호들의 총칭

// 1. 증감연산자 : ++, --

// OperEx1 클래스 시작
public class OperEx1 {
	// main 메소드 시작
	public static void main(String[] args)
	{
		// int타입 변수 a에 100 할당
		int a = 100;
		// a에 100 + 1의 결과값 할당
		a = a+1;
		// 화면에 100 + 1의 결과값 출력
		System.out.println(a);
		
		// a에 할당된 값을 1증가
		a++; // a = a+1
		// a에 할당된 값에 1을 증가시킨 결과값 출력
		System.out.println(a);
		System.out.println("----------------");
		
		// int타입 변수 b,c에 각각 10,20 할당
		int b = 10;
		int c = 20;
		
		// c에 b값을 할당하고 b의 값을 1증가
		c = b++; // b값을 c에 저장하고 b의 값을 1증가
		// 화면에 b와 c으 값을 출력 
		System.out.println(" b = " + b + " , c = "  + c); // b=11, c=10
		
		// int타입 변수 b,c에 각각 10,20할당
		b = 10;
		c = 20;
		// c에 b의 값을 1증가시키고 증가시킨 결과값을 할당
		c = ++b; // b의 값을 1증가시키고 c에 저장
		// 화면에 b,c의 값을 출력
		System.out.println(" b = " + b + " , c = "  + c); // b=11, c=11
	}
}
