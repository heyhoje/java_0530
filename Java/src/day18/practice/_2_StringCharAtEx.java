package day18.practice;

import java.util.Scanner;

public class _2_StringCharAtEx {

	public static void main(String[] args) {
		// 2. 영문 소문자로 된 문자열을 입력받아 알파벳이 각각 몇개 있는지 확인하는 코드를 작성하세요.
		/* input : hello world
		 * a : 0 => 0개는 출력 안함
		 * d
		 * e
		 * h
		 * l
		 * o
		 * r
		 * w
		 */
		
		String str = "hello world!";
		//char alphabet = 'a';
		int count = 0;
		int index = -1;
		Scanner sc = new Scanner(System.in);
		
		// 찾을 단어 변수설정
		// int num = sc.nextInt();
		System.out.println("영문 소문자를 입력하세요 : ");
		char alphabet = sc.next().charAt(0);
		
//		for (int i = 1; i < 26; i++) {
//			
//	}
		do {
			index = str.indexOf(alphabet, ++index);
			if(index != -1) {
				count++;
			}
			
		}while(index != -1);
		System.out.println(alphabet + " : " + count);
		
		
		
		
		
	}

}
