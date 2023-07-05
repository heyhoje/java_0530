package day26.Library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
// 대출 열람 클래슨
public class LoanBrowsing implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -8453150469974226957L;
	
	private Book book;// 대출 도서
	private Date loanDate; // 대출일
	private Date returnDate; // 반납일
	
	// 반납예정일은 calender 클래스? 뭐시기? 사용해서 할것임
	public LoanBrowsing (Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
	}
	
	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(loanDate);
	}

}
