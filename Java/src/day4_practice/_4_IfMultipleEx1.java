package day4_practice;

import java.util.Scanner;

public class _4_IfMultipleEx1 {

	public static void main(String[] args) {
		// ���� num�� �Է¹޾� num�� 2�� ������� �ƴ��� �Ǻ��ϴ� �ڵ带 �ۼ��ϼ���.
		// 2�� ��� Ȯ�� ����(Ȧ¦�� ����)
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input integer number : ");
		num = sc.nextInt();
		
		if (num % 2 == 0) {
			System.out.println(num + "�� 2�� ����̴�.");
		}else {
			System.out.println(num + "�� 2�� ����� �ƴϴ�.");
		}
	
		sc.close();
	}

}
