package day25.test;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
	
		//list�� hashSet�� 
		// HashSet�� List�� ����Ŭ������ �ƴϱ� ������(��ī��) HashSet�� ��ü�� List�� ������ �� ����.
		//List<Integer> list = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		
		// 3�� int. 3�� �ڵ����� �ڽ̵Ǽ� Integer�� ��ü�� ����
		// (�ڽ� - wrapperŬ���� ��ü�� /��ڽ� - ���ִ°�)
		list.add(3);
		list.add((int)4);
		// 5�� ���� �ڽ����� Integer�� ��ü�� ��ȯ �� ����
		list.add((Integer)5);
				
		// >> �´� ������!
			
	}
}
