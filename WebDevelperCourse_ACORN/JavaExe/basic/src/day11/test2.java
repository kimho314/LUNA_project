package day11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class test2 {
	
	
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fout = new FileOutputStream("src/res/test.txt");
		//fout.write(12);
		fout.write('1');
		fout.write('2');
		fout.flush();
		
		fout.close();
		System.out.println("process done");
		
		
		// 1. 파일 입력 스트림 fin 객체를 생성할 것.
		//String file_path = "C:\\eclipse\\workspace\\basic\\src\\images\\자연풍경.bmp";
		//String file_path = "src/images/자연풍경.bmp";
		//FileInputStream fin = new FileInputStream(file_path);
		
		
		// 2. 파일에서 첫 번째 1바이트를 얻어서 출력 할 것.
		//int num = fin.read();
		//System.out.println(num);
		
		// 3. 파일 입력 스트림을 닫을 것.
		//fin.close();
	}
}
