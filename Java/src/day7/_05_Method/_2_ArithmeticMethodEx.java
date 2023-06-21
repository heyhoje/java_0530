package day7._05_Method;

public class _2_ArithmeticMethodEx {

	public static void main(String[] args) {
		System.out.println(sum(1, 2));
		System.out.println(sub(1, 2));
		System.out.println(mul(1, 2));
		System.out.println(div(1, 2));
		System.out.println(mod(1, 2));
		sum2(1,2);  // sysout(sum2(1,2)); 라고 쓰면 return 값이 없어서 출력안됨
		//sysout(1+2)
		
		//1+2+3   1번 재사용 가능! / 2번 출력하고 끝나서 재사용x 응용할 수 없다.
		int num1=1, num2=2, num3=3;
		int result = sum(num1, num2);
		result = sum(result, num3);
		System.out.println(result); // 6이 나옵니다! 재사용됨!!
		
	}
	/**
	 * 주어진 num1, num2의 합을 출력하는 메소드
	 * (더하는 기능 + 출력하는 기능) 같이 들어있음. 좋은 형태의 메소드(하나의 기능만 하는)는 아님 ^ㅠ^
	 * @param num1 정수1
	 * @param num2 정수2
	 *
	 */
	//리턴이 없다. 콘솔에 찍고 끝
	
	public static void sum2(int num1, int num2) {
		System.out.println(num1 + num2);
	}

	/**
	 * 주어진 num1, num2의 합을 알려주는 메소드
	 * @param num1 정수1
	 * @param num2 정수2
	 * @return num1과 num2의 합
	 */
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	public static double div(int num1, int num2) { // 나누기는 리턴타입이 double이고
		return num1 / (double)num2; 				// 형변환도 해줘야한다.
	}
	
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
}
