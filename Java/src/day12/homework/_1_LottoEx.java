package day12.homework;

import java.util.Scanner;

import array.Array;

public class _1_LottoEx {

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
		// user : 6개ㅑ

		// 1. 뽑아야할 숫자 7개, 6개를 랜덤으로 생성(중복x) 
		int lotto[] = new int[7]; // 보너스도 숫자니까 7개 뽑는거지?ㅇㅇ
		//int bonus[] = new int[1];
		int user[] = new int[6]; // lotto가 뽑은 숫자랑 몇개 같은지, 순서 상관없이
		
		int min = 1, max = 45; // 번호는 1부터 45까지 
		int bonus = lotto[6];
		int lotto2[] = new int[6]; 
		
//		System.out.println(bonus);
//		System.out.println(lotto2); // 그저 번호를 알고 싶었을 뿐인디, 주소값이 나와버리는듯...??
		
		// 콘솔창 입력
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이번주 로또 번호 6개!");
		Array.createRandomArray(min, max, lotto); 
		Array.printArray(lotto);
		System.out.println("보너스 번호 : " + bonus);
		
		// 마지막 나온 숫자를 보너스라고해?? 보너스만 따로 뽑아야할거같은데
		//Array.createRandomArray(min, max, bonus); 
		//Array.printArray(bonus);
		
		// ㄴ 이렇게 하면 로또번호랑 보너스번호랑 중복발생.. 
		// 어떻게 보너스를 보너스라고 알려줘서 2등을 골라내지?
		// ㄴ 로또가 뽑은 번호 제외하고, 하나만 더 뽑아달라고 하면 안됨???
		
		// 2+3. 반복문(여러번 입력하고 판별해야함)
//		do {
//			// 2. 사용자가 숫자 3개를 입력
//			System.out.println("user : ");
//			for(int i = 0; i < user.length; i++) {
//				user[i] = sc.nextInt();
//			}
//			// 사용자 입력 체크/중복되면 판별할 필요 없음
//			if(Array.arrayCheck(user)) {
//				System.out.println("중복된 수를 입력하지 마세요!");
//				continue;
//			}
//		
//			// 3. 판별
//			normal = 0;
//			bonus = 0;
//			
//		} while();
			
		System.out.println("축하합니다. 등 입니다");
		sc.close();
	}
	
	
}
