package day19._113wrapper;

//wrapper, 박싱언박싱 다시,,,

public class _3_WrapperEx {

	public static void main(String[] args) {
		// 1. 기본
		Integer num1 = 10; // 박싱 : 정수 10을 Integer 클래스 객체 num1에 저장
		// num1 = null;
		int num2 = 0;
		if(num1 != null) {// 예외처리 필요
			num2 = num1; // 언박싱 : Integer클래스 객체 num1에 있는 값을 num2에 저장. 
		}
		// 2. 박싱언박싱
		
		System.out.println(num1);
		System.out.println(num2);
		
		//제네릭
		//ArrayList<Integer> list;
		
 
		//Integer.parseInt와 같이 문자열을 기본자료형으로 변환하는 메소드를 사용할 때 예외처리해주는것이 좋음
		int num3 = Integer.parseInt("123");
		System.out.println(num3);
	}

}
