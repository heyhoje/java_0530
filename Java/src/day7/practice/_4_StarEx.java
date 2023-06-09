package day7.practice;

public class _4_StarEx {

	public static void main(String[] args) {
		/* *****  - i = 1
		 * *****	i = 2
		 * *****	i = 3
		 * *****	i = 4
		 * *****	i = 5
		 */
		
		/* 외부반복문
		 * 반복횟수 : i는 1부터 5까지, 1씩 증가
		 * 규칙성(실행문) : * 5개를 출력 후 엔터
		 * */
		System.out.println("----별 네모----");
		int j;
		for (int i = 0; i < 5; i++) { // int i 를 반복문 내부에서 정의할 경우, 그 변수는 해당 반복문 내에서만 사용할 수 있다. 
			/* 내부 반복문
			 * 반복횟수 : j는 1부터 5까지, 1씩 증가
			 * 규칙성 : *을 출력
			 * */ 
			for (j = 0;j < 5; j++) {
				System.out.print("*");
			}
			// 엔터
			System.out.println();
		}
		
		System.out.println("----왼쪽 삼각형----");
		
		int i = 0;
		j = 0;
		/* *	  - i = 1 *=1
		 * **		i = 2 *=2
		 * ***		i = 3 *=3
		 * ****		i = 4 *=4
		 * *****	i = 5 *=5
		 * 				  * = i개 (내부에서 갯수)
		 */
		
		/* 외부반복문
		 * 반복횟수 : i는 1부터 5까지, 1씩 증가
		 * 규칙성(실행문) : * i개를 출력 후 엔터
		 * */
		for (i = 0; i < 5; i++) {
			/* 내부반복문
			 * 반복횟수 : j는 1부터 i까지, 1씩 증가
			 * 규칙성(실행문) : * 를 출력
			 * */
			for (j = 1; j <= i + 1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("----오른쪽 삼각형----");
		
		i = 0;
		j = 0;
		/*     *  - i = 1 공=4 *=1
		 *    **	i = 2 공=3 *=2
		 *   ***	i = 3 공=2 *=3
		 *  ****	i = 4 공=1 *=4
		 * *****	i = 5 공=0 *=5
		 * 				  공=? *=i개 (내부에서 갯수)
		 */
		/* 외부반복문
		 * 반복횟수 : i는 1부터 5까지, 1씩 증가
		 * 규칙성(실행문) : * i개를 출력 후 엔터
		 * */
		for (i = 0; i < 5; i++) {
			/* 내부반복문
			 * 반복횟수 : j는 1부터 5 - i / i까지, 1씩 증가
			 * 규칙성(실행문) : ' ' / * 를 출력
			 * */
			for (j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("----이등변 삼각형----");
		
		i = 0;
		j = 0;
		/*     *  	 	i = 1 공=4 *=1
		 *    ***		i = 2 공=3 *=2
		 *   *****		i = 3 공=2 *=3
		 *  *******		i = 4 공=1 *=4
		 * *********	i = 5 공=0 *=5
		 * 				  공=? *=i개 (내부에서 갯수)
		 */
		/* 외부반복문
		 * 반복횟수 : i는 1부터 5까지, 1씩 증가
		 * 규칙성(실행문) : * i개를 출력 후 엔터
		 * */
		for (i = 0; i < 5; i++) {
			/* 내부반복문
			 * 반복횟수 : j는 1부터 5 - i / i까지, 1씩 증가
			 * 규칙성(실행문) : ' ' / * 를 출력
			 * */
			for (j = 1; j <= 5 - i; j++) {
				System.out.print(" ");
			}
			for (j = 1; j <= i + 1; j++) {
				System.out.print("*");
			}
			for (j = 2; j <= 4 - i; j++) {
				System.out.println(" ");
			}
			System.out.println();
		}
		
	}

}
