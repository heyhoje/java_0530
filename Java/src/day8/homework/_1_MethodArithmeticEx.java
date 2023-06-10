package day8.homework;

import java.util.Scanner;

public class _1_MethodArithmeticEx {

	public static void main(String[] args) {
		/* 1. 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요 
		 * 단, 메소드 이용 
		 * 연산자를 잘못 입력한 경우는 없다고 가정 (예외 처리이후 추가)
		 * 0으로 나누는 일은 없다고 가정 (입력만 잘해주면됨 코드 추가할 필요x)
		 */	
		int num1, num2;
		char operator;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수와 산술 연산자를 입력하세요 : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		String getArithmetic = Arithmetic(num1, num2, operator);
		System.out.println(getArithmetic);
		
		sc.close();
	}

	/** 기능 : 두 정수와 산술연산자를 입력받아 산술 연산 결과를 알려주는 메소드
	 * 매개변수 : 두 정수, 산술연산자 => int num1, int num2, char operator
	 * 리턴타입 : 산술 연산 결과 ex) 1 + 2 = 3 => char?? 
	 * 										문자열???? 매개변수가 다 다른데 String으로 리턴받아???
	 * 메소드명 : Arithmetic
	 * @return 
	 */
	public static String Arithmetic(int num1, int num2, char operator) {
//		int sum = num1 + num2;
//		int sub = num1 - num2;
//		int mul = num1 * num2;
//		double div = (double)num1 / num2;
//		int mod = num1 % num2;
		
		if (operator == '+') {// ""문자열로 처리할 경우 .equals()를 써야하니까 ''문자처리하자
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
		return null; // 리턴타입을 void로 바꾸거나, 리턴문을 더하라는 경고문 떠서 쓰긴했는데, 
					 // 콘솔창에 그대로 출력됨. 이러면 안되잖아...? 		
											
	}
	
}
