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
		
		printString("*****");
		printChar('*', 3);
		System.out.println();
		printChar('?', 5, '\n');
		printChar('^', 7, '\n');
		
	}
	
	/** 기능 : 문자열이 주어지면 주어진 문자열을 출력하고 줄바꿈하는 메소드 
	 * 매개변수 : 
	 * 리턴타입 : 
	 * 매소드명 : printString
	 */
		 
	//public static 리턴타입 메소드명(매개변수);
	public static void printString(String str) {
		System.out.println(str);
	}
		
	/** 기능 : 문자와 개수가 주어지면 주어진 문자를 개수만큼 출력하는 메소드
	 * 매개변수 : 문자, 개수 => , count
	 * 리턴타입 : (출력) 없음 => void
	 * 매소드명 : printChar
	 */
	
	public static void printChar (char ch, int count) {
		for(int i = 1; i <= count; i++) {
			System.out.print(ch);
		}
	}
	 
	/** 기능 : 문자와 개수, 마지막 문자가 주어지면, 주어진 문자를 개수만큼 출력하고 마지막 문자를 출력하는 메소드 
	 * 매개변수 : 문자, 개수, 마지막 문자 =>  char ch, int count, char lastCh
	 * 리턴타입 : 마지막 문자 출력 => String
	 * 매소드명 : printChar
	 */
	 
	public static String printChar(char ch, int count, char lastCh) {
		String str = "";
		for(int i = 1; i <= count; i++) {
			System.out.print(ch);
			str += ch;
		}
		System.out.print(lastCh);
		str += lastCh;
		return str;
	}
	
	
}
