package day19.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _1_ArithmeticEx {

	public static void main(String[] args) {
		// 1. 두 정수와 산술연산자를 입력했을 때 연산 결과를 출력하는 코드를 작성하세요.
		// (예외처리도 추가)
		/* input : 1 + 2
		 * 1 + 2 = 3
		 * input : 1 ? 2
		 * Not operator!
		 * input : 1 / 0
		 * Not operator!
		 * */
		
		// 1. 두 정수와 산술연산자 입력
		try {
		int num1, num2;
		char operator;
		double res;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수와 연산자를 입력하세요");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		// 2. 연산자에 따른 결과를 출력
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
				System.out.println("잘못된 연산입니다.");
			}
		
		sc.close();
		}catch(InputMismatchException e) {
			System.out.println("Wrong Input!");
		}catch(ArithmeticException e) {
			System.out.println("Not Operation");
		}catch(Exception e) { // 꼭 추가해서 내가 잡지못한 예외도 걸러질 수 있도록! 적기
			System.out.println("Exception");
		}
		
	}

}


//		try {
//			System.out.println(num1 / 0);
//		}catch (ArithmeticException e){
//			System.out.println("잘못된 연산입니다.");
//		}