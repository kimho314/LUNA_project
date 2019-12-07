package exception_handling;

public class Calculator {
	public static int add(int x, int y) throws LargeNumberException
	{
		int result = x + y;
		
		if(result > 10000)
		{
			throw new LargeNumberException();
		}
		
		return result;
	}
	
	public static int sub(int x, int y)
	{
		int result = x - y;
		return result;
	}
	
	public static int multi(int x, int y)
	{
		int result = x * y;
		return result;
	}
	
	public static int div(int x, int y)
	{
		int result = x/y;
		return result;
	}
}
