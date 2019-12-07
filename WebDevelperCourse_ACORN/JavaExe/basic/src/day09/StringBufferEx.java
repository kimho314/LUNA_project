package day09;

//import java.lang.StringBuffer;
public class StringBufferEx {
	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM emp ");
		sb.append("WHERE deptno = 10");
		
		System.out.println(sb.toString());
		
		System.out.println(sb.reverse());
	}
}
