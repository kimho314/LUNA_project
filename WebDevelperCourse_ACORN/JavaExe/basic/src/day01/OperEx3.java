package day01;

// 3. 시프트 연산자

// OperEx4 클래스 시작
public class OperEx3 {
	// main 메소드 시작
	public static void main(String[] args)
	{
		// int타입 변수 b에 10할당
		int b = 10; // 0000 1010
		
		// 0000 0010(2)
		// 화면에 10의 이진수값의 각 비트들을 왼쪽으로 2칸 시프트시킨 결과값 출력
		System.out.println(" b >> 2 : " + (b>>2));
		// 0010 1000(40)
		// 화면에 10의 이진수값의 각 비트들을 오른쪽으로 2칸 시프트시킨 결과값 출력
		System.out.println(" b << 2 : " + (b << 2));
		
		 
	}
}
