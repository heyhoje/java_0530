package day4.homework;

import java.util.Scanner;

public class _3_TriangleEx2 {

	public static void main(String[] args) {
		// 3. �� ���� ���̸� ������ �Է¹޾� �� ������ �ﰢ���� ���� �� �ִ��� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
		// �� �� �� ���� �� ���� ������ ���� ū ������ Ŀ�� �ﰢ���� ���� �� �ִ�.
//		input 3 integer num : 
//		1 2 3 
//		Unable to create triangle.
//		input 3 integer num : 
//		2 2 3 
//		Able to create triangle.

		int num0, num1, num2;
		Scanner scan = new Scanner(System.in);
		System.out.println("�ﰢ���� �� ���� ���� : ");
		num0 = scan.nextInt();
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		int[] num = new int[] {num0, num1, num2};
		int max = num[0];
		
		for (int i = 1; num.length > i; i++)
			if(num[1] > max) {
				max = num[1];
			}
		
	
		if(max < (num0 + num1 + num2) - max) {
			System.out.println("�ﰢ���� ���� �� �ֽ��ϴ�.");
		}else {
			System.out.println("�ﰢ���� ���� �� �����ϴ�.");
		}
		
		scan.close();
		
	}

}
