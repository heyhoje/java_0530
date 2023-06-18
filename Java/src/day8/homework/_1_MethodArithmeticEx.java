package day8.homework;

import java.util.Scanner;

public class _1_MethodArithmeticEx {

	public static void main(String[] args) {
		/* 1. 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요 
		 * 단, 메소드 이용 
		 * 연산자를 잘못 입력한 경우는 없다고 가정 (예외 처리이후 추가)
		 * 0으로 나누는 일은 없다고 가정 (입력만 잘해주면됨 코드 추가할 필요x)
		 */	
		
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char operator;
		double result;
		
		System.out.println("두 정수와 산술연산자를 입력하세요 : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0); // 문자
		num2 = sc.nextInt();
		
		result = arithmetic(num1, operator, num2);
		
		System.out.println(num1 + "" + operator + "" + num2 + " = " + result );
		
		sc.close();
	}

	/** 기능 : 두 정수와 산술연산자를 입력받아 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수, 산술연산자 => int num1, int num2, char operator
	 * 리턴타입 : 산술 연산 결과 ex) 1 + 2 = 3 => 
	 * 메소드명 : Arithmetic
	 * @return 
	 */
	
	// switch / break;  필요한 경우
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
	
	// switch, return 반환 하는 경우
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
