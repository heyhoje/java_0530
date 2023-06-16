package day13.practice;

import lombok.Data;

@Data

public class Subject {
	// 멤버변수(필드)
	private String title; // 과목명 : 국어, 영어, 수학
	private double total; // 과목의 총점 = 중간 + 기말 + 수행평가
	private double midTerm;
	private double finalTerm;
	private double performance;
	
	private int grade;
	private int semester;
	
	// 학생정보 x(학생이 과목 정보를 가지고 있기 때문) 
	
	// 생성자 초기화
	public Subject(String title) {
		this.title = title;
		this.grade = 1;
		this.semester = 1;
	}
	public Subject(String title, int grade, int semester) {
		this.title = title;
		this.grade = grade;
		this.semester = semester;
	}
	
	// 메소드
	
	/** 중간고사 성적 추가/수정 : setMidTerm
	/** 기말고사 성적 추가/수정 : setMidTerm
	/** 수행평가 성적 추가/수정 : setPerformance
	 
	/** 성적 추가(전체)/수정 */
	public void updateScore(int midTerm, int finalTerm, int performance) {
		this.midTerm = midTerm;
		this.finalTerm = finalTerm;
		this.performance = performance;
		
		total = midTerm + finalTerm + performance;
	}
	 
	/**성적 출력 */
	public void print() {
		System.out.println("title : " + title);
		System.out.println("grade : " + grade);
		System.out.println("semester : " + semester);
		System.out.println("mid : " + midTerm);
		System.out.println("final : " + finalTerm);
		System.out.println("performance : " +  performance);
		System.out.println("total : " + total);
	
	
	/* 기능 : 과목별 점수의 합을 출력하는 메소드
	 * 매개변수 : 과목별 점수 => int Score
	 * 리턴타입 : 없음 => void
	 * 메소드명 : sum
	 * */
	

		
	}

}
