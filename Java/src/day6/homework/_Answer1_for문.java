package day6.homework;

import java.util.Scanner;

public class _Answer1_for�� {

	public static void main(String[] args) {
		// ���μ� <- practice �ִ����� ���� Ȱ��
		/* 1. �� ������ �Է¹޾� �� ������ ���μ� �������� �Ǻ��ϴ� �ڵ带 �ۼ��Ͻÿ�
		 * ���μ� : �ִ� ������� 1�� �� ���� ���� <<- day6.practice3.gcd�������� �ݺ��� ���� �� ��¹��� �޶���.
		 * input 2 numbers : 3 4
		 * Disjoint! (���μ�)
		 * input 2 numbers : 8 4
		 * Not disjoint! (���μ� �ƴ�)
		 */
		
		// �ݺ��� : i�� 1���� num1(num2)����, 1�� ���� 
				// ��Ģ�� : i�� num1�� ����̰�, i�� num2�� ����̸�, i�� gcd�� ����
				//num % i == 0 && num2 % i ==0, i�� gcd�� ���� 
				// �ݺ��� ���� �� : gcd�� 1�̸� Disjoint�� ����ϰ�
				// 				�ƴϸ� Not Disjoint�� ���
				
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
				 * 5) gcd�� 1�̸� Disjoint�� ����ϰ�, �ƴϸ� Not Disjoint�� ���
				 */
				
//				i = 1;
//				gcd = 0;
				for (i = 1, gcd = 1; i <= num1; i++) {
					if (num1 % i == 0 && num2 % i == 0) {
						gcd = i; // *i�� gcd�� ����!! l������ r���� ������ �߿���...!!!
					}
					// System.out.println(gcd);
				//	i++;
				}
				
				// a = b : b�� a�� ���� / A == B : A�� B�� ����. 
				if(gcd == 1) {
					System.out.println("���μ��̴�");
				}else {
					System.out.println("���μҰ� �ƴϴ�");
				}
				System.out.println("�ִ������� " + gcd);
				
				sc.close();

		}
				
	}


