package day8.Practice;

import java.util.Scanner;

public class _2_MethodMultipleEx {

	public static void main(String[] args) {
		// 2. ���� num�� �Է¹޾� 2,3,6�� ������� �ƴ��� �Ǻ��ϴ� �ڵ带 �ۼ��ϼ���
		// ��, �޼ҵ带 �̿��� ��
		
		// System.out.println(MethodEvenNumberEx.isMultiple(4,2));
		
		int num;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ��� : ");
		num = sc.nextInt();
		
		if(isMultiple(num, 6)) {
			System.out.println(num + "�� 6�� ���");
		}else if(isMultiple(num, 2)) {
			System.out.println(num + "�� 2�� ���");
		}else if(isMultiple(num, 3)) {
			System.out.println(num + "�� 3�� ���");
		}else {
			System.out.println("2,3,6 �� ����� �ƴմϴ�.");
		}
		
		sc.close();
	}
	
	/** 
	 * �Ű����� : ���� num => int num
	 * ����Ÿ�� : ������� �ƴ��� => boolean
	 * �޼ҵ�� : isMultiple
	 */
	
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	// Ʋ�� ����....�Ф� �޼ҵ� �ؿ� �� ���� �־��µ� ������ �Ұ� �����ٸ�
//	public static int multiple (int num) {
//		if(num % 6 == 0) {
//			System.out.println("6�� ���");
//		}else if(num % 2 == 0) {
//			System.out.println("2�� ���");
//		}else if(num % 3 == 0) {
//			System.out.println("3�� ���");
//		}
		
}


