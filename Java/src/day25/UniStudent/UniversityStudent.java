package day25.UniStudent;

import java.util.Scanner;

public class UniversityStudent {

		int menu;
		private Scanner sc = new Scanner(System.in);
		private Student[] std = new Student[10];
		// ����� ���� ���������� ����
		
		private final static int EXIT = 3;
		

	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
	}
	
	public void printMenu() {
		System.out.println("---���---");
		System.out.println("1. �л� ���");
		System.out.println("2. �л� Ȯ��");
		System.out.println("3. ����");
		System.out.println("�޴��� �����ϼ���");
		
	}
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1: // �л� ���
			register();
			break;
		case 2: // �л� Ȯ��
			search();
			break;
		case 3: 
			System.out.println("�ý����� ����˴ϴ�.");
			break;
		default:
			System.out.println("�߸��� �޴�");
		}
		
	}
	
	private void register() {
		System.out.print("�̸� : ");
		String name = sc.next();
		System.out.print("�а� : ");
		String major = sc.next();
		System.out.print("�й� : ");
		int num = sc.nextInt();
		
		if()
		//System.out.println("�л����� : " + name + ", " + major +"�а�, �й� " + num);
	}
	
	/**�̸�(���������� �������ְڱ���) �Ǵ� �й��� �˻��ϰ� Ȯ���ؾ� �� �� ������....
	 * �Ű����� : String name || int number
	 * ����Ÿ�� : void
	 * �޼ҵ�� : search */
	private void search(int num) {
		int index = indexOf(num);
//		public int indexOf(String title) {
//			for(int i = 0; i < wordCount; i++) {
//				if(wordList[i].getTitle().equals(title)) {
//					return i;
//				}
//			}
//			return -1;
//		}
		
		
	}

	private int indexOf(int num) {
		// TODO Auto-generated method stub
		return 0;
	}
}


