package day5._04_whileEx;

public class _1_HelloWorldEx {

	public static void main(String[] args) {
		// Hello world �� 10�� ����ϴ� �ڵ带 �ۼ��ϼ���.
		System.out.println("Hello world!");
		System.out.println("------------------");
		
		/* �ݺ�Ƚ�� : 10��, 1������ 10������ 1�� ���� ( 1 ~ 10 ) ( 0 ~ 9 )
		 *  => �ݺ�Ƚ���� ������ �ʱⰪ : 1
		 *  => ���ǽ� : 10����( 10���� �۰ų� ���� ������)
		 *  => �����ϴ� �� : 1�� ����
		 * ��Ģ�� : Hello world(���� ���ڿ�)�� ���
		 */
		
		int max = 3;
		int i = 1; // ������ �ʱⰪ : 1
		//while (���ǽ�) {
		//	���๮;
		//} 
		// i �� 10���� �۰ų� ���� ������
		while (i <= max) {
			System.out.println("Hello world!");
			i++; // i�� 1�� ����, i++, i = i + 1, i += 1
		}
		System.out.println("------------------");
		
		/* �ݺ�Ƚ�� : i�� 10���� 1���� 1�� ����
		 * 
		 * */
		i = max;
		while (i >= 1) {
			System.out.println("Hello world!");
			--i;
		}
		System.out.println("------------------");
		i = max;
		while (i-- >= 1) { // ���������ڸ� ���� �ڵ� ������ ���� �� �ִ�. 
			System.out.println("Hello world!");
			
			
			
		}
	}

}
