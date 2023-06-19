package day13.homework.controler;

import java.util.Scanner;
import day13.homework.ValueObject.VocabularyNote;

// ���� ���� ���� ��&�߰����� �ʿ�

public class VocabularyNoteController {

	//import�� �ʿ��� �༮��... �� ���ŷӰ���...?
	private Scanner sc = new Scanner(System.in); // �ؿ� ���� ���̴ϱ� �����
	private VocabularyNote note = new VocabularyNote(); // ��Ʈ�ѷ��� �����
	
	
	public void run() {
		//�ݺ�(���Ḧ �����ϱ� ������) => ������ 1���� ����(do-while��)
		// do-while�� = �ܼ����α׷� �Ҷ��� ���ǰ� �� �Ⱦ�
		
		int menu = -1;
		
		do {// 1. �޴����
			printMenu(); // ���߿� �޴��� �޶�����, run���� ���ʿ���� printMenu�� �����ϸ��
			
			// 2. �޴� ����
			menu = sc.nextInt();
			//menu = sc.next().charAt(0); //���� �ΰ͵� ���ݾ�..?
		
			// 5. �޴��� ���� ��� ����
			runMenu(menu);
			
		}while(menu != 5); // ������ �޴��� 5�� �ƴҶ�����
		
		sc.close();
	}
	// �޼ҵ�ȿ� �ڵ���� �޼ҵ�� �����ϸ� ����/�ڵ� �ľ��� ������. �����ϱ� ������
	// �ּ���� �� �� �ֵ��� �޼ҵ�� ������
	
	// �޼ҵ�1 : ���θ޴� ���
	/** ��� : �޴��� ����ϴ� �޼ҵ�
	 * �Ű����� : (������ �޴�) ����
	 * ����Ÿ�� : (���) ����
	 * �޼ҵ�� : printMenu
	 */
	private void printMenu() { // �ش� Ŭ���� �ȿ����� �ϸ� ��
	System.out.println("���� �ܾ���");
	System.out.println("1. �ܾ� �߰�");
	System.out.println("2. �ܾ� ����"); //������� ��Ȯ�� �ʿ�
	System.out.println("3. �ܾ� ����");
	System.out.println("4. �ܾ� ���");
	System.out.println("5. ���α׷� ����");
	System.out.print("�޴��� �����ϼ��� : ");
	
	}
	
	// �޼ҵ�2 :
	/** ��� : �޴��� ���� ����� �����ϴ� �޼ҵ�
	 * �Ű����� : �޴� => int menu
	 * ����Ÿ�� : (�ȿ��� ����) ���� => void
	 * �޼ҵ�� : runMene
	 */
	
	// �����д�
	private void runMenu(int menu) {
		// ���ǹ� (Switch / in)
		switch(menu) {
		// �޴��� 1�̸� �ܾ� �߰� ����� ����
		case 1: 
			System.out.println("----------");
			//System.out.println("�ܾ� �߰� ��� ����");
			insertWord();
			System.out.println("----------");
			break;
			
		// �޴��� 2�̸� �ܾ� ���� ����� ����
		case 2: 
			System.out.println("----------");
			deleteWord();
			// System.out.println("�ܾ� ���� ��� ����");
			System.out.println("----------");
			break;
		// �޴��� 3�̸� �ܾ� ���� ����� ����
		case 3: 
			System.out.println("----------");
			updateWord();
			// System.out.println("�ܾ� ���� ��� ����");
			System.out.println("----------");
			break;
		// �޴��� 4�̸� �ܾ� ��� ����� ����
		case 4: 
			System.out.println("----------");
			//System.out.println("�ܾ� ��� ��� ����");
			printWord();
			System.out.println("----------");
			break;
		// �޴��� 5�̸� ���α׷� ����
		case 5: 
			System.out.println("----------");
			System.out.println("���α׷� ����");
			System.out.println("----------");
			break;
		// �޴��� �׿��̸� �߸��� �޴���� ��� 
		default:
			System.out.println("----------");
			System.out.println("�߸��� �޴� �����Դϴ�.");
			System.out.println("----------");
		}
		
	}
	
	// �޼ҵ�4 : �ܾ�/�ǹ� �߰�
	private void insertWord() {
		// �߰��� �ܾ �Է�
		System.out.print("�ܾ� : ");
		String title = sc.next();
		
		// �ܾ�� �Է��� ���͸� ó��
		sc.nextLine(); // ������ �����ϴ� ���, �Ƚ���� ����� �� ����.
		
		// �߰��� ���� �Է�
		System.out.print("�� : ");
		String meaning = sc.nextLine();// ���� ���� �ܾ�� ����, ������ ���Ե� �� �ֱ� ����
		
		// �ܾ��忡 �߰� ->note ��������� ����
		int result = note.insert(title, meaning);
		// note.print(); // �ܾ� ��±���� ���� �������� Ȯ���ϱ� ����
		// > �Ʒ� ����ġ�� ����Ʈ��
		
		switch(result) { // switch(note.insert(title, meaning)) { �� �ٷ� ����
		case 1: System.out.println("�ܾ� �߰� ����!");	 break;
		case 0: System.out.println("�ܾ� �߰� ����!");  break;
		case -1: System.out.println("�ǹ� �߰� ����!"); break;
		}
	}
	
