package day25.test;

import java.util.HashSet;
import java.util.Set;

public class Test5 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		// �޼ҵ� add�� Collection�������̽��� �ִ�.
		// Collection �������̽��� �ڽ����� List�� Set�� ����. �׷��� add�޼ҵ� �Ѵ� ��� ����.
		set.add(1);
		set.add(2);
		
		/*
		for(int i = 0; i<set.size(); i++) {
			// get�� list�� �ִ� �޼ҵ�. Set���� ���� �޼ҵ��(����!!!)
			System.out.println(set.get(i));
		}
		*/
		for(Integer tmp : set) {
			System.out.println(tmp);
		}
	}
}

// �� list, set ������ �κ� �� �𸣳�����... 
