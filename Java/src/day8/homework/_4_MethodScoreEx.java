package day8.homework;

import java.util.Scanner;

public class _4_MethodScoreEx {

	public static void main(String[] args) {
		// 4. ������ �Է¹޾� ������ ����ϴ� �ڵ带 �ۼ��ϼ��� (��, �޼ҵ� �̿�)
		
		int score = 10;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� : ");
		score = sc.nextInt();
		System.out.println(getGrade(score));
		sc.close();
	}
	
	/** ��� : ������ �Է��ϸ� ������ �˷��ش�. 
	 * �Ű����� : ���� => ���� or �Ǽ� => int score 
	 *	����Ÿ�� : ���� => ���ڿ� => String
	 *	�żҵ�� : getGrade 
	 */
	
	public static String getGrade(int score) {
		if(score < 0 || score > 100) {
			return "Wrogn Score!";
		}
		
		if(score >= 90) {
			return "A����";
		} else if(score >= 80) {
			return "B����";
		} else if(score >= 70) {
			return "C����";
		} else if(score >= 60) {
			return "D����";
		}
		return "F����";
		
	}

}
