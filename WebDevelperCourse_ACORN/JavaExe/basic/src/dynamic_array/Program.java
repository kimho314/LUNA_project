package dynamic_array;

import java.util.Scanner;

public class Program {
	
	private static int CNT = 0;
	
	private static void input(Object[] data)
	{
		Scanner scan = new Scanner(System.in);
		System.out.printf("Input: ");
		int dataIn = scan.nextInt();
		
		data[CNT++] = (Object)dataIn;
	}
	
	private static void print(Object[] data)
	{		
		
		for(int i=0; i<CNT; i++) {
			Integer num = (Integer)data[i];
			System.out.printf("kor: %d ", num.intValue());
		}
		System.out.printf("\n");
	}
	
	public static void main(String[] args) {
		ObjectList list = new ObjectList();
		//Object[] data = new Object[3];
		
		int exit = 0;
		
		Scanner scan = new Scanner(System.in);
		
		do {
			//input(data);
			//print(data);
			input(list);
			print(list);
			System.out.println("go? (1 or 0): ");
			exit = scan.nextInt();
		}while(exit != 1);
		System.out.println("Program Exit");
	}

	private static void input(ObjectList list) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("kor : ");
		list.add(scan.nextInt());
	}

	private static void print(ObjectList list) {
		
		for(int i=0; i<list.size(); i++)
		{
			System.out.printf("kor : %d ", list.get(i));
		}
		System.out.println("");
	}


}
