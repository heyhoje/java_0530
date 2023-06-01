package day2_04_Homework;

import java.util.Scanner;

public class Ex2 {
	public static void main (String[] args ) {
		/*1. 콘솔에서 정수 2개와 문자(산술연산자)를 입력받아 출력하는 코드를 작성하세요. 
		 * ex) // 정수형 변수, 
		 * 두 정수와 산술연산자를 입력하세요 (예시: 1 + 2) :
		 * [입력] 1 + 2 [엔터]
		 * [출력] 1 + 2 
		 ​*/
		int num1, num2;
		char operator; /// 얘가 왜필요해...??????
		Scanner scan = new Scanner(System.in); // scan = 참조변수
		
		System.out.println("두 정수와 산술연산자를 입력하세요 (예시: 1 + 2) :");
		num1 = scan.nextInt(); // 정수입력받는 예제
		operator = scan.next().charAt(0);// 문자입력받는 예제 / 가져올 것 중 공백제외 첫번째글자
		num2 = scan.nextInt();
		System.out.println("" + num1 + operator + num2);
		System.out.println("" + num1 + " " + operator + " " +num2);
		// 테스트할때는 '1 + 2' 띄어서 입력해야함. '1+2'로 붙여서 입력하면 하나의 문자로 인식한다. 
		
		
		scan.close();
	}

}
