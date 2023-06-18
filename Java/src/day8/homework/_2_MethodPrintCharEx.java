package day8.homework;

import java.util.Scanner;

public class _2_MethodPrintCharEx {

	public static void main(String[] args) {
		// 2.������ ���� ����ϱ� ���� �ڵ带 �ۼ��ϼ��� (��, �޼ҵ� �̿�)
		// if ���� �����°� �ƴ϶� ���پ� �Էµǵ��� 
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
	
	/** ��� : ���ڿ��� �־����� �־��� ���ڿ��� ����ϰ� �ٹٲ��ϴ� �޼ҵ� 
	 * �Ű����� : 
	 * ����Ÿ�� : 
	 * �żҵ�� : printString
	 */
		 
	//public static ����Ÿ�� �޼ҵ��(�Ű�����);
	public static void printString(String str) {
		System.out.println(str);
	}
		
	/** ��� : ���ڿ� ������ �־����� �־��� ���ڸ� ������ŭ ����ϴ� �޼ҵ�
	 * �Ű����� : ����, ���� => , count
	 * ����Ÿ�� : (���) ���� => void
	 * �żҵ�� : printChar
	 */
	
	public static void printChar (char ch, int count) {
		for(int i = 1; i <= count; i++) {
			System.out.print(ch);
		}
	}
	 
	/** ��� : ���ڿ� ����, ������ ���ڰ� �־�����, �־��� ���ڸ� ������ŭ ����ϰ� ������ ���ڸ� ����ϴ� �޼ҵ� 
	 * �Ű����� : ����, ����, ������ ���� =>  char ch, int count, char lastCh
	 * ����Ÿ�� : ������ ���� ��� => String
	 * �żҵ�� : printChar
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
