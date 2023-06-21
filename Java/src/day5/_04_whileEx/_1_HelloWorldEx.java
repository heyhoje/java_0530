package day5._04_whileEx;

public class _1_HelloWorldEx {

	public static void main(String[] args) {
		// Hello world 를 10번 출력하는 코드를 작성하세요.
		System.out.println("Hello world!");
		System.out.println("------------------");
		
		/* 반복횟수 : 10번, 1번부터 10번까지 1씩 증가 ( 1 ~ 10 ) ( 0 ~ 9 )
		 *  => 반복횟수가 변수의 초기값 : 1
		 *  => 조건식 : 10까지( 10보다 작거나 같을 때까지)
		 *  => 증가하는 식 : 1씩 증가
		 * 규칙성 : Hello world(같은 문자열)를 출력
		 */
		
		int max = 3;
		int i = 1; // 변수의 초기값 : 1
		//while (조건식) {
		//	실행문;
		//} 
		// i 가 10보다 작거나 같을 때까지
		while (i <= max) {
			System.out.println("Hello world!");
			i++; // i는 1씩 증가, i++, i = i + 1, i += 1
		}
		System.out.println("------------------");
		
		/* 반복횟수 : i는 10부터 1까지 1씩 감소
		 * 
		 * */
		i = max;
		while (i >= 1) {
			System.out.println("Hello world!");
			--i;
		}
		System.out.println("------------------");
		i = max;
		while (i-- >= 1) { // 후위연산자를 쓰면 코드 한줄을 줄일 수 있다. 
			System.out.println("Hello world!");
			
			
			
		}
	}

}
