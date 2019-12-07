package day07;

public class Child extends Parent {
	
	Child()
	{
		super();
		System.out.println("child 클래스의 기본 생성자");
	}
	
	public void clubbing()
	{
		System.out.println("dancing~~~~~~");
	}
	
	// annotation
	@Override
	public void sing()
	{
		System.out.println("DNA~~~~~~~~~~");
	}
}
