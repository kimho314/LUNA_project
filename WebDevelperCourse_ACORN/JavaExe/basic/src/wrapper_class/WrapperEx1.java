package wrapper_class;

public class WrapperEx1 {
	
	public static void main(String[] args) {
		int x = 3;
		float y = 3.5f;
		char c = 'a';
		double d = 4.7;
		Exam r = new Exam(1,1,1);
		
		Object[] data = new Object[5];
		//data[0] = new Integer(x); 
		data[0] = Integer.valueOf(x);
		data[1] = new Float(y);
		data[2] = new Character(c);
		data[3] = new Double(d);
		data[4] = r;
		
		for(int i=0; i<data.length; i++)
		{
			System.out.println(data[i]);
		}
		
		String s = new String("hello");
		String s2 = "hello";
		String a = "abcde".substring(0,2);
		System.out.println(a);
		
		int n = 3;
		s = Integer.toString(n);
		System.out.println(s);
		s = String.valueOf(n);
		System.out.println(s);
		
		s = "35";
		int x2 = Integer.parseInt(s);
		System.out.println(x2);
	}
}
