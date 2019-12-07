package day10;

public class OuterClassEx3 {
	private int a = 10;
	static int b = 20;
	static final int C = 30;
	
	public void printAll()
	{
		//int k = 0; // local variable
		class LocalInnerClass
		{
			int d = 40;
			//static int e = 50;
			static final int F = 60;
			public void print()
			{
				System.out.println("a : " + a);
				System.out.println("b : " + b);
				System.out.println("C : " + C);
				System.out.println("d : " + d);
				//System.out.println("e : " + e);
				System.out.println("F : " + F);
			}
		}
		
		// local inner class는 메소드의 범위내에서만 생존할 수 있다.
		// 사용도 메소드 범위내에서 사용
		LocalInnerClass lic = new LocalInnerClass();
		lic.print();
	}
	
	
	
	public static void main(String[] args) {
		OuterClassEx3 oce3 = new OuterClassEx3();
		oce3.printAll();
	}
}
