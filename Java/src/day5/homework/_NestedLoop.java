package day5.homework;

public class _NestedLoop {

	public static void main(String[] args) {
		// �� �簢��
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*"); // *****
			}
			System.out.println(" "); // ���ιٲ� ���ιݺ�
		} 
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*"); // * > ** > *** > **** > *****
			}
			System.out.println(""); // ���ιٲ� ���� �ݺ� 5ȸ
		}
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i - 1;j++) {
				System.out.print("S");
			}
			for (int k = 0; k < i + 1; k++) {
				System.out.print("*"); // for �ȿ� for�� 2��/���� 4 + * 1
			}
			System.out.println(); // ���ιٲ� ���� �ݺ� 5ȸ
		}
		
		System.out.println("----------------------------");

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + (i*j));
			}
			System.out.println();
		}
	}

}
