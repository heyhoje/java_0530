package day5_practice;

import java.util.Scanner;

public class _4_DivisorEx {

	public static void main(String[] args) {
		// 4. 정수 num를 입력받아 num의 약수를 출력하는 코드를 작성하세요.
		// 약수 : A를 B로 나누었을 때 나머지가 0이면 B는 A의 약수이다. 
		// 12의 약수 : 1, 2, 3, 4, 6, 12
		
		int num, i;
		Scanner sc = new Scanner(System.in);
		//정수입력
		System.out.println("정수 num을 입력하세요.");
		num = sc.nextInt();
		
		// 반복횟수 : 1부터 num까지 1씩 증가 
		//        i가 num의 약수라면 i를 출력 =>
		// 규칙성 : (num % i == 0) 이라면, i는 num의 약수이다. 
		
		//반복문, i를 초기화
		//      i는 1부터 num 까지 1씩 증가
		//     	num을 i로 나누었을 때 나머지가 0과 같다면, i를 출력
		i = 1;
		while(i <= num) {
			if(num % i == 0) {
				//System.out.println(i + "는 " + num + "의 약수이다.");
				System.out.println(i);
			}
			++i;
			
		sc.close();	
		}
		
	}

}
