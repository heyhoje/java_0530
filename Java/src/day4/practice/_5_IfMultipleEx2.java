package day4.practice;

import java.util.Scanner;

public class _5_IfMultipleEx2 {

	public static void main(String[] args) {
		// ���� num�� �Է¹޾� num�� 2�� ����̸� 2�� ������ ����ϰ�, 
		// 3�� ����̸� 3�� ������ ����ϰ�, 6�� ����̸� 6�� ������ ����ϰ�, 
		// 2, 3, 6�� ����� �ƴ϶�� 2, 3, 6�� ����� �ƴ϶�� ����ϴ� �ڵ带 �ۼ��ϼ���
		// �� : 6�� 6�� ��� (�ϳ��� ��µǵ��� �ؾ���)
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input integer number : ");
		num = sc.nextInt();
		
		//6�� ����� �� ���ϴ� ������ ����Ǳ� ���� 6�� ������� üũ�ϵ��� ������ �Ű澸
		if (num % 6 == 0) {// 6�� ����!! 
			System.out.println(num + "�� 6�� ���");
		} else if (num % 2 == 0 && num % 6 != 0) {
			System.out.println(num + "�� 2�� ���");
		} else if (num % 3 == 0 && num % 6 != 0) {
			System.out.println(num + "�� 3�� ���");
		} else {
			System.out.println(num + "�� 2, 3, 6�� ����� �ƴϴ�."); //  else �� ���ڱ� ������ ó���ǳ�;;;;;;);
		}
		
		System.out.println("--------------------------------");
		// 6�� ����� �ƴ� 2�� ����� ã�� ���� 2�� ��������� 3�� ����� �ƴ� ������ Ȯ�� - && num % 3 != 0
		if (num % 2 == 0 && num % 6 != 0) {
			System.out.println(num + "�� 2�� ���");
		//6�� ����� �ƴ� 3�� ����� ã�� ���� 2�� ��������� 3�� ����� �ƴ� ������ Ȯ�� - && num % 2 != 0
		} else if (num % 3 == 0 && num % 6 != 0) {
			System.out.println(num + "�� 3�� ���");
		} else if (num % 6 == 0) {
			System.out.println(num + "�� 6�� ���"); // 6�� ����� �����ص� ��;;;; �� ������ ����..... 
													// ������ �ٲ㼭 �Ҷ� ����� �޶��� �� ����
		}else {
			System.out.println(num + "�� 2, 3, 6�� ����� �ƴϴ�."); //  else �� ���ڱ� ������ ó���ǳ�;;;;;; = ���� ��ȣ �ϳ� �ȴݾƼ�..!
		}
		
	
	}
}

