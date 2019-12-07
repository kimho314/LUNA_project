package day06;

public class TestMain5 {
	public static void main(String[] args) {
		Person p1 = new Person();
		
		Person p2 = new Person("È«±æµ¿", 20, "³²", 175.0f, 60.0f);
		
		System.out.println(p1.getName());
		System.out.println(p2.getName());
		System.out.println(p2.getHeight());
	}
}
