package day8_Practice;

import java.util.Scanner;

public class _1_MethodOverloadingEx {

	public static void main(String[] args) {
			// 1. ���� num�� �Է¹޾� ¦������ �ƴ��� �Ǻ��ϴ� �ڵ带 �ۼ��ϼ���.
			// ��, �޼ҵ带 �̿��� ��
			
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("������ �Է��ϼ��� : ");
		num = sc.nextInt();
//		int result = EvenNumher(num);
//		
//		if(result == 0) {
//			System.out.println("¦��");
//			}else {
//				System.out.println("Ȧ��");
//			}
		
		// 1
		printEvenNumber(num);
		
		// 2
		if(mod(num, 2) == 0) {
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
		}
		
		// 3
		if(isEvenNumber(num)) {
			System.out.println("¦��");
		}else {
			System.out.println("Ȧ��");
		}
		
		// 4
		
		sc.close();
		}
	
		

//		public static int EvenNumher (int num) {
//			int result = num % 2;
//			if (result == 0) {
//				System.out.println("¦��");
//			}else {
//				System.out.println("Ȧ��");
//			}
//			System.out.println();
			
		
		
		/** 1. num�� �־����� num�� ¦������ Ȧ������ ����ϴ� �޼ҵ� 
		 * @param num : �Ǻ��� ����
		 * @return : ���� => void
		 * �޼ҵ�� : printEvenNumber
		 */
		
		// public static ����Ÿ�� �޼ҵ�� (�Ű�����) { }
		
		// �޼ҵ� ������ ����ϴ� ���
		public static void printEvenNumber(int num) {
			if(num % 2 == 0) {
				System.out.println("¦��");
				}else {
					System.out.println("Ȧ��");
				}
		}
		
		/** 2. num1�� num2�� �־����� num1�� num2�� �������� �� �������� �˷��ִ� �޼ҵ�
		 * �Ű����� : �� ���� => int num1, int num2
		 * ����Ÿ�� : ���������� ������ => ���� => int
		 * �޼ҵ�� : mod
		 */
		
		public static int mod(int num1, int num2) {
			return num1 % num2;
		}
		
		/** 3. num�� �־����� num�� ¦������ Ȧ������ �˷��ִ� �޼ҵ�
		 * �Ű����� : �Ǻ��� ���� => int num
		 * ����Ÿ�� : ¦������(��) Ȧ������(����) => boolean 
		 * �޼ҵ�� : isEvenNumber
		 */
		
		public static boolean isEvenNumber(int num) {
			return num % 2 == 0;
		}
		
		/** 4. num1�� num2�� �־����� num1�� num2�� ������� �ƴ��� �˷��ִ� �޼ҵ�
		 * �Ű����� : �� ���� => int num1, int num2
		 * ����Ÿ�� : �������(��) �ƴ���(����) => boolean
		 * �޼ҵ�� : isMultiple
		 */
			
		public static boolean isMultiple(int num1, int num2) {
			return num1 % num2 == 0;
				}
}
		

