package exception_handling;

import java.io.FileInputStream;

public class Program {

	public static void main(String[] args) {
		
		
		try {
			int sum = Calculator.add(10004, 3);
			System.out.println("sum : " + sum);
		} catch (LargeNumberException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Unexpected Error");
			System.exit(-1);
		}
		
		System.out.println("Exit");
	}
}
