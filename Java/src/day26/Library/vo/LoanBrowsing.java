package day26.Library.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

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
	private Date estimatedDate; // �ݳ� ������
	
	// �ݳ��������� calender Ŭ����? ���ñ�? ����ؼ� �Ұ���
	public LoanBrowsing (Book book, Date date, int loanPeriod) {
		this.book = book;
		this.loanDate = date;
		// ���� ������ �̿��Ͽ� �ݳ� �������� �߰�
		calculateReturnDate(loanPeriod);
		
	}
	
	// �ݳ��� ��� �޼ҵ� - �������� ������ ����� �ȵ�. if�� �߰��ϴϱ� �ݳ���ɱ��� �� Ȯ�ε�.
	private void calculateReturnDate(int loanPeriod) {
		if(loanDate == null) {
			return;
		}
		Long loanDateMs = loanDate.getTime(); // �������� �и��ʷ� ȯ��
		Long periodMs = loanPeriod * 24 * 60 * 60 * 1000L; // 24�� 60�� 60�� 1000 �и���

		/* new Date() : ���� �ð��� Date��ü�� ����
		 * new Date(Long a) : 1970�� 1�� 1�� 0�ø� �������� a �и��� ��ŭ �帥 ��¥*/
		estimatedDate = new Date(loanDateMs + periodMs);
		
	}
	
	// ������
	public String getLoanDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
		return format.format(loanDate);
	}
	
	// �ݳ���
	public String getReturnDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
		return format.format(returnDate);
	}
	
	// �ݳ�������
	public String getEstimatedDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy�� MM�� dd��");
		return format.format(estimatedDate);
	}
	
	// ������ ������ ���� ������ �ν���
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
