package day13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BmpProgram {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fin = new FileInputStream("src/images/자연풍경.bmp");
		
		// 만약 byte형 배열을 사용하여 bmp파일의
		// 사이즈를 얻을려고 하면 제대로 얻을수가 없다
		// 왜냐하면 자바에서 byte형의 범위는 -128~127까지인데
		// 이 범위를 넘어가는 값이 올경우 음수값을 갖게 되게 때문에
		// 이를 고려하여 최대로 255값을 가질 수 있는 자료형을 
		// 사용해야 한다
		// byte[] buf = new byte[6];
		int[] buf = new int[10];
		
		for(int i=0; i<buf.length; i++)
		{
			buf[i] = fin.read();
			//System.out.println(buf[i]);
		}
		
		
		System.out.printf("%03X %03X\n", buf[0], buf[1]);
		
		
		int bmpSize = 0;
		// buf[2] : 0x2E -> LSB
		// buf[3] : 0x89
		// buf[4] : 0x33
		// buf[5] : 0x00 -> MSB
		// 0x00 33 89 2E   
		for(int i=2; i<=5; i++)
		{			
			bmpSize |= (buf[i] << (8*(i-2)));
		}
		System.out.println("1. Size : " + bmpSize + " byte");
		fin.close();
		
		fin = new FileInputStream("src/images/자연풍경.bmp");
		
		byte[] buf2 = new byte[10];
		fin.read(buf2);
		
		bmpSize = 0;
		// mask기법을 사용한 방법
		bmpSize = ((int)buf2[2] & 0xFF) << 0|
				((int)buf2[3] & 0xFF) << 8|
				((int)buf2[4] & 0xFF) << 16|
				((int)buf2[5] & 0xFF) << 24;
			
		
		System.out.println("2. Size : " + bmpSize + " byte");
		
		fin.close();
	}
}
