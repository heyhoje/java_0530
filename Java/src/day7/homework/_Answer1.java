package day7.homework;

public class _Answer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----���̾Ƹ��----");
		int i = 0;
		int j = 0;
		/*  sss*  	 	  i = 1 ��=3 *=1 
		 *  ss** *		  i = 2 ��=2 *=3 
		 *  s*** **		  i = 3 ��=1 *=5 
		 *  **** ***	//i = 4 ��=0	 *=7 
		 *  			�� = half-1 / * = 2*i-1
		 *  s*** ** 	  i = 5 ��=1 *=5  2*3-1 
		 * 	ss** *		  i = 6 ��=2 *=3  2*2-1
		 *  sss*		  i = 7 ��=3 *=1  2*1-1
		 * 					�� = i-half / * = 2*(num+1-i)-1 = 2*(num-i)+1
		 */
		/* �ܺιݺ���
		 * �ݺ�Ƚ�� : i�� 1���� 5����, 1�� ����
		 * ��Ģ��(���๮) : * i���� ��� �� ����
		 * */
		int num = 7;
		for (i = 0; i <= num; i++) {
			/* ���ιݺ���
			 * �ݺ�Ƚ�� : j�� 1���� 5 - i / i����, 1�� ����
			 * ��Ģ��(���๮) : ' ' / * �� ���
			 * */
			int half = (num + 1) / 2;
			// 4�� => (num + 1) / 2;
			if (i <= half) { // �� �ﰢ��
				// half - 1�� �������
				for (j = 1; j <= half - i; j++) {
					System.out.print(" ");
				}
				// 2*i-1�� * ���
				for (j = 1; j <= 2*i - 1; j++) {
					System.out.print("*");
				}
				// ����
				System.out.println();
			// 3�� => 
			}else {  
				// i - half�� �������
				for (j = 1; j <= i - half; j++) {
					System.out.print(" ");
				}
				// 2*(num-i)+1�� * ���
				for (j = 1; j <= 2*(num-i)+1; j++) {
					System.out.print("*");
				}
				// ����
				System.out.println();
			}
		}
	}

}
