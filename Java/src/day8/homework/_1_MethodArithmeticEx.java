package day8.homework;

import java.util.Scanner;

public class _1_MethodArithmeticEx {

	public static void main(String[] args) {
		/* 1. �� ������ ��� �����ڸ� �Է¹޾� ��� ���� ����� ����ϴ� �ڵ带 �ۼ��ϼ��� 
		 * ��, �޼ҵ� �̿� 
		 * �����ڸ� �߸� �Է��� ���� ���ٰ� ���� (���� ó������ �߰�)
		 * 0���� ������ ���� ���ٰ� ���� (�Է¸� �����ָ�� �ڵ� �߰��� �ʿ�x)
		 */	
		int num1, num2;
		char operator;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ������ ��� �����ڸ� �Է��ϼ��� : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		String getArithmetic = Arithmetic(num1, num2, operator);
		System.out.println(getArithmetic);
		
		sc.close();
	}

	/** ��� : �� ������ ��������ڸ� �Է¹޾� ��� ���� ����� �˷��ִ� �޼ҵ�
	 * �Ű����� : �� ����, ��������� => int num1, int num2, char operator
	 * ����Ÿ�� : ��� ���� ��� ex) 1 + 2 = 3 => char?? 
	 * 										���ڿ�???? �Ű������� �� �ٸ��� String���� ���Ϲ޾�???
	 * �޼ҵ�� : Arithmetic
	 * @return 
	 */
	public static String Arithmetic(int num1, int num2, char operator) {
//		int sum = num1 + num2;
//		int sub = num1 - num2;
//		int mul = num1 * num2;
//		double div = (double)num1 / num2;
//		int mod = num1 % num2;
		
		if (operator == '+') {// ""���ڿ��� ó���� ��� .equals()�� ����ϴϱ� ''����ó������
			System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		}else if (operator == '-') {
			System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
		}else if (operator == '*') {
			System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
		}else if (operator == '/') {
			System.out.println((double)num1 + " / " + num2 + " = " + (double)(num1/num2));
		}
		else if (operator == '%') {
			System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
		}
		return null; // ����Ÿ���� void�� �ٲٰų�, ���Ϲ��� ���϶�� ��� ���� �����ߴµ�, 
					 // �ܼ�â�� �״�� ��µ�. �̷��� �ȵ��ݾ�...? 		
											
	}
	
}
