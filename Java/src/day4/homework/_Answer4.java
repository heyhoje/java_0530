package day4.homework;

import java.util.Scanner;

public class _Answer4 {

	public static void main(String[] args) {
		// 4. 정수 num이 짝수이면 num에 2를 나누고, 
				// 정수 num이 홀수이면 num에 1을 더한 후, num을 출력하는 코드를 작성하세요.
				
				int num;
				Scanner sc = new Scanner(System.in);
				// 정수 입력
				System.out.println("정수 num을 입력하세요");
				num = sc.nextInt();
				
				// 정수 num가 짝수이면 num에 2를 나누고(나머지 0 이니까 int값 나옴)
				// num 2 를 나눈 값을 num에 저장
				if (num % 2 == 0) {
					num /= 2; // num = num / 2;
				}// 아니면 num에 1을 더한 후
				// num에 1을 더한 값을 num에 저장(또한 int 값이 나

				//else if (num % 2 == 1) 
				else {
					num += 1; // num = num + 1'\; << 변수를 하나 덜 쓸 수 있는 방법을 보여주려고 낸 문제
				}
					
				// num을 출력
				System.out.println(num);
				sc.close();
	}

}
