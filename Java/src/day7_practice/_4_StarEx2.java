package day7_practice;

public class _4_StarEx2 {

	public static void main(String[] args) {
System.out.println("----�̵ �ﰢ��----");
		
		int i = 0;
		int j = 0;
		/*     *  	 	i = 1 ��=4 *=1 *=0 * i����ŭ �߰�
		 *    ** *		i = 2 ��=3 *=2 *=1
		 *   *** **		i = 3 ��=2 *=3 *=2
		 *  **** ***	i = 4 ��=1 *=4 *=3
		 * ***** ****	i = 5 ��=0 *=5 *=4
		 * 				  ��=? *=i�� (���ο��� ����)
		 */
		/* �ܺιݺ���
		 * �ݺ�Ƚ�� : i�� 1���� 5����, 1�� ����
		 * ��Ģ��(���๮) : * i���� ��� �� ����
		 * */
		for (i = 0; i < 5; i++) {
			/* ���ιݺ���
			 * �ݺ�Ƚ�� : j�� 1���� 5 - i / i����, 1�� ����
			 * ��Ģ��(���๮) : ' ' / * �� ���
			 * */
			for (j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= i + 1; j++) {
				System.out.print("*");
			}// * i�� ���
			for (j = 1; j <= i; j++) { // ** �߰��� for��!
				System.out.print("*");
			}
//			for (j = 2; j <= 4 - i; j++) {
//				System.out.print(" ");
//			}
			System.out.println();
		}
		
		System.out.println("----�̵ �ﰢ�� 2----");
		
		i = 0;
		j = 0;
		/* ssss*ssss 	i = 1 ��=4 *=1
		 * sss***sss	i = 2 ��=3 *=2
		 * ss*****ss	i = 3 ��=2 *=3
		 * s*******s	i = 4 ��=1 *=4
		 * *********	i = 5 ��=0 *=5
		 * 				  ��=? *=i�� (���ο��� ����)
		 */
		/* �ܺιݺ���
		 * �ݺ�Ƚ�� : i�� 1���� 5����, 1�� ����
		 * ��Ģ��(���๮) : * i���� ��� �� ����
		 * */
		for (i = 0; i < 5; i++) {
			/* ���ιݺ���
			 * �ݺ�Ƚ�� : j�� 1���� 5 - i / i����, 1�� ����
			 * ��Ģ��(���๮) : ' ' / * �� ���
			 * */
			for (j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= i + 1; j += 2) {
				System.out.print("*");
			}
			for (j = 1; j <= 5 - i; j++) {
				System.out.println(" ");
			}
			System.out.println();
		}
		
	}

}
