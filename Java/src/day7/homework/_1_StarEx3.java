package day7.homework;

public class _1_StarEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("----다이아몬드----");
		int i = 0;
		int j = 0;
		/*  sss*  	 	i = 1 공=3 *=1 
		 *  ss** *		i = 2 공=2 *=3 
		 *  s*** **		i = 3 공=1 *=5 
		 *  **** ***	i = 4 공=0 *=7 
		 *  s*** ** 	i = 5 공=1 *=5 
		 * 	ss** *		i = 6 공=2 *=3 
		 *  sss*		i = 7 공=3 *=1
		 * 
		 */
		/* 외부반복문
		 * 반복횟수 : i는 1부터 5까지, 1씩 증가
		 * 규칙성(실행문) : * i개를 출력 후 엔터
		 * */
		
		for (i = 1; i <= 7; i++){
			for (j = 1; j <= 4 - i; j++) {
				System.out.print(" ");
			}
			for (j = 0; j <= 8; j += 2) {
				System.out.print("*");
			}
			System.out.println();
		}
				
	}

}
