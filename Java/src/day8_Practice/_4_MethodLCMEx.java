package day8_Practice;

import java.util.Scanner;

public class _4_MethodLCMEx {

	public static void main(String[] args) {
		// ���� num1�� num2�� �Է¹޾� �� ������ �ּ� ������� ���ϴ� �ڵ带 �ۼ��ϼ���
		// ��, �޼ҵ带 �̿��� ��
		/* A : ga, B : gb
		 * g : �ִ�����
		 * l : A+B/g
		 * A+B/g == (ga+gb)/g == gab
		 */
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ������ �Է��ϼ��� : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int lcm = lcm1(num1, num2);
		System.out.println(num1 + "�� " + num2 + "�� lcm : " + lcm);
		
		sc.close();
		
	}
	
	/** �ִ����� GCD �޼ҵ� �ҷ��� 
	 */
		
	/** �� ������ �־����� �� ������ �ִ� ������� �˷��ִ� �޼ҵ�
	*/
	public static int lcm1(int num1, int num2) {
		for(int i = num1; i <= num1 * num2; i += num1) {
			// ������� ã��. isMultiple�� ����� ã�� �żҵ��̰�,
			// i�� num1�� ������̱� ������ i�� num2�� ����̸� num1�� num2�� ������� ��
			if(isMultiple(i, num2)) {
				return i;
			}
		}
		return num1*num2; 
	}
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;

	}
}