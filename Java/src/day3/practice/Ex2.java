package day3.practice;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		/* 2. ?��???? ???��??? ???��??? ?��???? 60???��???��? ???��???? �???�? ???��???��??.
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
		
		String result = score >= 60 ? "pass" : "fail";// in result �?�? ���� String �?���濡�? �?����?���?(pass/fail�� �?��?�� �?����?��??��)
		System.out.println("Do you pass " + score + " points? : " + result);
		
		sc.close();
	}

}
