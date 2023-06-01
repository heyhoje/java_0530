package day2_03_Homework;

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
		// '정수-문자-정수' 입력하는 순서도 중요! '정수-정수-문자'로 출력하고 싶다면 그 순서로 입력해야한다.
		System.out.println("" + num1 + operator + num2);
		System.out.println("" + num1 + " " + operator + " " +num2);
		// 테스트할때는 '1 + 2' 띄어서 입력해야함. '1+2'로 붙여서 입력하면 하나의 문자로 인식한다. 
		
		/* 2. 두 정수를 입력받아 두 정수의 산술 연산 결과를 출력하는 코드를 작성하세요.
		(단, 두번째 숫자는 0이 아니어야 한다.)
		​
		ex)
		두 정수를 입력하세요.
		1 2 [엔터]
		1 + 2 = 3
		1 - 2 = -1
		1 * 2 = 2
		1 / 2 = 0.5
		1 % 2 = 1
		*/
		
		System.out.println("두 정수를 입력하세요.");// 안내 문구 출력
		Scanner sc = new Scanner(System.in);
		// 콘솔에서 입력받을 수 있는 스캐너 생성
		// 두 정수를 입력받음
		int num3 = sc.nextInt();// 변수선언. 변수 선언과 동시에 초기화.???????
		int num4 = sc.nextInt();
		// 두 변수의 산술 연산을 계산
		int sum = num3 + num4;
		int sub = num3 = num4;
		int mul = num3 * num4;
		double div = num3 / (double)num4; // 나누기는 더블!!!!!!! 오른쪽 변수에도 더블!! 하나는 실수로 만들어야함.
		int mod = num3 % num4;
		//결과를 콘솔에 출력
		System.out.println("" + num3 + " + " + num4 + " = " + sum);
		System.out.println("" + num3 + " - " + num4 + " = " + sub);
		System.out.println("" + num3 + " * " + num4 + " = " + mul);
		System.out.println("" + num3 + " / " + num4 + " = " + div);
		System.out.println("" + num3 + " % " + num4 + " = " + mod);
		
		scan.close();
	}

}
