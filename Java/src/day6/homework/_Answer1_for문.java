package day6.homework;

import java.util.Scanner;

public class _Answer1_for문 {

	public static void main(String[] args) {
		// 서로소 <- practice 최대공약수 문제 활용
		/* 1. 두 정수를 입력받아 두 정수가 서로소 관계인지 판별하는 코드를 작성하시오
		 * 서로소 : 최대 공약수가 1인 두 수의 관계 <<- day6.practice3.gcd문제에서 반복문 종료 후 출력문만 달라짐.
		 * input 2 numbers : 3 4
		 * Disjoint! (서로소)
		 * input 2 numbers : 8 4
		 * Not disjoint! (서로소 아님)
		 */
		
		// 반복문 : i는 1부터 num1(num2)까지, 1씩 증가 
				// 규칙성 : i가 num1의 약수이고, i가 num2의 약수이면, i를 gcd에 저장
				//num % i == 0 && num2 % i ==0, i를 gcd에 저장 
				// 반복문 종료 후 : gcd가 1이면 Disjoint를 출력하고
				// 				아니면 Not Disjoint를 출력
				
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
				 * 5) gcd가 1이면 Disjoint를 출력하고, 아니면 Not Disjoint를 출력
				 */
				
//				i = 1;
//				gcd = 0;
				for (i = 1, gcd = 1; i <= num1; i++) {
					if (num1 % i == 0 && num2 % i == 0) {
						gcd = i; // *i를 gcd에 저장!! l변수와 r변수 순서도 중요함...!!!
					}
					// System.out.println(gcd);
				//	i++;
				}
				
				// a = b : b를 a에 저장 / A == B : A는 B와 같다. 
				if(gcd == 1) {
					System.out.println("서로소이다");
				}else {
					System.out.println("서로소가 아니다");
				}
				System.out.println("최대공약수는 " + gcd);
				
				sc.close();

		}
				
	}


