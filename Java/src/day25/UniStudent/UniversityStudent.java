package day25.UniStudent;

import java.util.Scanner;

public class UniversityStudent {

		int menu;
		private Scanner sc = new Scanner(System.in);
		private Student[] std = new Student[10];
		// 멤버로 할지 지역변수로 할지
		
		private final static int EXIT = 3;
		

	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
	}
	
	public void printMenu() {
		System.out.println("---기능---");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 확인");
		System.out.println("3. 종료");
		System.out.println("메뉴를 선택하세요");
		
	}
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1: // 학생 등록
			register();
			break;
		case 2: // 학생 확인
			search();
			break;
		case 3: 
			System.out.println("시스템이 종료됩니다.");
			break;
		default:
			System.out.println("잘못된 메뉴");
		}
		
	}
	
	private void register() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("학과 : ");
		String major = sc.next();
		System.out.print("학번 : ");
		int num = sc.nextInt();
		
		if()
		//System.out.println("학생정보 : " + name + ", " + major +"학과, 학번 " + num);
	}
	
	/**이름(동명이인이 있을수있겠구나) 또는 학번을 검색하고 확인해야 할 것 같은데....
	 * 매개변수 : String name || int number
	 * 리턴타입 : void
	 * 메소드명 : search */
	private void search(int num) {
		int index = indexOf(num);
//		public int indexOf(String title) {
//			for(int i = 0; i < wordCount; i++) {
//				if(wordList[i].getTitle().equals(title)) {
//					return i;
//				}
//			}
//			return -1;
//		}
		
		
	}

	private int indexOf(int num) {
		// TODO Auto-generated method stub
		return 0;
	}
}


