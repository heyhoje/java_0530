package day7_practice;

public class _3_PrintAlphabetEx2 {

	public static void main(String[] args) {
		/* 3. ������ ���� ��µǴ� �ڵ带 �ۼ��ϼ���.
		 * a
		 * ab
		 * abc
		 * abcd
		 * ...
		 * abcdefg_xyz
		 */
		
		/* �ܺιݺ���
		 * �ݺ�Ƚ�� : end�� 'a'���� �����ؼ� 'z'����, 1�� ����
		 * ��Ģ�� : 'a'���� end���� ���
		 * �ݺ��� ���� �� : ����
		 * */
		int i, j;
		char ch = 'a';
		for(i = 0; i < 26; i++) {
			/* ���ιݺ���
			 * �ݺ�Ƚ�� : end�� 'a'���� �����ؼ� 'z'����, 1�� ����
			 * ��Ģ�� : 'a'���� end���� ���
			 * �ݺ��� ���� �� : ����
			 * */
			for(j = 0; j < i+1; j++) {
				System.out.print((char)(ch + j));
			}
			System.out.println();

		}
			System.out.println();
		System.out.println("---����� ���---");
		
		char end;
		for(end = 'a'; end <= 'z'; end++) {
			for(ch = 'a'; ch <= end; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}
		System.out.println("---â���� ���---");
		ch = 'a';
		for(i = 0; i < 26; i++) {
			/* ���ιݺ���
			 * �ݺ�Ƚ�� : end�� 'a'���� �����ؼ� 'z'����, 1�� ����
			 * ��Ģ�� : 'a'���� end���� ���
			 * �ݺ��� ���� �� : ����
			 * */
			for(j = 0; j < i+1; j++) {
				System.out.print((char)(ch + i)); // ���ιݺ����ȿ� i�� ������, a bb ccc �̷��� �����
			}
			System.out.println();
		}
		
	}

}
