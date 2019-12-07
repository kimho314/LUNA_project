package day03;


// char 배열을 선언하고
// 이 배열에 java world 라는 글자를 담은 후
// 반복문을 사용해서 출력 : java world
public class ArrayEx3 {
	public static void main(String[] args) {
		char[] str = new char[10];
		str[0] = 'j';
		str[1] = 'a';
		str[2] = 'v';
		str[3] = 'a';
		str[4] = ' ';
		str[5] = 'w';
		str[6] = 'o';
		str[7] = 'r';
		str[8] = 'l';
		str[9] = 'd';
		System.out.println(str);
		
		String str2 = "java world";
		System.out.println(str2);
	}
}
