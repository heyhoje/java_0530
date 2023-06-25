package day18.controller;

import java.util.Scanner;

public class ArithmeticEx implements Program {
	// 1. 산술연산을 하는 프로그램을 작성하세요(인터페이스 이용)
	
	private final static int EXIT = 3;
	private Scanner sc = new Scanner(System.in);
	
	// 두 정수와 산술 연산자, 연산 결과
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
		System.out.println("1. 두 정수 입력");
		System.out.println("2. 산술연산자 입력");
		System.out.println("3. 종료");
		System.out.print("메뉴를 선택하세요 : ");
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
			System.out.println("종료!");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
			
		}		
	}

	// 두 정수 입력
	private void InputNumber() {
		System.out.print("두 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
	}	
	
	// 산술 연산자 입력
	private void InputOperator() {
		System.out.print("산술 연산자를 입력하세요 : ");
		operator = sc.next().charAt(0);
		// 산술연산자가 아닌 경우
		if(!checkOperator(operator)) {
			System.out.println("잘못된 산술 연산자 입니다");
			return;
		}
		// 연산 후 결과 출력
		calculator();
	}
	
	// 연산자가 산술 연산자인지 아닌지 알려주는 메소드
	private boolean checkOperator(char operator) {
		switch(operator) {
		case '+', '-', '*', '/', '%':
			return true;
			}
			return false;
		}

		
	// 산술 연산을 하고, 결과를 출력하는 메소드
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
			System.out.println("잘못된 산술 연산자입니다. ");
			return;
		}
		System.out.println(num1 + " " + operator + " " + num2 + "=" + result);
	}
	
	
}

