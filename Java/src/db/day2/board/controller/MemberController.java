package db.day2.board.controller;

import java.sql.Connection;
import java.util.Scanner;

import db.day2.board.service.MemberService;
import db.day2.board.service.MemberServiceImp;

public class MemberController {

	private Connection con;
	private Scanner sc;
	private MemberService memberService; // 다른 클래스에 있기 때문에 import
										 // 컨트롤러는 서비스/서비스임프 한테 일시키니까 서비스를 멤버?변수화 한건가???
	
	public MemberController(Connection con, Scanner sc) {
		this.con = con;
		this.sc = sc;
		memberService = new MemberServiceImp(con); // 
		
	}
	
	public void run() {
		int menu;
		final int EXIT = 3;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
			signup();
			break;
		case 2:
			withdraw();
			break;
		case 3: 
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
	}

	private void printMenu() {
		System.out.println("-----회원메뉴-----");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 뒤로가기");
		System.out.println("--------------");
		System.out.print("메뉴 선택 : ");
	}

	// ---------------------------------------------
	/** 회원 가입 메소드 */
	private void signup() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		
		if(memberService.signup(id, pw)) {
			System.out.println("[회원가입 성공!]");
		}else {
			System.out.println("[회원가입 실패..");
		}
	}
	
	private void withdraw() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		
		if(memberService.withdraw(id, pw)) {
			System.out.println("[회원탈퇴 성공!]");
		}else {
			System.out.println("[회원탈퇴 실패..]");
		};
	}
}
