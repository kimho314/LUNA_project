package day06;

public class Medic {
	private int hp, offensepower, range, movingspeed, attackspeed, defensepower, healingpower, mp;
	private int x, y;
	
	Medic()
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
		healingpower = 3;
	}
	
	
	
	public int getHp() {
		return hp;
	}



	public void setHp(int hp) {
		this.hp = hp;
	}



	public int getOffensepower() {
		return offensepower;
	}



	public void setOffensepower(int offensepower) {
		this.offensepower = offensepower;
	}



	public int getRange() {
		return range;
	}



	public void setRange(int range) {
		this.range = range;
	}



	public int getMovingspeed() {
		return movingspeed;
	}



	public void setMovingspeed(int movingspeed) {
		this.movingspeed = movingspeed;
	}



	public int getAttackspeed() {
		return attackspeed;
	}



	public void setAttackspeed(int attackspeed) {
		this.attackspeed = attackspeed;
	}



	public int getDefensepower() {
		return defensepower;
	}



	public void setDefensepower(int defensepower) {
		this.defensepower = defensepower;
	}



	public int getHealingpower() {
		return healingpower;
	}



	public void setHealingpower(int healingpower) {
		this.healingpower = healingpower;
	}



	public int getMp() {
		return mp;
	}



	public void setMp(int mp) {
		this.mp = mp;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
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
	
	void heal(Marine x)
	{
		System.out.println("healing~~~~~");
		x.hp += getHealingpower();
		if(x.hp > 100)
			x.hp = 100;
		setMp(getMp() - 3);
	}
	
	
	void steempack()
	{		
		setMovingspeed(getMovingspeed() + 3);
		setDefensepower(getDefensepower() + 3);
	}
	
	void attack(Marine x)
	{
		System.out.println("두두두두두~~~~");
		x.hp -= getOffensepower();
	}
}
