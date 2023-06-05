package day4.homework;

import java.util.Scanner;

public class _Answer2 {
	
	public static void main(String[] args) {
	//2. 두 정수를 입력받아 두 정수 중 큰 수를 출력하는 코드를 작성하세요.
		
		int num1, num2;
		int Max; // 두 수 중 큰 수를 저장할 변수
		
		Scanner sc = new Scanner(System.in);
		System.out.println("두 정수를 입력하세요");
		num1 = sc.nextInt();
		num2 = sc.nextInt(); // 두 정수를 입력
		// Max = (num1 > num2) ? num1 : num2; 
		
		// 큰 수를 Max에 저장, Max 출력
		// num1이 num2 보다 크거나 같으면 max에 num1을 저장
		if (num1 >= num2) {
			Max = num1; // num1 = max (x)
		}// 아니면 max에 num2를 저장
		else {
			Max = num2;
		}
		
		System.out.println("두 정수 중 큰 수는 " + Max + "입니다." ); 
		
		sc.close();
	}

}
