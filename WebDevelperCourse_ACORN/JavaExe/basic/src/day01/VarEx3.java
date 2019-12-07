package day01;

// VarEx3 클래스 시작
public class VarEx3 {
	// main 메소드 시작
	static public void main(String[] args) {
		
		// byte타입 변수 b1, b2에 각각 10, 20할당
		byte b1 = 10;
		byte b2 = 20;
		// int타입 변수 c에 b1과 b2에 할당된 값들을 더한 결과값을 할당
		int c = b1 + b2;
		
		// 변수 c에 할당된 값 30을 화면에 출력
		System.out.println(c);
		System.out.println("----------------");
		
		// int타입 변수 a에 100할당
		int a = 100;
		// long타입 변수 b에 200할당
		long b = 200;
		// 형변환 : (자료형)
		
		// 변수 a와 b를 더한 결과값을 int타입으로 변환 후 int타입인 변수 k에 할당
		int k = (int)(a + b);
		// 화면에 변수 k값 300을 출력
		System.out.println(k);
	}
}
