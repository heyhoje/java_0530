package day6._044_ForEx;

public class _1_HelloworldEx {

	public static void main(String[] args) {
		/* for���� �̿��Ͽ� Hello world �� 5�� ����ϴ� ����
		 * �ݺ�Ƚ�� : 5��, i�� 1���� 5����, 1�� ����
		 * ��Ģ�� : Hello world �� ���
		 */
		
		int i;
		for (i = 0; i < 5; i++) {
			System.out.println("Hello world");
		}
		
		
		System.out.println("---------");
		i = 1; // * �ʱ�ȭ
		while (i <= 5) {
			System.out.println("Hello world");
			i++; // * i�� 1�� ����
			// ���ѷ��� ���ͼ� ��¦�����;;;;
		}
	}

}
