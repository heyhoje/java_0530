package day21.practice._4_UpDown;

import day21.practice.UpDown.controller.GameManager;

public class UpDownlEx {

	public static void main(String[] args) {
		// UpDown ���α׷��� �ۼ��ϰ�, ���(������� ����°�)�� �����ϴ� ����� �߰��ϼ���
		/*
		 * 1. play
		 * 2. record
		 * 3. exit
		 * select : 1
		 * ...
		 * record id : */
		
		GameManager gm = new GameManager();//import�� ���ؼ� ���� ��ſ��� ã��..�Ф�!!!
		gm.run();
	}
}
		
//		int min = 1, max = 100;
//		int menu;
//		Scanner sc = new Scanner(System.in);
//		
//		do {
//			printMenu();
//			
//			selectMenu();
//			menu = sc.nextInt();
//			
//			runMenu();
//			
//		}while(menu != 3);
//	}
//			
//	
//	private static void printMenu() {
//		System.out.println("�޴��� �Է��ϼ��� : ");
//		System.out.println("1. play");
//		System.out.println("2. record");
//		System.out.println("3. exit");
//	}
//	
//	private static void runMenu(int menu) {
//		switch(menu) {
//		case 1: // play
//			break;
//		case 2: // record
//			break;
//		case 3:
//			System.out.println("EXIT");
//			break;
//		default:
//			System.out.println("�߸��� �޴��Դϴ�.");
//		}
