package day6._042_DoWhileEx;

import java.util.Scanner;

public class _1_PringMenu2 {

	public static void main(String[] args) {
		/* 1. ������ ���� �޴��� ����ϰ� ���α׷� ���Ḧ �����ϱ� ������ �ݺ������� ����Ǵ� �ڵ带 �ۼ��ϼ���.
		 * Menu 
		 * 1. Start 
		 * 2. Save 
		 * 3. Exit
		 * Select Menu :
		 */
		
		int menu; // ���ప�� ����ϰ� ������ Ȯ�� �ϱ� ������ menu�ʱⰪ �߿����� ����. �ʱ�ȭ ����
		Scanner sc = new Scanner(System.in);// �޴� �Է� �ޱ����� Scanner
		
		// �Է¹��� �޴��� 3�� �ƴϸ� �ݺ�
		do {
			// �޴���� �� ����
			System.out.println("Menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("Select Menu : ");
			menu = sc.nextInt(); // menu���� ���� ����
			
			// ������ �޴��� ���� ��¹� ����
			switch (menu) {
			case 1: 
				System.out.println("Program Start!");
				break;
			case 2:
				System.out.println("Program Save!");
				break;
			case 3:
				System.out.println("Program Exit!");
				break;
			}
			
		}while(menu != 3);
		
		sc.close();
	}

}
