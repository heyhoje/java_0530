package day4.practice;

import java.util.Scanner;

public class _3_IfArithmeticEx {

	public static void main(String[] args) {
		// 산술 연산자와 두 정수를 입력받아 산술연산자(v조건문 + -> =)에 맞는 연산 결과를 출력하는 코드를 작성하세요
		// 예 : input 2 nums and arithmetic operator : 
		// 1 + 2 [엔터]
		// 1 + 2 = 3
		// input 2 nums and arithmetic operator
		// 1 ? 2 [엔터]
		// ? is not arithmetic operator!
		
		//산술연산자 : op, 두 정수 : num1, num2
		int num1, num2;
		char operator;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("산술 연산자와 두 정수를 입력하세요.");// input 2 nums and arithmetic operator (ex : 1 2 +)
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		operator = sc.next().charAt(0);// num1, num2, operator 선언한 순서대로, 띄어쓰기하며 입력.
		
		
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)num1 / num2;
		int mod = num1 % num2;
		
		
		if (operator == '+') {// ""문자열로 처리할 경우 .equals()를 써야하니까 ''문자처리하자
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
