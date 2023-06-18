package day8_Practice;

import java.util.Scanner;

public class _5_MethodSeasonEx {

	public static void main(String[] args) {
		// 5. 월을 입력받아 계절을 출력하는 코드를 작성하세요.
		// 단, 메소드를 이용
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("월을 입력하세요 : ");
		month = sc.nextInt();
		
		// month가 3이거나, 4이거나, 5이면 Spring 출력
		if(month == 3||month == 4||month == 5) {
			System.out.println("Spring!");
		// month가 6이거나, 7이거나, 8이면 Summer 출력
		}else if(month == 6||month == 7||month == 8) {
			System.out.println("Summer!");
		// month가 9이거나, 10이거나, 11이면 Fall 출력
		}else if(month == 9||month == 10||month == 11) {
			System.out.println("Fall!");
		// month가 12이거나, 1이거나, 2이면 Winter 출력
		}else if(month == 12||month == 1||month == 2) {
			System.out.println("Winter!");
		// 아니면 Wrong Month 출력
		}else {
			System.out.println("Wrong month");
		}
		
		System.out.println("-------");
		
		String season = getSeason(month);
		System.out.println(month + " is " + getSeason(month));
		
		sc.close();
	}
	
	// 메소드1 : 월에 맞는 계절
	/** 기능 : 월이 주어지면 주어지는 월에 맞는 계절을 알려주는 메소드
	 * 매개변수 : 월 => int month
	 * 리턴타입 : 계절 => String
	 * 메소드명 : getSeason
	 */
	public static String getSeason(int month) {
		if(month == 3||month == 4||month == 5) {
			return "Spring!";
		// month가 6이거나, 7이거나, 8이면 Summer 출력
		}else if(month == 6||month == 7||month == 8) {
			return "Summer!";
		// month가 9이거나, 10이거나, 11이면 Fall 출력
		}else if(month == 9||month == 10||month == 11) {
			return "Fall!";
		// month가 12이거나, 1이거나, 2이면 Winter 출력
		}else if(month == 12||month == 1||month == 2) {
			return "Winter!";
		// 아니면 Wrong Month 출력
		}else {
			return "Wrong month";
		}
	}
	

}
