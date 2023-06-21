package day6._044_ForEx;

public class _1_HelloworldEx {

	public static void main(String[] args) {
		/* for문을 이용하여 Hello world 를 5번 출력하는 예제
		 * 반복횟수 : 5번, i는 1부터 5까지, 1씩 증가
		 * 규칙성 : Hello world 를 출력
		 */
		
		int i;
		for (i = 0; i < 5; i++) {
			System.out.println("Hello world");
		}
		
		
		System.out.println("---------");
		i = 1; // * 초기화
		while (i <= 5) {
			System.out.println("Hello world");
			i++; // * i값 1씩 증가
			// 무한루프 나와서 깜짝놀랐네;;;;
		}
	}

}
