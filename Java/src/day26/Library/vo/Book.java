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
	// ������ȣ : ���������� ����
	// ������, ����, isbn
	private String num, title, author, isbn;
		
	private boolean loan; // ���� ���θ� �����ϴ� ���� �߰�

	// source -> toString (���ϰ� ���� ���ؼ�)
	@Override
	public String toString() {
		return "������ȣ : " + num + "\n �������� : " + title + "\n ��������: " + author + "\n isbn : " + isbn + "\n" ;
	}
	
	// source -> generate using fields
	public Book(String num, String title, String author, String isbn) {
		this.num = num;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}
	
	// LibraryController���� å ���������� boolean���� �Ÿ����� �߰��� �޼ҵ�2
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
