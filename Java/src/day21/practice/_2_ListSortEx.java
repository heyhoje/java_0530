package day21.practice;

// ��￡ ����... �� ����� �ƴϾ�..... 

import java.util.ArrayList;
import java.util.Comparator;

public class _2_ListSortEx {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(4);
		list.add(8);
		System.out.println(list);
		/* ����Ʈ�� �ִ� sort�� compare�޼��带 ���� ��ü�� �ʿ���.
		 * ��? ���ı����� compare�� �ϱ� ����. compare���� �����̸� ������, ������ 0,
		 * ����̸� �ڷ�.
		 * ��ü�� compare �޼��带 �ݵ�� �����ϱ� ���� Comparator �������̽��� ������
		 * ���� Ŭ������ ��ü�� �� �� �ְ� ����  */
		//list.sort(new IntegerCompare());
		//Comparator �������̽��� �͸� Ŭ������ ���� ��ü�� ����
		/*
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
			
		});*/
		list.sort(null);
		//list.sort((Integer o1, Integer o2)->o1-o2);
		System.out.println(list);
	}

}
class IntegerCompare implements Comparator<Integer>{

	//@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
}

