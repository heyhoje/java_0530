package day26.Library.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import day26.Library.vo.Book;
import day26.Library.vo.LoanBrowsing;

public class LibraryController {
	
	private Scanner sc = new Scanner(System.in);
	// * 도서 리스트
	List<Book> bookList = new ArrayList<>();
	// * 대출 열람 리스트
	List<LoanBrowsing> loanList = new ArrayList<>();
	
	
	private final static int EXIT = 4;
	
	public void run() {
		int menu;
		String bookFileName = "src/day26/Library/book.txt";
		loadBook(bookFileName);
		do {
			// 메뉴 출력
			System.out.println("===========");
			printMenu();
			
			// 메뉴 선택(메뉴를 입력받음) : Scanner 필요
			menu = sc.nextInt();
			
			// 선택된 메뉴에 따른 기능을 실행
			runMenu(menu);
			System.out.println("===========");
			
		}while(menu != EXIT);
		saveBook(bookFileName);
		sc.close();
	}

	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 대출");
		System.out.println("3. 도서 반납");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 : ");
	}
	private void runMenu(int menu) {
		switch(menu) {
		case 1: // 도서등록
			insertBook();
			break;
		case 2: // 대출
			loanBook();
			break;
		case 3: // 반납
			returnBook();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 선택");
		
		}
	}

	public void insertBook() {
		System.out.println("도서 등록 기능 구현");
		sc.nextLine(); // 위에 한번만 엔터에의한 공백 없애주면됨.
		// 도서 정보 입력
		System.out.print("도서 번호 : ");
		String num = sc.nextLine();
		System.out.print("도서 제목 : ");
		String title = sc.nextLine();
		System.out.print("도서 저자 : ");
		String author = sc.nextLine();
		System.out.print("ISBN	 : ");
		String isbn = sc.nextLine();
		System.out.println("------------");
		System.out.println("도서등록이 완료되었습니다.");
		
		// * 입력 정보를 이용하여 도서 객체를 생성
		Book book = new Book(num, title, author, isbn);
		
		// * 도서 리스트에 도서 객체를 추가
		bookList.add(book);
		// System.out.println(bookList); // 테스트용 보여주기
	}

	
	private void loanBook() {
		// 1. 빌릴 수 있는 도서 목록
		
		Stream<Book> stream = bookList.stream(); // 리스트를 이용해서 스트림만듬 -> 람다식 이용해서 필터
		stream
			.filter(b->!b.isLoan()) // 대출 가능한 도서만 추출 // 불리안은 is로, 대출되지 !않은
			.forEach(b->{ 			// 추출한 도서를 출력
				System.out.println("==============");
				System.out.println(b);
				System.out.println("==============");
			}); 
		
//		for(Book tmp : bookList) {
//			if(!tmp.isLoan()){
//				System.out.println("==============");
//				System.out.println(tmp);
//				System.out.println("==============");
//			}
//		}
		// 2. 도서 번호를 입력
		sc.nextLine(); // 위에 한번만 엔터에의한 공백 없애주면됨.
		System.out.println("대출할 도서 번호 : ");
		String num = sc.nextLine();
		
		// 3. 대출을 신청
		// 도서 번호가 올바른지 확인
		// 번호에 맞는 도서가 있는지 확인 
		// 도서가 없으면 올바르지 않음
		// 도서가 있으면 대출중인지 확인
		boolean possible 
			= bookList
				.stream()
				.filter(b->!b.isLoan() && b.getNum().equals(num))
				.count() > 0;
		// 올바르지않으면(없는 도서 번호이거나, 대출중인 도서인 경우)
		// 대출할 수 없다고 출력
		if(!possible) {
			System.out.println("대출할 수 없습니다.");
			return;
		}
		// 올바르면 대출을 진행
		// 도서 대출 객체를 생성. (도서, 대출일, 대출기간)
		int index = bookList.indexOf(new Book(num, null, null, null));
		Date loanDate = new Date();
		LoanBrowsing lb 
		= new LoanBrowsing(bookList.get(index) , loanDate, 14);
		
		// 대출열람 리스트에 추가
		loanList.add(lb);
		bookList.get(index).loanBook();// 도서에 대출했다고 수정
		// 대출일을 출력
		System.out.println("대출일 : " + lb.getLoanDateStr());
		// (반납예정일도 출력)
		
		
//		sc.nextLine();
		// 빌리려는 도서 번호 입력
//		System.out.print("대출할 도서 번호 : ");
//		String chNum = sc.nextLine();
//		if(bookList.(false)) {
//			System.out.println("해당 도서는 대출 상태입니다.");
//			return;
//		}
//		System.out.println("대출이 완료 되었습니다.");
//		
//		// 대출로 상태 변경? 
//		
	}
	
	private void returnBook() {
		sc.nextLine(); // 위에 한번만 엔터에의한 공백 없애주면됨.
		System.out.println("반납할 도서 번호 : ");
		String num = sc.nextLine();
		
		boolean possible 
		= bookList
			.stream()
			.filter(b->b.isLoan() && b.getNum().equals(num));
		
//		sc.nextLine();
//		// 반납하려는 도서 번호 입력
//		System.out.print("반납할 도서 번호 : ");
//		String chNum = sc.nextLine();
//		
//		System.out.println("반납이 완료 되었습니다.");
//
//		// 대출 가능으로 상태 변경
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	private void saveBook(String fileName) {
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
				// 절대경로 : D:\\.student / 상대정보(프로젝트 기준)
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				// 모든 보조스트림은 기반스트림이 필요하다
				for(Book tmp : bookList) {
					oos.writeObject(tmp);
					//public class Student implements Serializable {
					//** add generated sirialversionUID
				}
		} catch (IOException e) {
			e.printStackTrace();
			}		
	}

	private void loadBook(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				try {
					Book tmp = (Book)ois.readObject();
					bookList.add(tmp);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
			// 예외를 이용해서 파일읽기를 마무리 / IOException이 부모클래스라 위에 배치
		} catch(EOFException e) {
			System.out.println("불러오기 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}		
		System.out.println(bookList);		
	}
}
