package day6_practice;

import java.util.Scanner;

public class _2_AverageEx2 {

	public static void main(String[] args) {
		// ����, ����, ���� ������ �Է¹޾� ����� ���ϴ� �ڵ带 �ۼ��ϼ���
		/* input 3 score(kor, eng, math) : 10 20 30
		 * average : 20.0
		 * continue? (y/n) :
		 * y
		 * input 3 score(kor, eng, math) : 90 95 100
		 * average : 95.0
		 * continue? (y/n) : n
		 * EXIT!
		 */
		
		// �ݺ��� : menu�� n�� �ƴϸ� �ݺ�(y, n�� �ƴ� �ٸ����ڸ� �Է��ϸ� �ݺ�)
		//		  menu�� y�̸� �ݺ�(y, n�� �ƴ� �ٸ� ���ڸ� �Է��ϸ� ����)
			// ����, ����, ���� ���� �Է�
			// ����� ���
			// ����� ���
			// ���Ұ��� ��� ��, �Է�
		//EXIT! �� ���
		
		int kor, eng, math;
		char menu = 'y'; // *n�� �ƴ� y�� �ʱⰪ ���� *String �ƴϰ� char => sc.next().charAt(0);
		double average;
		Scanner sc = new Scanner(System.in);
		//System.out.println("����, ����, ���� ������ �Է��ϼ��� : ");
		
		while(menu != 'n') { //* ���ڴ� '', ���ڿ��� ""
			System.out.println("input 3 score(kor, eng, math) : ");
			kor = sc.nextInt();
			eng = sc.nextInt();
			math = sc.nextInt();
			
			average = (double)(kor + eng + math) / 3;
			System.out.println("average : " + average);
			System.out.println("continue? (y/n) : " );
			menu = sc.next().charAt(0); //*
			
			}
		System.out.println("EXIT!"); // * ��������� ��.... ��Ƴ�....
		
		sc.close();
	}

}
