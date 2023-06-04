package day4.homework;

import java.util.Scanner;

public class _4_NumberEx {

	public static void main(String[] args) {
		//4. 정수 num이 짝수이면 num에 2를 나누고, 정수 num이 홀수이면 num에 1을 더한 후, num을 출력하는 코드를 작성하세요.
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 num을 입력하세요");
		num = sc.nextInt();
		
		if (num % 2 == 0) {
			num /= 2;
		}else if (num % 2 == 1) {
			num += 1;
		}
		System.out.println(num);
		sc.close();
	}

}
