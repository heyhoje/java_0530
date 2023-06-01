package day3_practice;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		/*1.성적을 입력받아 입력받은 성적이 60점 이상인지 확인하는 코드를 작성하세요.
		​예 :  
		input score : 
		65
		[결과출력] Do you pass 65 points? pass
				​
		input score : 
		45
		[결과출력] Do you pass 45 points? fail
		*/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input score : ");
		int score = sc.nextInt(); 
		
		String result = score >= 60 ? "pass" : "fail";// in result 가 아닌 String 변수로 받아야함(pass/fail을 값으로 받아야해서)
		System.out.println("Do you pass " + score + " points? : " + result);
		
		sc.close();
	}

}
