package day6.practice;

import java.util.Scanner;

public class _5_UpDown2_DoWhile {

	public static void main(String[] args) {
		// 2. UpDown������ �ϴ� �ڵ带 �ۼ��ϼ���
//		1~100 ������ ������ ������ �����ϰ�, �� ������ ���ߴ� ������ �����ϼ���. *RandomEx Ȱ��
		// �� ���� ������ ���Ұ����� ��� n�� �Է��ϸ� ����, y�� �Է��ϸ� �̾ ������ ����.
		
		int min = 1, max = 100;
		char menu = 'y'; // *
		int num, random;
		Scanner scan = new Scanner(System.in);
		
		/* �ܺιݺ��� : ������ �� �����Ұ��� �����ϴ� �ݺ���
		 * �ݺ�Ƚ�� : �Է¹��� ���ڰ� n�� �ƴϸ� �ݺ�
		 * ��Ģ�� : Up Down ���� �� �� ����
		 * */
		
		do {//������ �� ����
			random = (int)(Math.random() * (max - min + 1) + min);
			/*���ιݺ��� : UpDown ���� �����ϴ� �ݺ���
			 * �ݺ�Ƚ�� : �Է¹��� ���ڰ� ������ ���ڿ� ��ġ���� ������ �ݺ�
			 * ��Ģ�� : �Է¹��� ���ڰ� ���亸�� ũ�� Down!, ������ Up! ������ Goood!�� ���
			 * */	
			System.out.println(random);
			do {
				// �Է�
				System.out.println("input : ");
				num = scan.nextInt();
				
				// �Ǻ��� �� ��� ���
				if(num > random) {
					System.out.println("Down!");
				}else if(num < random) {
					System.out.println("Up!");
				}else {
					System.out.println("Goood!");
				}
			}while(random != num);
			//menu�� ����(�� �Ұ��� ������)
			System.out.println("continue?(y/n) : ");
			menu = scan.next().charAt(0);
		}while(menu != 'n');
		
		
		scan.close();
		
	}
	
}
