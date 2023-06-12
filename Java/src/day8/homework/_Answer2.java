package day8.homework;

import java.util.Scanner;

public class _Answer2 {

	public static void main(String[] args) {
		// 2.다음과 같이 출력하기 위한 코드를 작성하세요 (단, 메소드 이용)
		// if 조건 따지는게 아니라 한줄씩 입력되도록 
		// *****
		// ***
		// ?????
		// ^^^^^^^
		
		printString("*****");
		printString("***");
		printString("?????");
		printString("^^^^^^^");
				
		System.out.println("------");
				
		printChar('*', 5);
		System.out.println();
		printChar('*', 3);
		System.out.println();
		printChar('?', 5);
		System.out.println();
		printChar('^', 7);
		System.out.println();
				
		System.out.println("------");
				
		printChar('*', 5, '\n');
				
		System.out.println("---------");
				
		int num = 5;
		for (int i = 1; i <= num; i++) {
		// 공백('')이 num - i개 출력
		printChar(' ', num - i);
		// '*'이 i개 출력 후 엔터
		printChar('*', i, '\n');
		}

	}		
		/** 기   능 : 문자열이 주어지면 주어진 문자열을 출력하고 줄바꿈하는 매소드 
		 * 	매개변수 : 문자열 => String text(Str)
		 *	리턴타입 : 없음 => void
		 *	매소드명 : PrintString 
		 */
			 
	//public static 리턴타입 메소드명(매개변수);
			
	public static void printString(String text) {
		System.out.println(text);
		}
			
		/** 기   능 : 문자와 개수가 주어지면 주어진 문자를 개수만큼 ��력하는 매소드 
		 * 	매개변수 : 문자와 개수 => char ch, int count 
		 *	리턴타입 : 없음 => void
		 *	매소드명 : PrintChar 
		 */
			
	public static void printChar(char ch, int count) {
		for (int i = 1; i <= count; i++) {
			System.out.print(ch);
			}
		}
			
		/** 기   능 : 문자와 개수, 마지막 문자가 주어지면 주어진 문자를 개수만큼 출력하고 마지막 문자를 출력하는 메소드 
		 * 	매개변수 : 문자와 개수, 마지막 ㅣ문자 => char ch, int count, char lastCh 
		 *	리턴타입 : ��력된 문자열 => String
		 *	메소드명 : PrintChar 
		 *  메소드 오버로딩으로 printChar 메소드 추가! 매개변수 2 -> 3
		 */
			
	public static String printChar(char ch, int count, char lastCh) {
		String str = "";
		for(int i = 1; i <= count; i++) {
			System.out.print(ch);
			str += ch;
			}
			System.out.println(lastCh);
			str += lastCh;
			return str;
			
	}
}