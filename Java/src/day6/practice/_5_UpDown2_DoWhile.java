package day6.practice;

import java.util.Scanner;

public class _5_UpDown2_DoWhile {

	public static void main(String[] args) {
		// 2. UpDown게임을 하는 코드를 작성하세요
//		1~100 사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요. *RandomEx 활용
		// 한 판이 끝나면 더할건지를 물어서 n을 입력하면 종료, y를 입력하면 이어서 게임이 진행.
		
		int min = 1, max = 100;
		char menu = 'y'; // *
		int num, random;
		Scanner scan = new Scanner(System.in);
		
		/* 외부반복문 : 게임을 더 진행할건지 결정하는 반복문
		 * 반복횟수 : 입력받은 문자가 n이 아니면 반복
		 * 규칙성 : Up Down 게임 한 판 진행
		 * */
		
		do {//랜덤한 수 생성
			random = (int)(Math.random() * (max - min + 1) + min);
			/*내부반복문 : UpDown 게임 진행하는 반복문
			 * 반복횟수 : 입력받은 숫자가 랜덤한 숫자와 일치하지 않으면 반복
			 * 규칙성 : 입력받은 숫자가 정답보다 크면 Down!, 작으면 Up! 맞으면 Goood!을 출력
			 * */	
			System.out.println(random);
			do {
				// 입력
				System.out.println("input : ");
				num = scan.nextInt();
				
				// 판별한 후 결과 출력
				if(num > random) {
					System.out.println("Down!");
				}else if(num < random) {
					System.out.println("Up!");
				}else {
					System.out.println("Goood!");
				}
			}while(random != num);
			//menu를 선택(더 할건지 말건지)
			System.out.println("continue?(y/n) : ");
			menu = scan.next().charAt(0);
		}while(menu != 'n');
		
		
		scan.close();
		
	}
	
}
