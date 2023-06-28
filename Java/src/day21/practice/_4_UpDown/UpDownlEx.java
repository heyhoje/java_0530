package day21.practice._4_UpDown;

import day21.practice.UpDown.controller.GameManager;

public class UpDownlEx {

	public static void main(String[] args) {
		// UpDown 프로그램을 작성하고, 기록(몇번만에 맞췄는가)도 관리하는 기능을 추가하세요
		/*
		 * 1. play
		 * 2. record
		 * 3. exit
		 * select : 1
		 * ...
		 * record id : */
		
		GameManager gm = new GameManager();//import를 안해서 에러 뜬거였다 찾음..ㅠㅠ!!!
		gm.run();
	}
}
		
//		int min = 1, max = 100;
//		int menu;
//		Scanner sc = new Scanner(System.in);
//		
//		do {
//			printMenu();
//			
//			selectMenu();
//			menu = sc.nextInt();
//			
//			runMenu();
//			
//		}while(menu != 3);
//	}
//			
//	
//	private static void printMenu() {
//		System.out.println("메뉴를 입력하세요 : ");
//		System.out.println("1. play");
//		System.out.println("2. record");
//		System.out.println("3. exit");
//	}
//	
//	private static void runMenu(int menu) {
//		switch(menu) {
//		case 1: // play
//			break;
//		case 2: // record
//			break;
//		case 3:
//			System.out.println("EXIT");
//			break;
//		default:
//			System.out.println("잘못된 메뉴입니다.");
//		}
