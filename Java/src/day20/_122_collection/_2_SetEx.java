package day20._122_collection;

import java.util.HashSet;

public class _2_SetEx {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		System.out.println(set);
		
		set.remove(10);
		System.out.println(set);
		System.out.println(set.contains(20));
		// set.indexOf ������ �������� �ʱ� ������, contains�� ���������� indexOf�� �ȵ� 
		System.out.println(set.size());
		
		// �ζ�, ���ھ߱����ӿ� ������ �� ����
	}

}
