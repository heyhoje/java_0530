package day13.homework.controler;

import java.util.Scanner;
import day13.homework.ValueObject.VocabularyNote;

// 강사 깃헙 보고 비교&추가수정 필요

public class VocabularyNoteController {

	//import가 필요한 녀석들... 왜 번거롭게해...?
	private Scanner sc = new Scanner(System.in); // 밑에 많이 쓰이니까 멤버로
	private VocabularyNote note = new VocabularyNote(); // 컨트롤러의 멤버로
	
	
	public void run() {
		//반복(종료를 선택하기 전까지) => 무조건 1번은 실행(do-while문)
		// do-while문 = 콘솔프로그램 할때만 사용되고 잘 안씀
		
		int menu = -1;
		
		do {// 1. 메뉴출력
			printMenu(); // 나중에 메뉴가 달라지면, run으로 갈필요없이 printMenu만 수정하면됨
			
			// 2. 메뉴 선택
			menu = sc.nextInt();
			//menu = sc.next().charAt(0); //문자 인것도 있잖아..?
		
			// 5. 메뉴에 따른 기능 실행
			runMenu(menu);
			
		}while(menu != 5); // 선택한 메뉴가 5가 아닐때까지
		
		sc.close();
	}
	// 메소드안에 코드들을 메소드로 구현하면 구조/코드 파악이 쉬워짐. 이해하기 쉬워짐
	// 주석대로 볼 수 있도록 메소드로 만들어보자
	
	// 메소드1 : 메인메뉴 출력
	/** 기능 : 메뉴를 출력하는 메소드
	 * 매개변수 : (고정된 메뉴) 없음
	 * 리턴타입 : (출력) 없음
	 * 메소드명 : printMenu
	 */
	private void printMenu() { // 해당 클래스 안에서만 하면 됨
	System.out.println("영어 단어장");
	System.out.println("1. 단어 추가");
	System.out.println("2. 단어 삭제"); //삭제기능 재확인 필요
	System.out.println("3. 단어 수정");
	System.out.println("4. 단어 출력");
	System.out.println("5. 프로그램 종료");
	System.out.print("메뉴를 선택하세요 : ");
	
	}
	
	// 메소드2 :
	/** 기능 : 메뉴에 따른 기능을 실행하는 메소드
	 * 매개변수 : 메뉴 => int menu
	 * 리턴타입 : (안에서 실행) 없음 => void
	 * 메소드명 : runMene
	 */
	
	// 업무분담
	private void runMenu(int menu) {
		// 조건문 (Switch / in)
		switch(menu) {
		// 메뉴가 1이면 단어 추가 기능을 실행
		case 1: 
			System.out.println("----------");
			//System.out.println("단어 추가 기능 실행");
			insertWord();
			System.out.println("----------");
			break;
			
		// 메뉴가 2이면 단어 삭제 기능을 실행
		case 2: 
			System.out.println("----------");
			deleteWord();
			// System.out.println("단어 삭제 기능 실행");
			System.out.println("----------");
			break;
		// 메뉴가 3이면 단어 수정 기능을 실행
		case 3: 
			System.out.println("----------");
			updateWord();
			// System.out.println("단어 수정 기능 실행");
			System.out.println("----------");
			break;
		// 메뉴가 4이면 단어 출력 기능을 실행
		case 4: 
			System.out.println("----------");
			//System.out.println("단어 출력 기능 실행");
			printWord();
			System.out.println("----------");
			break;
		// 메뉴가 5이면 프로그램 종료
		case 5: 
			System.out.println("----------");
			System.out.println("프로그램 종료");
			System.out.println("----------");
			break;
		// 메뉴가 그외이면 잘못된 메뉴라고 출력 
		default:
			System.out.println("----------");
			System.out.println("잘못된 메뉴 선택입니다.");
			System.out.println("----------");
		}
		
	}
	
	// 메소드4 : 단어/의미 추가
	private void insertWord() {
		// 추가할 단어를 입력
		System.out.print("단어 : ");
		String title = sc.next();
		
		// 단어에서 입력한 엔터를 처리
		sc.nextLine(); // 공백을 포함하는 기능, 안써봐서 어색할 수 있음.
		
		// 추가할 뜻을 입력
		System.out.print("뜻 : ");
		String meaning = sc.nextLine();// 뜻은 여러 단어로 설명, 공백이 포함될 수 있기 떄문
		
		// 단어장에 추가 ->note 멤버변수로 만듬
		int result = note.insert(title, meaning);
		// note.print(); // 단어 출력기능을 구현 안했지만 확인하기 위해
		// > 아래 스위치로 프린트함
		
		switch(result) { // switch(note.insert(title, meaning)) { 로 바로 가능
		case 1: System.out.println("단어 추가 성공!");	 break;
		case 0: System.out.println("단어 추가 실패!");  break;
		case -1: System.out.println("의미 추가 성공!"); break;
		}
	}
	
