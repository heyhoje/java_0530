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
		System.out.println("�޴�");
		System.out.println("1. ���� ���");
		System.out.println("2. ���� ����");
		System.out.println("3. ���� �ݳ�");
		System.out.println("4. ����");
		System.out.println("�޴� ���� : ");
		System.out.println("----------");
	}
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1: // ���� ���
			insertBook();
			break;
		case 2: // ���� ����
			loanBook();
			break;
		case 3: // ���� �ݳ�
			returnBook();
			break;
		case 4: // ����
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�߸��� �޴� �Դϴ�.");
				
		}
		
	}
	// �޼ҵ�1: ���� ���
	private void insertBook() {
		sc.nextLine();
		System.out.print("���� ��ȣ : ");
		String num = sc.nextLine();
		System.out.print("���� ���� : ");
		String title = sc.nextLine();
		System.out.print("���� ���� : ");
		String author = sc.nextLine();
		System.out.print("ISBN : ");
		String isbn = sc.nextLine();
		
		Book book = new Book(num, title, author, isbn);
		
		if(bookList.contains(book)) {
			System.out.println("�̹� ��ϵ� ���� ��ȣ�Դϴ�. Ȯ�����ּ���.");
			return;
		}
		
		bookList.add(book);
		System.out.println(bookList);
		
	}

	// �޼ҵ�2 : ���� ����
	private void loanBook() {
		// 1. ������ �ִ� ���� ���
//		Stream<Book> stream = bookList.stream();// ����Ʈ�� �̿��ؼ� ��Ʈ������ -> ���ٽ� �̿��ؼ� ����
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
		// 2. ���� ��ȣ�� �Է�
		sc.nextLine();
		System.out.println("������ ���� ��ȣ : ");
		String num = sc.nextLine();
		
		// 3. ������ ��û
		// ���� ��ȣ�� �ùٸ���/ ��ȣ�� �´� ������ �ִ���/ ������ ������ ���������� Ȯ��
		boolean possible = bookList
				.stream()
				.filter(b->!b.isLoan() && b.getNum().equals(num))
				.count() > 0;
	}

	// �޼ҵ�3 : ���� �ݳ�
	private void returnBook() {
		// TODO Auto-generated method stub
		
	}

}
