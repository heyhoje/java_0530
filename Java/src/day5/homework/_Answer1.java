package day5.homework;

import java.util.Scanner;

public class _Answer1 {

	public static void main(String[] args) {
		// 1. 30���� �л��� �ִ� �ݿ��� 1������ ���ӵ� ��ȣ�� ���� 3���� �л��� 1���� �ǵ��� ��������. 
		// �� �� ���� ū ��ȣ�� �л��� ������ �ȴ�.
		// �л� ��ȣ�� �־����� �� �������� �������� �Ǻ��ϴ� �ڵ带 �ۼ��Ͻÿ�. * switch������
		// input student number : 
		// 1
		// Student number 1 is a member of the team.
		// input student number : 
		// 6
		// Student number 6 is the team leader.
		
		// �л� ��ȣ�� �Է�
		int num; // ��������
		Scanner sc = new Scanner(System.in); // [�Է�]
		System.out.println("�л� ��ȣ�� �Է��ϼ���"); // ��ȣ�� �Է��ϱ� ���� �ȳ�����
		num = sc.nextInt(); // �����Է�
		
		// �л� ��ȣ�� ���� ��ȣ���� �ƴ����� �Ǻ�
		// 3�� ����̸� = ���� ��� ��� / �ƴϸ� ���� �̶�� ���
		// num�� 3���� ���������� �������� 0�� ���ٸ� ����, �ƴϸ� �������� ���
		// num % 3 == 0 / ���ٷ� ������ �͸� ����ġ���� ���� �� ����
		switch(num % 3) {
		case 0: 
			System.out.println(num + "���� �����Դϴ�");
			break;
		default:
			System.out.println(num + "���� �����Դϴ�");
			
		}
		
		sc.close();
	}

}

