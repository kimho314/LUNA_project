package day05;

public class TestMain3 {
	public static void main(String[] args) {
		Person p1 = new Person();
		
		// È£»§¸Ç
		p1.m_name = "È£»§¸Ç";
		p1.m_age = 100;
		p1.m_eye = 2;
		p1.m_norse = 1;
		p1.m_mouth = 1;
		p1.m_gender = "man";
		p1.printInfo();
		
		System.out.println("----------------------");
		Person p2 = new Person("¼¼±Õ¸Ç", 99, 2, 1, 1, "man");
		p2.printInfo();		
		
		System.out.println("----------------------");
		Person p3 = new Person("½Ä»§¸Ç", 20, 2, 1, 1, "man");
		p3.printInfo();
		
	}
}
