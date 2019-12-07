package day10;

public class OuterClassEx1 {
	private int a = 10;
	static int b = 20;
	static final int C = 30;
	
	// 멤버 변수와 같은 위치에 놓고 사용하는
	// Member Inner Class
	class InnerClass
	{
		int d = 40;
		//static int e = 50; (x) // Inner class에서는 static변수를 선언할 수 없다.
		static final int F = 60;
		public void print()
		{
			System.out.println("a : " + a);
			System.out.println("b : " + b);
			System.out.println("C : " + C);
			System.out.println("d : " + d);
			//System.out.println(" e : " + e);
			System.out.println("F : " + F);
		}
	}
	
	
	public static void main(String[] args) {
		OuterClassEx1 oce = new OuterClassEx1();
		System.out.println(oce.a);
		
		OuterClassEx1.InnerClass ic = oce.new InnerClass();
		System.out.println(ic.d);
		ic.print();
	}
}
