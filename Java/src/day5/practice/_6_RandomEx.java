package day5.practice;

public class _6_RandomEx {

	public static void main(String[] args) {
		// �ݺ��� ������ �ƴϰ�, ������ �ʿ��� ����
		// min���� max ������ ������ ������ ����� �ڵ带 �ۼ��ϼ���.
		// Math.random() : 0�̻� 1�̸�(1����x)�� �Ǽ��� �������� ����
		System.out.println(Math.random());
		// 0 <= random < 1
		// 0 *(max - min + 1) <= r *(max - min + 1) < 1 *(max - min + 1) // 0�̾ƴ� ����� ���ϸ� �ε�ȣ �״�� ����
		// 0 <= r *(max - min + 1) < (max - min + 1) 
		// 0 + min <= r*(max - min + 1) + min < (max - min + 1) + min
		// min <= r *(max - min + 1) + min < max + 1
		
		//��
		int min = 1, max = 10;
		int random = (int)(Math.random() * (max - min + 1) + min); // double + � �� = double => ������ ������ ����� ���� �Ҽ��� ������
		// �� �� �ڵ常 �����....�� 																//(int)�� ����ȯ
		System.out.println(random);
	}

}
