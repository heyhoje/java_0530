package day22.practice.PhoneListEx.controller;

import java.util.Scanner;

import day22.practice.PhoneListEx.vo.PhoneBook;

public class PhoneList implements Program {
	// ��ȭ��ȣ�� �����ϴ� ���α׷��� �ۼ��ϼ���.
		/* 1. ��ȭ��ȣ ���
		 * 2. ��ȭ��ȣ ����
		 * 3. ��ȭ��ȣ �˻�
		 * 4. ���α׷� ����
		 * */
	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4;
	
	// �����ϱ����� ��ȭ��ȣ�ΰ� �ʿ��ϱ���...~ ����Ʈ �����ʿ����
	// ��� �����̿�
	private PhoneBook pb = new PhoneBook();
	
	@Override
	public void run() {
		int menu;
		do {
			System.out.println("==========");
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			System.out.println("==========");
		} while(menu != EXIT);
		
		sc.close();
	}
	@Override
	public void printMenu() {
		
		System.out.println("1. ��ȭ��ȣ ���");
		System.out.println("2. ��ȭ��ȣ ����");
		System.out.println("3. ��ȭ��ȣ �˻�");
		System.out.println("4. ���α׷� ����");
		System.out.print("�޴��� �������ּ��� : ");
	}


	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
			insert();
			break;
		case 2: 
			update();
			break;
		case 3: 
			search();
			break;
		case 4:
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�߸��� �޴��Դϴ�.");
		}
	}

	private void insert() {
		// �̸��� ��ȭ��ȣ�� �Է¹޾ƾ���
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("��ȭ��ȣ : ");
		String number = sc.next();
		
		// ��ȭ��ȣ�ο� �߰��� �ؼ� �����ϸ� �����̶��
		if(pb.insertPhone(name, number)) {
			System.out.println("��� ����!!");
			// �ǽ����ϸ� �����ߴٰ� ���
		} else {
			System.out.println("��� ����!!");
		}
		
		
	}
	private void update() { // ��ȣ / �̸� / ��ȣ�̸� / ����
		// �̸�, ������ �̸�, ������ ��ȭ��ȣ�� �Է¹޾ƾ���
				System.out.print("�̸� : ");
				String name = sc.next();
				
				System.out.println("������ �̸� :");
				String updateName = sc.next();
				
				System.out.print("��ȭ��ȣ : ");
				String number = sc.next();
				
				// ��ȭ��ȣ�ο� ������ �ؼ� �����ϸ� �����̶��
				// �����ϸ� �����ߴٰ� ���
				if(pb.update(name, updateName, number)) {
					System.out.println("���� ����!!");
				}else {
					System.out.println("���� ����");
				}
	}
	
	// �߰� & ������ �Է°� �����¸� �ϸ��(�����ҽ� : ����� ���Ͽ� �� �����س���. )
	
	private void search() {
		// �˻��� �̸��� �Է��ϰ�
		System.out.print("�̸� : ");
		String name = sc.next();
		
		// �˻� ����� ���
		pb.print(s->s.getName().contains(name)); 
		// ����� : �̸��� �Ϻ� ��ġ�ص� �˻�����Ϸ��� contains�̿��ؼ� ����
		//pb.print(s->s.getName().equals(name)); // ������ �������� equals
		// pb.print(s->true); // ��ü ���( ������ ��ü?????? )
	}

}
