package day8.homework;

import java.util.Scanner;

public class _4_MethodScoreEx {

	public static void main(String[] args) {
		// 4. ������ �Է¹޾� ������ ����ϴ� �ڵ带 �ۼ��ϼ��� (��, �޼ҵ� �̿�)
		
		int score;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� : ");
		score = sc.nextInt();
		
		
		grade(score);
		
		sc.close();
	}
	
	/** ��� : ������ �Է��ϸ� ������ �˷��ش�. 
	 * �Ű����� : ���� => double score 
	 *	����Ÿ�� : ���� ���ڿ�
	 *	�żҵ�� : grade 
	 */
	public static void grade(int score) {
		
		score; // 0�� 1�� �ƴ�, �Ű����� num�̾��ٳ� ��¾�� �Ƚ����...�� ������
		// String grade;
		if (score < 0 || score > 100) {
			System.out.println("Wrong Score");
		}else if (score >= 90) {
			System.out.println("A �Դϴ�");
		}else if (score >= 80) {
			System.out.println("B �Դϴ�");
		}else if (score >= 70) {
			System.out.println("C �Դϴ�");
		}else if (score >= 60) {
			System.out.println("D �Դϴ�");
		}else if (score < 60) {
			System.out.println("F �Դϴ�");
		}
		
	}
	

}
