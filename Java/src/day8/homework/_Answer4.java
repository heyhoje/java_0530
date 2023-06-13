package day8.homework;

import java.util.Scanner;

public class _Answer4 {

	public static void main(String[] args) {
		// 4. ������ �Է¹޾� ������ ����ϴ� �ڵ带 �ۼ��ϼ��� (��, �޼ҵ� �̿�)
		
		double score;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� : ");
		score = sc.nextInt();
		
		getGrade(score);
		
	
		System.out.println(getGrade(score));
		
		sc.close();
	}
	
	/** ��   �� : ������ �Է��ϸ� ������ �˷��ִ� �޼ҵ�. 
	 *  �Ű����� : ���� => ���� or �Ǽ� => double
	 *	����Ÿ�� : ���� ���ڿ� => String
	 *	�żҵ�� : getGrade 
	 */
	
	public static String getGrade(double score) {
		if (score < 0 || score > 100) {
			return "Wrong Score";
		}
		/* 100���� => A
		 *  90���� => A
		 *  80���� => B
		 *  70���� => C
		 *  60���� => D
		 *   �� �� => F
		 */
		int result = (int)(score/10);
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
		}
		//return null; // �������� ����� �ȵǿ�....
	}
	
	

	
}
