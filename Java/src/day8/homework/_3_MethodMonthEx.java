package day8.homework;

import java.util.Scanner;

public class _3_MethodMonthEx {

	public static void main(String[] args) {
		// 3. 월을 입력받아 월에 맞는 영어를 출력하세요 (단, 메소드 이용)
		// 예
		// input month : 
		// 3
		// March
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요 : ");
		num = sc.nextInt();
		
		String getMonth = Month(num);
		System.out.println(getMonth(num));
		
		sc.close();
	}


	/** 매개변수 : 숫자 월 => int num
	 *	리턴타입 : 월 영어로 => String
	 *	매소드명 : Month 
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
