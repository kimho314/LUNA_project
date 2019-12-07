package day01;

// VarEx1 클래스 시작
public class VarEx1 {
	// main 메소드 시작
	public static void main(String[] args) {
		// 변수 
		// 자료형 변수명;
		
		// byte타입 변수 b에 10 할당
		byte b;
		b = 10;
		// 화면에 변수 b의 값 10 출력
		System.out.println(b);
		
		// 변수 b에 10 + 1의 결과값을 byte타입으로 변환 후 할당
		b = (byte) (b+1);
		// 화면에 11 출력
		System.out.println(b);
		
		//32비트 크기의 공간을 차지하는 c라는 변수를 선언하고
		int c;
		//c변수에 100값을 대임
		c = 100;
		//c변수에 드렁있는 갑승ㄹ 화면에 출력
		System.out.println(c);
		
		// 변수를 선언하면서 바로 값을 대임 : 초기화
		int d = 200;
		// d = d+1;
		System.out.println(d);
		
		// 16비트 크기의 k라는 변수에 30값을 대임
		short k = 30;
		// k 화면에 출력
		System.out.println(k);
		// 64 비트 크기의  m라는 변수에 1000값을 대임
		long m = 1000;
		// m 화면에 대임
		System.out.println(m);
	}
}
