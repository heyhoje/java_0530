package day4.homework;

import java.util.Scanner;

public class _3_TriangleEx {

	public static void main(String[] args) {
		// 3. �� ���� ���̸� ������ �Է¹޾� �� ������ �ﰢ���� ���� �� �ִ��� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
		// �� �� �� ���� �� ���� ������ ���� ū ������ Ŀ�� �ﰢ���� ���� �� �ִ�.
//		input 3 integer num : 
//		1 2 3 
//		Unable to create triangle.
//		input 3 integer num : 
//		2 2 3 
//		Able to create triangle.

		int num1, num2, num3;
		Scanner scan = new Scanner(System.in);
		System.out.println("�ﰢ���� �� ���� ���� : ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();
		int max;
		
		if (num2 + num3 > num1) {
			if(num1 > num2 && num1 > num3) {
				System.out.println("�ﰢ���� ���� �� �ֽ��ϴ�.");
				}
//		}else if(num1 + num3 > num2){
//			if(num2 > num1 && num2 > num3) {
//				System.out.println("�ﰢ���� ���� �� �ֽ��ϴ�.");
//			}
//		}else if(num1 + num2 > num3) {
//			if(num1 > num2 && num1 > num3) {
//				System.out.println("�ﰢ���� ���� �� �ֽ��ϴ�.");
//				}
		}else {
				System.out.println("�ﰢ���� ���� �� �����ϴ�.");	
		} 
		
		scan.close();
		
	}

}