package day6.practice;

import java.util.Scanner;

public class _5_UpDown2 {

	public static void main(String[] args) {
		// 2. UpDown������ �ϴ� �ڵ带 �ۼ��ϼ���
//		1~100 ������ ������ ������ �����ϰ�, �� ������ ���ߴ� ������ �����ϼ���. *RandomEx Ȱ��
		// �� ���� ������ ���Ұ����� ��� n�� �Է��ϸ� ����, y�� �Է��ϸ� �̾ ������ ����.
		
		int min = 1, max = 100;
		char menu = 'y'; // *
		int num;
		Scanner scan = new Scanner(System.in);

		int random = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(random);
		
//		System.out.println(random);
//		System.out.println("������ �� : " + random);
//		System.out.println("----------");
		while(menu != 'n') { //*
			num = 0; // 0���� �ʱ�ȭ = while ���ǹ����� �ش� ���� �ʱ�ȭ �϶�� �ؼ� ��
			while(num != random) {
				System.out.println("1~100 ���� ������ ���߽ÿ�.");
				System.out.println("���� �Է� : ");
				num = scan.nextInt();
		
		// ���� �θ� ���� num, ������� ���� random
				if(random == num) {
					System.out.println("GOOOOOD!!");
				}else if(random < num) {
					System.out.println("DOWN!");
				}else {
					System.out.println("UP!");
				}
			}
			System.out.println("����Ͻðڽ��ϱ�? : "); // *
			menu = scan.next().charAt(0);// *
		}
		scan.close();
	}

}
