package day4.homework;

import java.util.Scanner;

public class _1_ScoreAverageEx {

	public static void main(String[] args) {
		// 1.국어, 영어, 수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요. 
		// * 성적은 정수
		
		int koreaScore;
		int englishScore;
		int mathScore;
		Scanner sc = new Scanner(System.in);
		System.out.println("국어, 영어, 수학 성적을 입력하세요");
		koreaScore = sc.nextInt();
		englishScore = sc.nextInt();
		mathScore = sc.nextInt();
		
		int average = (koreaScore + englishScore + mathScore) / 3;
		System.out.println("성적의 평균은 " + average + "점 입니다.");
		
		
		sc.close();
		
	}

}
