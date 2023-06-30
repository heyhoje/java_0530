package day22.practice.PhoneListEx.controller;

import java.util.Scanner;

import day22.practice.PhoneListEx.vo.PhoneBook;

public class PhoneList implements Program {
	// 전화번호를 관리하는 프로그램을 작성하세요.
		/* 1. 전화번호 등록
		 * 2. 전화번호 수정
		 * 3. 전화번호 검색
		 * 4. 프로그램 종료
		 * */
	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4;
	
	// 시작하기전에 전화번호부가 필요하구나...~ 리스트 만들필요없음
	// 멤버 등장이요
	private PhoneBook pb = new PhoneBook();
	
	@Override
	public void run() {
		int menu;
		do {
			System.out.println("==========");
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			System.out.println("==========");
		} while(menu != EXIT);
		
		sc.close();
	}
	@Override
	public void printMenu() {
		
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 검색");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴를 선택해주세요 : ");
	}


	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
			insert();
			break;
		case 2: 
			update();
			break;
		case 3: 
			search();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void insert() {
		// 이름과 전화번호를 입력받아야함
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("전화번호 : ");
		String number = sc.next();
		
		// 전화번호부에 추가를 해서 성공하면 성공이라고
		if(pb.insertPhone(name, number)) {
			System.out.println("등록 성공!!");
			// 실실패하면 실패했다고 출력
		} else {
			System.out.println("등록 실패!!");
		}
		
		
	}
	private void update() { // 번호 / 이름 / 번호이름 / 삭제
		// 이름, 수정할 이름, 수정할 전화번호를 입력받아야함
				System.out.print("이름 : ");
				String name = sc.next();
				
				System.out.println("수정할 이름 :");
				String updateName = sc.next();
				
				System.out.print("전화번호 : ");
				String number = sc.next();
				
				// 전화번호부에 수정을 해서 성공하면 성공이라고
				// 실패하면 실패했다고 출력
				if(pb.update(name, updateName, number)) {
					System.out.println("수정 성공!!");
				}else {
					System.out.println("수정 실패");
				}
	}
	
	// 추가 & 수정은 입력과 결과출력만 하면됨(좋은소식 : 기능은 폰북에 다 구현해놨음. )
	
	private void search() {
		// 검색할 이름을 입력하고
		System.out.print("이름 : ");
		String name = sc.next();
		
		// 검색 결과를 출력
		pb.print(s->s.getName().contains(name)); 
		// 람담식 : 이름이 일부 일치해도 검색허용하려고 contains이용해서 구현
		//pb.print(s->s.getName().equals(name)); // 완전히 같으려면 equals
		// pb.print(s->true); // 전체 출력( 무엇을 전체?????? )
	}

}
