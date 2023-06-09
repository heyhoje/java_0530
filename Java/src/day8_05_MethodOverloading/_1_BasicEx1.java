package day8_05_MethodOverloading;

public class _1_BasicEx1 {

	public static void main(String[] args) {
		// pringln의 메소드 오버로딩
		// 대표적인 메소드 오버로딩 예제
		// 매개변수는 다르지만, 같은 기능을 함
		System.out.println("----- p r i n t l n -----");
		
		System.out.println(1);
		System.out.println("1");
		System.out.println(1.1);
		System.out.println("c");
		
		System.out.println("----- s u m -----");
		
		System.out.println(sum(1, 1));
		System.out.println(sum(1.1, 1)); // 실수로도 처리하고 싶음
		System.out.println(sum(1, 1.1));
		System.out.println(sum(1.1, 1.1));
	}
	// 매개변수가 다른 경우
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}

	public static double sum(double num1, int num2) {
		return num1 + num2;
	}
	
	public static double sum(int num1, double num2) {
		return num1 + num2;	
	}
	
	// 매개변수의 타입이 다른 경우
	public static double sum(double num1, double num2) { // 정수 -> 실수 로 변하는건 자동 형변환이 됨. 실수 -> 정수 는 안됨
		return num1 + num2;								// 효율적인 메소드는 4번만 있어도 된다
	}
	
	// 리턴타입만 다른 매소드는 오버로딩이 될 수 없다
//	public static double sum(int num1, int num2) { // 반환값타입만 다르고 <매개변수>는 타입도 갯수도 같음 -> 오버로딩 안됨xxxxx
//		return num1 + num2;						   // 리턴타입은 중요하지 않음 
	
	// 매개변수의 갯수가 다른 경우
	public static int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}
