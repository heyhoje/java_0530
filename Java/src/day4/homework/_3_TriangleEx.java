package day4.homework;

import java.util.Scanner;

public class _3_TriangleEx {

	public static void main(String[] args) {
		// 3. 세 변의 길이를 정수로 입력받아 세 변으로 삼각형을 만들 수 있는지 확인하는 코드를 작성하세요.
		// 세 변 중 작은 두 변의 길이의 합이 큰 변보다 커야 삼각형을 만들 수 있다.
//		input 3 integer num : 
//		1 2 3 
//		Unable to create triangle.
//		input 3 integer num : 
//		2 2 3 
//		Able to create triangle.

		int num1, num2, num3;
		Scanner scan = new Scanner(System.in);
		System.out.println("삼각형의 세 변의 길이 : ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();
		int max;
		
		if (num2 + num3 > num1) {
			if(num1 > num2 && num1 > num3) {
				System.out.println("삼각형을 만들 수 있습니다.");
				}
//		}else if(num1 + num3 > num2){
//			if(num2 > num1 && num2 > num3) {
//				System.out.println("삼각형을 만들 수 있습니다.");
//			}
//		}else if(num1 + num2 > num3) {
//			if(num1 > num2 && num1 > num3) {
//				System.out.println("삼각형을 만들 수 있습니다.");
//				}
		}else {
				System.out.println("삼각형을 만들 수 없습니다.");	
		} 
		
		scan.close();
		
	}

}
