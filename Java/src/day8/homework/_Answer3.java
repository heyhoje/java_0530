package day8.homework;

import java.util.Scanner;

public class _Answer3 {

	public static void main(String[] args) {
				int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요 : ");
		num = sc.nextInt();
		
		//String getMonth = Month(num);
		printMonth(num);
		System.out.println(getMonth(1));//getMonth 자체에는 출력하는 기능이 없기 때문에 sysout안에 넣어야함
		
		sc.close();
	}


	/** 기   능 : 숫자를 입력 받으면 영어로 달을 나타낸다 
	 * 			 월이 주어지면 주어진 월의 영문을 출력하는 메소드 
	 *  매개변수 : 숫자 월 => int num
	 *	리턴타입 : 없음 => void
	 *	매소드명 : printMonth 
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
		
		/** 기능 : 월이 주어지면 주어진 월의 영문을 알려주는 메소드 
		 * 매개변수 : 숫자 월 => int num
		 *	리턴타입 : 월 영어로 => String
		 *	매소드명 : getMonth 
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
