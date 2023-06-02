package day4_practice;

import java.util.Scanner;

public class _1_IfAdultEx {

	public static void main(String[] args) {
		// 나이를 입력받아 나이가 20세 이상이면 adult를 출력하고, 20세 미만이면 minor로 출력하는 코드를 작성하세요.
		// * if else문을 이용
		
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("성인입니까?"); // "input age : "
		age = sc.nextInt(); // age를 정수로 선언했으니까 nextInt(); // 인풋 물어보고 > age값 받고,
	
		
		if (age >= 20) {
			System.out.println("adult 입니다");
		} else {
			System.out.println("minor 입니다");
		}
		
	    sc.close();
	}

}
