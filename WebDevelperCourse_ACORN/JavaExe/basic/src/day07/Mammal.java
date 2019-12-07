package day07;

// 상속용 클래스
// instance화 하는 클래스가 아니다 -> 추상 클래스

public abstract class Mammal {
	String species;
	int head;
	int tail;
	String color;
	int age;
	
	// 이 메소드는 사용시 반드시 오버라이드 하세요
	public abstract void eating();
	
	public abstract void sleeping();
	
	public void status()
	{
		System.out.println("species : " + species);
		System.out.println("head : " + head);
		System.out.println("tail : " + tail);
		System.out.println("color : " + color);
		System.out.println("age : " + age);
	}
}
