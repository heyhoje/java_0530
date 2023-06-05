package day4.homework;

import java.util.Scanner;

public class _Answer3 {

	public static void main(String[] args) {
		// 3. 세 변의 길이를 정수로 입력받아 세 변으로 삼각형을 만들 수 있는지 확인하는 코드를 작성하세요.
				// 세 변 중 작은 두 변의 길이의 합이 큰 변보다 커야 삼각형을 만들 수 있다.

				
				int a, b, c;
				Scanner scan = new Scanner(System.in);
				
				// 세 변의 길이 입력
				System.out.println("삼각형의 세 변의 길이 : ");
				a = scan.nextInt();
				b = scan.nextInt();
				c = scan.nextInt();
				int max; // 세 변 중 가장 큰 변의 길이
				
				// 삼각형 가능 여부를 확인 및 출력
				// 세 변 중 가장 큰 변의 길이를 계산
				// a가 b보다 크면 
				  // a가 c보다 크면, max에 a를 저장
				  // 아니면 c를 max에 저장
				
				if (a > b) {
					if (a > c) {
						max = a;
					}else {
						max = c;
					}
				// a가 b보다 작으면
				  // b가 c보다 크면, max에 b를 저장
				  // 아니면 max에 c를 저장
				}else if (b > c) {
					max = b;
				} else {
					max = c;
				}
				
				// 조건연산자로 1줄로 쓰면
				// max = a > b ? ( a > c ? a : c )  : ( b > c ? b : c ); // 조금 복잡하지만 조건연산자를 쓰면 코드가 간결해질 수 있다. 
				System.out.println("가장 큰 변은 " + max + " 입니다");
				
				//삼각형 가능여부 확인
				//작은 두변의 합 > max
				if (max < a + b + c - max) {// 아름님이 떠올린거 맞았다!!!!
					System.out.println("삼각형을 만들 수 있습니다.");
				} else {
					System.out.println("삼각형을 만들 수 없습니다.");
				}
				
				scan.close();
				
	}

}
