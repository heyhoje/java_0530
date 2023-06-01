package day3.homework;

import java.util.Scanner;

public class Ex1_conditional {

	public static void main(String[] args) {
		/*1. 성별(M:남성, W:여성)을 입력받아 여성인지 확인하는 코드를 작성하세요.
		input gender : M
		Are you a women? false
		
		input gender : W
		Are you a women? true
		*/

		Scanner sc = new Scanner(System.in);
		boolean isWoman = false;
		String WOMEN = "W";
		
		while(true) {
			System.out.println("input gender : ");
			String gender = sc.next(); // "W"
			isWoman = WOMEN.equals(gender) ? true : false;
			System.out.println("Are you a women? " + isWoman);
		}
		
//		System.out.println("여성인지 확인하시오.");
//		String gender = women ? "m" : "w";
//		String result = gender == m ? "man" : "woman";
//		boolean woman = true;
//		boolean man = false;
//		String gender = String.valueOf(woman);
//		
//		String result = (gender == "woman") ? "여성입니다" : "남성입니다"; 
//		// from String to boolean 은 안된다고 빠꾸먹음 -> 그래서 String.valueOf 써봄.
//		System.out.println("여성입니까? : " + result);
//		 
//		result = (gender != "woman") ? "남성입니다" : "여성입니다";
//		System.out.println("여성입니까? : " + result);
		
	
	}

}
