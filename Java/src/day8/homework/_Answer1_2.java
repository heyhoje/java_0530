package day8.homework;

import java.util.Scanner;

public class _Answer1_2 {

	public static void main(String[] args) {
		/* 1. 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요 
		 * 단, 메소드 이용 
		 * 연산자를 잘못 입력한 경우는 없다고 가정 (예외 처리는 이후 추가)
		 * 0으로 나누는 일은 없다고 가정 (입력만 잘해주면됨 코드 추가할 필요x)
		 */	
		int num1, num2;
		char operator;
		double result; // *
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수와 산술 연산자를 입력하세요 : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		
		result = Arithmetic2(num1, operator, num2); // *
		System.out.println(num1 + " " + operator + " " + num2 + " = " + result);
		
		//Arithmetic(num1, operator, num2);

		sc.close();
	}

	/** 기  능 : 두 정수와 산술연산자를 입력받아 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수, 산술연산자 => int num1, int num2, char operator
	 * 리턴타입 : 산술 연산 결과 => 실수 => double 로 받아야함(div가 double이기 때문)
	 * 메소드명 : Arithmetic
	 * @return 
	 */
	public static double Arithmetic2(int num1, char operator ,int num2) {// *
		double result = 0.0; // *
		switch (operator) {
		case '+': // ""문자열로 처리할 경우 .equals()를 써야하니까 ''문자처리하자
			return num1 + num2; 
			// break; // 위에 return이 있기 때문에 break가 실행될 일이 절대 없음 => 에러 발생
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return (double)num1 / num2;
		 // 나누기를 (double)(num1/num2) 이렇게 하지 말고 >> (double)num1/num2 이렇게 하니까 됨
		case '%':
			return num1 % num2;
			
		default: // 잘못된 연산자인 경우 예외처리를 해야 하는데 아직 안배워서 주석처리
			//throw new RuntimeException("Wrong operator!");
			return 0.0; // * // return 이 없다면 오류 발생
		}
		// return 0.0; 바깥에 넣어도 됨
	}
	
}
