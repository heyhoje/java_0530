package day22._131_lambda;

public class _1_LambdaEx1 {

	public static void main(String[] args) {
		InterfaceA a = new InterfaceA() {

			@Override
			public int getMax(int num1, int num2) {
				return num1 >= num2 ? num1 : num2;
			}
		};
		System.out.println(a.getMax(10, 20));
		
		InterfaceA b = (num1, num2)->{ // 인터페이스의 값을 쓰기 때문에, 자료형타입이 생략된다
			return num1 >= num2 ? num1 : num2;
		};
		System.out.println(b.getMax(10, 20));
		
		// 매개변수가 1개이면 ()를 생략.
		// 실행문이 1줄이면 {}, return 을 생략 가능!
		InterfaceA c = (num1, num2)-> num1 >= num2 ? num1 : num2;
		System.out.println(b.getMax(10, 20));
	}
}

interface InterfaceA {
	int getMax(int num1, int num2);

}