package day5.homework;

import java.util.Scanner;

public class _2_UpDownEx {

	public static void main(String[] args) {
//		2. UpDown����
//		1~100������ ������ ������ �����ϰ�, �� ������ ���ߴ� ������ �����ϼ���. *RandomEx Ȱ��
//		������ �� : 45
//		input : 50 > Down! >> input : 40 > UP! >> input : 45 > Good! //[����] ���⶧����
		
		int min = 1, max = 10;
		int random = (int)((Math.random()*(max - min + 1) + min)*10); // 100 �̻��� ���� ����....  *10�� �Ϻ��� ���� �ƴ�
		//random > 1 && random <= 100; // �� ������ �ְ� ������.......
//		System.out.println((Math.random()*(max - min + 1) + min));
		System.out.println(random);
		System.out.println("������ �� : " + random);
		System.out.println("----------");
		int num, i;
		Scanner scan = new Scanner(System.in);
		
		num = 0;
		while(num != random) {
		System.out.println("1~100 ���� ������ ���߽ÿ�.");
		System.out.println("���� �Է� : ");
		num = scan.nextInt();
		
		// ���� �θ� ���� num, ������� ���� random
		// ����/���� �̴ϱ� switch���� �ƴԤ�������
		i = random; // i�� �ȸ��� �ɰŰ�����.....
			if(random == num) {
				System.out.println("GOOOOOD!!");
			}else if(random < num) {
				System.out.println("DOWN!");
			}else {
				System.out.println("UP!");
			}
		}
		scan.close();
	}

}
