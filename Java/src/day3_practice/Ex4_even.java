package day3_practice;

import java.util.Scanner;

public class Ex4_even {
	public static void main(String[] args) {
	//정수 num을 입력받아 num가 홀수인지 짝수인지 판별하는 코드를 작성하세요.

	int num;
	Scanner scan = new Scanner(System.in);
	System.out.println("input number : ");
	num = scan.nextInt();
	
	//num를 2로 [나누었을때 나머지]가 0이 아니면 홀수
	//num을 2로 [나누었을때 나머지]가 0이면 짝수
	
	if(num % 2 == 0) {
		System.out.println(num + "은 짝수이다.");
	}
	if(num % 2 != 0) {
		System.out.println(num + "은 홀수이다.");
	}
	scan.close();
	
	}
	
	
	
	

}
