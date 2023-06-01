package day2_04_Homework;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
				//1. 콘솔에서 정수 2개와 문자(산술연산자)를 입력받아 출력하는 코드를 작성하세요
				//ex) 정수와 산술연산자를 입력하세요. (예시 : 1+2)
				Scanner scan = new Scanner(System.in);

				System.out.println("두 정수와 산술연산자를 입력하세요");
				int num1 = scan.nextInt();
				int num2 = scan.nextInt();
				System.out.println("" + num1 + '+' + num2);
				
				//2. 두 정수를 입력받아 두 정수의 산술 연산 결과를 출력하는 코드를 작성하세요.
				//(단 두번째 숫자는 0이 아니어야 한다)
				//ex) 두 정수를 입력하세요.
				System.out.println("두 정수의 산술 연산 결과를 출력하세요.");
				int num3 = scan.nextInt();
				int num4 = scan.nextInt();

				int sum = num3 + num4;
				int sub = num3 = num4;
				int mul = num3 * num4;
				int div = num3 / num4;
				int mod = num3 % num4;
				System.out.println("" + num3 + '+' + num4 + '=' + sum);
				System.out.println("" + num3 + '-' + num4 + '=' + sub);
				System.out.println("" + num3 + '*' + num4 + '=' + mul);
				System.out.println("" + num3 + '/' + num4 + '=' + div);
				System.out.println("" + num3 + '%' + num4 + '=' + mod);
			}
		}
