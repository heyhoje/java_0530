package day6_practice;

public class _4_PrimeNumbers3 {

	public static void main(String[] args) {
		// 4. 2���� 100������ �Ҽ��� ����ϴ� �ڵ带 �ۼ��ϼ���.
		// day5.practice << PrimeNumbersEx ����
		
		int i = 2, j;
		int count = 0;
		// �ܺιݺ���
				// �ݺ�Ƚ�� : i�� 2���� 100���� 1�� ����
				// ��Ģ�� : i�� �Ҽ�(����� 1�� �ڽŹۿ� ���� ��)�̸� i�� ���
				//		num % i == 0
		while(i <= 100) {
			j = 1;
			count = 0; // �ݺ��� �ۿ��� count�ʱ�ȭ�� �������.
			while(j <= i) {
				if(i % j == 0) {
					count++;
				}
				j++;
			}
		
			if (count == 2) {
				System.out.println(i);
			}
			i++;
		}
		
		System.out.println("----------");
//		for (i = 2; i <= 100; i++) { // 2���� 100���� ���ǵ�
//			/*���ιݺ���
//			 * �ݺ�Ƚ�� : j�� 1���� i���� 1�� ����
//			 * ��Ģ�� : j�� i�� ����̸� ����� ����(�ʱ�ȭ, �����ָ� �����̵�)�� 1 ����
//			 * �ݺ��� ���� �� : ����� ������ 2���̸� i�� ���
//			 */
//			for (num = 1; j <= num; num++) {
//				if (num % j == 0) {
//					j++;
//					count += 1;
//				}
//			}
//			if (count == 2) {
//				System.out.println(num);
//			
			}
		
	}

