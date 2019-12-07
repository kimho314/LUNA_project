package day03;

public class ArrayEx1 {
	public static void main(String[] args) {
		// 배열 : 동일한 사이즈에 연속된 공간에 할당되는 변수
		// 자료형[] 변수명;
		int[] m;
		m = new int[3];
		// m[index] : 해당 인덱스에 있는 값을 참조할 수 있다.
		System.out.println("m : " + m); 
		
		/*
		 * m[0] = 10; m[1] = 20; m[2] = 30;
		 * 
		 * System.out.println("m[[0] = " + m[0] + " m[1] = " + m[1] + " m[2] = " +
		 * m[2]);
		 */		
		
		for(int i=0; i<m.length; i++)
		{
			m[i] = (i+1)*10;
			System.out.println("m[" + i + "] = " + m[i]);
		}
		
		System.out.println("m[0] : " + m[0]);
		System.out.println("m.length : " + m.length);
	}
}
