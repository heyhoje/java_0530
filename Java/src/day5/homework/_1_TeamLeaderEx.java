package day5.homework;

import java.util.Scanner;

public class _1_TeamLeaderEx {

	public static void main(String[] args) {
		// 1. 30명의 학생이 있는 반에서 1번부터 연속된 번호를 가진 3명의 학생이 1조가 되도록 나누었다. 
		// 이 때 가장 큰 번호인 학생이 조장이 된다.
		// 학생 번호가 주어졌을 때 조장인지 조원인지 판별하는 코드를 작성하시오. * switch문으로
		// input student number : 
		// 1
		// Student number 1 is a member of the team.
		// input student number : 
		// 6
		// Student number 6 is the team leader.
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 번호를 입력하세요");
		num = sc.nextInt();
		
		// 3의 배수 = 리더 / 아니면 조원
		
		switch(num % 3) {
		case 0: 
			System.out.println("조장입니다");
			break;
		default:
			System.out.println("조원입니다");
			
		}
	}

}
