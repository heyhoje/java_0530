package day5.practice;

public class _2_PrintEvenNumberEx {

	public static void main(String[] args) {
		// 2. 10 ������ ¦���� ����ϴ� �ڵ带 �ۼ��ϼ���.
		
		System.out.println("----���1----");
		/*�ݺ�Ƚ�� : i�� 1���� 5���� 1�� ����
		 * ��Ģ�� : 2*i �� ���
		 */
		int i = 1;
		while (i <= 5) {
			System.out.println(2*i);
			++i;
		}
		System.out.println("----���2----");
		/*�ݺ�Ƚ�� : i�� 2���� 10���� 2�� ����
		 * ��Ģ�� : i �� ���
		 */
		i = 2;
		while (i <= 10) {
			System.out.println(i);
			i += 2; // i = i + 2
		}
	
		System.out.println("----���3----");
		/*�ݺ�Ƚ�� : i�� 1���� 10���� 1�� ����
		 * ��Ģ�� : i�� ¦���̸� i�� ���
		 */
		i = 1;
		while (i <= 10) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
			++i;
		}
		
//		int num = 0;
//		if(num % 2 == 0) {
//			while (num <= 10) {
//				System.out.println(num);
//				++num;
//			}
//		}
		
	}

}
