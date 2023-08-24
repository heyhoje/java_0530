package db.day3.board.controller;

import java.util.List;
import java.util.Scanner;

import db.day3.board.service.BoardServiceImp;
import db.day3.board.service.BoardService;
import db.day3.board.vo.BoardVO;

public class BoardController {

	private BoardService boardService = new BoardServiceImp();
	
	public void run() {
		int menu;
		final int EXIT = 5;
		Scanner sc = new Scanner(System.in);
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1: // �Խñ� ���
			insertBoard();
			break;
		case 2: // �Խñ� ����
			updateBoard();
			break;
		case 3: // �Խñ� ����
			deleteBoard();
			break;
		case 4: // �Խñ� ��ȸ
			selectAllBoard();
			break;
		case 5:
			System.out.println("[�ڷΰ���]");
			break;
		default:
			System.out.println("[�߸��� �޴� �Է�]");
		}
	}

	private void insertBoard() {
		// �Խñ� ����� ���� �Խñ� ������ �Է�(title, id)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� : ");
		String title = sc.nextLine();
		System.out.println("���̵� : ");
		String id = sc.next();
		
		BoardVO board = new BoardVO(title, id);
		if(boardService.insertBoard(board)) {
			System.out.println("[�Խñ� ��� ����]");
		}else {
			
		}
		
	}

	private void updateBoard() {
		// ������ �Խñ� ���� (�Խñ� ��ȣ, ����) �Է�
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Խñ� ��ȣ : ");
		int num = sc.nextInt();
		System.out.println("������ �Խñ� ���� : ");
		sc.nextLine();
		String title = sc.nextLine(); 
		
		BoardVO board = new BoardVO(num, title, null);
		if(boardService.updateBoard(board)) {
			System.out.println("[�Խñ� ���� ����]");
		}else {
			System.out.println("[�Խñ� ���� ����]");
		}
	}

	private void deleteBoard() {
		// ������ �Խñ� ����(�Խñ� ��ȣ, �ۼ���) �Է�
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Խñ� ��ȣ : ");
		int num = sc.nextInt();
		System.out.println("�ۼ��� ���̵� : ");
		String id = sc.next(); 
		
		BoardVO board = new BoardVO(num, null, id);
		if(boardService.deleteBoard(board)) {
			System.out.println("[�Խñ� ���� ����]");
		}else {
			System.out.println("[�Խñ� ���� ����]");
		}
	}

	private void selectAllBoard() {
		// ��ü �Խñ��� ��ȣ/����/�ۼ��� ���̵� ������ ���
		List<BoardVO> boardList = boardService.getBoardList();
		for(BoardVO tmp : boardList) {
			System.out.println(tmp);
		}
	}

	private void printMenu() {
		System.out.println("======�Խ��Ǹ޴�======");
		System.out.println("1. �Խñ� ���");
		System.out.println("2. �Խñ� ����");
		System.out.println("3. �Խñ� ����");
		System.out.println("4. �Խñ� ��ȸ");
		System.out.println("5. �ڷΰ���");
		System.out.println("=================");
		System.out.print("�޴� ���� : ");		
	}
	
}
