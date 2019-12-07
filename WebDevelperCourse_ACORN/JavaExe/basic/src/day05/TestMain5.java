package day05;

public class TestMain5 {
	public static void main(String[] args) {
		Marine m1 = new Marine();
		System.out.println("m1 : " + m1.hp);
		
		Marine m2 = new Marine(500);
		System.out.println("m2 : " + m2.hp);
		
		// Ã¼·Â, x, y
		Marine m3 = new Marine(500,100,200);
		System.out.println("m3 : " + m3.hp);
		System.out.println("m3.x : " + m3.x);
		System.out.println("m3.y : " + m3.y);
	}
}
