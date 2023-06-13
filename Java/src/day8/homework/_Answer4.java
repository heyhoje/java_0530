package day8.homework;

import java.util.Scanner;

public class _Answer4 {

	public static void main(String[] args) {
		// 4. 성적을 입력받아 학점을 출력하는 코드를 작성하세요 (단, 메소드 이용)
		
		double score;
		Scanner sc = new Scanner(System.in);
		System.out.println("성적을 입력하세요 : ");
		score = sc.nextInt();
		
		getGrade(score);
		
	
		System.out.println(getGrade(score));
		
		sc.close();
	}
	
	/** 기   능 : 성적을 입력하면 학점을 알려주는 메소드. 
	 *  매개변수 : 성적 => 정수 or 실수 => double
	 *	리턴타입 : 학점 문자열 => String
	 *	매소드명 : getGrade 
	 */
	
	public static String getGrade(double score) {
		if (score < 0 || score > 100) {
			return "Wrong Score";
		}
		/* 100점대 => A
		 *  90점대 => A
		 *  80점대 => B
		 *  70점대 => C
		 *  60점대 => D
		 *   그 외 => F
		 */
		int result = (int)(score/10);
		switch(result) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		}
		//return null; // 학점값이 출력이 안되여....
	}
	
	

	
}
