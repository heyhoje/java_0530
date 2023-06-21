package day6._041_whilEx2;

import java.util.Scanner;

public class _1_SumEx {

	public static void main(String[] args) {
		// 누적합 : 1부터 n까지 합을 구하는 코드를 작성하세요 (n은 10)
		/* 반복횟수 : i는 1부터 n까지, 1씩 증가
		 * *규칙성 : sum = num + 1
		 * 반복문 종료 후 : 누적합인 sum을 출력
		 * ㄴ 소수판별 처럼 반복문 이후 if문
		 * 			sum0 = 0; 으로 초기설정
		 * i = 1 	sum1 = sum0 + 1
		 * i = 2 	sum2 = sum1 + 2
		 * i = 3 	sum3 = sum2 + 3
		 * . . .
		 * i = 10	sum10 = sum9 + 10
		 * i = n 	sum = sum + i => sum += 1;
		 */
		
		int n = 10, sum = 0;
		int i = 1;
		while (i <= n) {// i는 n까지
			sum += 1;
			i++; // 여기는 if문 없이 while문 내에서 바로 i++
		}
		System.out.println("1 ~ " + n + "까지 합 : " + sum);
	}

}
