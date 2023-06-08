package day7_practice;

public class _4_StarEx2 {

	public static void main(String[] args) {
System.out.println("----이등변 삼각형----");
		
		int i = 0;
		int j = 0;
		/*     *  	 	i = 1 공=4 *=1 *=0 * i개만큼 추가
		 *    ** *		i = 2 공=3 *=2 *=1
		 *   *** **		i = 3 공=2 *=3 *=2
		 *  **** ***	i = 4 공=1 *=4 *=3
		 * ***** ****	i = 5 공=0 *=5 *=4
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
			}// * i개 출력
			for (j = 1; j <= i; j++) { // ** 추가된 for문!
				System.out.print("*");
			}
//			for (j = 2; j <= 4 - i; j++) {
//				System.out.print(" ");
//			}
			System.out.println();
		}
		
		System.out.println("----이등변 삼각형 2----");
		
		i = 0;
		j = 0;
		/* ssss*ssss 	i = 1 공=4 *=1
		 * sss***sss	i = 2 공=3 *=2
		 * ss*****ss	i = 3 공=2 *=3
		 * s*******s	i = 4 공=1 *=4
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
			for (j = 1; j <= i + 1; j += 2) {
				System.out.print("*");
			}
			for (j = 1; j <= 5 - i; j++) {
				System.out.println(" ");
			}
			System.out.println();
		}
		
	}

}
