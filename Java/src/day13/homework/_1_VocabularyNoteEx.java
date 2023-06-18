package day13.homework;

import java.util.Scanner;

import day12.practice.VocabularyNote;
import day12.practice.Word;

public class _1_VocabularyNoteEx {

	public static void main(String[] args) {
		// day12.practice 활용. 더 실제로 사용 가능하도록....
		
		// 1. 영어 단어장 프로그램을 구현하세요
		// Word, VocabularyNote 클래스 이용
		
		/*메뉴
		 * 1. 단어 추가
		 * 2. 단어 삭제
		 * 3. 단어 수정
		 * 	 a. 단어 수정
		 *   b. 뜻 수정
		 *   c. 뜻 삭제
		 * 4. 단어 출력
		 *   a. 전체 출력
		 *   b. 검색
		 * 5. 프로그램 종료
		 */
		
//		메뉴문 출력
//		메뉴 선택
//		서브메뉴 나옴
//		서브메뉴선택
//		수정할 단어 / 수정될 단어 
//		수정에 성공했습니다
		
		int menu = 0;
		Scanner sc = new Scanner(System.in);
		
		//메인 메뉴를 출력 및 선택
		// 배열로 하고, 다 메소드 호출로 해야하나?
		// 서브메뉴들은 어떡하지? >> if로 빼버림. 상위 메뉴랑 같이 잘.. 출력됨
		System.out.println("영어 단어장");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 삭제");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 출력");
		System.out.println("5. 프로그램 종료");
		System.out.println("메뉴를 선택하세요 : ");
		
		Word wordList[] = {
				new Word("abc"),
				new Word("def", "def is define")
		};
		VocabularyNote note = new VocabularyNote(wordList);
		
		do {
			
			//메뉴를 입력
			menu = sc.nextInt();

			//선택한 메뉴에 따른 출력문 실행
			switch(menu) {
			case 1: 
				System.out.println("1. 단어 추가");
				
				break;
			case 2:
				System.out.println("2. 단어 삭제");
				break;
			case 3: 
				System.out.println("3. 단어 수정");
				
				break;
			case 4:
				System.out.println("4. 단어 출력");
				
				break;
			case 5:
				System.out.println("5.프로그램 종료");
				break;
			}		
				
		}
		while(menu != 5);
			
		if(menu == 3) {
			System.out.println("a. 단어 수정");
			System.out.println("b. 뜻 수정");
			System.out.println("c. 뜻 삭제");
			System.out.println("서브 메뉴를 선택하세요 : ");
		}
		if(menu == 4) {
			System.out.println("a. 전체 출력");
			System.out.println("b. 검색");
			System.out.println("서브 메뉴를 선택하세요 : ");
			
		sc.close();
		}
		
	}
	
	/** 기능 : 메인메뉴를 선택
	 * 매개변수 : int num
	 * 리턴타입 : void??
	 * 메소드명 : selectMain
	 */
	
	/** 기능 : 서브메뉴를 선택
	 * 매개변수 : int num
	 * 리턴타입 : void??
	 * 메소드명 : selectSub
	 */
}
