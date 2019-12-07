package day04;

public class MethodEx2 {
	static void max(int a, int b) {
		if (a==b) {
			System.out.println("두 수가 같습니다.");
			return;
		}
		int max = (a>b) ? a : b;
		System.out.println("max : " + max);
	}
	
	static void min(int a, int b) {
		if(a==b) {
			System.out.println("두 수가 같습니다.");
			return;
		}
		int min = (a<b) ? a : b;
		System.out.println("min : " + min);
	}
	
	static int sum(int a, int b) {
		int ret = a+b;
		//System.out.println("sum : " + ret);
		// return : 현재 작업을 중단하고
		// 이 값을 메인 메서드에게 전달시킨다.
		return ret;
	}
	
	static int subtraction(int a, int b) {
		int ret = a-b;
		
		return ret;
	}
	
	// 메서드의 구분 : 메서드 시그니쳐
	
	// 메서드의 형식
	// static [리턴값의 자료형] [메서드명](
	//			자료형 매개변수명, 자료형 매개변수명, ...){
	//			return 값;
	// }
	
	public static void main(String[] args) {
		max(50, 200);		
		max(200, 200);		
		min(200, 300);
		
		int ret = -1;
		ret = sum(100, 200);
		System.out.println("sum : " + ret);
		
		ret = subtraction(300, 50);
		System.out.println("minus : " + ret);
	}
}
