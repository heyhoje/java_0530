package day7.homework;

public class _1_StarEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----���̾Ƹ��----");
		int i = 0;
		int j = 0;
		int k = 0;
		/*  sss*  	 	  i = 1 ��=3 *=1 
		 *  ss** *		  i = 2 ��=2 *=3 
		 *  s*** **		  i = 3 ��=1 *=5 
		 *  **** ***	//i = 4 ��=0 *=7 
		 *  s*** ** 	  i = 5 ��=1 *=5 
		 * 	ss** *		  i = 6 ��=2 *=3 
		 *  sss*		  i = 7 ��=3 *=1
		 * 
		 */
		/* �ܺιݺ���
		 * �ݺ�Ƚ�� : i�� 1���� 5����, 1�� ����
		 * ��Ģ��(���๮) : * i���� ��� �� ����
		 * */
		
		for (i = 0; i < 4; i++) {
			/* ���ιݺ���
			 * �ݺ�Ƚ�� : j�� 1���� 5 - i / i����, 1�� ����
			 * ��Ģ��(���๮) : ' ' / * �� ���
			 * */
			for (j = 1; j <= 3 - i; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= i + 1; j++) {
				System.out.print("*");
			}// * i�� ���
			for (j = 1; j <= i; j++) { // ** �߰��� for��!
				System.out.print("*");
			}
			System.out.println();
		}
		for (i = 0; i < 3; i++) {
			for (k = 1; k <= i + 1; k++) {
				System.out.print(" ");
			}
			for (k = 1; k <= 3 - i; k++) {
				System.out.print("*");
			}
			for (k = 1; k <= 2 - i ; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
