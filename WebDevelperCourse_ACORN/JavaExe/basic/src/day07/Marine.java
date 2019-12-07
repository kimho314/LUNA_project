package day07;

public class Marine extends Terran{
	int offense;
	
	public Marine()
	{
		super();
		offense = 3;
	}
	
	
	public Marine(int hp_in, int x_in, int y_in)
	{
		this();
		hp = hp_in;
		x = x_in;
		y = y_in;
	}
	
	@Override
	void status()
	{
		super.status();
		System.out.println("offense : " + offense);
	}
	
	void steempack()
	{
		speed += 3;
		offenseSpeed += 3;
		offense += 3;
	}
	
	void attack(Terran x)
	{
		System.out.println("두두두두두~~~~");
		x.hp -= this.offense;
	}		
	
}
