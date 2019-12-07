package day13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class APIProgram {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fin = new FileInputStream("src/res/data.txt");
		FileOutputStream fos = new FileOutputStream("src/res/api-out.txt");
		PrintStream fout = new PrintStream(fos);

		System.out.print("Input: ");
		int b1 = System.in.read();
		System.out.println("b1 : " + b1);
		
		int b2 = fin.read();
		fout.println(b2);
		
		fin.close();
		fos.close();
		
//		int kor = 90;
//		int eng = 80;
				
//		System.out.printf("kor : %d, eng : %d", kor, eng);
//		System.out.print("\r\n");
//		System.out.print("end");
		
	
		
//		fout.printf("kor : %d, eng : %d", kor, eng);
//		fout.print("\r\n");
//		fout.print("end");
		
		fout.close();
	}
}