	// �޼ҵ�6 : ����޴� ���
	private void printWord() {
		// ����޴� ���
		printSubMenuPrint();
		
		// ����޴� ����
		int submenu = sc.nextInt();
		
		// ����޴��� 1�̸� ��ü ���
		// ����޴��� 2�̸� �˻�
		switch(submenu) {
		case 1: note.print(); // ��ü ���
				break;
		case 2: 
			// �˻��� �ܾ�
			System.out.print("�˻� �ܾ� : ");
			String title = sc.next();
			// ���
			note.search(title);
			break;
		}	
	}
	
	// �޼ҵ�7 : �ܾ� ����
	private void deleteWord() {
		// ������ �ܾ� �Է�
		System.out.print("���� �ܾ� : ");
		String title = sc.next();
		
		// �ش� �ܾ� ����
		if(note.delete(title)) {
			System.out.println("�ܾ� ���� �Ϸ�!");
		}else {
			System.out.println("�ܾ� ���� ����!");
		}
	}
		
	// �޼ҵ�5 : ����޴���� �� ���
	private void printSubMenuPrint() { // ����޴� ����ϴ°��� �����(���Ҹ��� �˰���?)
		System.out.println("---------");
		System.out.println("���� �޴�");
		System.out.println("1. ��ü ���");
		System.out.println("2. �ܾ� �˻�");
		System.out.print("���� �޴� ���� : ");
		System.out.println();
		
	}
	
		// 3. ���� �޴��� ������ ���� �޴��� ���
		//		���޴��� ���� ��ɽ���
		
		// 4. ���� �޴��� ������ ���� �޴��� ����
		
	//�޼ҵ�8 : ������Ʈ
	private void updateWord() {
		// ����޴� ���
		printSubMenuUpdate();
		
		// ����޴� �Է�
		int submenu = sc.nextInt();
		
		// ����޴��� ���� ��� ����
		switch(submenu) {
		case 1: 
			// �ܾ� ����
			// ������ �ܾ�
			System.out.print("������ �ܾ� : ");
			String word = sc.next();
			// ������ �ܾ�
			System.out.print("������ �ܾ� : ");
			String updateWord = sc.next();
			
			// �ܾ��忡 �ִ� �ܾ� ��������� ����
			if(note.updateTitle(word, updateWord)) { // ������� Ȯ�� �ʿ�.. vo.VocaabublartyNote
				System.out.println("�ܾ� ���� ����!");
			}else {
				System.out.println("�ܾ� ���� ����!");
			}
			break;
			
			// �� ����
		case 2:  
			// ���� ������ �ܾ �Է�
			System.out.print("�ܾ� : ");
			String title = sc.next();
			
			// �ܾ ����ϰ�, �ܾ ������ �ȳ����� ��� �� ����
			if(!note.search(title)) {
				System.out.println("���� �ܾ��Դϴ�.");
				return;
			}
			// ������ ���� ��ȣ�� �Է�
			System.out.print("������ �� ��ȣ ���� : ");
			int num = sc.nextInt();
			
			sc.nextLine(); // *���� ó��
			// ������ ���� �Է�
			System.out.print("������ ��");
			String meaning = sc.nextLine(); // * nextLine���� ����ó��
			
			// �ܾ��忡�� ����
			if(!note.updateMeaning(title, num, meaning)) {
				System.out.println("�� ���� ����");
			}else {
				System.out.println("�� ���� ����");
			}
			break;
			
		// �� ����
		case 3:  
			// ���� ������ �ܾ �Է�
			System.out.print("�ܾ� : ");
			String title2 = sc.next();
			
			// �ܾ ����ϰ�, �ܾ ������ �ȳ����� ��� �� ����
			if(!note.search(title2)) {
				System.out.println("���� �ܾ��Դϴ�.");
				return;
			}
			// ������ ���� ��ȣ�� �Է�
			System.out.print("������ �� ��ȣ ���� : ");
			int num2 = sc.nextInt();
			if(!note.deleteMeaning(title2, num2)) {
				System.out.println("�� ���� ����!");
			}else {
				System.out.println("�� ���� ����!");
			}
			break;
		}
	}
	private void printSubMenuUpdate() {
		System.out.println("����޴�");
		System.out.println("1. �ܾ� ����");
		System.out.println("2. �� ����");
		System.out.println("3. �� ����");
		System.out.println("���� �޴� ���� : ");
		
	}
}
