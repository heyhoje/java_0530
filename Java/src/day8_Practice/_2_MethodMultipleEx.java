package day8_Practice;

import java.util.Scanner;

public class _2_MethodMultipleEx {

	public static void main(String[] args) {
		// 2. ���� num�� �Է¹޾� 2,3,6�� ������� �ƴ��� �Ǻ��ϴ� �ڵ带 �ۼ��ϼ���
		// ��, �޼ҵ带 �̿��� ��
		
		// System.out.println(MethodEvenNumberEx.isMultiple(4,2));
		
		int num1;
		Scanner sc = new Scanner(System.in);
		System.out.println("input number : ");
		num1 = sc.nextInt();
		
		if (isMultiple(num1, 6)) {
			System.out.println("6�� ���");
		}else if (isMultiple(num1, 2)) {
			System.out.println("2�� ���");
		}else if (isMultiple(num1, 3)) {
			System.out.println("3�� ���");
		}else {
			System.out.println("2,3,6 �� ����� �ƴϴ�");
		
		}
		sc.close();
	}
	
	/** 
	 * �Ű����� : ���� num => int num
	 * ����Ÿ�� : 
	 * �޼ҵ�� : 
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


