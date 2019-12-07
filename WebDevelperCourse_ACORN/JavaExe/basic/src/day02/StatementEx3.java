package day02;

import java.io.IOException;

public class StatementEx3 {
	public static void main(String[] args) throws IOException {
		// 사용자로부터 숫자를 입력 받기
		/*
		System.out.print("숫자를 입력하세요: ");
		int userdata = System.in.read();
		userdata -= 48;
		System.out.println(userdata);
		*/
		
		// 입력 단의 구구단을 출력
		System.out.print("단을 입력하세요: ");
		int input = System.in.read(); // read()함수는 ascii값을 읽어온다
		input -= '0';
		for(int i=1; i<=9; i++)
		{
			System.out.println(input + " * " + i + " = " + (input * i));
		}
	}
}
