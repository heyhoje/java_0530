package day11.practice;

import java.util.Scanner;

public class _3_DivisorEx {

	public static void main(String[] args) {
		// 3. ���� num�� ������� �迭�� �����ϴ� �ڵ带 �ۼ��ϼ���.
		// ����� �ִ� 10������ ����
		
		// ��� ���� Ȱ��
		
		/* 12 : 1 2 3 5 6 12
		 *     0���� ~~~~~ 5����
		 */
		
//		arr[0] = 1;
//		arr[1] = 2;
//		arr[2] = 3;
//		arr[3] = 4;
//		arr[4] = 6;
//		arr[5] = 12;
//		
//		arr[i] = num2
		
		int num, count = 0;
		int divisor[] = new int[10];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ���");
		num = sc.nextInt();
		
	
		for(int i = 1; i <= num; i++) { // i�� 0���Ͱ� �ƴ϶�, 1���Ϳ��� �Ѵ�(������ 0���� ������ ���� ������)
			// Exception in thread "main" java.lang.ArithmeticException: / by zero 
			if(num % i == 0) {
				//System.out.println(i);// ��ºκ��� �迭�� �����ϴ� �κ�����
				divisor[count] = i; // ���ο� ����, count��������
				count++;
			}
			if(count == divisor.length) { // count == 10�̶� ������ �� ���뼺 ���� ǥ��
				break;
			}
		}
		
		for(int i = 0; i < count; i++) {
			System.out.println(divisor[i]);
		}
		
		sc.close();
		
	}
}


