package wrapper_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex3 {
	
	public static void main(String[] args) {
		
		// 배열의 대체제
		// 데이터를 식별하는 방법에 차이를 두고 있는 계열들
		// 1. 데이터가 곧 식별자다 -> Set계열
		// set은 중복 데이터 불가
		
		Set set = new HashSet(); 
		set.add("hello");
		set.add(37);
		set.add("호호호");
		set.add("hello");
		set.add(37);
		set.add("호호호");
		
		for(Object obj : set)
			System.out.println(obj);
		System.out.println("====================");
		
		// 2. 데이터의 순서가 곧 식별자다 => List계열
		List list = new ArrayList();
		list.add("hello");
		list.add(37);
		list.add("호호호");
		list.add("hello");
		list.add(37);
		list.add("호호호");
		
//		for(int i=0; i<list.size(); i++)
//			System.out.println(list.get(i));
		//System.out.println("====================");
		for(Object obj : list)
			System.out.println(obj);
		System.out.println("====================");
		
		// 3. 데이터의 식별자가 따로 있다. => Map계열
		Map map = new HashMap();
		map.put("이름", "홍길동");
		map.put("나이", "17");
		map.put("주소", "서울");
		
		for(Object obj : map.entrySet())
			System.out.println(obj);
		System.out.println("====================");
		for(Object obj : map.keySet())
			System.out.println(obj);
		System.out.println("====================");
		for(Object obj : map.values())
			System.out.println(obj);

		
		
	}
}
