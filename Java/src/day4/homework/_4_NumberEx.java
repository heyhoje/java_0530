package day4.homework;

import java.util.Scanner;

public class _4_NumberEx {

	public static void main(String[] args) {
		//4. ���� num�� ¦���̸� num�� 2�� ������, ���� num�� Ȧ���̸� num�� 1�� ���� ��, num�� ����ϴ� �ڵ带 �ۼ��ϼ���.
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� num�� �Է��ϼ���");
		num = sc.nextInt();
		
		if (num % 2 == 0) {
			num /= 2;
		}else if (num % 2 == 1) {
			num += 1;
		}
		System.out.println(num);
		sc.close();
	}

}
