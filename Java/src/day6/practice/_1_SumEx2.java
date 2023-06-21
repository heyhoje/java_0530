package day6.practice;

import java.util.Scanner;

public class _1_SumEx2 {

	public static void main(String[] args) {
		// 1. n을 입력받아 1부터 n까지 짝수의 합을 구하는 코드를 작성하세요
		// input : 10
		// 1 ~ 10 even sum : 30
		
		int n, i = 1;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		// n을 입력
		System.out.println("n을 입력하세요 : ");
		n = sc.nextInt();
		
		// 반복문을 이용하여 n까지 짝수의 합을 계산
		// 1가 n보다 작거나 같으면 반복
		while(i <= n) {
			// i가 짝수이면 누적
			if (i % 2 == 0) {
				sum = sum + i; // sum += 1 (x) sum += i; (o)
			}
			i++; // if문 밖으로. 증감식이 없으면 무한루프에 빠질 수 있음. 
		}
		System.out.println("1 ~ " + n + "까지의 짝수 합 : " + sum);
		
		sc.close();
	}

}
