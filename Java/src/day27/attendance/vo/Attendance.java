package day27.attendance.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

//학생 한명이 특정날에 출석했는지 알려주는 클래스
@Data
public class Attendance implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -860094218489134759L;
	// 필드(멤버변수, 인스턴스, 객체멤버 등)
	private Date date; // 출석 날짜
	private Student student; // 학생 정보
	private boolean attendance; // 출석 여부
	
	// 출석일, 학생, 출석여부를 이용한 생성자(초기화해주는 곳)
	public Attendance(Date date, Student student, char state ) {
		
		this.date = date;
		this.student = student;
		this.attendance = state == 'O'?true:false;
	}

	// 출석부 확인시 보여질 양식 ex) 학번 이름 : O / X
	@Override
	public String toString() {
		return student.toString() + " : " +(attendance?"O" : "X");
	}

	// 출석날짜, 학생정보만 체크
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

	// 출석부 - printAttendance
	// * 날짜를 문자열로
	public String getDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

}
