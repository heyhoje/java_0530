package db.day2.board.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	private static Connection con = null; // db�� �����ؼ� ���Ῡ�θ� �˷��� 
		// �Ź� ��Ʈ�ѷ��� �������ֱ� ���ŷο�ϱ� �������ȭ!(�޼ҵ尡 �ƴ϶� Ŭ���� ������ ������)
	private static MemberController memberController; // ��ü ����. �����ڴ� ���߿�
	private static BoardController boardController;
	
		
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/test";
		String dbid = "root";
		String dbpw = "root";

		con = connect(url, dbid, dbpw);
		if (con != null) {
			System.out.println("[���� ����!]");			
		}else {
			System.out.println("[���� ����..]");
			return;
		}
		
		// ��¥ �������� �ϴ� ���̴�,, 
		Scanner sc = new Scanner(System.in);
		int menu;
		final int EXIT = 3;
		memberController = new MemberController(con, sc);
		boardController = new BoardController(con, sc);
		do {
			// �޴� ���
			printMenu();
			// �޴� ����
			menu = sc.nextInt();
			// �޴� ����
			runMenu(menu);
		}while(menu != EXIT);
		
		sc.close();
		close(con);
	}
	
	
	/** DB���� �޼ҵ� */
	private static Connection connect(String url, String id, String pw) {
		try {
			return DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			return null;
		}
	}
	
	/** �޴� ��� �޼ҵ� */
	private static void printMenu() {
		System.out.println("-----�޴�-----");
		System.out.println("1. ȸ�� �޴�");
		System.out.println("2. �Խ��� �޴�");
		System.out.println("3. ����"); // 
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
		case 3: 
			System.out.println("[���α׷��� �����մϴ�.]");
		default:
			System.out.println("[�߸��� �޴��Դϴ�.]");
		}
	}

	/** �ݾ��ִ� �޼ҵ� */
	private static void close(Connection con) {
		try {
			// ������ connection�� �ݾ��� / ������ �ȵǼ� null �� �� �ֱ� ����
			if(con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {}
	}
}
