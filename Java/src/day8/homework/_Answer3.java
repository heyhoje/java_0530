package day8.homework;

import java.util.Scanner;

public class _Answer3 {

	public static void main(String[] args) {
				int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �Է��ϼ��� : ");
		num = sc.nextInt();
		
		//String getMonth = Month(num);
		printMonth(num);
		System.out.println(getMonth(1));//getMonth ��ü���� ����ϴ� ����� ���� ������ sysout�ȿ� �־����
		
		sc.close();
	}


	/** ��   �� : ���ڸ� �Է� ������ ����� ���� ��Ÿ���� 
	 * 			 ���� �־����� �־��� ���� ������ ����ϴ� �޼ҵ� 
	 *  �Ű����� : ���� �� => int num
	 *	����Ÿ�� : ���� => void
	 *	�żҵ�� : printMonth 
	 */
	public static void printMonth(int month) {
		switch(month) {
		case 1: System.out.println("January");		break;
		case 2: System.out.println("February");		break;
		case 3: System.out.println("March");		break;
		case 4: System.out.println("April");		break;
		case 5: System.out.println("May");			break;
		case 6: System.out.println("June");			break;
		case 7: System.out.println("July");			break;
		case 8: System.out.println("August");		break;
		case 9: System.out.println("September");	break;
		case 10: System.out.println("October");		break;
		case 11: System.out.println("Nobember");	break;
		case 12: System.out.println("December");	break;
		default: System.out.println("Wrong month!");
		}
		
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
		
		/** ��� : ���� �־����� �־��� ���� ������ �˷��ִ� �޼ҵ� 
		 * �Ű����� : ���� �� => int num
		 *	����Ÿ�� : �� ����� => String
		 *	�żҵ�� : getMonth 
		 */
	public static String getMonth(int month) {
		switch(month) {
		case 1: return "January";
		case 2: return "February";
		case 3: return "March";
		case 4: return "April";
		case 5: return "May";
		case 6: return "June";
		case 7: return "July";
		case 8: return "August";
		case 9: return "September";
		case 10: return "October";
		case 11: return "Nobember";
		case 12: return "December";
		default: return "Wrong month!";
		
		}
			
	}
}
