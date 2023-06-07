package day6_practice;

import java.util.Scanner;

public class _3_GCDEx {

	public static void main(String[] args) {
		// 3. 두 정수 num1과 num2를 입력받아 두 정수의 최대 공약수를 구하는 코드를 작성하시오
		/* 약수 : 나누어 떨어지는 수
		 * 공약수 : 공통으로 있는 약수
		 * 최대 공약수 : 공약수 중 가장 큰 수
		 * 8과 12의 공약수 : 1, 2, 4
		 * 8과 12의 최대공약수
		 * 9, 10, 11, 12 = 8의 약수가 될 수 없기 때문에, num1로 하든 num2로 하든 상관없다.
		 */
		
		// 반복문 : i는 1부터 num1(num2)까지, 1씩 증가 
		// 규칙성 : i가 num1의 약수이고, i가 num2의 약수이면, i를 gcd에 저장
		//num % i == 0 && num2 % i ==0, i를 gcd에 저장 
		// 반복문 종료 후 : gcd 출력 => 공약수에 2를 저장하면 1을 덮어씀. 4를 저장하면 2를 덮어씀. 최대 공약수만 남음
		
		int num1 = 0, num2 = 0;
		int i, gcd;
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt(); // num 입력문을 while안에 넣으면 안됨.
		
		/* 1) 두 정수를 입력
		 * 2) 반복문(최대공약수를 구하기 위한, 안에 정수를 입력하면 안됨) : i가 num1까지	
		 * 	3) num1을 i로 나누었을때 나머지가 0과 같고, num2를 i로 나누었을 때 나머지가 0과 같다면, i를 gcd에 저장
		 * 	4) i를 1증가
		 * 5) gcd를 출력
		 */
		
		i = 1;
		gcd = 0;
		while (i <= num1) {
			if (num1 % i == 0 && num2 % i ==0) {
				gcd = i; // *i를 gcd에 저장!! l변수와 r변수 순서도 중요함...!!!
			}
			// System.out.println(gcd);
			i++;
		}
		System.out.println("최대공약수는 " + gcd);
		
		sc.close();
	}
}
