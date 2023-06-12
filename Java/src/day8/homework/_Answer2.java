package day8.homework;

import java.util.Scanner;

public class _Answer2 {

	public static void main(String[] args) {
		// 2.������ ���� ����ϱ� ���� �ڵ带 �ۼ��ϼ��� (��, �޼ҵ� �̿�)
		// if ���� �����°� �ƴ϶� ���پ� �Էµǵ��� 
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
		// ����('')�� num - i�� ���
		printChar(' ', num - i);
		// '*'�� i�� ��� �� ����
		printChar('*', i, '\n');
				}

			
		/** ��   �� : ���ڿ��� �־����� �־��� ���ڿ��� ����ϰ� �ٹٲ��ϴ� �żҵ� 
		 * 	�Ű����� : ���ڿ� => String text(Str)
		 *	����Ÿ�� : ���� => void
		 *	�żҵ�� : PrintString 
		 */
			 
		//public static ����Ÿ�� �޼ҵ��(�Ű�����);
			
		public static void printString(String text) {
			System.out.println(text);
		}
			
		/** ��   �� : ���ڿ� ������ �־����� �־��� ���ڸ� ������ŭ �����ϴ� �żҵ� 
		 * 	�Ű����� : ���ڿ� ���� => char ch, int count 
		 *	����Ÿ�� : ���� => void
		 *	�żҵ�� : PrintChar 
		 */
			
		public static void printChar(char ch, int count) {
			for (int i = 1; i <= count; i++) {
				System.out.print(ch);
			}
		}
			
			/** ��   �� : ���ڿ� ����, ������ ���ڰ� �־����� �־��� ���ڸ� ������ŭ ����ϰ� ������ ���ڸ� ����ϴ� �޼ҵ� 
			 * 	�Ű����� : ���ڿ� ����, ������ �ӹ��� => char ch, int count, char lastCh 
			 *	����Ÿ�� : ���µ� ���ڿ� => String
			 *	�޼ҵ�� : PrintChar 
			 *  �޼ҵ� �����ε����� printChar �޼ҵ� �߰�! �Ű����� 2 -> 3
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
	}
}
