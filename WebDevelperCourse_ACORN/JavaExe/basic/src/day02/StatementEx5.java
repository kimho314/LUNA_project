package day02;

// ¹Ýº¹¹®
//	do{
//		statement;
//		statement;
//	}while(condition);
public class StatementEx5 {
	public static void main(String[] args) {
		int i = 1;
		do {
			System.out.println("3 * " + i + " = " + (3*i));
			i++;
		}while(i<10);
	}
}
