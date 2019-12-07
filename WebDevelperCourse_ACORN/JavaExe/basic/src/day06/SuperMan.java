package day06;

// extends Person : Person 클래스로부터 맴버 변수와 메소드를 상속 받음
public class SuperMan extends Person {
	private int redCape;	
	
	SuperMan()
	{
		// 부모 클래스의 생성자 호출 -> 생략가능
		super(); // 부모 클래스의 기본 생성자 호출
		redCape = 1;
		System.out.println("SuperNam 기본생성자");
	}
	
	SuperMan(String name, int age, int redCape)
	{
		super(name, age);
		this.redCape = redCape;
		System.out.println("SuperMan 매개변수 3개짜리 생성자");		
	}
	

	public int getRedCape() {
		return redCape;
	}
	

	public void setRedCape(int redCape) {
		this.redCape = redCape;
	}


	public void flying()
	{
		System.out.println("superman is flying~~~~");
	}
	
	public void blazing()
	{
		System.out.println("superman is blazing~~~~");
	}
	
}
