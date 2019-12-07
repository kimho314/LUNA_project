package dynamic_array;

import test3.Exam;

public class Program2 {
	
	public static void main(String[] args) {
		ObjectList list = new ObjectList();
		// 모든 것을 담는 것은 담점일 수 있다.
		list.add("hello");
		list.add(30);
		list.add(new Exam());
		
		// 서비스 함수를 사용하려면 형식을 변환해야 한다.
		//((Exam)list.get(2)).input();
		
		///////////////////////////////////////
		
		GList<String> glist = new GList();
		glist.add("hello");
		System.out.println(glist.get(0));
	}
}
