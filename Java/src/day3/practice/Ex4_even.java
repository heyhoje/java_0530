package day3.practice;

import java.util.Scanner;

public class Ex4_even {
	public static void main(String[] args) {
	//���� num�� �Է¹޾� num�� Ȧ������ ¦������ �Ǻ��ϴ� �ڵ带 �ۼ��ϼ���.

	int num;
	Scanner scan = new Scanner(System.in);
	System.out.println("input number : ");
	num = scan.nextInt();
	
	//num�� 2�� [���������� ������]�� 0�� �ƴϸ� Ȧ��
	//num�� 2�� [���������� ������]�� 0�̸� ¦��
	
	if(num % 2 == 0) {
		System.out.println(num + "�� ¦���̴�.");
	}
	if(num % 2 != 0) {
		System.out.println(num + "�� Ȧ���̴�.");
	}
	scan.close();
	
	}
	
	
	
	

}
