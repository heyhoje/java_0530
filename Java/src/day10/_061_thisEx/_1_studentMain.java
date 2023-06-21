package day10._061_thisEx;

public class _1_studentMain {

	public static void main(String[] args) {
		Student1.printCount();
		
		Student1 std1 = new Student1(1, 1, 1, "ȫ�浿"); // new�� ��ü ����, �����ڸ� ����
		Student1.printCount();
		
		Student1 std2 = new Student1(1, 1, 2, "�Ӳ���");
		Student1.printCount();
		
		// std2.studentCount = 1;
		// System.out.println(std1.studentCount);
		std1.print();
		// Student1.print(); //���� �߻�. static�� print���� �Ⱥپ.�Ⱥ��� �͵��� ��ü�� ���� ȣ���ؾ���
		std2.print();
		System.out.println(std1);
		System.out.println(std2); // ��ü�� �ٸ��ٺ���, ���� ���������� �ּҰ��� �ٸ�
	}

}

class Student1 {
	static int studentCount;
	private int grade, classNum, number;
	private String name;
	
	// �Ʒ� �����ڴ� �Ű������� �ְ�, �Ű������� '�̸���' ��������� '���� ������'
	// ��� ������ ȣ���� �� this �� �ݵ�� �ٿ�����
	public Student1(int grade, int classNum, int number, String name) {
		// this(); // �Ʒ�-�� ���, ���� �ݺ��ؼ� ȣ���ϱ� ������ ���ѷ��� �ɸ�
		this.grade = grade;
		this.classNum = classNum;
		this.number = number;
		this.name = name;
		
		studentCount++;
	}
	
	// �⺻�����ڴ� �Ű������� ���� ������ this�� �Ƚᵵ��.
	public Student1() { // �⺻ ������
		// ��������� �̸��� ���� ���� ������ ���� ���� �ִ�(but ����õ)
		// int grade = 10; // ���� ����
		// this.grade = grade;
	
		this(1, 1, 1, ""); // this�� ù ���ο� ������ ȣ��
		name = "";
		
		/*
		this.grade = 1; // ���������. ������� ȣ��� this�� �ᵵ �ǰ� �Ƚᵵ��
		classNum = 1;
		number = 1;
		name = "";
		*/
	}
	
	// ��ü �޼ҵ�
	public void print() {
		System.out.println("----------");
		System.out.println("grade : " + grade);
		System.out.println("classNum : " + classNum);
		System.out.println("number : " + number);
		System.out.println("name : " + name);
		System.out.println("==========");
//		// Ŭ���� ���� ��� ����
//		System.out.println("count : " + studentCount);
//		// Ŭ���� �޼ҵ� ��밡��
//		printCount();
	}
	
	// Ŭ���� �޼ҵ�
	public static void printCount() {
		// Ŭ���� ���� ��� ����
		System.out.println("Registered student count : " + studentCount);
//		// ��ü ���� ��� �Ұ���(���� �� ��� �����ϰ� �־�?>?????)
//		grade = 1;
//		// ��ü �޼ҵ� ��� �Ұ���(�� �� ����??????????)
//		print();
		
		//��ü�� ���� �� ȣ���ؼ� ��� ����
		Student1 std1 = new Student1(); // ��ü�� �����ϰ�� ����
		std1.name = "ȫ";
		std1.print();
	}
}
