package day07;

public class Terran {
	int hp, range, defense, speed, offenseSpeed;
	int x,y;
	
	public Terran() {
		super();
		this.hp = 100;
		this.range = 10;
		this.defense = 5;
		this.speed = 5;
		this.offenseSpeed = 5;
		this.x = 3;
		this.y = 3;
	}
	
	public Terran(int hp, int range, int defense, int speed, int offenseSpeed, int x, int y) {
		super();
		this.hp = hp;
		this.range = range;
		this.defense = defense;
		this.speed = speed;
		this.offenseSpeed = offenseSpeed;
		this.x = x;
		this.y = y;
	}

	void status()
	{
		System.out.println("hp : " + hp);
		System.out.println("(x,y) : " + x + ", " + y);
		System.out.println("defense : " + defense);
		System.out.println("range : " + range);
		System.out.println("speed : " + speed);
		System.out.println("offenseSpeed : " + offenseSpeed);
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
}
