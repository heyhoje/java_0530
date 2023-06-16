package day13.practice;

public class SubjectTest {

	public static void main(String[] args) {
		
		Subject sub1 = new Subject("kor");
		sub1.print();
		
		System.out.println("------------");
		
		Subject sub2 = new Subject("eng", 1, 1);
		sub2.updateScore(30, 40, 10);
		sub2.print();
//		// 1. 성적을 관리하기 위한 Subject 클래스를 만드세요.
//		// 멤버변수
//		String student;
//		String subject;
//		int Score;
//		
//		// 생성자
//		Student student = new Student(이름, 학년, 반);
//		Subject subject = new Subject(과목명, 점수);
//		
//		// 메소드
		
	}

}
