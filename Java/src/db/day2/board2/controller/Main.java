package db.day2.board2.controller;

import java.util.Scanner;

public class Main {

	private static MemberController memberController;
	private static BoardController boardController;
	
		
	public static void main(String[] args) {
		
		// config ������ �˾Ƽ� �������� ����. url, id, pw �ʿ����
		
		Scanner sc = new Scanner(System.in);
		
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(sc); //
		boardController = new BoardController(sc); //
		
		do {
			// �޴� ���
			printMenu();
			// �޴� ����
			menu = sc.nextInt();
			// �޴� ����
			runMenu(menu);
		}while(menu != EXIT);
		
		sc.close();
	}
	
	/** �޴� ��� �޼ҵ� */
	private static void printMenu() {
		System.out.println("-----�޴�2-----");
		System.out.println("1. ȸ�� �޴�");
		System.out.println("2. �Խ��� �޴�");
		System.out.println("3. ����");
		System.out.println("------------");
		System.out.print("�޴� ���� : ");
	}
	
	/** �޴� ���� �޼ҵ� */
	private static void runMenu(int menu) {
			
		switch(menu) {
		case 1: // ȸ�� �޴�
			memberController.run();
			break;
		case 2: // �Խ��� �޴�
			boardController.run();
			break;
		case 3: // ���α׷� ���� ��� ��� ���´���.... 
			System.out.println("[���α׷��� �����մϴ�.]"); 
		default:
			System.out.println("[�߸��� �޴��Դϴ�.]");
		}
	}

	/** DB���� �޼ҵ� connect */
	
	/** �ݾ��ִ� �޼ҵ� close */
	
}
