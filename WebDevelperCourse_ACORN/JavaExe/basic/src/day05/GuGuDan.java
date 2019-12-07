package day05;

public class GuGuDan {
	int dan;
	
	GuGuDan()
	{
		this.dan = 2;
	}
	
	GuGuDan(int dan)
	{
		this();
		this.dan = dan;
	}
	
	void print()
	{
		for(int i=1; i<10; i++)
		{
			System.out.println(dan + " * " + i + " = " + (dan * i));
		}
	}
	
	
	
	public static void main(String[] args) {
		GuGuDan g1 = new GuGuDan();

		g1.dan = 5;

		g1.print();// 5´Ü Ãâ·Â 
	}
}
