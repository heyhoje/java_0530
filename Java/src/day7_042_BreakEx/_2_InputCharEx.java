package day7_042_BreakEx;

import java.util.Scanner;

public class _2_InputCharEx {

	public static void main(String[] args) {
		// q를 입력하면 반복문을 종료하는 예제
		
		char ch;
		Scanner sc = new Scanner(System.in);
		
		//for문은 조건식을 생략하면 무한루프, 항상 true가 나옴
		for(; ;) {
			System.out.println("input char (exit : q) : ");
			ch = sc.next().charAt(0); // ch 입력
			if(ch == 'q') {
				break;
			}
		}
		System.out.println("종료");
		
		sc.close();
	}

}
