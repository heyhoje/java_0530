package day18.practice;

import java.util.Scanner;

public class _2_StringCharAtEx {

	public static void main(String[] args) {
		// 2. ���� �ҹ��ڷ� �� ���ڿ��� �Է¹޾� ���ĺ��� ���� � �ִ��� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
		/* input : hello world
		 * a : 0 => 0���� ��� ����
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
		
		// ã�� �ܾ� ��������
		// int num = sc.nextInt();
		System.out.println("���� �ҹ��ڸ� �Է��ϼ��� : ");
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
