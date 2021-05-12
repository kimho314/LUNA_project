package wrapper_class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex3 {
	
	public static void main(String[] args) {
		
		// �迭�� ��ü��
		// �����͸� �ĺ��ϴ� ����� ���̸� �ΰ� �ִ� �迭��
		// 1. �����Ͱ� �� �ĺ��ڴ� -> Set�迭
		// set�� �ߺ� ������ �Ұ�
		
		Set set = new HashSet(); 
		set.add("hello");
		set.add(37);
		set.add("ȣȣȣ");
		set.add("hello");
		set.add(37);
		set.add("ȣȣȣ");
		
		for(Object obj : set)
			System.out.println(obj);
		System.out.println("====================");
		
		// 2. �������� ������ �� �ĺ��ڴ� => List�迭
		List list = new ArrayList();
		list.add("hello");
		list.add(37);
		list.add("ȣȣȣ");
		list.add("hello");
		list.add(37);
		list.add("ȣȣȣ");
		
//		for(int i=0; i<list.size(); i++)
//			System.out.println(list.get(i));
		//System.out.println("====================");
		for(Object obj : list)
			System.out.println(obj);
		System.out.println("====================");
		
		// 3. �������� �ĺ��ڰ� ���� �ִ�. => Map�迭
		Map map = new HashMap();
		map.put("�̸�", "ȫ�浿");
		map.put("����", "17");
		map.put("�ּ�", "����");
		
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