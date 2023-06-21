package day4._03_IfEx2;

import java.util.Scanner;

public class _1_EvenNumberEx {

	public static void main(String[] args) {
		//if else 문을 이용한 홀짝 판별 예제
		
//		int num;
//		Scanner scan = new Scanner(System.in);
//		System.out.println("홀짝을 맞춰보세요!");
//		num = scan.nextInt();
		
		int num = 4;
		if(num % 2 == 0) {
			System.out.println("짝수");
		}else { // 앞에있는 조건문이 아니면, 
			System.out.println("홀수");
		}
		
		//scan.close();
	}

}
