package day5.practice;

import java.util.Scanner;

public class _3_PrintMenuEx__ {

	public static void main(String[] args) {
		// 3. ������ ���� �޴��� ����ϰ� ���α׷� ���Ḧ �����ϱ� ������ �ݺ������� ����Ǵ� �ڵ带 �ۼ��ϼ���.
		// Menu 1. Start 2. Save 3. Exit
		// Select Menu : 1 [�Է�]
		// Program Start!
		
		// �ݺ�Ƚ�� : menu�� 3�� �ƴҶ�����     //i�� 1���� 1�� ����
		/* ��Ģ�� : 
		 *  - Menu ���
		 *  - �޴��� �Է�
		 *  - �Է¹��� �޴��� ���� �ֿܼ� ���
		 *  	- �Է¹��� �޴��� 1�̸� Program Start!
		 *  	- �Է¹��� �޴��� 2�̸� Program Save!
		 *  	- �Է¹��� �޴��� 3�̸� Program Exit!
		 */

		int menu = 0; // 3�� �ƴ� ������ �ʱ�ȭ!
		Scanner sc = new Scanner(System.in);
		
		while(menu != 3) {
			// �޴��� ���
			System.out.println("Menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("Select Menu : ");
			// �޴��� �Է�
			menu = sc.nextInt();
			
			//�Է¹��� �޴��� ���� �ֿܼ� ���
			switch (menu) {
			case 1:
				System.out.println("Program Start!");
				break;
			case 2:
				System.out.println("Program Save!");
				break;
			case 3:
				System.out.println("Program Exit");
				break;
				//������ ����� �������� ���, switch ����� �� �ִ�!!
			}
		}
		
		sc.close();
//		int i;
//		Scanner sc = new Scanner(System.in);
//		System.out.println("����");
//		i = sc.nextInt();
//				
//		i = 1;
//		while(i <= 3) {
//			System.out.println("Menu");
//			System.out.println("1. Start");
//			System.out.println("2. Save");
//			System.out.println("3. Exit");
//			
//			
//			if (i == 1) {
//				System.out.println("Program Start!");			
//			}else if (i == 2) {
//				System.out.println("Program Save!");
//			}else {
//				System.out.println("Program Exit");
			
	}
}
	


