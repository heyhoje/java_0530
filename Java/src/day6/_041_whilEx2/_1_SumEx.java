package day6._041_whilEx2;

import java.util.Scanner;

public class _1_SumEx {

	public static void main(String[] args) {
		// ������ : 1���� n���� ���� ���ϴ� �ڵ带 �ۼ��ϼ��� (n�� 10)
		/* �ݺ�Ƚ�� : i�� 1���� n����, 1�� ����
		 * *��Ģ�� : sum = num + 1
		 * �ݺ��� ���� �� : �������� sum�� ���
		 * �� �Ҽ��Ǻ� ó�� �ݺ��� ���� if��
		 * 			sum0 = 0; ���� �ʱ⼳��
		 * i = 1 	sum1 = sum0 + 1
		 * i = 2 	sum2 = sum1 + 2
		 * i = 3 	sum3 = sum2 + 3
		 * . . .
		 * i = 10	sum10 = sum9 + 10
		 * i = n 	sum = sum + i => sum += 1;
		 */
		
		int n = 10, sum = 0;
		int i = 1;
		while (i <= n) {// i�� n����
			sum += 1;
			i++; // ����� if�� ���� while�� ������ �ٷ� i++
		}
		System.out.println("1 ~ " + n + "���� �� : " + sum);
	}

}
