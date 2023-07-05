package day26.Library.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// @AllArgsConstructor
public class Book implements Serializable{
	
	private static final long serialVersionUID = -1533849533424416127L;
	// 도서번호 : 도서관에서 지정
	// 도서명, 저자, isbn
	private String num, title, author, isbn;
		
	private boolean loan; // 대출 여부를 관리하는 변수 추가

	// source -> toString (편하게 보기 위해서)
	@Override
	public String toString() {
		return "도서번호 : " + num + "\n 도서제목 : " + title + "\n 도서저자: " + author + "\n isbn : " + isbn + "\n" ;
	}
	
	// source -> generate using fields
	public Book(String num, String title, String author, String isbn) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	// LibraryController에서 책 대출중인지 boolean으로 거를려고 추가한 메소드2
	public void loanBook() {
		this.loan = true; // setloan(true)
	} 
	public void returnBook() {
		this.loan = false; // setloan(false)
	}
	
	// source -> hashCode & equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(num, other.num);
	}
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
	
}
