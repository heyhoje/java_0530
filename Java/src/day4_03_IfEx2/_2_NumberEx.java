package day4_03_IfEx2;

import java.util.Scanner;

public class _2_NumberEx {

	public static void main(String[] args) {
		/* ���� num�� ����̸� positive number��� ����ϰ�
		 * num�� �����̸� negative number�� ����ϰ�
		 * num�� 0�̸� 0���� ����ϴ� �ڵ带 �ۼ��Ͻÿ�.
		 * (if������ �̿��ؼ� �۾��߾���. �̹����� if else�� ���)
		 */
		
		int num;
		Scanner scan = new Scanner(System.in);
		System.out.println("input number : ");
		num = scan.nextInt();
		
		// ���� num�� ����̸� "���"��� ����ϰ�
		if (num > 0) {
			System.out.println(num + "�� ����̴�");
		}else if (num < 0) { // ���� num�� �����̷���, ����� �ƴ� �� �߿��� ������ �Ǻ�. num !> 0 )
			System.out.println(num + "�� �����̴�");
		}else {// 0�� ������ �ƴϰ� ����� �ƴ�
			System.out.println(num + "�� 0�̴�");
		}
		
	}

}
