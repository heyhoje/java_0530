package day6.homework;

import java.util.Scanner;

public class _1_DisjointEx {

	public static void main(String[] args) {
		// ���μ� <- practice �ִ����� ���� Ȱ��
		/* 1. �� ������ �Է¹޾� �� ������ ���μ� �������� �Ǻ��ϴ� �ڵ带 �ۼ��Ͻÿ�
		 * ���μ� : �ִ� ������� 1�� �� ���� ����
		 * input 2 numbers : 3 4
		 * Disjoint! (���μ�)
		 * input 2 numbers : 8 4
		 * Not disjoint! (���μ� �ƴ�)
		 */
		
		int num1, num2, i;
		System.out.println("�� ������ �Է��ϼ��� : ");
		Scanner sc = new Scanner(System.in);
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		// ���μ� = �ִ� ������� 1�̴� = 1�ܿ��� �������� ����.
		// i�� num1�� ����̰ų�, num2�� ����̴�.
		i = 2;
		while(i <= num1) {
			if(num1 % i == 0 || num2 % i == 0 ) {
				System.out.println(num1 + "�� " + num2 + "�� ���μ��̴�");
			}else if (num1 % i == 0 && num2 % i == 0 ) {
				System.out.println(num1 + "�� " + num2 + "�� ���μҰ� �ƴϴ�");
			}
			i++;
		}
		
		
		
		sc.close();
	}

}
