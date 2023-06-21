package day4.practice;

import java.util.Scanner;

public class _5_IfMultipleEx2 {

	public static void main(String[] args) {
		// 정수 num를 입력받아 num가 2의 배수이면 2의 배수라고 출력하고, 
		// 3의 배수이면 3의 배수라고 출력하고, 6의 배수이면 6의 배수라고 출력하고, 
		// 2, 3, 6의 배수가 아니라면 2, 3, 6의 배수가 아니라고 출력하는 코드를 작성하세요
		// 예 : 6은 6의 배수 (하나만 출력되도록 해야함)
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input integer number : ");
		num = sc.nextInt();
		
		//6의 배수일 때 원하는 동작이 실행되기 위해 6의 배수먼저 체크하도록 순서를 신경씀
		if (num % 6 == 0) {// 6을 먼저!! 
			System.out.println(num + "은 6의 배수");
		} else if (num % 2 == 0 && num % 6 != 0) {
			System.out.println(num + "은 2의 배수");
		} else if (num % 3 == 0 && num % 6 != 0) {
			System.out.println(num + "은 3의 배수");
		} else {
			System.out.println(num + "은 2, 3, 6의 배수가 아니다."); //  else 왜 갑자기 빨간줄 처리되냐;;;;;;);
		}
		
		System.out.println("--------------------------------");
		// 6의 배수가 아닌 2의 배수만 찾기 위해 2의 배수이지만 3의 배수가 아닌 정수를 확인 - && num % 3 != 0
		if (num % 2 == 0 && num % 6 != 0) {
			System.out.println(num + "은 2의 배수");
		//6의 배수가 아닌 3의 배수만 찾기 위해 2의 배수이지만 3의 배수가 아닌 정수를 확인 - && num % 2 != 0
		} else if (num % 3 == 0 && num % 6 != 0) {
			System.out.println(num + "은 3의 배수");
		} else if (num % 6 == 0) {
			System.out.println(num + "은 6의 배수"); // 6의 배수를 먼저해도 됨;;;; 헐 생각도 못함..... 
													// 순서를 바꿔서 할때 출력이 달라질 수 있음
		}else {
			System.out.println(num + "은 2, 3, 6의 배수가 아니다."); //  else 왜 갑자기 빨간줄 처리되냐;;;;;; = 위에 괄호 하나 안닫아서..!
		}
		
	
	}
}

