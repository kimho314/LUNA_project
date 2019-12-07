package day07;

// class : 사용자 정의형 타입
public class TestMain3 {
	public static void main(String[] args) {
		Parent p1 = new Parent();
		System.out.println(p1.name);
		
		p1.scold();
		p1.sing();
		System.out.println("-------------------");
		
		Child c1 = new Child();
		System.out.println(c1.name);
		
		c1.clubbing();
		c1.sing();
		c1.scold();
		
		// m1 = p1; -> 다른 클래스들끼리 참조값을 담을 수 없다
		// m1.move() (x)
		// 참조변수의 크리 : 32bit
		System.out.println("-------------------");
		Parent p2;
		p2 = p1; // (o) -> 같은 클래스들끼리 참조값을 담을 수 있다.
		p2.sing();
		System.out.println("-------------------");
		
		p2 = c1;
		p2.sing();
		p2.scold();
		
	}
}
