package day6_043_NestedLoopEx;

public class _1_MultiplicationTable2 {

	public static void main(String[] args) {
		// 구구단 2단부터 9단까지 출력하는 코드를 입력하세요
		
		
		
		// * 구구단 안나옴 ㅅㅂㅌㅁ
		int i = 0, j = 0;// * 안에서 초기화하는 변수는 밖에서도 초기화해줘야함
		for (i = 2; i < 10; i++) {
			/* 외부반복문
			 * ㄴ 외부 반복문이 한번 돌때, 내부 반복문은 
			 * 반복횟수 : i는 2부터 9까지 1씩 증가
			 * 규칙성(실행문) : i단이 출력
			 * */
			for (j = 1; j < 10; j++) {
				System.out.println(i + "x" + j + "=" + i*j);
				//i단 출력
				/* 내부반복문
				 * 반복횟수 : j는 1부터 9까지 1씩 증가
				 * 규칙성 : i * j = i*j 를 출력
				 * */
			}
			System.out.println();
		}
		// 이 위치에서 i와 j값은 얼마? i = 10, j = 10 << 조건에 맞지 않을때 10이 되었을때 반복문을 탈출했기 때문
		System.out.println("i : " + i + ", j : " + j);
	}

}
