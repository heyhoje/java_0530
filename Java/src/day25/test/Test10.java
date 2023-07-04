package day25.test;

public class Test10 {
	public static void main(String[] args) {
		PhoneNumber pn1 = new PhoneNumber("Hong", null);
		// pn2 기본 생성자가 없어서 에러가 뜸.
		// 생성자가 있기 때문에 기본 생성자가 자동으로 추가되지 않음.
		// 1) 매개변수 추가 2) 기본 생성자 만들기
		PhoneNumber pn2 = new PhoneNumber("Kim", "010-1111-4444");
	}
}
