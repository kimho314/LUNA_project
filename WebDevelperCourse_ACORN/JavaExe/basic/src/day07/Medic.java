package day07;

public class Medic extends Terran {
	int healing, mp;
	
	Medic()
	{
		super();
		healing = 3;
		mp = 50;
	}		
	
	void status()
	{
		super.status();
		System.out.println("mp : " + mp);
		System.out.println("healing : " + healing);
	}
	
	void heal(Terran x)
	{
		System.out.println("healing~~~~~");
		x.hp += healing;
		if(x.hp > 100)
			x.hp = 100;
		mp -= 10;
	}
	
	
	
}
