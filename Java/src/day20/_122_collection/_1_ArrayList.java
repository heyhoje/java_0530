package day20._122_collection;

import java.util.ArrayList;
import java.util.Iterator;

// ������ �߰�(add) & ����(remove)
public class _1_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		// 1���� 5���� ���ʴ�� �߰�
		for (int i = 1; i <= 5; i++) {
			list.add(i); // ���� i�� �ڽ����� IntegerŬ������ ��ü�� �� �� list�� �߰�
		}
		
		// 1�� �� �߰�
		
		list.add(1); // �ߺ��� ����ϱ� ������ 1 �߰� ��! 
		System.out.println(list);
		
		// 1�� ����
		System.out.println("----------");
		list.remove((Integer)1); // 1���� �� -> Integer�� �ڽ�, 
								 // ù��° ������ 1�� �����ϰ�, ���Ű� �Ǿ� true�� ��ȯ
		System.out.println(list);
		// 1������ �ִ� ��/��ü�� ����(3�� ����)
		System.out.println("---------");
		Integer num = list.remove(1); // 1������ �ִ� ��Ҹ� �����ϰ� ������ ��Ҹ� ��ȯ
		System.out.println(num);
		System.out.println(list);
		System.out.println("----------");
		System.out.println(list.size());// size : (����) ����� ��ü ���� ���. ���� ������ �ִ� ��ü ���� �ƴ�
		// �迭������ ���� ������ ��ü ���� ��ü �迭�� ���� �ٸ� �� ����. 
		
		// �Ϲ�. List�� Ư�� ������ ������ �� �־, get()�� �̿��Ͽ� �ݺ����� Ȱ���� �� �ִ�.
		// >> �迭�� �ִ� �� ���ٷ� ���
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// ���� for��. List�� Set ��� ����
		for(int tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		// Iterator(������ ���� map���� �ʿ�. ���)
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) { // hasNext : ���� ��Ұ� �ִ��� ������ ���°�
			Integer tmp = it.next(); // ������ �����ͼ� ���. ������ ����
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		// Set�� ������ ���⶧���� '���� for��'�̳� 'Iterator'�� ����ؾ���
		System.out.println("----------");
		// ��Ҹ� ã�� �� ���� contains, indexOf
		System.out.println(list.contains(1)); // list.contains() : List�� 1�� �ִ��� ������ Ȯ��
		System.out.println(list.indexOf(1)); // list.indexOf() : List�� 1�� ������� �ִ��� Ȯ��
		
		
	}

}
