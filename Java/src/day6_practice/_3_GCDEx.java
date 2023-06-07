package day6_practice;

import java.util.Scanner;

public class _3_GCDEx {

	public static void main(String[] args) {
		// 3. �� ���� num1�� num2�� �Է¹޾� �� ������ �ִ� ������� ���ϴ� �ڵ带 �ۼ��Ͻÿ�
		/* ��� : ������ �������� ��
		 * ����� : �������� �ִ� ���
		 * �ִ� ����� : ����� �� ���� ū ��
		 * 8�� 12�� ����� : 1, 2, 4
		 * 8�� 12�� �ִ�����
		 * 9, 10, 11, 12 = 8�� ����� �� �� ���� ������, num1�� �ϵ� num2�� �ϵ� �������.
		 */
		
		// �ݺ��� : i�� 1���� num1(num2)����, 1�� ���� 
		// ��Ģ�� : i�� num1�� ����̰�, i�� num2�� ����̸�, i�� gcd�� ����
		//num % i == 0 && num2 % i ==0, i�� gcd�� ���� 
		// �ݺ��� ���� �� : gcd ��� => ������� 2�� �����ϸ� 1�� ���. 4�� �����ϸ� 2�� ���. �ִ� ������� ����
		
		int num1 = 0, num2 = 0;
		int i, gcd;
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ������ �Է��ϼ��� : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt(); // num �Է¹��� while�ȿ� ������ �ȵ�.
		
		/* 1) �� ������ �Է�
		 * 2) �ݺ���(�ִ������� ���ϱ� ����, �ȿ� ������ �Է��ϸ� �ȵ�) : i�� num1����	
		 * 	3) num1�� i�� ���������� �������� 0�� ����, num2�� i�� �������� �� �������� 0�� ���ٸ�, i�� gcd�� ����
		 * 	4) i�� 1����
		 * 5) gcd�� ���
		 */
		
		i = 1;
		gcd = 0;
		while (i <= num1) {
			if (num1 % i == 0 && num2 % i ==0) {
				gcd = i; // *i�� gcd�� ����!! l������ r���� ������ �߿���...!!!
			}
			// System.out.println(gcd);
			i++;
		}
		System.out.println("�ִ������� " + gcd);
		
		sc.close();
	}
}
