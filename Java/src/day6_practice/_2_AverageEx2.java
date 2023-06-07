package day6_practice;

import java.util.Scanner;

public class _2_AverageEx2 {

	public static void main(String[] args) {
		// 국어, 영어, 수학 성적을 입력받아 평균을 구하는 코드를 작성하세요
		/* input 3 score(kor, eng, math) : 10 20 30
		 * average : 20.0
		 * continue? (y/n) :
		 * y
		 * input 3 score(kor, eng, math) : 90 95 100
		 * average : 95.0
		 * continue? (y/n) : n
		 * EXIT!
		 */
		
		// 반복문 : menu가 n이 아니면 반복(y, n이 아닌 다른문자를 입력하면 반복)
		//		  menu가 y이면 반복(y, n이 아닌 다른 문자를 입력하면 종료)
			// 국어, 영어, 수학 점수 입력
			// 평균을 계산
			// 평균을 출력
			// 더할건지 물어본 후, 입력
		//EXIT! 를 출력
		
		int kor, eng, math;
		char menu = 'y'; // *n이 아닌 y로 초기값 설정 *String 아니고 char => sc.next().charAt(0);
		double average;
		Scanner sc = new Scanner(System.in);
		//System.out.println("국어, 영어, 수학 성적을 입력하세요 : ");
		
		while(menu != 'n') { //* 문자는 '', 문자열은 ""
			System.out.println("input 3 score(kor, eng, math) : ");
			kor = sc.nextInt();
			eng = sc.nextInt();
			math = sc.nextInt();
			
			average = (double)(kor + eng + math) / 3;
			System.out.println("average : " + average);
			System.out.println("continue? (y/n) : " );
			menu = sc.next().charAt(0); //*
			
			}
		System.out.println("EXIT!"); // * 여기까지가 끝.... 어렵네....
		
		sc.close();
	}

}
