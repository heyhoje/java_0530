package day19.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _1_ArithmeticEx {

	public static void main(String[] args) {
		// 1. �� ������ ��������ڸ� �Է����� �� ���� ����� ����ϴ� �ڵ带 �ۼ��ϼ���.
		// (����ó���� �߰�)
		/* input : 1 + 2
		 * 1 + 2 = 3
		 * input : 1 ? 2
		 * Not operator!
		 * input : 1 / 0
		 * Not operator!
		 * */
		
		// 1. �� ������ ��������� �Է�
		try {
		int num1, num2;
		char operator;
		double res;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ������ �����ڸ� �Է��ϼ���");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		// 2. �����ڿ� ���� ����� ���
		switch(operator) {
			case '+': 
				System.out.println(""+num1 + operator + num2 +" = " + (num1 + num2)); break;
			case '-': 
				System.out.println(""+num1 + operator + num2 +" = " + (num1 - num2)); break;
			case '*': 
				System.out.println(""+num1 + operator + num2 +" = " + (num1 * num2)); break;
			case '/': 
				System.out.println(""+num1 + operator + num2 +" = " + ((double)num1 / num2)); break;
			case '%': 
				System.out.println(""+num1 + operator + num2 +" = " + (num1 % num2)); break;
			default:
				System.out.println("�߸��� �����Դϴ�.");
			}
		
		sc.close();
		}catch(InputMismatchException e) {
			System.out.println("Wrong Input!");
		}catch(ArithmeticException e) {
			System.out.println("Not Operation");
		}catch(Exception e) { // �� �߰��ؼ� ���� �������� ���ܵ� �ɷ��� �� �ֵ���! ����
			System.out.println("Exception");
		}
		
	}

}


//		try {
//			System.out.println(num1 / 0);
//		}catch (ArithmeticException e){
//			System.out.println("�߸��� �����Դϴ�.");
//		}