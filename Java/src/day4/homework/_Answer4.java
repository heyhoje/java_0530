package day4.homework;

import java.util.Scanner;

public class _Answer4 {

	public static void main(String[] args) {
		// 4. ���� num�� ¦���̸� num�� 2�� ������, 
				// ���� num�� Ȧ���̸� num�� 1�� ���� ��, num�� ����ϴ� �ڵ带 �ۼ��ϼ���.
				
				int num;
				Scanner sc = new Scanner(System.in);
				// ���� �Է�
				System.out.println("���� num�� �Է��ϼ���");
				num = sc.nextInt();
				
				// ���� num�� ¦���̸� num�� 2�� ������(������ 0 �̴ϱ� int�� ����)
				// num 2 �� ���� ���� num�� ����
				if (num % 2 == 0) {
					num /= 2; // num = num / 2;
				}// �ƴϸ� num�� 1�� ���� ��
				// num�� 1�� ���� ���� num�� ����(���� int ���� ��

				//else if (num % 2 == 1) 
				else {
					num += 1; // num = num + 1'\; << ������ �ϳ� �� �� �� �ִ� ����� �����ַ��� �� ����
				}
					
				// num�� ���
				System.out.println(num);
				sc.close();
	}

}
