package day7._05_Method;

public class _1_SumMethodEx {

	public static void main(String[] args) {
		/* 1. 두 정수의 합을 구하는 함수(메소드)를 만드세요
		 */
		int num1 = 1, num2 = 2;
		int result = sum(1, 2);
		System.out.println(result);
		
		/** 
		 * 기능	: 두 정수가 주어지면, 두 정수의 합을 알려주는 메소드
		 * 메소드명 : sum   / 영어단어 검색해서
		 * 리턴타입 : 두 정수의 합 => int
		 * 매개변수 : 두 정수 => int num1, int num2
		 * @return
		 */
		/**
		 * 기능	: 두 정수가 주어지면 두 정수의 합을 알려주는 메소드
		 * @param num1 정수1
		 * @param num2 정수2
		 */
		// public static 리턴타입 매소드명(매개변수들) {
		// 	return xx;
		// }
		
	}

	public static int sum(int num1, int num2) {
		int result = num1 + num2;
		return result; // int의 기본값 = 0 -> 변수 또는 값을 통해 알려줘야함
		// return num1 + num2;  // 일반적으로는 주석처리된 해당 리턴을 많이 씀
	}

}
