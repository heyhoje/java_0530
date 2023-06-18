package day8.homework;

import java.util.Scanner;

public class _3_MethodMonthEx {

	public static void main(String[] args) {
		//���� �Է¹޾� ���� �´� ��� ����ϼ���.
		
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ��� : ");
		month = sc.nextInt();
		
		System.out.println(getMonth(4) + "�� �Դϴ�.");
		
		printMonth(month);
		System.out.println(getMonth(month));
	}


	/** ��� : ���� �־����� �־��� ���� ������ �˷��ִ� �޼ҵ�
	 *  �Ű����� : ���� �� => int month
	 *	����Ÿ�� : �� ����� => String
	 *	�żҵ�� : getMonth 
	 */
	
	public static String getMonth(int month) {
		switch(month) {
		case 1: return "Jan";
		case 2: return "Feb";
		case 3: return "Mar";
		case 4: return "April";
		case 5: return "May";
		case 6: return "June";
		case 7: return "July";
		case 8: return "Aug";
		case 9: return "Sep";
		case 10: return "Oct";
		case 11: return "Nov";
		case 12: return "Dec";
		default: return "Wrong month!";
		}
	}
	
	/** ��� : ���� �־����� �־��� ���� ������ ����ϴ� �޼ҵ�
	 *  �Ű����� : ���� �� => int month
	 *	����Ÿ�� : (���)���� => void
	 *	�żҵ�� : printMonth 
	 */
	
	public static void printMonth(int month) {
	
		switch(month) {
		case 1: System.out.println("Jan");     break;
		case 2: System.out.println("Feb");     break;
		case 3: System.out.println( "Mar");     break;
		case 4: System.out.println( "April");     break;
		case 5: System.out.println( "May");     break;
		case 6: System.out.println( "June");     break;
		case 7: System.out.println( "July");     break;
		case 8: System.out.println( "Aug");     break;
		case 9: System.out.println( "Sep");     break;
		case 10: System.out.println( "Oct");     break;
		case 11: System.out.println( "Nov");     break;
		case 12: System.out.println( "Dec");     break;
		default: System.out.println( "Wrong month!");     break;
		}
	}
	
	
}
