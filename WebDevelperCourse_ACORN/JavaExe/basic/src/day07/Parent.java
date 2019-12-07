package day07;

public class Parent {
	String name, gender, job;
	int age;
	
	Parent()
	{
		System.out.println("부모의 기본 생성자");		
	}
	
	Parent(String name)
	{
		this.name = name;
		System.out.println("부모의 매개변수 있는 생성자");
	}
	
	public void sing()
	{
		System.out.println("내 나이가 어때서~~~~");
	}
	
	public void breath()
	{
		System.out.println("후~~~후~~~");
	}
	
	public void eat()
	{
		System.out.println("맛난거만 먹어요.");
	}
	
	public void scold()
	{
		System.out.println("맞는 말이지만 듣고나면 기분이 나빠요.");
	}
}
