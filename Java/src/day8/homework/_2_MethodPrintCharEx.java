package day8.homework;

import java.util.Scanner;

public class _2_MethodPrintCharEx {

	public static void main(String[] args) {
		// 2.다음과 같이 출력하기 위한 코드를 작성하세요 (단, 메소드 이용)
		// if 조건 따지는게 아니라 한줄씩 입력되도록 
		// *****
		// ***
		// ?????
		// ^^^^^^^
		
		System.out.println("*****");
		System.out.println("***");
		System.out.println("?????");
		System.out.println("^^^^^^^");
	}

	
	/** 매개변수 : int i, char 
	 *	리턴타입 : 특수문자 => Char
	 *	매소드명 : PrintChar 
	 */
	 
	//public static 리턴타입 메소드명(매개변수);
	
	public static void PrintChar(String text) {
		System.out.println(text);
	}
	
}
