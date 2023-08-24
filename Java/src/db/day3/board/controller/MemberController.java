package db.day3.board.controller;

import java.util.Scanner;

import db.day3.board.service.MemberService;
import db.day3.board.service.MemberServiceImp;
import db.day3.board.vo.MemberVO;


public class MemberController {

	private MemberService memberService = new MemberServiceImp();

	public void run() {
		int menu;
		final int EXIT = 3;
		Scanner sc = new Scanner(System.in);
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
			System.out.println("[�ڷΰ���]");
			break;
		default:
			System.out.println("[�߸��� �޴� �Է�]");
		}

	}

	private void withdraw() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���̵� : ");
		String id = sc.next();
		System.out.println("��� : ");
		String pw = sc.next();
		
		// MemberVO member = 

	}

	private void signup() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���̵� 		: ");
		String id = sc.next();
		System.out.print("���    	: ");
		String pw = sc.next();
		System.out.print("���Ȯ�� 	: ");
		String pw2 = sc.next();
		//����� ���Ȯ���� ��ġ���� ������ ����
		if(!pw.equals(pw2)) {
			System.out.println("[��� ����ġ]");
			return;
		}
		MemberVO member = new MemberVO(id,pw);
		if(memberService.signup(member)) {
			System.out.println("[ȸ�� ���� ����]");
		}else {
			System.out.println("[ȸ�� ���� ����]");
		}

	}

	private void printMenu() {
		System.out.println("======ȸ���޴�======");
		System.out.println("1. ȸ������");
		System.out.println("2. ȸ��Ż��");
		System.out.println("3. �ڷΰ���");
		System.out.println("=================");
		System.out.print("�޴� ���� : ");
	}


}