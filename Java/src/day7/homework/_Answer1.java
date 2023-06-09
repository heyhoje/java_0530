package day7.homework;

public class _Answer1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----다이아몬드----");
		int i = 0;
		int j = 0;
		/*  sss*  	 	  i = 1 공=3 *=1 
		 *  ss** *		  i = 2 공=2 *=3 
		 *  s*** **		  i = 3 공=1 *=5 
		 *  **** ***	//i = 4 공=0	 *=7 
		 *  			공 = half-1 / * = 2*i-1
		 *  s*** ** 	  i = 5 공=1 *=5  2*3-1 
		 * 	ss** *		  i = 6 공=2 *=3  2*2-1
		 *  sss*		  i = 7 공=3 *=1  2*1-1
		 * 					공 = i-half / * = 2*(num+1-i)-1 = 2*(num-i)+1
		 */
		/* 외부반복문
		 * 반복횟수 : i는 1부터 5까지, 1씩 증가
		 * 규칙성(실행문) : * i개를 출력 후 엔터
		 * */
		int num = 7;
		for (i = 0; i <= num; i++) {
			/* 내부반복문
			 * 반복횟수 : j는 1부터 5 - i / i까지, 1씩 증가
			 * 규칙성(실행문) : ' ' / * 를 출력
			 * */
			int half = (num + 1) / 2;
			// 4줄 => (num + 1) / 2;
			if (i <= half) { // 위 삼각형
				// half - 1개 공백출력
				for (j = 1; j <= half - i; j++) {
					System.out.print(" ");
				}
				// 2*i-1개 * 출력
				for (j = 1; j <= 2*i - 1; j++) {
					System.out.print("*");
				}
				// 엔터
				System.out.println();
			// 3줄 => 
			}else {  
				// i - half개 공백출력
				for (j = 1; j <= i - half; j++) {
					System.out.print(" ");
				}
				// 2*(num-i)+1개 * 출력
				for (j = 1; j <= 2*(num-i)+1; j++) {
					System.out.print("*");
				}
				// 엔터
				System.out.println();
			}
		}
	}

}
