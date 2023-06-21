package day8.Practice;

import java.util.Scanner;

public class _4_MethodLCMEx {

	public static void main(String[] args) {
		// ���� num1�� num2�� �Է¹޾� �� ������ <�ּ� �����>�� ���ϴ� �ڵ带 �ۼ��ϼ���
		// ��, �޼ҵ带 �̿��� ��
		/* A : ga, B : gb
		 * g : g     �ִ� �����
		 * l : A+B/g �ּ� �����
		 * A+B/g == (ga+gb)/g == gab
		 */
		
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ������ �Է��ϼ��� : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int lcm = lcm1(num1, num2);
		System.out.println(num1 + "�� " + num2 + "�� lcm(�ּҰ����1) : " + lcm);
		
		lcm = lcm2(num1, num2);
		System.out.println(num1 + "�� " + num2 + "�� lcm(�ּҰ����2) : " + lcm);
		
		sc.close();
		
	}
	
	/** �ִ����� GCD �޼ҵ� �ҷ��� */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0; 
		// num1�� num2�� ���
		// num2�� num1�� ���
	}
	
	public static int gcd(int num1, int num2) {
		for (int i = num1; i >= 1; i--) {
			if(isMultiple(num1, i) && isMultiple(num2, i)) {
				return i;
			}
		}
		return 1;
	}
		
	/** �� ������ �־����� �� ������ <�ּ� �����>�� �˷��ִ� �޼ҵ� */
	public static int lcm1(int num1, int num2) {
		for(int i = num1; i <= num1 * num2; i += num1) {
			//      num1 = 2/  2 * 12 = 24/ i�� num1�� ���
			
			if(isMultiple(i, num2)) { // i % num2 == 0 -> num1�� num2 �� �����
				// ������� ã��. isMultiple�� ����� ã�� �żҵ��̰�,
				// i�� num1�� ������̱� ������ i�� num2�� ����̸� num1�� num2�� ������� ��
				return i;
			}
		}
		return num1*num2; 
	}
	
	public static int lcm2(int num1, int num2) {
		return num1*num2 / gcd(num1, num2);
						 // num2�� num1�� ����̴� == num1�� num2�� ����̴�!!
						 // �ִ����� = num1�� i�� ���&&num2�� i�� ��� = 
	}
	
	
	}