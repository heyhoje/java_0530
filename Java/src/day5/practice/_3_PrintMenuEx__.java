package day5.practice;

import java.util.Scanner;

public class _3_PrintMenuEx__ {

	public static void main(String[] args) {
		// 3. 다음과 같은 메뉴를 출력하고 프로그램 종료를 선택하기 전까지 반복적으로 실행되는 코드를 작성하세요.
		// Menu 1. Start 2. Save 3. Exit
		// Select Menu : 1 [입력]
		// Program Start!
		
		// 반복횟수 : menu가 3이 아닐때까지     //i는 1부터 1씩 증가
		/* 규칙성 : 
		 *  - Menu 출력
		 *  - 메뉴를 입력
		 *  - 입력받은 메뉴에 따라 콘솔에 출력
		 *  	- 입력받은 메뉴가 1이면 Program Start!
		 *  	- 입력받은 메뉴가 2이면 Program Save!
		 *  	- 입력받은 메뉴가 3이면 Program Exit!
		 */

		int menu = 0; // 3이 아닌 값으로 초기화!
		Scanner sc = new Scanner(System.in);
		
		while(menu != 3) {
			// 메뉴를 출력
			System.out.println("Menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("Select Menu : ");
			// 메뉴를 입력
			menu = sc.nextInt();
			
			//입력받은 메뉴에 따라 콘솔에 출력
			switch (menu) {
			case 1:
				System.out.println("Program Start!");
				break;
			case 2:
				System.out.println("Program Save!");
				break;
			case 3:
				System.out.println("Program Exit");
				break;
				//변수의 사용이 제한적인 경우, switch 사용할 수 있다!!
			}
		}
		
		sc.close();
//		int i;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("시작");
//		i = sc.nextInt();
//				
//		i = 1;
//		while(i <= 3) {
//			System.out.println("Menu");
//			System.out.println("1. Start");
//			System.out.println("2. Save");
//			System.out.println("3. Exit");
//			
//			
//			if (i == 1) {
//				System.out.println("Program Start!");			
//			}else if (i == 2) {
//				System.out.println("Program Save!");
//			}else {
//				System.out.println("Program Exit");
			
	}
}
	


