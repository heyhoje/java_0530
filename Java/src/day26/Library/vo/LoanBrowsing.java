package day26.Library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
// ���� ���� Ŭ����
public class LoanBrowsing implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -8453150469974226957L;
	
	private Book book;// ���� ����
	private Date loanDate; // ������
	private Date returnDate; // �ݳ���
	
	// �ݳ��������� calender Ŭ����? ���ñ�? ����ؼ� �Ұ���
	public LoanBrowsing (Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
	}
	
	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
		return format.format(loanDate);
	}

}
