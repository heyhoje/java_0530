package review_0706.library.vo;

public class Book {

	private String num, title, author, isbn;
	private boolean loan;// 대출여부

	public Book(String num, String title, String author, String isbn) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		
	}

	@Override
	public String toString() {
		return "num : " + num + ", title : " + title + ", author : " + author + ", isbn : " + isbn;
		
	}
	
	

}
