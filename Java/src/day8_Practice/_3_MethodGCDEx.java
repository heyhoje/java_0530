package day8_Practice;

import java.util.Scanner;

public class _3_MethodGCDEx {

	public static void main(String[] args) {
		// 정수 num1과 num2를 입력받아 두 정수의 최대 공약수를 구하는 코드를 작성하세요
		// 단, 메소드를 이용할 것
		
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("두 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int GCD = GCD(num1, num2);
		
		System.out.println(num1 + "과 " + num2 + "의 GCD(최대공약수) : " + GCD);
		
		sc.close();
	}
	
	/**배수 판별하는 메소드
	 * 매개변수 : 두 정수 => num1, num2
	 * 리턴타입 : 배수인지 아닌지 => boolean
	 * 메소드명 : isMultiple
	 */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	/** 두 정수가 주어지면 두 정수의 최대 공약수를 알려주는 메소드
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 최대공약수 => 정수 => int
	 * 매소드명 : GCD
	 */
	
	public static int GCD(int num1, int num2) {
		for(int i = num1; i >= 1; i--) {
			// i가 num1의 약수이다 == num1은 i의 배수이다!!
			if(isMultiple(num1, i) && isMultiple(num2, i)) {
				//num1의 약수 && num2의 약수 ==> 최대 공약수
				return i;
			}
		}
		return 1; // num1이 잘못되더라도 1을 출력하고 빠져나올 수 있도록???
	}
}
