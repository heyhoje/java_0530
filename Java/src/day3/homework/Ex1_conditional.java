package day3.homework;

import java.util.Scanner;

public class Ex1_conditional {

	public static void main(String[] args) {
		/*1. ����(M:����, W:����)�� �Է¹޾� �������� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
		input gender : M
		Are you a women? false
		
		input gender : W
		Are you a women? true
		*/

		Scanner sc = new Scanner(System.in);
		boolean isWoman = false;
		String WOMEN = "W";
		
		while(true) {
			System.out.println("input gender : ");
			String gender = sc.next(); // "W"
			isWoman = WOMEN.equals(gender) ? true : false;
			System.out.println("Are you a women? " + isWoman);
		}
		
//		System.out.println("�������� Ȯ���Ͻÿ�.");
//		String gender = women ? "m" : "w";
//		String result = gender == m ? "man" : "woman";
//		boolean woman = true;
//		boolean man = false;
//		String gender = String.valueOf(woman);
//		
//		String result = (gender == "woman") ? "�����Դϴ�" : "�����Դϴ�"; 
//		// from String to boolean �� �ȵȴٰ� ���ٸ��� -> �׷��� String.valueOf �ẽ.
//		System.out.println("�����Դϱ�? : " + result);
//		 
//		result = (gender != "woman") ? "�����Դϴ�" : "�����Դϴ�";
//		System.out.println("�����Դϱ�? : " + result);
		
	
	}

}
