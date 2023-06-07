package day6.homework;

import java.util.Scanner;

public class _1_DisjointEx {

	public static void main(String[] args) {
		// 서로소 <- practice 최대공약수 문제 활용
		/* 1. 두 정수를 입력받아 두 정수가 서로소 관계인지 판별하는 코드를 작성하시오
		 * 서로소 : 최대 공약수가 1인 두 수의 관계
		 * input 2 numbers : 3 4
		 * Disjoint! (서로소)
		 * input 2 numbers : 8 4
		 * Not disjoint! (서로소 아님)
		 */
		
		int num1, num2, i;
		System.out.println("두 정수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		// 서로소 = 최대 공약수가 1이다 = 1외에는 공통약수가 없다.
		// i는 num1의 약수이거나, num2의 약수이다.
		i = 2;
		while(i <= num1) {
			if(num1 % i == 0 || num2 % i == 0 ) {
				System.out.println(num1 + "과 " + num2 + "는 서로소이다");
			}else if (num1 % i == 0 && num2 % i == 0 ) {
				System.out.println(num1 + "과 " + num2 + "는 서로소가 아니다");
			}
			i++;
		}
		
		
		
		sc.close();
	}

}
