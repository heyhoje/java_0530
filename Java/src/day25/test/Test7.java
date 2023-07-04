package day25.test;

public class Test7 {
	public static void main(String[] args) {
		System.out.println(sum(10,20));
		System.out.println(sum(10.4,12.2));
	}
	
	// 메소드 오버로딩 : 메소드명이 같고, 매개변수가 다를때(리턴타입은 무관)
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	// 이미 sum(정수, 정수)가 있기 때문에 아래 메소드는 오버로딩 될 수 없음
	// int -> double
	public static double sum(double num1, double num2) {
		return num1 + num2;
	}
}

// 메소드 오버라이딩