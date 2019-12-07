package day07;

public class TestMain5 {
	public static void main(String[] args) {
		Marine  m = new Marine();
		SiegeTank st = new SiegeTank();
		Medic me = new Medic();
		Ghost g = new Ghost();
		
		m.move();
		m.status();
		System.out.println("-----------");
		
		st.attack(m);
		st.attack(me);
		st.attack(g);
		System.out.println("-----------");
		
		me.heal(m);
		me.heal(st);
		
	}
}
