package day5.homework;

import java.util.Scanner;

public class _1_TeamLeaderEx {

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
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("�л� ��ȣ�� �Է��ϼ���");
		num = sc.nextInt();
		
		// 3�� ��� = ���� / �ƴϸ� ����
		
		switch(num % 3) {
		case 0: 
			System.out.println("�����Դϴ�");
			break;
		default:
			System.out.println("�����Դϴ�");
			
		}
	}

}
