package day4.homework;

import java.util.Scanner;

public class _3_TriangleEx2 {

	public static void main(String[] args) {
		// 3. 세 변의 길이를 정수로 입력받아 세 변으로 삼각형을 만들 수 있는지 확인하는 코드를 작성하세요.
		// 세 변 중 작은 두 변의 길이의 합이 큰 변보다 커야 삼각형을 만들 수 있다.
//		input 3 integer num : 
//		1 2 3 
//		Unable to create triangle.
//		input 3 integer num : 
//		2 2 3 
//		Able to create triangle.

		int num0, num1, num2;
		Scanner scan = new Scanner(System.in);
		System.out.println("삼각형의 세 변의 길이 : ");
		num0 = scan.nextInt();
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		int[] num = new int[] {num0, num1, num2};
		int max = num[0];
		
		for (int i = 1; num.length > i; i++)
			if(num[1] > max) {
				max = num[1];
			}
		
	
		if(max < (num0 + num1 + num2) - max) {
			System.out.println("삼각형을 만들 수 있습니다.");
		}else {
			System.out.println("삼각형을 만들 수 없습니다.");
		}
		
		scan.close();
		
	}

}
