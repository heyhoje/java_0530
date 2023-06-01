package day3_03_IfEx;

public class _01_IfEx1 {

	public static void main(String[] args) {
		//조건문은 참일때 동작을 한다.
		
		//정수 num가 0이면 "0입니다."라고 출력하는 코드를 작성하세요
		//정수 (정수 num가 0이다) {
		   //0입니다.라고 출력;
		int num = 10;// 10, 0
		if(num == 0) {
			System.out.println("0입니다.");
		}
		//정수 num가 0이 아니면 num is not 0 라고 출력하는 코드를 작성하세요
		//if(num가 0이 아니다)
		//if(num가 0과 같지 않다)
		if(num != 0) {
			System.out.println(num + "은 0이 아닙니다.");
			
		}
		// if 가 두개있으면, 첫번째것만 동작하는 것이 아니라 각각! 동작한다. d
	}
}
