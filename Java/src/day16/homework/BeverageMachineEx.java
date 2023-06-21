package day16.homework;

import java.util.Scanner;

public class BeverageMachineEx {

	public static void main(String[] args) {
		//1. 음료수를 뽑는 자판기 프로그램을 작성하세요
		// 단 음료수 자판기에 음료수는 사이다, 콜라 환타가 고정(메뉴 추가x)이라고 가정.
		// 메뉴를 선택하면 음료수와 잔액이 나옴(출력)
		
		/* 메뉴
		 * 1.금액 투입
		 * 2. 메뉴 선택
		 * 3. 제품 입고
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 
		 * 1. 사이다
		 * 2. 콜라
		 * 3. 환타
		 * 음료 선택 : 1
		 * 사이다를 선택했습니다.
		 * 사이다가 나옵니다 [금액이 충분한 경우]
		 * 잔돈 xxx가 나옵니다.
		 * 금액이 부족합니다. [금액이 부족한 경우]
		 * 잔돈 xxx이 나옵니다.
		 */
		
		int money;
		int menu = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			// 메뉴 출력 및 선택
			System.out.println("메뉴");
			System.out.println("1. 금액 투입");
			System.out.println("2. 메뉴 선택");
			System.out.println("3. 제품 입고");
			System.out.println("4. 프로그램 종료");
			System.out.println("메뉴를 선택하세요 : ");
			menu = sc.nextInt(); // 이거 안썼다고 무한루프 걸리는구나;;;
			
			// 선택한 메뉴에 따른 출력문 실행
			switch(menu) {
			case 1: 
				System.out.println("1. 금액을 투입하세요");
				break;
			case 2:
				System.out.println("2. 메뉴 선택");
				break;
			case 3:
				System.out.println("3. 제품 입고");
				break;
			case 4: 
				System.out.println("4. 프로그램 종료");
				break;
			}
		} while(menu != 4);
		
		sc.close();
		
	}

}