	// 메소드6 : 서브메뉴 출력
	private void printWord() {
		// 서브메뉴 출력
		printSubMenuPrint();
		
		// 서브메뉴 선택
		int submenu = sc.nextInt();
		
		// 서브메뉴가 1이면 전체 출력
		// 서브메뉴가 2이면 검색
		switch(submenu) {
		case 1: note.print(); // 전체 출력
				break;
		case 2: 
			// 검색할 단어
			System.out.print("검색 단어 : ");
			String title = sc.next();
			// 출력
			note.search(title);
			break;
		}	
	}
	
	// 메소드7 : 단어 삭제
	private void deleteWord() {
		// 삭제할 단어 입력
		System.out.print("삭제 단어 : ");
		String title = sc.next();
		
		// 해당 단어 삭제
		if(note.delete(title)) {
			System.out.println("단어 삭제 완료!");
		}else {
			System.out.println("단어 삭제 실패!");
		}
	}
		
	// 메소드5 : 서브메뉴출력 을 출력
	private void printSubMenuPrint() { // 서브메뉴 출력하는것을 출력함(뭔소린지 알겠음?)
		System.out.println("---------");
		System.out.println("서브 메뉴");
		System.out.println("1. 전체 출력");
		System.out.println("2. 단어 검색");
		System.out.print("서브 메뉴 선택 : ");
		System.out.println();
		
	}
	
		// 3. 서브 메뉴가 있으면 서브 메뉴를 출력
		//		ㄴ메뉴에 따른 기능실행
		
		// 4. 서브 메뉴가 있으면 서브 메뉴를 선택
		
	//메소드8 : 업데이트
	private void updateWord() {
		// 서브메뉴 출력
		printSubMenuUpdate();
		
		// 서브메뉴 입력
		int submenu = sc.nextInt();
		
		// 서브메뉴에 따른 기능 실행
		switch(submenu) {
		case 1: 
			// 단어 수정
			// 수정할 단어
			System.out.print("수정할 단어 : ");
			String word = sc.next();
			// 수정될 단어
			System.out.print("수정될 단어 : ");
			String updateWord = sc.next();
			
			// 단어장에 있는 단어 수정기능을 실행
			if(note.updateTitle(word, updateWord)) { // 강사깃헙 확인 필요.. vo.VocaabublartyNote
				System.out.println("단어 수정 성공!");
			}else {
				System.out.println("단어 수정 실패!");
			}
			break;
			
			// 뜻 수정
		case 2:  
			// 뜻을 수정할 단어를 입력
			System.out.print("단어 : ");
			String title = sc.next();
			
			// 단어를 출력하고, 단어가 없으면 안내문구 출력 후 종료
			if(!note.search(title)) {
				System.out.println("없는 단어입니다.");
				return;
			}
			// 수정할 뜻의 번호를 입력
			System.out.print("수정할 뜻 번호 선택 : ");
			int num = sc.nextInt();
			
			sc.nextLine(); // *엔터 처리
			// 수정될 뜻을 입력
			System.out.print("수정할 뜻");
			String meaning = sc.nextLine(); // * nextLine전에 엔터처리
			
			// 단어장에서 수정
			if(!note.updateMeaning(title, num, meaning)) {
				System.out.println("뜻 수정 실패");
			}else {
				System.out.println("뜻 수정 성공");
			}
			break;
			
		// 뜻 삭제
		case 3:  
			// 뜻을 수정할 단어를 입력
			System.out.print("단어 : ");
			String title2 = sc.next();
			
			// 단어를 출력하고, 단어가 없으면 안내문구 출력 후 종료
			if(!note.search(title2)) {
				System.out.println("없는 단어입니다.");
				return;
			}
			// 수정할 뜻의 번호를 입력
			System.out.print("삭제할 뜻 번호 선택 : ");
			int num2 = sc.nextInt();
			if(!note.deleteMeaning(title2, num2)) {
				System.out.println("뜻 삭제 실패!");
			}else {
				System.out.println("뜻 삭제 성공!");
			}
			break;
		}
	}
	private void printSubMenuUpdate() {
		System.out.println("서브메뉴");
		System.out.println("1. 단어 수정");
		System.out.println("2. 뜻 수정");
		System.out.println("3. 뜻 삭제");
		System.out.println("서브 메뉴 선택 : ");
		
	}
}
