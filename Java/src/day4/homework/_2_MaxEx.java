package day4.homework;

import java.util.Scanner;

public class _2_MaxEx {

	public static void main(String[] args) {
		//2. �� ������ �Է¹޾� �� ���� �� ū ���� ����ϴ� �ڵ带 �ۼ��ϼ���.
		
		int num1, num2;
		int Max;
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ������ �Է��ϼ���");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		Max = (num1 > num2) ? num1 : num2;
		System.out.println("�� ���� �� ū ���� " + Max + "�Դϴ�." );
	}

}
