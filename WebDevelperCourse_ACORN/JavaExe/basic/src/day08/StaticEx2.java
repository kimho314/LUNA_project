package day08;

public class StaticEx2 {
	int a = 10;
	static int b = 20;
	
	// static block -> static variable이나 static function등을 읽을때
	// static block이 가장 먼저 실행된다.
	static
	{
		int c = 30;
		System.out.println("static block : " + c);
	}
	
	StaticEx2()
	{
		System.out.println("기본생성자");
	}
	
	static void print()
	{
		System.out.println(" b : " + b);
	}
}
