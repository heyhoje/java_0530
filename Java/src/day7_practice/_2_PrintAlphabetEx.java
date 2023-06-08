package day7_practice;

public class _2_PrintAlphabetEx {

	public static void main(String[] args) {
		// 2. a부터 z까지 출력하는 코드를 작성하세요.
		// abcdefg - xyz : 
		
		System.out.println("---- 방 법 1 -----");
		// 'a' + 정수 => Int형
		// 'a'에 0을 더하면 'a'
		// 'a'에 1을 더하면 'b'
		// 'a'에 2을 더하면 'c'
		// ...
		// 'a'에 25을 더하면 'z'
		
		/* 반복횟수 : i는 0부터 25까지(26개, 26보다 작을때까지), 1씩 증가 
		 * 규칙성 : 'a' + i 를 더한 값을 문자형으로 자료형변환해서 출력
		 * 반복문 종료 후 : 없음
		 */
		int i;
		char ch = 'a';
		for (i = 0;i < 26 ;i++) {
			System.out.print((char)('a' + i));
		}
		
		System.out.println();
		System.out.println("---- 방 법 2 -----");
		/* 문자를 변수ch++을 하면 char
		 * 반복횟수 : ch는 'a'부터 시작해서 'z'까지 1씩 증가 
		 * 규칙성 : ch를 출력
		 * 반복문 종료 후 : 없음
		 */
		
		for (ch = 'a';ch <= 'z' ;ch++) { // 현재타입에서 1이 더해짐. + int 1 이 더해지는것과 다름.
			System.out.print(ch);
		}
	}

}
