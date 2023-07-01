package review_0630.VocabularyNote.controller;

import java.util.Scanner;

import review_0630.VocabularyNote.vo.VocabularyNote;

public class VocabularyNoteController {
	
	// day12.practice Ȱ��. �� ������ ��� �����ϵ���....

			// 1. ���� �ܾ��� ���α׷��� �����ϼ���
			// Word, VocabularyNote Ŭ���� �̿�

			/*�޴�
			 * 1. �ܾ� �߰�
			 * 2. �ܾ� ����
			 * 3. �ܾ� ����
			 * 	 a. �ܾ� ����
			 *   b. �� ����
			 *   c. �� ����
			 * 4. �ܾ� ���
			 *   a. ��ü ���
			 *   b. �˻�
			 * 5. ���α׷� ����
			 */

//			�޴��� ���
//			�޴� ����
//			����޴� ����
//			����޴�����
//			������ �ܾ� / ������ �ܾ� 
//			������ �����߽��ϴ�
	
	int menu;
	private Scanner sc = new Scanner(System.in);
	private VocabularyNote note = new VocabularyNote();
	public final static int EIXT = 5;
	
	public void run() { // ��ü���� ������ ����
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EIXT);
	}
	public void printMenu() {
		System.out.println("===========");
		System.out.println("�޴�");
		System.out.println("1. �ܾ� �߰�");
		System.out.println("2. �ܾ� ����");
		System.out.println("3. �ܾ� ����");
		System.out.println("4. �ܾ� ���");
		System.out.println("5. ���α׷� ����");
		System.out.print("�޴��� �����ϼ��� : ");
		System.out.println("===========");
		
	}
	public void runMenu(int menu) {
		switch(menu) {
		case 1: // �ܾ� �߰�
			insertWord();
			break;
		case 2: // �ܾ� ����
			deleteWord();
			break;
		case 3: // �ܾ� ����
			updateWord();
			break;
		case 4: // �ܾ� ���
			printWord();
			break;
		case 5:
			System.out.println("���α׷��� �����մϴ�");
			break;
		default:
			System.out.println("�߸��� �޴��Դϴ�.");
				
		}
	}
	
	public void insertWord() {
		System.out.print("�ܾ� : ");
		String title = sc.next();
		System.out.print("�� : ");
		String meaning = sc.next();

		int result = this.note.insert(title, meaning);
		
		switch(result) {
		case 1: 
			System.out.println("�ܾ� �߰� ����!");
		case -1: 
			System.out.println("�� �߰� ����!");
		case 0:
			System.out.println("�ܾ� �߰� ���Ф�");
			
		}
	}
	
	public void deleteWord() {
		System.out.print("������ �ܾ� : ");
		String title = sc.next();
		
		if(note.delete(title)) {
			System.out.println("�ܾ� ���� �Ϸ�!");
		}else {
			System.out.println("�ܾ� ���� ���Ф�");
		}
	}
	
	private void printWord() {
		printSubMenuPrint();
		int submenu = sc.nextInt();
		switch(submenu) {
		case 1: // ��ü ��� 
			note.print();
			break;
		case 2: // �˻�
			System.out.println("�˻��� �ܾ� : ");
			String title = sc.next();
			
			note.search(title);
			break;
		}
	}
	
	public void printSubMenuPrint() {
		System.out.println("----------");
		System.out.println("���� �޴�");
		System.out.println("1. ��ü ���");
		System.out.println("2. �ܾ� �˻�");
		System.out.print("���� �޴� ���� : ");
	}
	
	private void updateWord() {
		printSubMenuUpdate();
		int submenu = sc.nextInt();
		
		switch(submenu) {
		case 1: // �ܾ� ����
			System.out.print("������ �ܾ� : ");
			String word = sc.next(); // ��� �� word�� ����????
			System.out.print("������ �ܾ� : ");
			String updateWord = sc.next();
			
			if(note.updateTitle(word, updateWord)) {
				System.out.println("�ܾ� ���� ����!");
			}else {
				System.out.println("�ܾ� ���� ���Ф�");
			}
			break;
			
		case 2: // �� ����
			System.out.print("������ �ܾ� : ");
			String title = sc.next();
			
			if(!note.search(title)) {
				System.out.println("���� �ܾ��Դϴ�.");
				return;
			}
			
			System.out.print("������ �� ��ȣ ���� : ");
			int num = sc.nextInt();
			
			
			sc.nextLine(); // ����ó��
			System.out.print("������ �� :");
			String meaning = sc.nextLine();
			
			// �ܾ��忡�� ����
			if(!note.updateMeaning(title, num, meaning)) {
				System.out.println("�� ���� ���Ф�");
			}else {
				System.out.println("�� ���� ����!");
			}
			break;
			
		case 3: // �� ����
			System.out.print("������ �ܾ� : ");
			String title1 = sc.next();
			
			if(!note.search(title1)) {
				System.out.println("���� �ܾ��Դϴ�.");
				return;
			}
			System.out.print("������ �� ��ȣ ���� : ");
			int num1 = sc.nextInt();
			if(!note.deleteMeaning(title1, num1)) {
				System.out.println("�� ���� ���Ф�");
			}else {
				System.out.println("�� ���� ����!");
			}
			break;
		}
		
	}
	private void printSubMenuUpdate() {
		System.out.println("���� �޴�");
		System.out.println("1. �ܾ� ����");
		System.out.println("2. �� ����");
		System.out.println("3. �� ����");
		System.out.print("���� �޴� ���� : ");
		
	}

}
