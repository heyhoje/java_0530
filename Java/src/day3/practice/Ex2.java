package day3.practice;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		/* 2. ?±ì???? ???¥ë??? ???¥ë??? ?±ì???? 60???´ì???¸ì? ???¸í???? ì½???ë¥? ???±í???¸ì??.
		 * ??:
		 * input score :
		 * 65
		 * Do you pass 65 points? pass
		 * input score :
		 * 45
		 * Do you pass 45 points? fail
		 * */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input score : ");
		int score = sc.nextInt(); 
		
		String result = score >= 60 ? "pass" : "fail";// in result åª?ï¿? ï¿½ï¿½ï¿½ï¿½ String è¹?ï¿½ï¿½ï¿½æ¿¡ï¿? è«?ï¿½ï¿½ï¿½ï¿½?³ï¿½ï¿?(pass/failï¿½ï¿½ åª?ï¿½ï¿½?°ï¿½ è«?ï¿½ï¿½ï¿½ï¿½?³ï¿½??ï¿½ï¿½)
		System.out.println("Do you pass " + score + " points? : " + result);
		
		sc.close();
	}

}
