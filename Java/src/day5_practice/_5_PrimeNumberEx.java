package day5_practice;

import java.util.Scanner;

public class _5_PrimeNumberEx {

	public static void main(String[] args) {
		// 5. 정수 num을 입력받아 num이 소수인지 아닌지를 판별하는 코드를 작성하세요.
		// 소수 : 약수가 1과 자기자신밖에 없는 수 ex) 2, 3, 5, 7, 11, 13 등
		//		ㄴ약수가 2개인 수, 1을 제외하고 처음 구한 약수가 자신인 수
		
		// 정수 입력
		int num, i, count;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 num을 입력하세요.");
		num = sc.nextInt();
		
		// 반복횟수 : 1부터 num까지 1씩 증가
		// 규칙성 : i가 num의 약수이면, 약수의 개수 count를 1 증가
		// i의 개수가 2개라면...../~~라면 소수이다.
		// 반복문 종료 후 : count가 2이면 소수라고 출력, 아니면 소수가 아님 이라고 출력
		
		// 반복문 i는 1부터 num까지 1씩 증가
			//i가 num의 약수라면 약수의 개수 count를 1 증가
		i = 1;
		count = 0;
		while(i <= num) {
			if(num % i == 0) {
				count += 1; // 출력하는 코드가 갯수세는 코드로 바뀜.
				}
			++i;
		}
		// count가 2이면 소수라고 출력하고, 아니면 소수가 아님이라고 출력
		if(count == 2 ) { 
			System.out.println(num + "은/는 소수");
		}else {
			System.out.println(num + "은/는 소수가 아님");
		}	
		sc.close();
	}

}
