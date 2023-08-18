package db.day2.board2.controller;

import java.util.ArrayList;
import java.util.Scanner;

import db.day2.board2.service.BoardService;
import db.day2.board2.service.BoardServiceImp;
import db.day2.board2.vo.BoardVO;

public class BoardController {

	private Scanner sc;
	private BoardService boardService;

	public BoardController(Scanner sc) {
		this.sc = sc;
		boardService = new BoardServiceImp();
	}

	public void run() {
			// �Խñ� ���, ����, ����, �Խñ� ����Ʈ ��ȸ
		// �ָ�����!!!!!!!!!!!!!!!!!!!!!!!!!
		int menu;
		final int EXIT = 5;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
	}
	
	private void printMenu() {
		System.out.println("-----�Խ��Ǹ޴�-----");
		System.out.println("1. �Խñ� ���");
		System.out.println("2. �Խñ� ����");
		System.out.println("3. �Խñ� ����");
		System.out.println("4. �Խñ� Ȯ��");
		System.out.println("5. �ڷΰ���");
		System.out.println("---------------");
		System.out.print("�޴� ���� : ");
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1: // �Խñ� ���
			insertBoard();
			break;
		case 2: // �Խñ� ����
			
			break;
		case 3: // �Խñ� ����
			break;
		case 4: // �Խñ� ����Ʈ Ȯ��
			printBoardList();
			break;
		case 5: // �ڷΰ���
			break;
		default:
			System.out.println("[�߸��� �޴��Դϴ�.]");
		}
	}
	
	/** �Խñ� ����Ʈ Ȯ�� �޼ҵ� */
	private void printBoardList() {
		ArrayList<BoardVO> list = boardService.getBoardList();
		for(BoardVO tmp : list) {
			System.out.println(tmp);
		}
	}

	/** �Խñ� ��� �޼ҵ� */
	private void insertBoard() {
		// ����, �ۼ��� id
		System.out.print("���� : ");
		sc.nextLine();
		String title = sc.nextLine();
		System.out.println("ID : ");
		String id = sc.next();
		
		if(boardService.insertBoard(title, id)) {
			// �ִ� ���̵��� ���
			System.out.println("[�Խñ� �ۼ� ����!]");
		}else {
			System.out.println("[�Խñ� �ۼ� ����..]");
		}
	}
}
