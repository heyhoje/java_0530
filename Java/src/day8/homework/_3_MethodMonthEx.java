package day8.homework;

import java.util.Scanner;

public class _3_MethodMonthEx {

	public static void main(String[] args) {
				int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ��� : ");
		num = sc.nextInt();
		
		//String getMonth = Month(num);
		Month(num);
		
		sc.close();
	}


	/** ��� : ���ڸ� �Է� ������ ����� ���� ��Ÿ���� 
	 * �Ű����� : ���� �� => int num
	 *	����Ÿ�� : �� ����� => String
	 *	�żҵ�� : Month 
	 */
	public static void Month(int month) {
		
		if (month == 1) {
			System.out.println("January");
		}else if (month == 2) {
			System.out.println("February");
		}else if (month == 3) {
			System.out.println("March");
		}else if (month == 4) {
			System.out.println("April");
		}else if (month == 5) {
			System.out.println("May");
		}else if (month == 6) {
			System.out.println("June");
		}else if (month == 7) {
			System.out.println("July");
		}else if (month == 8) {
			System.out.println("August");
		}else if (month == 9) {
			System.out.println("September");
		}else if (month == 10) {
			System.out.println("October");
		}else if (month == 11) {
			System.out.println("Nobember");
		}else if (month == 12) {
			System.out.println("December");
		}
	}
}
