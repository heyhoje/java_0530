package day8.homework;

import java.util.Scanner;

public class _1_MethodArithmeticEx {

	public static void main(String[] args) {
		/* 1. �� ������ ��� �����ڸ� �Է¹޾� ��� ���� ����� ����ϴ� �ڵ带 �ۼ��ϼ��� 
		 * ��, �޼ҵ� �̿� 
		 * �����ڸ� �߸� �Է��� ���� ���ٰ� ���� (���� ó������ �߰�)
		 * 0���� ������ ���� ���ٰ� ���� (�Է¸� �����ָ�� �ڵ� �߰��� �ʿ�x)
		 */	
		
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char operator;
		double result;
		
		System.out.println("�� ������ ��������ڸ� �Է��ϼ��� : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0); // ����
		num2 = sc.nextInt();
		
		result = arithmetic(num1, operator, num2);
		
		System.out.println(num1 + "" + operator + "" + num2 + " = " + result );
		
		sc.close();
	}

	/** ��� : �� ������ ��������ڸ� �Է¹޾� ��� ���� ����� �˷��ִ� �޼ҵ�
	 * �Ű����� : �� ����, ��������� => int num1, int num2, char operator
	 * ����Ÿ�� : ��� ���� ��� ex) 1 + 2 = 3 => 
	 * �޼ҵ�� : Arithmetic
	 * @return 
	 */
	
	// switch / break;  �ʿ��� ���
	public static double arithmetic(int num1, char operator, int num2) {
		double result = 0.0;
		
		switch(operator) {
		case '+':
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
		case '%':
			result = num1 % num2;
			break;
		default:
			System.out.println("Worng operator!");
		}
		return result;
	}
	
	// switch, return ��ȯ �ϴ� ���
	public static double arithmetic2(int num1, char operator, int num2) {
		switch(operator) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return (double) num1 / num2;
		case '%':
			return num1 % num2;
		default:
			//throw new RuntimeException("Wrong operator!");
			return 0.0;
		}
		
	}
}
