package day4.homework;

import java.util.Scanner;

public class _Answer3 {

	public static void main(String[] args) {
		// 3. �� ���� ���̸� ������ �Է¹޾� �� ������ �ﰢ���� ���� �� �ִ��� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
				// �� �� �� ���� �� ���� ������ ���� ū ������ Ŀ�� �ﰢ���� ���� �� �ִ�.

				
				int a, b, c;
				Scanner scan = new Scanner(System.in);
				
				// �� ���� ���� �Է�
				System.out.println("�ﰢ���� �� ���� ���� : ");
				a = scan.nextInt();
				b = scan.nextInt();
				c = scan.nextInt();
				int max; // �� �� �� ���� ū ���� ����
				
				// �ﰢ�� ���� ���θ� Ȯ�� �� ���
				// �� �� �� ���� ū ���� ���̸� ���
				// a�� b���� ũ�� 
				  // a�� c���� ũ��, max�� a�� ����
				  // �ƴϸ� c�� max�� ����
				
				if (a > b) {
					if (a > c) {
						max = a;
					}else {
						max = c;
					}
				// a�� b���� ������
				  // b�� c���� ũ��, max�� b�� ����
				  // �ƴϸ� max�� c�� ����
				}else if (b > c) {
					max = b;
				} else {
					max = c;
				}
				
				// ���ǿ����ڷ� 1�ٷ� ����
				// max = a > b ? ( a > c ? a : c )  : ( b > c ? b : c ); // ���� ���������� ���ǿ����ڸ� ���� �ڵ尡 �������� �� �ִ�. 
				System.out.println("���� ū ���� " + max + " �Դϴ�");
				
				//�ﰢ�� ���ɿ��� Ȯ��
				//���� �κ��� �� > max
				if (max < a + b + c - max) {// �Ƹ����� ���ø��� �¾Ҵ�!!!!
					System.out.println("�ﰢ���� ���� �� �ֽ��ϴ�.");
				} else {
					System.out.println("�ﰢ���� ���� �� �����ϴ�.");
				}
				
				scan.close();
				
	}

}
