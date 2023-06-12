package day8.homework;

import java.util.Scanner;

public class _Answer1_1 {

	public static void main(String[] args) {
		/* 1. �� ������ ��� �����ڸ� �Է¹޾� ��� ���� ����� ����ϴ� �ڵ带 �ۼ��ϼ��� 
		 * ��, �޼ҵ� �̿� 
		 * �����ڸ� �߸� �Է��� ���� ���ٰ� ���� (���� ó���� ���� �߰�)
		 * 0���� ������ ���� ���ٰ� ���� (�Է¸� �����ָ�� �ڵ� �߰��� �ʿ�x)
		 */	
		int num1, num2;
		char operator;
		double result; // *
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ������ ��� �����ڸ� �Է��ϼ��� : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		result = Arithmetic(num1, operator, num2); // *
		System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
		
		//Arithmetic(num1, operator, num2);

		sc.close();
	}

	/** ��  �� : �� ������ ��������ڸ� �Է¹޾� ��� ���� ����� �˷��ִ� �޼ҵ�
	 * �Ű����� : �� ����, ��������� => int num1, int num2, char operator
	 * ����Ÿ�� : ��� ���� ��� => �Ǽ� => double �� �޾ƾ���(div�� double�̱� ����)
	 * �޼ҵ�� : Arithmetic
	 * @return 
	 */
	public static double Arithmetic(int num1, char operator ,int num2) {// *
		double result = 0.0; // *
		switch (operator) {
		case '+': // ""���ڿ��� ó���� ��� .equals()�� ����ϴϱ� ''����ó������
			result = num1 + num2;
			break;
		case '-':
			result = num1 - num2;
			break;
		case '*':
			result = num1 * num2;
			break;
		case '/':
			result = (double)num1 / num2;
			break;
		 // �����⸦ (double)(num1/num2) �̷��� ���� ���� >> (double)num1/num2 �̷��� �ϴϱ� ��
		case '%':
			result = num1 % num2;
			break;
			
		default: // �߸��� �������� ��� ����ó���� �ؾ� �ϴµ� ���� �ȹ���� �ּ�ó��
			throw new RuntimeException("Wrong operator!");
		}
		
		return 0.0; // *
		//return null; // ����Ÿ���� void�� �ٲٰų�, ���Ϲ��� ���϶�� ��� ���� �����ߴµ�, 
					 // �ܼ�â�� �״�� ��µ�. �̷��� �ȵ��ݾ�...? 		
											
	}
	
}
