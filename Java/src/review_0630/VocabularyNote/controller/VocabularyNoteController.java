package review_0630.VocabularyNote.controller;

import java.util.Scanner;

import review_0630.VocabularyNote.vo.VocabularyNote;

public class VocabularyNoteController {
	
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

//			메뉴문 출력
//			메뉴 선택
//			서브메뉴 나옴
//			서브메뉴선택
//			수정할 단어 / 수정될 단어 
//			수정에 성공했습니다
	
	int menu;
	private Scanner sc = new Scanner(System.in);
	private VocabularyNote note = new VocabularyNote();
	public final static int EIXT = 5;
	
	public void run() { // 전체적인 실행할 내용
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EIXT);
	}
	public void printMenu() {
		System.out.println("===========");
		System.out.println("메뉴");
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 삭제");
		System.out.println("3. 단어 수정");
		System.out.println("4. 단어 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
		System.out.println("===========");
		
	}
	public void runMenu(int menu) {
		switch(menu) {
		case 1: // 단어 추가
			insertWord();
			break;
		case 2: // 단어 삭제
			deleteWord();
			break;
		case 3: // 단어 수정
			updateWord();
			break;
		case 4: // 단어 출력
			printWord();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
				
		}
	}
	
	public void insertWord() {
		System.out.print("단어 : ");
		String title = sc.next();
		System.out.print("뜻 : ");
		String meaning = sc.next();

		int result = this.note.insert(title, meaning);
		
		switch(result) {
		case 1: 
			System.out.println("단어 추가 성공!");
		case -1: 
			System.out.println("뜻 추가 성공!");
		case 0:
			System.out.println("단어 추가 실패ㅠ");
			
		}
	}
	
	public void deleteWord() {
		System.out.print("삭제할 단어 : ");
		String title = sc.next();
		
		if(note.delete(title)) {
			System.out.println("단어 삭제 완료!");
		}else {
			System.out.println("단어 삭제 실패ㅠ");
		}
	}
	
	private void printWord() {
		printSubMenuPrint();
		int submenu = sc.nextInt();
		switch(submenu) {
		case 1: // 전체 출력 
			note.print();
			break;
		case 2: // 검색
			System.out.println("검색할 단어 : ");
			String title = sc.next();
			
			note.search(title);
			break;
		}
	}
	
	public void printSubMenuPrint() {
		System.out.println("----------");
		System.out.println("서브 메뉴");
		System.out.println("1. 전체 출력");
		System.out.println("2. 단어 검색");
		System.out.print("서브 메뉴 선택 : ");
	}
	
	private void updateWord() {
		printSubMenuUpdate();
		int submenu = sc.nextInt();
		
		switch(submenu) {
		case 1: // 단어 수정
			System.out.print("수정할 단어 : ");
			String word = sc.next(); // 얘는 왜 word로 가죠????
			System.out.print("수정될 단어 : ");
			String updateWord = sc.next();
			
			if(note.updateTitle(word, updateWord)) {
				System.out.println("단어 수정 성공!");
			}else {
				System.out.println("단어 수정 실패ㅠ");
			}
			break;
			
		case 2: // 뜻 수정
			System.out.print("수정할 단어 : ");
			String title = sc.next();
			
			if(!note.search(title)) {
				System.out.println("없는 단어입니다.");
				return;
			}
			
			System.out.print("수정할 뜻 번호 선택 : ");
			int num = sc.nextInt();
			
			
			sc.nextLine(); // 엔터처리
			System.out.print("수정될 뜻 :");
			String meaning = sc.nextLine();
			
			// 단어장에서 수정
			if(!note.updateMeaning(title, num, meaning)) {
				System.out.println("뜻 수정 실패ㅠ");
			}else {
				System.out.println("뜻 수정 성공!");
			}
			break;
			
		case 3: // 뜻 삭제
			System.out.print("삭제할 단어 : ");
			String title1 = sc.next();
			
			if(!note.search(title1)) {
				System.out.println("없는 단어입니다.");
				return;
			}
			System.out.print("삭제할 뜻 번호 선택 : ");
			int num1 = sc.nextInt();
			if(!note.deleteMeaning(title1, num1)) {
				System.out.println("뜻 삭제 실패ㅠ");
			}else {
				System.out.println("뜻 삭제 성공!");
			}
			break;
		}
		
	}
	private void printSubMenuUpdate() {
		System.out.println("서브 메뉴");
		System.out.println("1. 단어 수정");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.print("서브 메뉴 선택 : ");
		
	}

}
