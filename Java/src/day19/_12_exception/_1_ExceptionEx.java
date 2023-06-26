package day19._12_exception;

// 230626 월 집중이 힘드네 졸리네 
public class _1_ExceptionEx {

	public static void main(String[] args) {
		/* num2의 값이 0이어도 오류 표시는 안됨
		 * 하지만, 예외가 발생해서 프로그램이 중단(arithmetifException - RuntimeException의 자식 클래스)
		 * 코드상으로 오류가 표시되지 않지만 의도치 않게 프로그램이 중단되는 경우는
		 * => RuntimeException(실행 오류)
		 */
		int num1 = 1, num2 = 0;
		
		System.out.println(num1/num2);
	}

}

class A implements Cloneable {
	/* clone 메소드를 오버라이딩 하기 위해서 Object 클래스의 clone을 소환하면
	 * CloneNotSupportedException 이 발생할 수 있다.
	 * CloneNotSupportedException는 RuntimeException클래스의 자식 클래스가 아니다
	 * => 반드시 예외처리를 해야함
	 * */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// RuntimeException : 예외처리 안해도 빨간줄이 안뜬다
// 				그 외, 
// 대표적인 RuntimeException 클래스의 자식 클래스들
// - 가능하면 기억하는게 좋다
// - 왜? 코드상으로 오류가 표시 안되기 때문에 예외처리 안하면 프로그램이 불안정.
//		 - NullPointerException
//		 - ArrayIndexOutOfBoundsException
//		 - ClassCastException
//		 = ArithmeticExceptopn
