package day04;

public class MethodEx3 {
	static int add(int a, int b) {
		return a+b;
	}
	
	// overloading
	static int add (int a, int b, int c) {
		return a+b+c;
	}
	
	static float add(int a, float b) {
		return (float)a + b;
	}
	
	static int sum(int n1, int n2, int n3, int n4) {
		return (n1+n2+n3+n4);
	}
	
	static float avg(int n1, int n2, int n3, int n4) {
		return sum(n1,n2,n3,n4)/4.0f;
	}
	
	public static void main(String[] args) {
		int result1 = add(100, 200);
		System.out.println(result1);
		
		int result2 = add(100, 200, 300);
		System.out.println(result2);
		
		float result3 = add(100, 200.0f);
		System.out.println(result3);
		
		int value = sum(100,200,300,400);
		float value2 = avg(100,200,300,400);
		System.out.println("ÇÕ°è : " + value);
		System.out.println("Æò±Õ : " + value2);
	}
}
