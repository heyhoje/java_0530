package day7.homework;

public class _1_StarEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----���̾Ƹ��----");
		int i = 0;
		int j = 0;
		/*  sss*  	 	i = 1 ��=3 *=1 
		 *  ss** *		i = 2 ��=2 *=3 
		 *  s*** **		i = 3 ��=1 *=5 
		 *  **** ***	i = 4 ��=0 *=7 
		 *  s*** ** 	i = 5 ��=1 *=5 
		 * 	ss** *		i = 6 ��=2 *=3 
		 *  sss*		i = 7 ��=3 *=1
		 * 
		 */
		/* �ܺιݺ���
		 * �ݺ�Ƚ�� : i�� 1���� 5����, 1�� ����
		 * ��Ģ��(���๮) : * i���� ��� �� ����
		 * */
		
		for (i = 1; i <= 7; i++){
			for (j = 1; j <= 4 - i; j++) {
				System.out.print(" ");
			}
			for (j = 0; j <= 8; j += 2) {
				System.out.print("*");
			}
			System.out.println();
		}
				
	}

}
