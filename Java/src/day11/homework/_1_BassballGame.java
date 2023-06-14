package day11.homework;

import java.util.Scanner;

public class _1_BassballGame {

	public static void main(String[] args) {
		// 1. 숫자 야구 게임을 구현하세요
		// 1 ~ 9 사이의 중복되지 않은 세 수를 맞추는 게임
		// 규칙 : 
		/* B : 같은 숫자가 있지만 위치가 다름
		 * S : 같은 숫자가 있고 위치가 같음
		 * 3O : 일치하는 숫자가 하나도 없음
		 */
		
		// 1 ~ 9 사이의
		int min = 1, max = 9;
		int [] arr = new int[3];
		
		// 중복되지 않은 랜덤한 3 정수 출력
 		boolean checkArr[] = new boolean[10];
 		//자료형 변수/배열	   = new 자료형[개수]
 		
 		// 랜덤한 정수 3개
 		System.out.println("야구 게임 시작!");
		int i;
		for(i = 0; i < 3; ) {
			int random = (int)(Math.random()*(max - min + 1) + min);
			if(!checkArr[random]) {
			arr[i] = random;
			i++;
			checkArr[random] = true;
			}
		}
		for(i = 0; i < 3; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		System.out.println("-------");
		
		// 사용자가 입력한 수
		// int num1, num2, num3;
		int [] baseball = new int[3];
		
		Scanner sc = new Scanner(System.in);
		// num1 = sc.nextInt();
		System.out.println("정수 3개를 입력하세요 : ");
		
		for(i = 0; i < 3; i++) {
			baseball[i] = sc.nextInt();			
		}
		for(i = 0; i < 3; i++) {
			System.out.print(baseball[i] + " ");
		}
		
		sc.close();
	}
	
	// 규칙 : 
			/* B : 같은 숫자가 있지만 위치가 다름
			 * S : 같은 숫자가 있고 위치가 같음
			 * 3O : 일치하는 숫자가 하나도 없음
			 */
	
	/** 기능 : 중복되는 / 같은 숫자가 있는지 확인하는 메소드
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 메소드명 : 
	 * 
	 */
	
	/** 기능 : 숫자의 위치가 같은지 확인하는 메소드
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 메소드명 : 
	 * 
	 */

}
