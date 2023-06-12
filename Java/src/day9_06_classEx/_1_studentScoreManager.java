package day9_06_classEx;

import java.util.Scanner;

public class _1_studentScoreManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		
		// korScore 를 인스턴스/객체 (<-> 현실세계에 있는 정보)
		Score1 korScore = new Score1(); // 기본생성자
		//		참조변수
		korScore.title = "korean Language";
		korScore.grade = 1;
		korScore.semester = 2;
		//==> Score1 korScore = new Score1(1, 2, "korean Language");
		Score1 engScore = new Score1(1, 2, "English");
		
		// 생성자 = 멤버변수들을 편하게 초기화 하기 위해 제공!
		
	}

}

//[접근제어자] 생략

// 성적 클래스
class Score1 {
	String title; // 과목명
	int grade; // 학년
	int semester; // 학기
	double total; // 총점수
	double midExam; // 중간
	double finalExam; // 기말
	double performance; // 수행평가
	//public 리턴타입 메소드명(매개변수들)// 기본생성자
	//Score1 클래스의 기본 생성자
	public Score1() {
		/* title 의 기본값은? null
		 * grade 의 기본값은? 0
		 * total 의 기본값은? 0.0
		 */
		title = "";
		grade = 1;
		semester = 1;
		// 기본 생성자를 수정해주고 싶으면 생성자 내에서 하면됨 (?이라고 한겨?)
	}
	
	public Score1(int _grade, int _semester, String _title) {
		grade = _grade;
		semester = _semester;
		title = _title; // 으로 초기화
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getMidExam() {
		return midExam;
	}

	public void setMidExam(double midExam) {
		this.midExam = midExam;
	}

	public double getFinalExam() {
		return finalExam;
	}

	public void setFinalExam(double finalExam) {
		this.finalExam = finalExam;
	}

	public double getPerformance() {
		return performance;
	}

	public void setPerformance(double performance) {
		this.performance = performance;
	}

	
	public Score1(String title, int grade, int semester, double total, double midExam, double finalExam,
			double performance) {
		// super();
		this.title = title;
		this.grade = grade;
		this.semester = semester;
		this.total = total;
		this.midExam = midExam;
		this.finalExam = finalExam;
		this.performance = performance;
	}
	
}

// 학생 클래스
class Student1{
	String name; // 이름
	String residentNumber; // 주민등록번호
	int grade; // 학년
	int classNum; // 반
	int number; // 번호
	int admissionYear; // 입학년도
	Score1 korScore, engScore, mathScore; // 국영수 성적(미완 - 배열 배우고 다시)
}