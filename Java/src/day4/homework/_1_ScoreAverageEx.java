package day4.homework;

import java.util.Scanner;

public class _1_ScoreAverageEx {

	public static void main(String[] args) {
		// 1.����, ����, ���� ������ �Է¹޾� ����� ����ϴ� �ڵ带 �ۼ��ϼ���. 
		// * ������ ����
		
		int koreaScore;
		int englishScore;
		int mathScore;
		Scanner sc = new Scanner(System.in);
		System.out.println("����, ����, ���� ������ �Է��ϼ���");
		koreaScore = sc.nextInt();
		englishScore = sc.nextInt();
		mathScore = sc.nextInt();
		
		int average = (koreaScore + englishScore + mathScore) / 3;
		System.out.println("������ ����� " + average + "�� �Դϴ�.");
		
		
		sc.close();
		
	}

}
