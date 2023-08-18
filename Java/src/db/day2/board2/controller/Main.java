package db.day2.board2.controller;

import java.util.Scanner;

public class Main {

	private static MemberController memberController;
	private static BoardController boardController;
	
		
	public static void main(String[] args) {
		
		// config 파일이 알아서 연결해줄 것임. url, id, pw 필요없음
		
		Scanner sc = new Scanner(System.in);
		
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(sc); //
		boardController = new BoardController(sc); //
		
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = sc.nextInt();
			// 메뉴 실행
			runMenu(menu);
		}while(menu != EXIT);
		
		sc.close();
	}
	
	/** 메뉴 출력 메소드 */
	private static void printMenu() {
		System.out.println("-----메뉴2-----");
		System.out.println("1. 회원 메뉴");
		System.out.println("2. 게시판 메뉴");
		System.out.println("3. 종료");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
	}
	
	/** 메뉴 실행 메소드 */
	private static void runMenu(int menu) {
			
		switch(menu) {
		case 1: // 회원 메뉴
			memberController.run();
			break;
		case 2: // 게시판 메뉴
			boardController.run();
			break;
		case 3: // 프로그램 종료 기능 어떻게 끝냈더라.... 
			System.out.println("[프로그램을 종료합니다.]"); 
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
	}

	/** DB연결 메소드 connect */
	
	/** 닫아주는 메소드 close */
	
}
