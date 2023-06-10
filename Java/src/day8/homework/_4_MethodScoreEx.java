package day8.homework;

import java.util.Scanner;

public class _4_MethodScoreEx {

	public static void main(String[] args) {
		// 4. 성적을 입력받아 학점을 출력하는 코드를 작성하세요 (단, 메소드 이용)
		
		int score;
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 입력하세요 : ");
		score = sc.nextInt();
		
		grade(60)
	}
	
	/** 매개변수 : 성적을 입력하고 => int score 
	 *	리턴타입 : 학점을 출력한다 => char
	 *	매소드명 : grade 
	 */
	public static char grade(int num) {
		int score;
		char grade = 0;
		if (score < 0 || score > 100) {
			System.out.println("Wrong Score");
		}else if () {
			System.out.println('A');
		}else if () {
			System.out.println('B');
		}else if () {
			System.out.println('C');
		}else if () {
			System.out.println('D');
		}else if () {
			System.out.println('F');
		}
		
		}
	}

}
