package day05;

public class FormatData {
	void print(int num)
	{
		System.out.println(num);
	}
	
	void print(int[] arr)
	{
		System.out.print("[ ");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ]");
	}
	
	void print(float num)
	{
		System.out.println(num);
	}
}
