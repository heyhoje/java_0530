package day8.homework;

import java.util.Scanner;

public class _Answer4 {

	public static void main(String[] args) {
		// 4. ������ �Է¹޾� ������ ����ϴ� �ڵ带 �ۼ��ϼ��� (��, �޼ҵ� �̿�)
		
		int score;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� : ");
		score = sc.nextInt();
		
		getGrade(score);
		
		double score2 = 100.1;
		System.out.println(getGrade(score2));
		sc.close();
	}
	
	/** ��   �� : ������ �Է��ϸ� ������ �˷��ִ� �޼ҵ�. 
	 *  �Ű����� : ���� => ���� or �Ǽ� => double
	 *	����Ÿ�� : ���� ���ڿ� => String
	 *	�żҵ�� : getGrade 
	 */
	public static String getGrade(double score) {
		double score = 0; // 0�� 1�� �ƴ�, �Ű����� num�̾��ٳ� ��¾�� �Ƚ����...�� ������
		// String grade;
		if (score < 0 || score > 100) {
			System.out.println("Wrong Score");
		}else if (score >= 90 && score <= 100) {
			System.out.println("A �Դϴ�");
		}else if (score >= 80 && score < 90) {
			System.out.println("B �Դϴ�");
		}else if (score >= 70 && score < 80) {
			System.out.println("C �Դϴ�");
		}else if (score >= 60 && score < 70) {
			System.out.println("D �Դϴ�");
		}else if (score < 60) {
			System.out.println("F �Դϴ�");
		}
		return null;
		
		System.out.println("--------");
		double score2 = 0.0;
		// String grade;
		if (score2 < 0 || score2 > 100) {
			return "Wrong Score";
		}
		/* 100���� => A
		 *  90���� => A
		 *  80���� => B
		 *  70���� => C
		 *  60���� => D
		 *   �� �� => F
		 */
		int result = (int)(score2/10);
		switch(result) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		return null;
		
	}
	

}
