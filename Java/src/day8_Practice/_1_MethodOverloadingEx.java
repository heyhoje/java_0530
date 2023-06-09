package day8_Practice;

import java.util.Scanner;

public class _1_MethodOverloadingEx {

	public static void main(String[] args) {
			// 1. 정수 num을 입력받아 짝수인지 아닌지 판별하는 코드를 작성하세요.
			// 단, 메소드를 이용할 것
			
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		num = sc.nextInt();
//		int result = EvenNumher(num);
//		
//		if(result == 0) {
//			System.out.println("짝수");
//			}else {
//				System.out.println("홀수");
//			}
		
		// 1
		printEvenNumber(num);
		
		// 2
		if(mod(num, 2) == 0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		
		// 3
		if(isEvenNumber(num)) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		
		// 4
		
		sc.close();
		}
	
		

//		public static int EvenNumher (int num) {
//			int result = num % 2;
//			if (result == 0) {
//				System.out.println("짝수");
//			}else {
//				System.out.println("홀수");
//			}
//			System.out.println();
			
		
		
		/** 1. num가 주어지면 num가 짝수인지 홀수인지 출력하는 메소드 
		 * @param num : 판별할 정수
		 * @return : 없음 => void
		 * 메소드명 : printEvenNumber
		 */
		
		// public static 리턴타입 메소드명 (매개변수) { }
		
		// 메소드 내에서 출력하는 경우
		public static void printEvenNumber(int num) {
			if(num % 2 == 0) {
				System.out.println("짝수");
				}else {
					System.out.println("홀수");
				}
		}
		
		/** 2. num1과 num2가 주어지면 num1을 num2로 나누었을 때 나머지를 알려주는 메소드
		 * 매개변수 : 두 정수 => int num1, int num2
		 * 리턴타입 : 나누었을때 나머지 => 정수 => int
		 * 메소드명 : mod
		 */
		
		public static int mod(int num1, int num2) {
			return num1 % num2;
		}
		
		/** 3. num가 주어지면 num가 짝수인지 홀수인지 알려주는 메소드
		 * 매개변수 : 판별할 정수 => int num
		 * 리턴타입 : 짝수인지(참) 홀수인지(거짓) => boolean 
		 * 메소드명 : isEvenNumber
		 */
		
		public static boolean isEvenNumber(int num) {
			return num % 2 == 0;
		}
		
		/** 4. num1과 num2가 주어지면 num1이 num2의 배수인지 아닌지 알려주는 메소드
		 * 매개변수 : 두 정수 => int num1, int num2
		 * 리턴타입 : 배수인지(참) 아닌지(거짓) => boolean
		 * 메소드명 : isMultiple
		 */
			
		public static boolean isMultiple(int num1, int num2) {
			return num1 % num2 == 0;
				}
}
		

