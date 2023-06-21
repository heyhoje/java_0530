package day6._042_DoWhileEx;

import java.util.Scanner;

public class _1_PringMenu2 {

	public static void main(String[] args) {
		/* 1. 다음과 같은 메뉴를 출력하고 프로그램 종료를 선택하기 전까지 반복적으로 실행되는 코드를 작성하세요.
		 * Menu 
		 * 1. Start 
		 * 2. Save 
		 * 3. Exit
		 * Select Menu :
		 */
		
		int menu; // 실행값을 출력하고 조건을 확인 하기 때문에 menu초기값 중요하지 않음. 초기화 안함
		Scanner sc = new Scanner(System.in);// 메뉴 입력 받기위한 Scanner
		
		// 입력받은 메뉴가 3이 아니면 반복
		do {
			// 메뉴출력 및 선택
			System.out.println("Menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("Select Menu : ");
			menu = sc.nextInt(); // menu값을 새로 받음
			
			// 선택한 메뉴에 따른 출력문 실행
			switch (menu) {
			case 1: 
				System.out.println("Program Start!");
				break;
			case 2:
				System.out.println("Program Save!");
				break;
			case 3:
				System.out.println("Program Exit!");
				break;
			}
			
		}while(menu != 3);
		
		sc.close();
	}

}
