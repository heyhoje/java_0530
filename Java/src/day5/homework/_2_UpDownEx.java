package day5.homework;

import java.util.Scanner;

public class _2_UpDownEx {

	public static void main(String[] args) {
//		2. UpDown����
//		1~100������ ������ ������ �����ϰ�, �� ������ ���ߴ� ������ �����ϼ���. *RandomEx Ȱ��
//		������ �� : 45
//		input : 50 > Down! >> input : 40 > UP! >> input : 45 > Good! //[����] ���⶧����
		
		int min = 1, max = 10; // max = 9 �� �����ߴµ�, �׷��� 100������ �ȳ���. min <= r *(max - min + 1) + min < max + 1
		int random = (int)(Math.random()*100); // 100 �̻��� ���� ����....  *10�� �Ϻ��� ���� �ƴ�
		//random > 1 && random <= 100; // �� ������ �ְ� ������.......
		//System.out.println((Math.random()*(max - min + 1) + min));
		
//		System.out.println(random);
//		System.out.println("������ �� : " + random);
//		System.out.println("----------");
		int num;
		Scanner scan = new Scanner(System.in);
		
		num = 0; // 0���� �ʱ�ȭ = while ���ǹ����� �ش� ���� �ʱ�ȭ �϶�� �ؼ� ��
		while(num != random) {
		System.out.println("1~100 ���� ������ ���߽ÿ�.");
		System.out.println("���� �Է� : ");
		num = scan.nextInt();
		
		// ���� �θ� ���� num, ������� ���� random
		// ����/���� �̴ϱ� switch���� �ƴԤ�������
		//i = random; // i�� �ȸ��� �ɰŰ�����..... // ����
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
