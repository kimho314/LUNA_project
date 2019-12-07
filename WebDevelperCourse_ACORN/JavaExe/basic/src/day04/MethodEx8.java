package day04;

public class MethodEx8 {
//	static int add(int a, int b) {
//		return a+b;
//	}
//	
//	static int add(int a, int b, int c) {
//		return a+b+c;
//	}
//	
//	static int add(int a, int b, int c, int d, int e) {
//		return a+b+c+d+e; 
//	}
	
	// 가변인자 메서드
	static int add(int ... m)
	{
		int sum = 0;
		for(int i=0; i<m.length; i++)
		{
			sum += m[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		// method overloading
		System.out.println(add(100,200));
		System.out.println(add(100,200,300));
		System.out.println(add(100,200,300,400,500));
			
	}
}
