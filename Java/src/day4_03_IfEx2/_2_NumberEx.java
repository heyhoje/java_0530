package day4_03_IfEx2;

import java.util.Scanner;

public class _2_NumberEx {

	public static void main(String[] args) {
		/* 정수 num가 양수이면 positive number라고 출력하고
		 * num가 음수이면 negative number로 출력하고
		 * num가 0이면 0으로 출력하는 코드를 작성하시오.
		 * (if문만을 이용해서 작업했었음. 이번에는 if else를 사용)
		 */
		
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.println("input number : ");
		num = scan.nextInt();
		
		// 정수 num가 양수이면 "양수"라고 출력하고
		if (num > 0) {
			System.out.println(num + "는 양수이다");
		}else if (num < 0) { // 정수 num가 음수이려면, 양수가 아닌 수 중에서 음수를 판별. num !> 0 )
			System.out.println(num + "은 음수이다");
		}else {// 0은 음수도 아니고 양수도 아님
			System.out.println(num + "은 0이다");
		}
		
	}

}
