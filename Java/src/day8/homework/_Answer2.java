package day8.homework;

import java.util.Scanner;

public class _Answer2 {

	public static void main(String[] args) {
		// 2.´ÙÀ½°ú °°ÀÌ Ãâ·ÂÇÏ±â À§ÇÑ ÄÚµå¸¦ ÀÛ¼ºÇÏ¼¼¿ä (´Ü, ¸Þ¼Òµå ÀÌ¿ë)
		// if Á¶°Ç µûÁö´Â°Ô ¾Æ´Ï¶ó ÇÑÁÙ¾¿ ÀÔ·ÂµÇµµ·Ï 
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
		// °ø¹é('')ÀÌ num - i°³ Ãâ·Â
		printChar(' ', num - i);
		// '*'ÀÌ i°³ Ãâ·Â ÈÄ ¿£ÅÍ
		printChar('*', i, '\n');
				}

			
		/** ±â   ´É : ¹®ÀÚ¿­ÀÌ ÁÖ¾îÁö¸é ÁÖ¾îÁø ¹®ÀÚ¿­À» Ãâ·ÂÇÏ°í ÁÙ¹Ù²ÞÇÏ´Â ¸Å¼Òµå 
		 * 	¸Å°³º¯¼ö : ¹®ÀÚ¿­ => String text(Str)
		 *	¸®ÅÏÅ¸ÀÔ : ¾øÀ½ => void
		 *	¸Å¼Òµå¸í : PrintString 
		 */
			 
		//public static ¸®ÅÏÅ¸ÀÔ ¸Þ¼Òµå¸í(¸Å°³º¯¼ö);
			
		public static void printString(String text) {
			System.out.println(text);
		}
			
		/** ±â   ´É : ¹®ÀÚ¿Í °³¼ö°¡ ÁÖ¾îÁö¸é ÁÖ¾îÁø ¹®ÀÚ¸¦ °³¼ö¸¸Å­ ­„·ÂÇÏ´Â ¸Å¼Òµå 
		 * 	¸Å°³º¯¼ö : ¹®ÀÚ¿Í °³¼ö => char ch, int count 
		 *	¸®ÅÏÅ¸ÀÔ : ¾øÀ½ => void
		 *	¸Å¼Òµå¸í : PrintChar 
		 */
			
		public static void printChar(char ch, int count) {
			for (int i = 1; i <= count; i++) {
				System.out.print(ch);
			}
		}
			
			/** ±â   ´É : ¹®ÀÚ¿Í °³¼ö, ¸¶Áö¸· ¹®ÀÚ°¡ ÁÖ¾îÁö¸é ÁÖ¾îÁø ¹®ÀÚ¸¦ °³¼ö¸¸Å­ Ãâ·ÂÇÏ°í ¸¶Áö¸· ¹®ÀÚ¸¦ Ãâ·ÂÇÏ´Â ¸Þ¼Òµå 
			 * 	¸Å°³º¯¼ö : ¹®ÀÚ¿Í °³¼ö, ¸¶Áö¸· ¤Ó¹®ÀÚ => char ch, int count, char lastCh 
			 *	¸®ÅÏÅ¸ÀÔ : ­‹·ÂµÈ ¹®ÀÚ¿­ => String
			 *	¸Þ¼Òµå¸í : PrintChar 
			 *  ¸Þ¼Òµå ¿À¹ö·ÎµùÀ¸·Î printChar ¸Þ¼Òµå Ãß°¡! ¸Å°³º¯¼ö 2 -> 3
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
