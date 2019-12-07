package day06;

public class SiegeTank {
	int hp, offensepower, range, movingspeed, attackspeed, defensepower, mp;
	int x,y;
	
	public SiegeTank()
	{
		hp = 100;
		mp = 100;
		x = 0;
		y = 0;
		offensepower = 3;
		range = 4;
		movingspeed = 2;
		attackspeed = 2;
		defensepower = 2;
	}

	public SiegeTank(int hp, int offensepower, int range, int movingspeed, int attackspeed, int defensepower, int mp,
			int x, int y) {
		super();
		this.hp = hp;
		this.offensepower = offensepower;
		this.range = range;
		this.movingspeed = movingspeed;
		this.attackspeed = attackspeed;
		this.defensepower = defensepower;
		this.mp = mp;
		this.x = x;
		this.y = y;
	}
	
	void attack(Marine m)
	{
		System.out.println("ÆãÆãÆã~~~~");
		m.hp -= this.offensepower;
	}
	
	void attack(Medic me)
	{
		System.out.println("ÆãÆãÆã~~~~");
		me.setHp(me.getHp() - this.offensepower);
	}
	
	public static void main(String[] args) {
		Marine m = new Marine();
		SiegeTank st = new SiegeTank();
		Medic me = new Medic();
		
		m.attack(st);
		System.out.println("m hp : " + m.hp);
		st.attack(m);
		System.out.println("st hp : " + st.hp);
		st.attack(me);
		System.out.println("me hp : " + me.getHp());
	}
}
