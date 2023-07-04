package day25.test;

public class TestProgram implement Program{
	int num;
	// Program 인터페이스를 구현한 클래스이기 떄문에 인터페이스에 있는 추상메소드를 반드시 오버라이딩 해야함.
	void run();
	void print() {
		System.out.println(num);
	}
}
