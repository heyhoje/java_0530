package day8_Practice;

import java.util.Scanner;

public class _5_MethodSeasonEx {

	public static void main(String[] args) {
		// 5. ���� �Է¹޾� ������ ����ϴ� �ڵ带 �ۼ��ϼ���.
		// ��, �޼ҵ带 �̿�
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ��� : ");
		month = sc.nextInt();
		
		// month�� 3�̰ų�, 4�̰ų�, 5�̸� Spring ���
		if(month == 3||month == 4||month == 5) {
			System.out.println("Spring!");
		// month�� 6�̰ų�, 7�̰ų�, 8�̸� Summer ���
		}else if(month == 6||month == 7||month == 8) {
			System.out.println("Summer!");
		// month�� 9�̰ų�, 10�̰ų�, 11�̸� Fall ���
		}else if(month == 9||month == 10||month == 11) {
			System.out.println("Fall!");
		// month�� 12�̰ų�, 1�̰ų�, 2�̸� Winter ���
		}else if(month == 12||month == 1||month == 2) {
			System.out.println("Winter!");
		// �ƴϸ� Wrong Month ���
		}else {
			System.out.println("Wrong month");
		}
		
		System.out.println("-------");
		
		String season = getSeason(month);
		System.out.println(month + " is " + getSeason(month));
		
		sc.close();
	}
	
	// �޼ҵ�1 : ���� �´� ����
	/** ��� : ���� �־����� �־����� ���� �´� ������ �˷��ִ� �޼ҵ�
	 * �Ű����� : �� => int month
	 * ����Ÿ�� : ���� => String
	 * �޼ҵ�� : getSeason
	 */
	public static String getSeason(int month) {
		if(month == 3||month == 4||month == 5) {
			return "Spring!";
		// month�� 6�̰ų�, 7�̰ų�, 8�̸� Summer ���
		}else if(month == 6||month == 7||month == 8) {
			return "Summer!";
		// month�� 9�̰ų�, 10�̰ų�, 11�̸� Fall ���
		}else if(month == 9||month == 10||month == 11) {
			return "Fall!";
		// month�� 12�̰ų�, 1�̰ų�, 2�̸� Winter ���
		}else if(month == 12||month == 1||month == 2) {
			return "Winter!";
		// �ƴϸ� Wrong Month ���
		}else {
			return "Wrong month";
		}
	}
	

}
