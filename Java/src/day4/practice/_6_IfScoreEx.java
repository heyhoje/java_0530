package day4.practice;

import java.util.Scanner;

public class _6_IfScoreEx {

	public static void main(String[] args) {
		//������ �Է¹޾� ������ �´� ������ ����ϴ� �ڵ带 �ۼ��ϼ���
//		90�̻� ~100���� : A
//		80�̻� ~ 90�̸� : B
//		70�̻� ~ 80�̸� : C
//		60�̻� ~ 70�̸� : D
//		60�̸� : F
//		0���� �۰ų� 100���� ū ��� : wrong score
		
		int score;
		Scanner sc = new Scanner(System.in); // ��ĳ�ʴ� �⺻. ����. ���̽Ẹ�� ��¾��ص� �ͼ�����
		System.out.println("������ �Է��ϼ���.");
		score = sc.nextInt();
		
		if(score < 0 || score > 100) {
			System.out.println("wrong score!");
		} else if (score >= 90) { // && score <= 100) <- 100���ϵ� �Ƚᵵ ����(������ 100�̻��� �ĳ±� ������)
			System.out.println(score + "���� A���� �Դϴ�.");
		} else if (score >= 80) {
			System.out.println(score + "���� B���� �Դϴ�.");
		} else if (score >= 70) {
			System.out.println(score + "���� C���� �Դϴ�.");
		} else if (score >= 60) {
			System.out.println(score + "���� D���� �Դϴ�.");
		} else if (score < 60) {
			System.out.println(score + "���� F���� �Դϴ�.");
		}
			
		
		
		
	}

}
