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
	// * ���� ����Ʈ
	List<Book> bookList = new ArrayList<>();
	// * ���� ���� ����Ʈ
	List<LoanBrowsing> loanList = new ArrayList<>();
	
	
	private final static int EXIT = 4;
	
	public void run() {
		int menu;
		String bookFileName = "src/day26/Library/book.txt";
		String loanFileName = "src/day26/Library/loan.txt";
		
		loadBook(bookFileName);
		loadLoan(loanFileName);

		do {
			// �޴� ���
			System.out.println("===========");
			printMenu();
			
			// �޴� ����(�޴��� �Է¹���) : Scanner �ʿ�
			menu = sc.nextInt();
			
			// ���õ� �޴��� ���� ����� ����
			runMenu(menu);
			System.out.println("===========");
			
		}while(menu != EXIT);
		saveBook(bookFileName);
		saveLoan(loanFileName);

		sc.close();
	}

	private void printMenu() {
		System.out.println("�޴�");
		System.out.println("1. ���� ���");
		System.out.println("2. ���� ����");
		System.out.println("3. ���� �ݳ�");
		System.out.println("4. ����");
		System.out.print("�޴� ���� : ");
	}
	private void runMenu(int menu) {
		switch(menu) {
		case 1: // �������
			insertBook();
			break;
		case 2: // ����
			loanBook();
			break;
		case 3: // �ݳ�
			returnBook();
			break;
		case 4:
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�߸��� �޴� ����");
		
		}
	}
	
	// �޼ҵ�1 : ���� ���
	public void insertBook() {
		sc.nextLine(); // ���� �ѹ��� ���Ϳ����� ���� �����ָ��.
		// ���� ���� �Է�
		System.out.print("���� ��ȣ : ");
		String num = sc.nextLine();
		System.out.print("���� ���� : ");
		String title = sc.nextLine();
		System.out.print("���� ���� : ");
		String author = sc.nextLine();
		System.out.print("ISBN	 : ");
		String isbn = sc.nextLine();
		System.out.println("------------");
		System.out.println("��������� �Ϸ�Ǿ����ϴ�.");
		
		// * �Է� ������ �̿��Ͽ� ���� ��ü�� ����
		Book book = new Book(num, title, author, isbn);
		
		// ������ȣ �ߺ� üũ
		if(bookList.contains(book)) {
			System.out.println("�̹� ��ϵ� ���� ��ȣ �Դϴ�. Ȯ�����ּ���.");
			return;
		}
		
		// * ���� ����Ʈ�� ���� ��ü�� �߰�
		bookList.add(book);
		// System.out.println(bookList); // �׽�Ʈ�� �����ֱ�
	}

	// �޼ҵ�2 : ���� ����
	private void loanBook() {
		// 1. ���� �� �ִ� ���� ���
		
		Stream<Book> stream = bookList.stream(); // ����Ʈ�� �̿��ؼ� ��Ʈ������ -> ���ٽ� �̿��ؼ� ����
		stream
			.filter(b->!b.isLoan()) // ���� ������ ������ ���� // �Ҹ����� is��, ������� !����
			.forEach(b->{ 			// ������ ������ ���
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
		// 2. ���� ��ȣ�� �Է�
		sc.nextLine(); // ���� �ѹ��� ���Ϳ����� ���� �����ָ��.
		System.out.println("������ ���� ��ȣ : ");
		String num = sc.nextLine();
		
		// 3. ������ ��û
		// ���� ��ȣ�� �ùٸ��� Ȯ��
		// ��ȣ�� �´� ������ �ִ��� Ȯ�� 
		// ������ ������ �ùٸ��� ����
		// ������ ������ ���������� Ȯ��
		boolean possible 
			= bookList
				.stream()
				.filter(b->!b.isLoan() && b.getNum().equals(num))
				.count() > 0;
		// �ùٸ���������(���� ���� ��ȣ�̰ų�, �������� ������ ���)
		// ������ �� ���ٰ� ���
		if(!possible) {
			System.out.println("�������̰ų� ���� �����Դϴ�.");
			return;
		}
		// �ùٸ��� ������ ����
		// ���� ���� ��ü�� ����. (����, ������, ����Ⱓ)
		int index = bookList.indexOf(new Book(num, null, null, null));
		Date loanDate = new Date();
		LoanBrowsing lb 
		= new LoanBrowsing(bookList.get(index) , loanDate, 14);
		
		// ���⿭�� ����Ʈ�� �߰�
		loanList.add(lb);
		bookList.get(index).loanBook();// ������ �����ߴٰ� ����
		// �������� ���
		System.out.println("���� �Ϸ�!");
		
		System.out.println("������ : " + lb.getLoanDateStr());
		// (�ݳ������ϵ� ���)
		System.out.println("�ݳ��� : " + lb.getEstimatedDateStr());
		System.out.println(loanList);
//		sc.nextLine();
		// �������� ���� ��ȣ �Է�
//		System.out.print("������ ���� ��ȣ : ");
//		String chNum = sc.nextLine();
//		if(bookList.(false)) {
//			System.out.println("�ش� ������ ���� �����Դϴ�.");
//			return;
//		}
//		System.out.println("������ �Ϸ� �Ǿ����ϴ�.");
//		
//		// ����� ���� ����? 
//		
	}
	
	// �޼ҵ�3 : ���� �ݳ�
	private void returnBook() {
		sc.nextLine(); // ���� �ѹ��� ���Ϳ� ���� ���� �����ָ��.
		// �ݳ����� ��ȣ�� �Է�
		System.out.println("�ݳ��� ���� ��ȣ : ");
		String num = sc.nextLine();
		
		// ������ ������ �ƴϸ� �ݳ�x
		int index = bookList.indexOf(new Book(num, null, null, null));
		if(index == -1) {
			System.out.println("������ ������ �ƴմϴ�.");
			return;
		}
		// ������ �ݳ�
		// �ݳ��� ������ ���¸� ���� �������� ����
		Book returnBook = bookList.get(index);
		returnBook.returnBook(); // loan = false �� �ٲ� ���� ���� ���°� ��
		
		// ���⿭�� ����Ʈ���� ������ ������ �ݳ����� ���� ��¥�� ����
		// �ݳ��� ������ ���� ������ ã�ƾ� ��
		int lbIndex = loanList.lastIndexOf(new LoanBrowsing(returnBook, null, 14));// ����Ʈ�� ������ ����. ������ �ε����� ������ ������
		LoanBrowsing tmpLb = loanList.get(lbIndex);
		tmpLb.setReturnDate(new Date());
		
		System.out.println("�ݳ� �Ϸ�!");
		System.out.println("������ : " + tmpLb.getLoanDateStr());
		System.out.println("�ݳ��� : " + tmpLb.getReturnDateStr());
	}
		
//		sc.nextLine();
//		// �ݳ��Ϸ��� ���� ��ȣ �Է�
//		System.out.print("�ݳ��� ���� ��ȣ : ");
//		String chNum = sc.nextLine();
//		
//		boolean possible 
//		= bookList
//		.stream()
//		.filter(b->b.isLoan() && b.getNum().equals(num));
		
//		System.out.println("�ݳ��� �Ϸ� �Ǿ����ϴ�.");
//
//		// ���� �������� ���� ����
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	// save&load - voŬ���� Serializable ����ߵ�
	private void saveLoan(String fileName){
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
				// ������ : D:\\.student / �������(������Ʈ ����)
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				// ��� ������Ʈ���� ��ݽ�Ʈ���� �ʿ��ϴ�
				for(LoanBrowsing tmp : loanList) { // *saveBook ���� �ݺ����� ����
					oos.writeObject(tmp);
					//public class Student implements Serializable {
					//** add generated sirialversionUID
				}
		} catch (IOException e) {
			e.printStackTrace();
			}		
		}
	private void saveBook(String fileName) {
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
				// ������ : D:\\.student / �������(������Ʈ ����)
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				// ��� ������Ʈ���� ��ݽ�Ʈ���� �ʿ��ϴ�
				for(Book tmp : bookList) {
					oos.writeObject(tmp);
					//public class Student implements Serializable {
					//** add generated sirialversionUID
				}
		} catch (IOException e) {
			e.printStackTrace();
			}		
	}

	private void loadLoan(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				try {
					LoanBrowsing tmp = (LoanBrowsing)ois.readObject();
					loanList.add(tmp);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ҷ��� ������ �����ϴ�.");
			// ���ܸ� �̿��ؼ� �����б⸦ ������ / IOException�� �θ�Ŭ������ ���� ��ġ
		} catch(EOFException e) {
			System.out.println("�ҷ����� �Ϸ�");
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
			System.out.println("�ҷ��� ������ �����ϴ�.");
			// ���ܸ� �̿��ؼ� �����б⸦ ������ / IOException�� �θ�Ŭ������ ���� ��ġ
		} catch(EOFException e) {
			System.out.println("�ҷ����� �Ϸ�");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(bookList);		
	}
}
