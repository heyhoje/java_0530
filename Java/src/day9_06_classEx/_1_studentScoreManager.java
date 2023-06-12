package day9_06_classEx;

import java.util.Scanner;

public class _1_studentScoreManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		
		// korScore �� �ν��Ͻ�/��ü (<-> ���Ǽ��迡 �ִ� ����)
		Score1 korScore = new Score1(); // �⺻������
		//		��������
		korScore.title = "korean Language";
		korScore.grade = 1;
		korScore.semester = 2;
		//==> Score1 korScore = new Score1(1, 2, "korean Language");
		Score1 engScore = new Score1(1, 2, "English");
		
		// ������ = ����������� ���ϰ� �ʱ�ȭ �ϱ� ���� ����!
		
	}

}

//[����������] ����

// ���� Ŭ����
class Score1 {
	String title; // �����
	int grade; // �г�
	int semester; // �б�
	double total; // ������
	double midExam; // �߰�
	double finalExam; // �⸻
	double performance; // ������
	//public ����Ÿ�� �޼ҵ��(�Ű�������)// �⺻������
	//Score1 Ŭ������ �⺻ ������
	public Score1() {
		/* title �� �⺻����? null
		 * grade �� �⺻����? 0
		 * total �� �⺻����? 0.0
		 */
		title = "";
		grade = 1;
		semester = 1;
		// �⺻ �����ڸ� �������ְ� ������ ������ ������ �ϸ�� (?�̶�� �Ѱ�?)
	}
	
	public Score1(int _grade, int _semester, String _title) {
		grade = _grade;
		semester = _semester;
		title = _title; // ���� �ʱ�ȭ
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

// �л� Ŭ����
class Student1{
	String name; // �̸�
	String residentNumber; // �ֹε�Ϲ�ȣ
	int grade; // �г�
	int classNum; // ��
	int number; // ��ȣ
	int admissionYear; // ���г⵵
	Score1 korScore, engScore, mathScore; // ������ ����(�̿� - �迭 ���� �ٽ�)
}