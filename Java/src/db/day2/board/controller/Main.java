package db.day2.board.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static Connection con = null; // db와 연결해서 연결여부를 알려줌 
		// 매번 컨트롤러에 연결해주기 번거로우니까 멤버변수화!(메소드가 아니라 클래스 밑으로 가야함)
	private static MemberController memberController; // 객체 생성. 생성자는 나중에
	private static BoardController boardController;
	
		
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String dbid = "root";
		String dbpw = "root";

		con = connect(url, dbid, dbpw);
		if (con != null) {
			System.out.println("[연결 성공!]");			
		}else {
			System.out.println("[연결 실패..]");
			return;
		}
		
		// 진짜 오랜만에 하는 폼이다,, 
		Scanner sc = new Scanner(System.in);
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(con, sc);
		boardController = new BoardController(con, sc);
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = sc.nextInt();
			// 메뉴 실행
			runMenu(menu);
		}while(menu != EXIT);
		
		sc.close();
		close(con);
	}
	
	
	/** DB연결 메소드 */
	private static Connection connect(String url, String id, String pw) {
		try {
			return DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			return null;
		}
	}
	
	/** 메뉴 출력 메소드 */
	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 회원 메뉴");
		System.out.println("2. 게시판 메뉴");
		System.out.println("3. 종료"); // 
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
		case 3: 
			System.out.println("[프로그램을 종료합니다.]");
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
	}

	/** 닫아주는 메소드 */
	private static void close(Connection con) {
		try {
			// 연결한 connection을 닫아줌 / 연결이 안되서 null 일 수 있기 때문
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {}
	}
}
