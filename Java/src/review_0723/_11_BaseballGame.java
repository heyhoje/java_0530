package review_0723;

import java.util.Scanner;

import array.Array;

public class _11_BaseballGame {

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
		int com[] = new int[3];
		int user[] = new int[3];
		
		int min = 1, max = 9;
		int strike = 0;
		int ball = 0;
		
		// 랜덤한 정수 3개 (입력)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("야구 게임 시작!");
		Array.createRandomArray(min, max, com);
		Array.printArray(com);
		
		// 2. 반복문
		do {
			// 사용자가 숫자 3개를 입력
			System.out.println("숫자 3개를 입력하세요");
			System.out.println("user : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			// 사용자 입력 체크 / 중복되면 판별할 필요 없음
			if(Array.arrayCheck(user)) {
				System.out.println("중복된 수를 입력하지 마세요");
				continue;
			}
		
		// 3. 판별!
			strike = 0;
			ball = 0;	
		// 스트라이크 개수 판별
			strike = strike(com, user);
			System.out.println("S : " + strike);

		// 볼 개수 판별
			ball = ball(com, user);
			System.out.println("B : " + ball);

			
		// 스트라이크와 볼의 개수에 맞게 출력
			printResult(strike, ball);
		}while(strike < 3);
		
		System.out.println("Good!");
		sc.close();
		
	}
	// 메소드1 : strike 판별
	/**기능 : strike 같은 자리에 같은 숫자가 몇개 있는지 확인한다
	 * 매개변수 : arr1[], arr2[]
	 * 리턴타입 : 몇 개 => 정수 int
	 * 메소드명 : strike
	 */
	public static int strike(int arr1[], int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	
	// 메소드2 : ball 판별
	/** 기능 : ball, 다른 자리에 같은 숫자가 몇개 있는지 확인하세요 
	 * 매개변수 : arr1[], arr2[]
	 * 리턴타입 : 몇 개 => 정수 int
	 * 메소드명 : ball
	 */
	public static int ball(int arr1[], int arr2[]) {
		if(arr1 == null||arr2 == null) {
			return 0;
		}
		int count = 0;
		
		for(int tmp : arr1) {
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;				
			}
		}
		return count - strike(arr1, arr2);
	}
	
	// 메소드3: printResult
	/**기능 : 스트라이크 개수와 볼 개수를 프린트한다.
	 * 매개변수 : int strike, int ball
	 * 리턴타입 : 프린트 => void
	 * 메소드명 : printResult
	 */
	private static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.println(strike + "S");
		}
		if(ball != 0) {
			System.out.println(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.println("3OUT!");
		}	
	}
}

// 이 짜식이 틀렸는데 3S라고 거짓말하고 퇴근한다....!!!!!!!! 배열 번지를 모르는 짜식 아닐까? 
/*
 * 야구 게임 시작!
[5, 7, 6]

숫자 3개를 입력하세요
user :
6 5 7

S : 3
B : 0
3S
Good!
 * */
