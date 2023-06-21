package day11.practice;

import java.util.Scanner;

public class _3_DivisorEx {

	public static void main(String[] args) {
		// 3. 정수 num의 약수들을 배열에 저장하는 코드를 작성하세요.
		// 약수는 최대 10개까지 저장
		
		// 약수 문제 활용
		
		/* 12 : 1 2 3 5 6 12
		 *     0번지 ~~~~~ 5번지
		 */
		
//		arr[0] = 1;
//		arr[1] = 2;
//		arr[2] = 3;
//		arr[3] = 4;
//		arr[4] = 6;
//		arr[5] = 12;
//		
//		arr[i] = num2
		
		int num, count = 0;
		int divisor[] = new int[10];
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요");
		num = sc.nextInt();
		
	
		for(int i = 1; i <= num; i++) { // i는 0부터가 아니라, 1부터여야 한다(정수는 0으로 나눌수 없기 때문에)
			// Exception in thread "main" java.lang.ArithmeticException: / by zero 
			if(num % i == 0) {
				//System.out.println(i);// 출력부분을 배열을 저장하는 부분으로
				divisor[count] = i; // 새로운 변수, count번지부터
				count++;
			}
			if(count == divisor.length) { // count == 10이랑 같은데 더 재사용성 높은 표현
				break;
			}
		}
		
		for(int i = 0; i < count; i++) {
			System.out.println(divisor[i]);
		}
		
		sc.close();
		
	}
}


