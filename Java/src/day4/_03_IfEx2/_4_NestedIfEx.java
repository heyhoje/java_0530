package day4._03_IfEx2;

public class _4_NestedIfEx {

	public static void main(String[] args) {
		// 2, 3, 6�� ��� �Ǻ� ����
		// day4.practice ��Ű���� IfMultipleEx2 ����
		
		int num = 6;
		
		// 2�� ���   2 4 6 8 10 12
		if (num % 2 ==0 ) {
			// 2�� ��� �� 3�� ��� -> 6�� ��� 6 12 18
			if(num % 3 == 0) {
				System.out.println("6�� ���");
			} else {
				System.out.println("2�� ���");
			}
			// �ƴ� �� -> 2�� ��� 2 4 8 10
		}
		// 3�� ��� 
		else if (num % 3 == 0) {
			System.out.println("3�� ���");
		}
		//�ƴ� ��
		else {
			System.out.println("2, 3, 6�� ����� �ƴϴ�");
		}

	}

}
