package day7_practice;

import java.util.Scanner;

public class _1_LCMEx {

	public static void main(String[] args) {
		/* 1. 두 정수를 입력 받아 두 정수의 최소공배수를 구하는 코드를 작성하세요.
		 * 						(* break문 포함) 그 후 공배수들이 무한이기때문 
		 * 2의 배수 : 2, 4, 6, 8, 10, ....
		 * 공배수 : 공통으로 있는 배수
		 * 6과 8의 공배수 : 24, 48, 72, ...
		 * 최소 공배수 : 공배수 중 가장 작은 배수
		 * 6과 8의 최소 공배수 : 24
		 */
		
		// 최대공약수는 count를 덮어쓰기 해서
		// 최소공배수는 break문을 이용
		
		// 두 정수 입력
		int num1, num2;
		int i;
		System.out.println("두 정수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		/* 반복횟수 : i는 1부터 (num1*num2까지) 1씩 증가
		 * 규칙성 : i가 num1의 배수이고, i가 num2의 배수이면 
		 * 		  i를 출력 후 반복문을 종료
		 * 		  => i를 num1로 나누었을때 나머지가 0과 같고
		 * 			 i를 num2로 나누었을때 나머지가 0과 같다면
		 * 			 i를 출력 후 반복문 탈출 
		 * 반복문 종료 후 : 없음
		 */
		
		System.out.println("---- 방 법 1 ----");
		for (i = 1; i <= num1*num2 ;i++) {
			// num1의 배수와 num2의 배수가 같아질때까지
			// 공배수 문제를 어디서 풀었더라... 
			if(i % num1 == 0 && i % num2 == 0) { // 약수는 num % i, 배수는 i % num
				System.out.println(i); // 면 앞에까지는 조건식, 뒤에는 실행문!!!!!!!!!! 
				//sysout을 break뒤에 써서 아무것도 안된거였네 맞네 ㅔ그러네
			break;
			}
		}
		
		System.out.println("---- 방 법 2 ----");
		/* 반복횟수 : i는 1부터 (num1*num2까지) num1씩 증가
		 * 규칙성 : //i가 num1의 배수이고,// i가 num2의 배수라면 
		 * 		  i를 출력 후 반복문을 종료 */
		for (i = 1; ;i += num1) {
			if(i % num2 == 0) {
				System.out.println(i);
				break;
			}
		}
		
		// 방법1과 방법2는 반복횟수의 차이만 있다.
		// 10,000 15,000 의 최소공배수는 1부터 10,000까지 반복 / 10,000 20,000 30,000 

		
	}

}
