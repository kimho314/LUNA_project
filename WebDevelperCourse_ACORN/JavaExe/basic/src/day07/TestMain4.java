package day07;

public class TestMain4 {
	public static void main(String[] args) {

		Child c1 = new Child();
		
		Parent p2;
		p2 = c1;
		p2.sing();
		
		Child c2;
		c2=(Child)p2; // 객체 형변환 -> compiler는 형만 보고 판단하기 때문에
		c2.sing();
	}
}
