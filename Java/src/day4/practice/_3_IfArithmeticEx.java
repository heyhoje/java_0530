package day4.practice;

import java.util.Scanner;

public class _3_IfArithmeticEx {

	public static void main(String[] args) {
		// ��� �����ڿ� �� ������ �Է¹޾� ���������(v���ǹ� + -> =)�� �´� ���� ����� ����ϴ� �ڵ带 �ۼ��ϼ���
		// �� : input 2 nums and arithmetic operator : 
		// 1 + 2 [����]
		// 1 + 2 = 3
		// input 2 nums and arithmetic operator
		// 1 ? 2 [����]
		// ? is not arithmetic operator!
		
		//��������� : op, �� ���� : num1, num2
		int num1, num2;
		char operator;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("��� �����ڿ� �� ������ �Է��ϼ���.");// input 2 nums and arithmetic operator (ex : 1 2 +)
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		operator = sc.next().charAt(0);// num1, num2, operator ������ �������, �����ϸ� �Է�.
		
		
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)num1 / num2;
		int mod = num1 % num2;
		
		
		if (operator == '+') {// ""���ڿ��� ó���� ��� .equals()�� ����ϴϱ� ''����ó������
			System.out.println(num1 + " + " + num2 + " = " + sum);
		//if (operator == '+') {
			//System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 + num2))}
		}else if (operator == '-') {
			System.out.println(num1 + " - " + num2 + " = " + sub);
		}else if (operator == '*') {
			System.out.println(num1 + " * " + num2 + " = " + mul);
		}else if (operator == '/') {
			System.out.println((double)num1 + " / " + num2 + " = " + div );
		}
		else if (operator == '%') {
			System.out.println(num1 + " % " + num2 + " = " + mod);
		}else {
			System.out.println("op is not arithmetic operator!");
		}
		
		sc.close();
		

	}

}
