package review_0706.library.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import review_0706.library.vo.Book;

public class LibraryController {
	
	private Scanner sc = new  Scanner(System.in);
	private final static int EXIT = 4;
	
	List<Book> bookList = new ArrayList<>();
	
	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt(); 
			runMenu(menu);
		}while(menu != EXIT);
	}
	
	public void printMenu() {
		System.out.println("----------");
		System.out.println("메뉴");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 대출");
		System.out.println("3. 도서 반납");
		System.out.println("4. 종료");
		System.out.println("메뉴 선택 : ");
		System.out.println("----------");
	}
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1: // 도서 등록
			insertBook();
			break;
		case 2: // 도서 대출
			loanBook();
			break;
		case 3: // 도서 반납
			returnBook();
			break;
		case 4: // 종료
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 입니다.");
				
		}
		
	}
	// 메소드1: 도서 등록
	private void insertBook() {
		sc.nextLine();
		System.out.print("도서 번호 : ");
		String num = sc.nextLine();
		System.out.print("도서 제목 : ");
		String title = sc.nextLine();
		System.out.print("도서 저자 : ");
		String author = sc.nextLine();
		System.out.print("ISBN : ");
		String isbn = sc.nextLine();
		
		Book book = new Book(num, title, author, isbn);
		
		if(bookList.contains(book)) {
			System.out.println("이미 등록된 도서 번호입니다. 확인해주세요.");
			return;
		}
		
		bookList.add(book);
		System.out.println(bookList);
		
	}

	// 메소드2 : 도서 대출
	private void loanBook() {
		// 1. 빌릴수 있는 도서 목록
//		Stream<Book> stream = bookList.stream();// 리스트를 이용해서 스트림만듬 -> 람다식 이용해서 필터
//		stream
//			.filter(b -> b.isLoan())
//			.forEach(b -> {
//				System.out.println("----------");
//				System.out.println(b);
//				System.out.println("----------");
//			});
		for(Book tmp : bookList) {
			if(!tmp.isLoan) {
				System.out.println("----------");
				System.out.println("----------");
			}
		}
		// 2. 도서 번호를 입력
		sc.nextLine();
		System.out.println("대출할 도서 번호 : ");
		String num = sc.nextLine();
		
		// 3. 대출을 신청
		// 도서 번호가 올바른지/ 번호에 맞는 도서가 있는지/ 도서가 있으면 대출중인지 확인
		boolean possible = bookList
				.stream()
				.filter(b->!b.isLoan() && b.getNum().equals(num))
				.count() > 0;
	}

	// 메소드3 : 도서 반납
	private void returnBook() {
		// TODO Auto-generated method stub
		
	}

}
