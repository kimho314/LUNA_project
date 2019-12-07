package day04;

public class hw2 {
	static int minus(int ... a)
	{
		int ret = a[0];
		for(int i=1; i<a.length; i++)
		{
			ret -= a[i];
		}
		return ret;
	}
	
	static int minus(int a, int b)
	{
		return a-b;
	}
	
	static float minus(float a, int b)
	{
		return a - (float)b;
	}
	
	
	public static void main(String[] args) {
		System.out.println(minus(200,100));
		System.out.println(minus(100.0f,100));
		System.out.println(minus(300,200));
		System.out.println(minus(500,300,200));
		
	}
}
