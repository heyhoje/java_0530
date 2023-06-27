package day20._122_collection;

import java.util.ArrayList;

// �л����� ����Ʈ
public class _1_listEx2 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "ȫ�浿"));
		list.add(new Student(1, 1, 2, "���浿"));
		list.add(new Student(1, 1, 3, "���浿"));
		list.add(new Student(1, 1, 4, "�ٱ浿"));
		list.add(new Student(1, 1, 5, "��浿"));
		
		System.out.println(list); // Student > @toString ����Ʈ �߰�
		
		/* remove �޼ҵ�� 'Object's'Ŭ������ equals'�� ȣ��(Objects.equals(A,B))�ؼ� true�� ��쿡�� ����! 
		 * => A�� �ڱ� �ڽ�, B�� �����Ϸ��� ��ü
		 * => A�� B�� Ŭ������ �ٸ��� false�� ����
		 * => A�� B�� Ŭ������ ������ A.equals(B)�� ȣ���ؼ� ����� ���� 
		 * Student Ŭ������ equals�� �������̵� ���� ������, Student Ŭ������ equals�� �ּҸ� ��
		 * => �г�, ��, ��ȣ, �̸��� ������, new StudentC ���� ��ü�� ������� ������ �ּҰ� �ٸ�
		 * => ���� �ٸ� ��ü�� �Ǻ��ؼ� �������� �ȵ�.... */
		//list.remove(new StudentC(1, 1, 1, "ȫ�浿"));
		System.out.println(list); // ������ �ȵ�
		
		// �� �÷��������ӿ�ũ, list, set, map���� �����Ҷ� equals�� Ȱ����
		// contains, indexOf�� Objects.equals�� ȣ���ؼ� ���� ��ü�� ã��
		System.out.println(list.contains(new Student(1,1,1,"ȫ�浿")));
		System.out.println(list.indexOf(new Student(1,1,1,"ȫ�浿")));
		
	}

}
