package day10;

public class OuterClassEx2 {
	private int a = 10;
	static int b = 20;
	static final int C = 30;
	
	// static 변수와 같은 위치 -> static inner class
	// outer class가 new하지 않아도
	// 직접 사용이 가능
	// outer class가 new해야 쓸 수 있는 변수는 접근 불가능
	static class InnerClass2
	{
		int d = 40;
		static int e = 50; 
		static final int F = 60;
		public void print()
		{
			//System.out.println("a : " + a); (x)
			System.out.println("b : " + b);
			System.out.println("C : " + C);
			System.out.println("d : " + d);
			System.out.println("e : " + e);
			System.out.println("F : " + F);
		}
	}
	
	
	public static void main(String[] args) {
		InnerClass2 ic2 = new InnerClass2();
		ic2.print();
	}
}
