package day04;

public class MethodEx7 {
	// 매열 요소의 합을 구하는 메소드 정의
	static int arraySum(int[] m) {
		int sum = 0;
		for(int i=0; i<m.length; i++) {
			sum += m[i];
		}
		return sum;
	}
	
	// 배열 요소의 평균을 구하는 메소드 정의
	static float arrayAvg(int[] m) {
		// casting operator -> (float)
		return arraySum(m) / (float)m.length;
	}
	
	// method overloading
	// parameter의 갯수, 타입, 순서에 따라 동일한 이름을 갖는 여러개의 함수를 만드는것
	// 함수의 반환형은 overloading과 관련이 없다.
	// 메소드 사용자의 편의성을 극대화 시킨다. -> 매개변수의 타입을 전혀 신경쓸 필요가 없어진다.
	static int add(int a, int b) {
		return a+b;
	}
	
	static int add(float a, float b) {
		return (int)(a+b);
	}
	
	// 첮번째 함수의 매개변수의 갯수, 타입 및 순서가 완전히 같아서 overloading이 안된다.
	// 반환형이 다른건 아무런 상관이 없다
//	static float add(int a, int b) {
//		return a+b;
//	}
	
	// main 메소드 시작
	public static void main(String[] args) {
		int[] m = {10,20,30,40};
		
		int sum = arraySum(m);		
		float avg = arrayAvg(m);
		
		System.out.println("배열 요소의 합계 : " + sum);
		System.out.println("배열 요소의 평균 : " + avg);
	}
}