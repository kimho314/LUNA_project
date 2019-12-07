package day13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyProgram {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fin = new FileInputStream("C:\\eclipse\\workspace\\basic\\src\\images\\cpp.jpg");
		FileOutputStream fos = new FileOutputStream("C:\\eclipse\\workspace\\basic\\src\\images\\cpp2.jpg");
		
		int b = 0;
		
		while((b = fin.read()) != -1)
		{
			fos.write(b);
		}
		System.out.println("Copy Done");
		
		fin.close();
		fos.close();
	}
}
