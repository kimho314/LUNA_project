package day05;

public class Human {
	String name;
	int eye;
	String gender;
	int arm;
	int age;
	String job;
	String 종특;
	
	Human()
	{
		name = "홍길동";
		eye = 2;
		gender = "남";
		arm = 2;
		age = 20;
		job = "도적";
		종특 = "스틸";
	}
	
	void 스틸()
	{
		System.out.println("내꼬내꼬 다 내꼬얌");
	}
	
	void 달리기()
	{
		System.out.println("헛둘 헛둘");
	}
	
	void 빠르게달리기()
	{
		System.out.println("땀나게 달려요");
	}
	
	void 축지법()
	{
		System.out.println("동해 번쩍 서해 번쩌");
	}
	
	public static void main(String[] args) {
		Human h = new Human();
		
		System.out.println(h.name); // 홍길동
		System.out.println(h.eye); // 2 
		System.out.println(h.gender);// 남
		System.out.println(h.arm); // 2
		System.out.println(h.age); // 20
		System.out.println(h.job); // 도적
		System.out.println(h.종특);// 스틸

		h.스틸(); // 내꼬내꼬 다 내꼬얌!! 

		h.달리기(); // "헛둘 헛둘"
		h.빠르게달리기(); // "땀나게 달려요
		h.축지법(); // 동해 번쩍 서해 번쩍
	}
}
