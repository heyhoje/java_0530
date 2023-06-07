package day5.homework;

import java.util.Scanner;

public class _Answer1 {

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
		
		// 학생 번호를 입력
		int num; // 변수설정
		Scanner sc = new Scanner(System.in); // [입력]
		System.out.println("학생 번호를 입력하세요"); // 번호를 입력하기 위한 안내문구
		num = sc.nextInt(); // 정수입력
		
		// 학생 번호가 팀장 번호인지 아닌지를 판별
		// 3의 배수이면 = 리더 라고 출력 / 아니면 조원 이라고 출력
		// num을 3으로 나누었을때 나머지가 0과 같다면 조장, 아니면 조원으로 출력
		// num % 3 == 0 / 같다로 나오는 것만 스위치문에 넣을 수 있음
		switch(num % 3) {
		case 0: 
			System.out.println(num + "번은 조장입니다");
			break;
		default:
			System.out.println(num + "번은 조원입니다");
			
		}
		
		sc.close();
	}

}

