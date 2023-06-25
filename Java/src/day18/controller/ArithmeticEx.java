package day18.controller;

import java.util.Scanner;

public class ArithmeticEx implements Program {
	// 1. ��������� �ϴ� ���α׷��� �ۼ��ϼ���(�������̽� �̿�)
	
	private final static int EXIT = 3;
	private Scanner sc = new Scanner(System.in);
	
	// �� ������ ��� ������, ���� ���
	int num1, num2;
	char operator;
	double result;
	
	@Override
	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			System.out.println("----------");
			runMenu(menu);
		} while (menu != EXIT);
	}

	@Override
	public void printMenu() {
		System.out.println("----------");
		System.out.println("1. �� ���� �Է�");
		System.out.println("2. ��������� �Է�");
		System.out.println("3. ����");
		System.out.print("�޴��� �����ϼ��� : ");
	}

	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case 1: 
			InputNumber();
			break;
		case 2: 
			InputOperator();
			break;
		case 3:
			System.out.println("����!");
			break;
		default:
			System.out.println("�߸��� �޴��Դϴ�.");
			
		}		
	}

	// �� ���� �Է�
	private void InputNumber() {
		System.out.print("�� ������ �Է��ϼ��� : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
	}	
	
	// ��� ������ �Է�
	private void InputOperator() {
		System.out.print("��� �����ڸ� �Է��ϼ��� : ");
		operator = sc.next().charAt(0);
		// ��������ڰ� �ƴ� ���
		if(!checkOperator(operator)) {
			System.out.println("�߸��� ��� ������ �Դϴ�");
			return;
		}
		// ���� �� ��� ���
		calculator();
	}
	
	// �����ڰ� ��� ���������� �ƴ��� �˷��ִ� �޼ҵ�
	private boolean checkOperator(char operator) {
		switch(operator) {
		case '+', '-', '*', '/', '%':
			return true;
			}
			return false;
		}

		
	// ��� ������ �ϰ�, ����� ����ϴ� �޼ҵ�
	private void calculator() {
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
			result = (double) num1 / num2; 
			break;
		case '%':
			result = num1 % num2; 
			break;
		default:
			System.out.println("�߸��� ��� �������Դϴ�. ");
			return;
		}
		System.out.println(num1 + " " + operator + " " + num2 + "=" + result);
	}
	
	
}

