package day13.practice;

public class SubjectTest {

	public static void main(String[] args) {
		
		Subject sub1 = new Subject("kor");
		sub1.print();
		
		System.out.println("------------");
		
		Subject sub2 = new Subject("eng", 1, 1);
		sub2.updateScore(30, 40, 10);
		sub2.print();
//		// 1. ������ �����ϱ� ���� Subject Ŭ������ ���弼��.
//		// �������
//		String student;
//		String subject;
//		int Score;
//		
//		// ������
//		Student student = new Student(�̸�, �г�, ��);
//		Subject subject = new Subject(�����, ����);
//		
//		// �޼ҵ�
		
	}

}
