package day04;

public class MethodEx5 {
	// add 메소드 선언 및 정의
	static int add(int c, int d) {
		// 매개변수로 받은 c,d를 화면에 출력
		System.out.println("c : " + c + " , d : " + d);
		// c와 d의 합한 결과값을 반환
		return c+d;
	}
	
	// main 메소드 시작
	public static void main(String[] args) {
		int a = 100;
		int b = 200;
		
		// a,b에 들어있는 값 100,200을 add함수에 매개변수로 넘기고 
		// 두 값의 합을 반환 받아서 result변수에 할당한다
		int result = add(a,b);
		System.out.println("result : " + result);
	}
}
