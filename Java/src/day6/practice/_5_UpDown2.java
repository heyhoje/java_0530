package day6.practice;

import java.util.Scanner;

public class _5_UpDown2 {

	public static void main(String[] args) {
		// 2. UpDown게임을 하는 코드를 작성하세요
//		1~100 사이의 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구현하세요. *RandomEx 활용
		// 한 판이 끝나면 더할건지를 물어서 n을 입력하면 종료, y를 입력하면 이어서 게임이 진행.
		
		int min = 1, max = 100;
		char menu = 'y'; // *
		int num;
		Scanner scan = new Scanner(System.in);

		int random = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(random);
		
//		System.out.println(random);
//		System.out.println("랜덤한 수 : " + random);
//		System.out.println("----------");
		while(menu != 'n') { //*
			num = 0; // 0으로 초기화 = while 조건문에서 해당 변수 초기화 하라고 해서 함
			while(num != random) {
				System.out.println("1~100 사이 정수를 맞추시오.");
				System.out.println("숫자 입력 : ");
				num = scan.nextInt();
		
		// 내가 부른 숫자 num, 맞춰야할 숫자 random
				if(random == num) {
					System.out.println("GOOOOOD!!");
				}else if(random < num) {
					System.out.println("DOWN!");
				}else {
					System.out.println("UP!");
				}
			}
			System.out.println("계속하시겠습니까? : "); // *
			menu = scan.next().charAt(0);// *
		}
		scan.close();
	}

}
