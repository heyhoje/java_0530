package day8.Practice;

import java.util.Scanner;

public class _2_MethodMultipleEx {

	public static void main(String[] args) {
		// 2. 정수 num을 입력받아 2,3,6의 배수인지 아닌지 판별하는 코드를 작성하세요
		// 단, 메소드를 이용할 것
		
		// System.out.println(MethodEvenNumberEx.isMultiple(4,2));
		
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		num = sc.nextInt();
		
		if(isMultiple(num, 6)) {
			System.out.println(num + "은 6의 배수");
		}else if(isMultiple(num, 2)) {
			System.out.println(num + "은 2의 배수");
		}else if(isMultiple(num, 3)) {
			System.out.println(num + "은 3의 배수");
		}else {
			System.out.println("2,3,6 의 배수가 아닙니다.");
		}
		
		sc.close();
	}
	
	/** 
	 * 매개변수 : 정수 num => int num
	 * 리턴타입 : 배수인지 아닌지 => boolean
	 * 메소드명 : isMultiple
	 */
	
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	// 틀린 추측....ㅠㅠ 메소드 밑에 다 쓰고 있었는데 참거짓 할게 없었다리
//	public static int multiple (int num) {
//		if(num % 6 == 0) {
//			System.out.println("6의 배수");
//		}else if(num % 2 == 0) {
//			System.out.println("2의 배수");
//		}else if(num % 3 == 0) {
//			System.out.println("3의 배수");
//		}
		
}


