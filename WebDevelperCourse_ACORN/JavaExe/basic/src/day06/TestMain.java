package day06;

// package day5에 있는 Marine클래스를 불러온다
//import day5.Marine;

public class TestMain {
	public static void main(String[] args) {
		Marine m1 = new Marine();
		Marine m2 = new Marine();
		Medic me = new Medic();
		
		m1.attack(m2);
		System.out.println("after m2 hp : " + m2.hp);
		m1.attack(me);
		System.out.println("me hp : " + me.getHp());
		
		me.heal(m2);
		System.out.println("m2 hp : " + m2.hp);
		me.heal(m2);
		System.out.println("m2 hp : " + m2.hp);
	}
}
