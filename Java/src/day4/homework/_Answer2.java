package day4.homework;

import java.util.Scanner;

public class _Answer2 {
	
	public static void main(String[] args) {
	//2. �� ������ �Է¹޾� �� ���� �� ū ���� ����ϴ� �ڵ带 �ۼ��ϼ���.
		
		int num1, num2;
		int Max; // �� �� �� ū ���� ������ ����
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�� ������ �Է��ϼ���");
		num1 = sc.nextInt();
		num2 = sc.nextInt(); // �� ������ �Է�
		// Max = (num1 > num2) ? num1 : num2; 
		
		// ū ���� Max�� ����, Max ���
		// num1�� num2 ���� ũ�ų� ������ max�� num1�� ����
		if (num1 >= num2) {
			Max = num1; // num1 = max (x)
		}// �ƴϸ� max�� num2�� ����
		else {
			Max = num2;
		}
		
		System.out.println("�� ���� �� ū ���� " + Max + "�Դϴ�." ); 
		
		sc.close();
	}

}
