package day05;

public class Marine {
	int hp, offensepower, range, movingspeed, attackspeed, defensepower;
	int x,y;
	
	public Marine()
	{
		hp = 100;
		x = 0;
		y = 0;
		offensepower = 3;
		range = 4;
		movingspeed = 2;
		attackspeed = 2;
		defensepower = 2;
	}
	
	public Marine(int hp_in)
	{
		this();
		hp = hp_in;
	}
	
	public Marine(int hp_in, int x_in, int y_in)
	{
		this();
		hp = hp_in;
		x = x_in;
		y = y_in;
	}
	
	void reconnaissance()
	{
		System.out.println("근무중 이상무...");
	}
	
	void move()
	{
		System.out.println("Go Go Go ~~~");
	}
	
	void hold()
	{
		System.out.println("Hold...");
	}
	
	void steempack()
	{
		movingspeed += 3;
		defensepower += 3;
	}
	
	void attack()
	{
		System.out.println("두두두두두~~~");
	}
}
