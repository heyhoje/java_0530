package day5.homework;

import java.util.Scanner;

public class _Answer2 {

	public static void main(String[] args) {
//		2. UpDown����
//		1~100������ ������ ������ �����ϰ�, �� ������ ���ߴ� ������ �����ϼ���. *RandomEx Ȱ��
		
		//������ ���� ���� (�� ���)
		
		int min = 1, max = 100;
		int random;
		random = (int)(Math.random()*(max - min +1) + min);
		int num = min -1;// 1~100�� �ƴ� ������ �ʱ�ȭ �ϸ��. �ּҰ� -1�� �ؼ� �������� ���� �� ���� �� ����.
		Scanner scan = new Scanner(System.in);

		
		// ****���� ������ https://github.com/st8324/java_0530 �ڵ� �����ؼ� �����صα� ****// 
		System.out.println(random);
		
		// �ݺ��� : ���⶧����, �Է��� ������ ������ �ƴϸ� �ݺ�
			// ������ �Է�
			// ������ ������ ���Ͽ� �Ǻ�
		//System.out.println(random);
		//System.out.println("������ �� : " + random);
		//System.out.println("----------");
		
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
		scan.close();
	}

}
