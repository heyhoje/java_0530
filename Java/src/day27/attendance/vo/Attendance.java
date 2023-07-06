package day27.attendance.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

//�л� �Ѹ��� Ư������ �⼮�ߴ��� �˷��ִ� Ŭ����
@Data
public class Attendance implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -860094218489134759L;
	// �ʵ�(�������, �ν��Ͻ�, ��ü��� ��)
	private Date date; // �⼮ ��¥
	private Student student; // �л� ����
	private boolean attendance; // �⼮ ����
	
	// �⼮��, �л�, �⼮���θ� �̿��� ������(�ʱ�ȭ���ִ� ��)
	public Attendance(Date date, Student student, char state ) {
		
		this.date = date;
		this.student = student;
		this.attendance = state == 'O'?true:false;
	}

	// �⼮�� Ȯ�ν� ������ ��� ex) �й� �̸� : O / X
	@Override
	public String toString() {
		return student.toString() + " : " +(attendance?"O" : "X");
	}

	// �⼮��¥, �л������� üũ
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Attendance other = (Attendance) obj;
		return Objects.equals(date, other.date) && Objects.equals(student, other.student);
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, student);
	}

	// �⼮�� - printAttendance
	// * ��¥�� ���ڿ���
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

}
