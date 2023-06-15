package day11.homework;

import java.util.Scanner;

import array.Array;

public class _Answer1 {

	public static void main(String[] args) {
		// 1. 숫자 야구 게임을 구현하세요
		// 1 ~ 9 사이의 중복되지 않은 세 수를 맞추는 게임
		// 규칙 : 
		/* B : 같은 숫자가 있지만 위치가 다름
		 * S : 같은 숫자가 있고 위치가 같음
		 * 3O : 일치하는 숫자가 하나도 없음
		 * => 3S를 만드는게 목적!
		 */
		
		// 1. 맞춰야할 숫자 3개를 랜덤으로 생성(중복x)!
		int com[] = new int[3]; // 랜덤으로 생성된 수를 저장할 배열
		int user[] = new int[3]; // 사용자가 입력한 수를 저장할 배열
		int min = 1, max = 9;
		int strike = 0; // 스트라이크 개수
		int ball = 0; // 볼의 개수  // 아웃은 카운트 안해도됨
		
 		// 랜덤한 정수 3개
		Scanner sc = new Scanner(System.in);
		
 		System.out.println("야구 게임 시작!");
 		Array.createRandomArray(min, max, com);
		Array.printArray(com); // 판정이 제대로 되는지 테스트 해보고, 나중에 주석처리
		
		// 4. 반복문(여러번 입력하고 판별해야함)
		do {
			// 사용자가 숫자 3개를 입력
			System.out.println("user : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			// 사용자 입력 체크/중복되면 판별할 필요 없음
			if(Array.arrayCheck(user)) {
				System.out.println("중복된 수를 입력하지 마세요!");
				continue;
			}
			
			// 3. 판별!
			strike = 0;
			ball = 0;
			
			// 스트라이크 개수 판별/ 메소드1
			strike = strike(com,user);
			System.out.println("S : " + strike);
			
			// 볼의 개수 판별
			ball = ball(com, user);
			System.out.println("B : " + ball);
			
			// 스트라이크와 볼의 개수에 맞게 출력
			printResult(strike, ball);
	
			
		} while(strike < 3);
		
		System.out.println("Good!");
		sc.close();
		
	}

	// 메소드1 = strike 판별
	/** 기능 : 스트라이크 개수를 판별하는 메소드
	 * => 두 배열에서 같은 번지에 있는 값들이 몇개 같은지 알려주는 메소드
	 * 매개변수 : 두 배열 => int arr1[], int arr2[]
	 * 리턴타임 : 같은 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 int
	 * 메소드명 : strike 
	 */
		
	public static int strike(int arr1[], int arr2[]) {
		//예외처리, 일하는 입장에서는 배열이 몇개짜리가 들어올지 모름
		// 배열 생성이 안된 배열이 1이라도 있으면 비교할 수 없어서 0을 리턴
		if(arr1 == null || arr2 == null) {
			return 0; // 비어있는것도 고려
		}
		
		// 배열의 개수가 다른 경우 작은 크기의 배열을 기준으로 비교하기 위해 size 계산
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
				// 작은 크기를 기준으로 (안정적으로 처리하는게 좋다)
				// 두개의 개수가 다를 수 있는것도 고려
		
		int count = 0; // 스트라이크 개수
		for(int i = 0; i < size; i++) {
			// 같은 번지에 있는 값들이 서로 같으면(스트라이크)
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;// 몇개가 일치하는지 알려줌
	}
	// 메소드2 : 볼의 개수 판별
	/** 기능 : 볼의 개수를 판별하는 메소드
	 * => 같은 숫자가 있고 위치가 다른 값들이 몇개 같은지
	 * => 두 배열에서 다른 번지에 있는 값들이 몇개 같은지 알려주는 메소드
	 * 매개변수 : 두 배열 => int arr1[], int arr2[]
	 * 리턴타임 : 같은 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 int
	 * 메소드명 : ball
	 */
	public static int ball(int arr1[], int arr2[]) {
		//배열 생성이 안된 배열이 1이라도 있으면 비교할 수 없어서 0을 리턴
		if (arr1 == null || arr2 == null) {
			return 0;
		}
		int count = 0;
		// 다른 번지를 비교해서 찾아도 되지만
		// 두 배열에서 같은 숫자의 개수에서 스트라이크 개수를 빼면 볼의 개수

		// 향상된 for문
		for(int tmp : arr1) {
			// 두 배열에서 
			// 배열 1에서 꺼낸 값(tmp)이 arr2에 있으면 개수를 증가
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1, arr2); // 왜 이 계산법이 나오는지 이해안됨
	}
	
	// 메소드3 : 
	/** 기능 : 스트라이크와 볼의 개수가 주어지면 결과를 출력하는 메소드
	 * 매개변수 : 스트라이크 개수, 볼의 개수 => int strike, int ball
	 * 리턴타입 : (출력) 없음 => void
	 * 메소드명 : printResult
	 */
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("3OUT");
		}
		System.out.println();
	}
	
	
		
		// 다른 숫자?? 정석 코드
		// 위의 리턴 = 이중반복문을 이용해서 다른 번지를 비교하는 코드!
//		for(int i = 0; i < arr1.length; i++) {
//			for(int j = 0; j < arr2.length; j++) {
//				//같은 번지면 건너뛰고
//				if(i == j) {
//				continue;
//				}
//				if(arr1[i] == arr2[i]) {
//					count++;
//				}
//			}
//		}
//		return count;
	
	
	//com  1 2 3   => 범위를 넘어가는 예외처리
	//user 4 5 6 7 => size신경쓸 필요 없음
	
	// 1 2 3
	// 1 4 2 
	// contains 
}
		

	
	// 규칙 : 
			/* B : 같은 숫자가 있지만 위치가 다름
			 * S : 같은 숫자가 있고 위치가 같음
			 * 3O : 일치하는 숫자가 하나도 없음
			 */
	
	/** 기능 : 중복되는 / 같은 숫자가 있는지 확인하는 메소드
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 메소드명 : checkNum
	 * 
	 */
	
	/** 기능 : 숫자의 위치가 같은지 확인하는 메소드
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 메소드명 : 
	 * 
	 */


