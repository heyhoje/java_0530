package day4_practice;

import java.util.Scanner;

public class _4_IfMultipleEx1 {

	public static void main(String[] args) {
		// 정수 num을 입력받아 num가 2의 배수인지 아닌지 판별하는 코드를 작성하세요.
		// 2의 배수 확인 예제(홀짝과 동일)
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input integer number : ");
		num = sc.nextInt();
		
		if (num % 2 == 0) {
			System.out.println(num + "은 2의 배수이다.");
		}else {
			System.out.println(num + "은 2의 배수가 아니다.");
		}
	
		sc.close();
	}

}
