package day5_03_SwitchEx;

import java.util.Scanner;

public class _2_SeasonEx {

	public static void main(String[] args) {
		// ���� �Է¹޾� �Է¹��� ���� ������ ����ϼ���.
		// 3, 4, 5 : �� / 6, 7, 8 : ���� / 9, 10, 11 : ���� / 12, 1, 2 : �ܿ� / �� �� : �߸��� ��
		
		int month;
		Scanner sc = new Scanner(System.in);
		
		// ���� �Է�
		System.out.println("���� �Է��ϼ��� : "); 
		month = sc.nextInt();
		
		/* if(month == 1) { //���ٿ��� ������ �κ��� (����)�� ����, ~~~~ �� case �ڷ� ����.
		
		}
		
		Switch(month) 
		case 1
	
	*/
		//���� ���� ������ ���(Switch������)
		switch(month ) {
		// month�� 1, 2, 12 �϶� 12�� ���๮�� ����Ǿ� �ܿ��� ���
		// 1�� ���๮�� ����, break���� ����
		// 2�� ���๮�� ����, break���� ����
		case 1 : case 2 : case 12 : // case 1, 2, 12: // JDK 7���� ���ķ� ����(�츮�� �ֽŹ��� ������̶� ������)
			System.out.println("�ܿ�"); // << �� 12�� ���๮��. 1 �� 2�� break�� ��� �Ѿ�Ѿ� ����.
			break;
		case 3 : case 4 : case 5 :
			System.out.println("��");
			break;
		case 6 : case 7 : case 8 :
			System.out.println("����");
			break;
		case 9 : case 10 : case 11:
			System.out.println("�ܿ�");
			break;
		}
//		switch(month) {
//		case 1 : month = 3;
//		case 2 : month = 4;
//		case 3 : month = 5;
//			System.out.println(month + "���� ���Դϴ�.");
//			break;
//		case 4 : month = 6;
//		case 5 : month = 7;
//		case 6 : month = 8;
//			System.out.println(month + "���� �����Դϴ�.");
//			break;
//		case 7 : month = 9;
//		case 8 : month = 10;
//		case 9 : month = 11;
//			System.out.println(month + "���� �����Դϴ�.");
//			break;
//		case 10 : month = 12;
//		case 11 : month = 1;
//		case 12 : month = 2;
//			System.out.println(month + "���� �ܿ��Դϴ�.");
//			break;
//		default : 
//			System.out.println("�߸��� ���Դϴ�.");
//		}
		
		sc.close();
		
				
	}

}
