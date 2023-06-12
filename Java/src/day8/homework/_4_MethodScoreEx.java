package day8.homework;

import java.util.Scanner;

public class _4_MethodScoreEx {

	public static void main(String[] args) {
		// 4. 성적을 입력받아 학점을 출력하는 코드를 작성하세요 (단, 메소드 이용)
		
		int score;
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 입력하세요 : ");
		score = sc.nextInt();
		
		
		grade(score);
		
		sc.close();
	}
	
	/** 기능 : 성적을 입력하면 학점을 알려준다. 
	 * 매개변수 : 성적 => double score 
	 *	리턴타입 : 학점 문자열
	 *	매소드명 : grade 
	 */
	public static void grade(int score) {
		
		score; // 0도 1도 아닌, 매개변수 num이었다네 어쩐지 안썼더라...는 몰랐다
		// String grade;
		if (score < 0 || score > 100) {
			System.out.println("Wrong Score");
		}else if (score >= 90) {
			System.out.println("A 입니다");
		}else if (score >= 80) {
			System.out.println("B 입니다");
		}else if (score >= 70) {
			System.out.println("C 입니다");
		}else if (score >= 60) {
			System.out.println("D 입니다");
		}else if (score < 60) {
			System.out.println("F 입니다");
		}
		
	}
	

}
