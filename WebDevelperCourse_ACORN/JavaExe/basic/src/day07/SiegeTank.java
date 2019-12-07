package day07;

public class SiegeTank extends Terran{
	int offense;
	
	public SiegeTank()
	{
		super();
		offense = 10;
		super.range = 8;
	}	
	
	void status()
	{
		super.status();
		System.out.println("offense : " + offense);
	}
	
	void attack(Terran x)
	{
		System.out.println("ÆãÆãÆã~~~~");
		x.hp -= this.offense;
	}
	
	
	
	
}
