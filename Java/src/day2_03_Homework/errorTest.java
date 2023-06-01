package day2_03_Homework;

import java.util.Scanner;

public class errorTest {

	public static void main(String[] args) {
		System.out.println("두 정수를 입력하세요.");// 안내 문구 출력
		Scanner sc = new Scanner(System.in);
		// 콘솔에서 입력받을 수 있는 스캐너 생성
		// 두 정수를 입력받음
		int num3 = sc.nextInt();// 변수선언. 변수 선언과 동시에 초기화.???????
		int num4 = sc.nextInt();
		// 두 변수의 산술 연산을 계산
		int sum = num3 + num4;
		int sub = num3 - num4;
		int mul = num3 * num4;
		double div = num3 / (double)num4; // 나누기는 더블!!!!!!! 오른쪽 변수에도 더블!! 하나는 실수로 만들어야함.
		int mod = num3 % num4;
		
		//결과를 콘솔에 출력
		System.out.println("" + num3 + " + " + num4 + " = " + sum);
		System.out.println("" + num3 + " - " + num4 + " = " + sub);
		System.out.println("" + num3 + " * " + num4 + " = " + mul);
		System.out.println("" + num3 + " / " + num4 + " = " + div);
		System.out.println("" + num3 + " % " + num4 + " = " + mod);
		
		sc.close();
	}

}
