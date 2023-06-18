package day8.homework;

import java.util.Scanner;

public class _4_MethodScoreEx {

	public static void main(String[] args) {
		// 4. 성적을 입력받아 학점을 출력하는 코드를 작성하세요 (단, 메소드 이용)
		
		int score = 10;
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 입력하세요 : ");
		score = sc.nextInt();
		System.out.println(getGrade(score));
		sc.close();
	}
	
	/** 기능 : 성적을 입력하면 학점을 알려준다. 
	 * 매개변수 : 성적 => 정수 or 실수 => int score 
	 *	리턴타입 : 학점 => 문자열 => String
	 *	매소드명 : getGrade 
	 */
	
	public static String getGrade(int score) {
		if(score < 0 || score > 100) {
			return "Wrogn Score!";
		}
		
		if(score >= 90) {
			return "A학점";
		} else if(score >= 80) {
			return "B학점";
		} else if(score >= 70) {
			return "C학점";
		} else if(score >= 60) {
			return "D학점";
		}
		return "F학점";
		
	}

}
