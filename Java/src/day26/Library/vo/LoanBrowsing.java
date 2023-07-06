package day26.Library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
// 대출 열람 클래스
public class LoanBrowsing implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -8453150469974226957L;
	
	private Book book;// 대출 도서
	private Date loanDate; // 대출일
	private Date returnDate; // 반납일
	private Date estimatedDate; // 반납 예정일
	
	// 반납예정일은 calender 클래스? 뭐시기? 사용해서 할것임
	public LoanBrowsing (Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
		// 대출 기한을 이용하여 반납 예정일을 추가
		calculateReturnDate(loanPeriod);
		
	}
	
	// 반납일 계산 메소드 - 대출일이 없으면 계산이 안됨. if를 추가하니까 반납기능까지 잘 확인됨.
	private void calculateReturnDate(int loanPeriod) {
		if(loanDate == null) {
			return;
		}
		Long loanDateMs = loanDate.getTime(); // 대출일을 밀리초로 환산
		Long periodMs = loanPeriod * 24 * 60 * 60 * 1000L; // 24시 60분 60초 1000 밀리초

		/* new Date() : 현재 시간을 Date객체로 생성
		 * new Date(Long a) : 1970년 1월 1일 0시를 기준으로 a 밀리초 만큼 흐른 날짜*/
		estimatedDate = new Date(loanDateMs + periodMs);
		
	}
	
	// 대출일
	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(loanDate);
	}
	
	// 반납일
	public String getReturnDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(returnDate);
	}
	
	// 반납예정일
	public String getEstimatedDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(estimatedDate);
	}
	
	// 도서가 같으면 같은 도서로 인식함
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanBrowsing other = (LoanBrowsing) obj;
		return Objects.equals(book, other.book);
	}

	@Override
	public int hashCode() {
		return Objects.hash(book);
	}


}
