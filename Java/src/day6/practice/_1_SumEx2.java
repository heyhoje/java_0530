package day6.practice;

import java.util.Scanner;

public class _1_SumEx2 {

	public static void main(String[] args) {
		// 1. n�� �Է¹޾� 1���� n���� ¦���� ���� ���ϴ� �ڵ带 �ۼ��ϼ���
		// input : 10
		// 1 ~ 10 even sum : 30
		
		int n, i = 1;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		// n�� �Է�
		System.out.println("n�� �Է��ϼ��� : ");
		n = sc.nextInt();
		
		// �ݺ����� �̿��Ͽ� n���� ¦���� ���� ���
		// 1�� n���� �۰ų� ������ �ݺ�
		while(i <= n) {
			// i�� ¦���̸� ����
			if (i % 2 == 0) {
				sum = sum + i; // sum += 1 (x) sum += i; (o)
			}
			i++; // if�� ������. �������� ������ ���ѷ����� ���� �� ����. 
		}
		System.out.println("1 ~ " + n + "������ ¦�� �� : " + sum);
		
		sc.close();
	}

}
