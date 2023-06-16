package day12.homework;

import java.util.Scanner;

import array.Array;

public class _Answer1 {

	public static void main(String[] args) {
		// 1. 로또 번호(45개)를 생성하고, 
		// 2. 사용자가 번호를 입력하면 
		// 3. 몇등인지 출력하는 코드를 작성하세요
		
		/* 1등 : 번호 6개
		 * 2등 : 번호 5개 + 보너스
		 * 3등 : 번호 5개
		 * 4등 : 번호 4개
		 * 5등 : 번호 3개
		*/
		
		// computer : 보너스 포함 7개
		// user : 6개

		// 1. 랜덤으로 로또번호 6개와 보너스 번호 1개 생성(중복x)
			// 7개짜리 배열에 로또번호를 생성하고, 앞에 6개는 로또번호, 마지막 1개는 보너스로 활용
		
		// 7개짜리 배열에 로또번호를 생성
		int lotto[] = new int [7];
		Array.createRandomArray(1, 45, lotto);
		
		//마지막 1개는 보너스로
		int bonus = lotto[6];
		int lotto2[] = new int[6];
		// 앞에 6개는 로또번호
		System.arraycopy(lotto, 0, lotto2, 0, 6);
		Array.sort(lotto2); // * 버블 정렬
		
		System.out.print("로또번호 : ");
		Array.printArray(lotto);
		System.out.println("보너스 번호 : " + bonus);
		
		System.out.println("-----l o t t o------");
		// 2. 사용자가 번호를 6개 입력
		Scanner sc = new Scanner(System.in); //입력받으려면 알죠?
		int user[] = new int[6];
		
		System.out.println("이번주 로또번호 6개를 고르세요!");
		System.out.println("사용자 : ");
		for(int i = 0; i < user.length; i++) {
			user[i] = sc.nextInt();
		}
		
		// 4. 중복입력하면 판별을 안함(추가적인 것)
		if(Array.arrayCheck(user)) {
			System.out.println("중복된 값을 입력했습니다");
			return;
		}
		
		// 3. 등수 판별(switch?)
		int count = count(lotto2, user);
		printResult(count, Array.contains(user, bonus, user.length));
		
		//System.out.println("축하합니다. " + printResult + " 당첨입니다!");
//		System.out.println(count(lotto2, user) + "개");
//		System.out.println("축하합니다. 등 입니다");
		
	}
	
	// 메소드1 : 몇개 맞췄는지
	/** 기능 : 로또번호와 사용자 번호가 주어지면 몇개가 같은지 알려주는 메소드
	 * 매개변수 : 로또번호, 사용자번호, count => int lotto[], int user[]
	 * 리턴타입 : 몇개 같은지 => 정수 -> int
	 * 메소드명 : count
	 */
	
	public static int count(int lotto[], int user[]) {
		if(lotto == null || user == null) {
			return 0;
		}
		// 아니면 반복문으로 작업
		int count = 0;
		// for(int i = 0 , i < lotto.length, i++) // 향상된 for문이 더 깔끔
		for(int tmp : lotto) { // 로또에서 하나 꺼내서
			if(Array.contains(user, tmp, user.length)) {
				count++;
			}
		}
		return count;
	}
	
	/** 기능 : 일치하는 개수와 보너스번호와 사용자 번호가 일치하는지 여부를 알려주면,
	 * 		  등수를 출력하는 메소드
	 * 매개변수 : 일치하는 개수, 보너스 번호와 일치여부 
	 * 			=> int count, boolean checkBonus 
	 * 리턴타입 : (출력만) 없음 => void
	 * 메소드명 : printResult
	 */
	
	public static void printResult(int count, boolean checkBonus) {
		switch(count) {
		case 6:
			System.out.println("1등");
			break;
		case 5:
			if(checkBonus) {
			System.out.println("2등");
			}else {
			System.out.println("3등");
			}
			break;
		case 4:
			System.out.println("4등");
			break;
		case 3:
			System.out.println("5등");
			break;
		default:
			System.out.println("꽝입니다");
		}
		
	}
	
	
	
}
