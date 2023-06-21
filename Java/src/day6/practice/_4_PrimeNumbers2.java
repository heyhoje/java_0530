package day6.practice;

public class _4_PrimeNumbers2 {

	public static void main(String[] args) {
		// 4. 2부터 100사이의 소수를 출력하는 코드를 작성하세요.
		// day5.practice << PrimeNumbersEx 참고
		
		int i = 2, j;
		int count = 0;
		// 외부반복문
				// 반복횟수 : i는 2부터 100까지 1씩 증가
				// 규칙성 : i가 소수(약수가 1과 자신밖에 없는 수)이면 i를 출력
				//		num % i == 0
		for (i = 2; i <= 100; i++) {
			/*내부반복문
		//	 * 반복횟수 : j는 1부터 i까지 1씩 증가
//			 * 규칙성 : j가 i의 약수이면 약수의 개수(초기화, 안해주면 누적이됨)를 1 증가
//			 * 반복문 종료 후 : 약수의 개수가 2개이면 i를 출력
//			 */
			for(j = 1, count = 0; j <= i; j++) {
				if (i % j == 0) {
					count++;
				}
			}
			if(count == 2) {
				System.out.println(i);
			}
		}
		
			
//		for (i = 2; i <= 100; i++) { // 2부터 100까지 갈건데
//			
//			for (num = 1; j <= num; num++) {
//				if (num % j == 0) {
//					j++;
//					count += 1;
//				}
//			}
//			if (count == 2) {
//				System.out.println(num);
//			
			}
		
	}

