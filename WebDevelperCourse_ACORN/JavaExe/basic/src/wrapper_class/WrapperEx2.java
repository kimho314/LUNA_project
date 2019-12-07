package wrapper_class;

public class WrapperEx2 {
	
	public static void main(String[] args) {
		String _kor = "40";
		String _eng = "50";
		String _math = "70";
		
		int kor = Integer.parseInt(_kor);
		int eng = Integer.parseInt(_eng);
		int math = Integer.parseInt(_math);
		
		int total = kor + eng + math;
		System.out.println(total);
		
		String name1 = "IU";
		String name2 = new String("IU");
		System.out.println(name1 == name2);
		System.out.println(name1.equals(name2));
		System.out.println(name1 == "IU");
		System.out.println("====================");
		
		Integer int1 = 3;
		Integer int2 = 3;
		System.out.println(int1 == int2);
		System.out.println("====================");
		
		String fileName = "photo.jpg";
		System.out.println(fileName.length());
		System.out.println(fileName.indexOf('.'));
		//System.out.println(fileName.substring(0,3));
		System.out.println(fileName.substring(0,fileName.indexOf('.')));
		String[] tmpArr = fileName.split(".");
		//System.out.println(tmpArr[0]);
		char ch = fileName.charAt(5);

		if(fileName.contains("."))
		{
			System.out.println("true");
			tmpArr = fileName.split("\\.");
			System.out.println(tmpArr[0]);
		}
		else
		{
			System.out.println("false");
		}
		
	}
}
