package day8.homework;

import java.util.Scanner;

public class _3_MethodMonthEx {

	public static void main(String[] args) {
		// 3. ���� �Է¹޾� ���� �´� ��� ����ϼ��� (��, �޼ҵ� �̿�)
		// ��
		// input month : 
		// 3
		// March
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ��� : ");
		num = sc.nextInt();
		
		String getMonth = Month(num);
		System.out.println(getMonth(num));
		
		sc.close();
	}


	/** �Ű����� : ���� �� => int num
	 *	����Ÿ�� : �� ����� => String
	 *	�żҵ�� : Month 
	 */
	public static String Month(int month) {
		month = 0;
		switch(month) {
		case 1:
			System.out.println("January");
			break;
		case 2:
			System.out.println("February");
			break;
		case 3:
			System.out.println("March");
			break;
		case 4:
			System.out.println("April");
			break;
		case 5:
			System.out.println("May");
			break;
		case 6:
			System.out.println("June");
			break;
		case 7:
			System.out.println("July");
			break;
		case 8:
			System.out.println("August");
			break;
		case 9:
			System.out.println("September");
			break;
		case 10:
			System.out.println("October");
			break;
		case 11:
			System.out.println("Nobember");
			break;
		case 12:
			System.out.println("December");
			break;
			
		}
		return null;
	}
}
