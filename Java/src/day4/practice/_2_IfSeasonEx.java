package day4.practice;

import java.util.Scanner;

public class _2_IfSeasonEx {

	public static void main(String[] args) {
		// ���� �Է¹޾� �Է¹��� ���� ������ ����ϼ���.
		// 3, 4, 5 : �� / 6, 7, 8 : ���� / 9, 10, 11 : ���� / 12, 1, 2 : �ܿ� / �� �� : �߸��� �� 
		
		int month; // ��������
		//String Season;
		Scanner scan = new Scanner(System.in); // �Է� = ��ĳ��
		System.out.println("input month : "); // �ȳ����� : ���� �Է��ϼ���.
		month = scan.nextInt(); // ��������� ��������? �������� �� �� ����? ������
		
		// if���� ��/���� ���� �Ǻ��Ǿ���. <��> �Ǵ� <��������>�� �����Ѵ� // ����(==) �����ڵ� �����
		//0 ~ 13 ���� �׽�Ʈ�غ��� 
		if(month == 3 || month == 4 || month == 5) { // ũ���۴ٷ� �����ұ�???   //Type mismatch: cannot convert from int to boolean
													// The operator == is undefined for the argument type(s) boolean, int
			System.out.println(month + "���� ���Դϴ�.");
		}else if (month == 6 || month == 7 || month == 8) {
			System.out.println(month + "���� �����Դϴ�.");
		}else if (month == 9 || month == 10 || month == 11) {
			System.out.println(month + "���� �����Դϴ�.");
		}else if (month == 12 || month == 1 || month == 2) {
			System.out.println(month + "���� �ܿ��Դϴ�.");
		}else {
			System.out.println("�߸��� ���Դϴ�.");
		}
		
		System.out.println("--------------------");
		if (month >= 4 && month <= 5) { // �� : 3�̰ų�(==���ų�) 4�̰ų� 5�̰ų� (3�̻��̰� 5�����̸�)
			System.out.println(month + "���� ���Դϴ�.");
		}else if (month == 12 || (month >= 1 && month <= 2)) {// �ܿ� : (���� 12�̰ų�, ���� 1�̻��̰� 2�����̸�)
			System.out.println(month + "���� �ܿ��Դϴ�."); // �������ڴ� �켱������ ��� (���ۼ���������) �տ������� ������� ������ �� �� �ִ�.
														// ���� �����ؾ��� �����ڿ� ��ȣ�� ���ִ°� ����. 
			// �������ڿ��� ���� �ٸ� �����ڰ� �����ִ� ���, ��ȣ�� �ļ� �۾����ִ°� ����!
		}
		
		
	}

}
