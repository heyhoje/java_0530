package day10._061_thisEx;

public class _1_studentMain {

	public static void main(String[] args) {
		Student1.printCount();
		
		Student1 std1 = new Student1(1, 1, 1, "홍길동"); // new는 객체 생성, 생성자를 제어
		Student1.printCount();
		
		Student1 std2 = new Student1(1, 1, 2, "임꺽정");
		Student1.printCount();
		
		// std2.studentCount = 1;
		// System.out.println(std1.studentCount);
		std1.print();
		// Student1.print(); //에러 발생. static이 print에는 안붙어서.안붙은 것들은 객체를 통해 호출해야함
		std2.print();
		System.out.println(std1);
		System.out.println(std2); // 객체가 다르다보니, 각각 참조변수의 주소값이 다름
	}

}

class Student1 {
	static int studentCount;
	private int grade, classNum, number;
	private String name;
	
	// 아래 생성자는 매개변수가 있고, 매개변수의 '이름이' 멤버변수와 '같기 때문에'
	// 멤버 변수를 호출할 때 this 를 반드시 붙여야함
	public Student1(int grade, int classNum, int number, String name) {
		// this(); // 아래-위 재귀, 서로 반복해서 호출하기 때문에 무한루프 걸림
		this.grade = grade;
		this.classNum = classNum;
		this.number = number;
		this.name = name;
		
		studentCount++;
	}
	
	// 기본생성자는 매개변수가 없기 때문에 this를 안써도됨.
	public Student1() { // 기본 생성자
		// 멤버변수와 이름이 같은 지역 변수를 만들 수도 있다(but 비추천)
		// int grade = 10; // 지역 변수
		// this.grade = grade;
	
		this(1, 1, 1, ""); // this는 첫 라인에 생성자 호출
		name = "";
		
		/*
		this.grade = 1; // 멤버변수임. 멤버변수 호출시 this를 써도 되고 안써도됨
		classNum = 1;
		number = 1;
		name = "";
		*/
	}
	
	// 객체 메소드
	public void print() {
		System.out.println("----------");
		System.out.println("grade : " + grade);
		System.out.println("classNum : " + classNum);
		System.out.println("number : " + number);
		System.out.println("name : " + name);
		System.out.println("==========");
//		// 클래스 변수 사용 가능
//		System.out.println("count : " + studentCount);
//		// 클래스 메소드 사용가능
//		printCount();
	}
	
	// 클래스 메소드
	public static void printCount() {
		// 클래스 변수 사용 가능
		System.out.println("Registered student count : " + studentCount);
//		// 객체 변수 사용 불가능(나는 왜 사용 가능하고 있어?>?????)
//		grade = 1;
//		// 객체 메소드 사용 불가능(왜 또 가능??????????)
//		print();
		
		//객체를 생성 후 호출해서 사용 가능
		Student1 std1 = new Student1(); // 객체를 생성하고는 가능
		std1.name = "홍";
		std1.print();
	}
}
