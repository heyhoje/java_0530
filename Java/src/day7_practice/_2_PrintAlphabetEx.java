package day7_practice;

public class _2_PrintAlphabetEx {

	public static void main(String[] args) {
		// 2. a���� z���� ����ϴ� �ڵ带 �ۼ��ϼ���.
		// abcdefg - xyz : 
		
		System.out.println("---- �� �� 1 -----");
		// 'a' + ���� => Int��
		// 'a'�� 0�� ���ϸ� 'a'
		// 'a'�� 1�� ���ϸ� 'b'
		// 'a'�� 2�� ���ϸ� 'c'
		// ...
		// 'a'�� 25�� ���ϸ� 'z'
		
		/* �ݺ�Ƚ�� : i�� 0���� 25����(26��, 26���� ����������), 1�� ���� 
		 * ��Ģ�� : 'a' + i �� ���� ���� ���������� �ڷ�����ȯ�ؼ� ���
		 * �ݺ��� ���� �� : ����
		 */
		int i;
		char ch = 'a';
		for (i = 0;i < 26 ;i++) {
			System.out.print((char)('a' + i));
		}
		
		System.out.println();
		System.out.println("---- �� �� 2 -----");
		/* ���ڸ� ����ch++�� �ϸ� char
		 * �ݺ�Ƚ�� : ch�� 'a'���� �����ؼ� 'z'���� 1�� ���� 
		 * ��Ģ�� : ch�� ���
		 * �ݺ��� ���� �� : ����
		 */
		
		for (ch = 'a';ch <= 'z' ;ch++) { // ����Ÿ�Կ��� 1�� ������. + int 1 �� �������°Ͱ� �ٸ�.
			System.out.print(ch);
		}
	}

}
