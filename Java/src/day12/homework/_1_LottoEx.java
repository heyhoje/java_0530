package day12.homework;

import java.util.Scanner;

import array.Array;

public class _1_LottoEx {

	public static void main(String[] args) {
		// 1. �ζ� ��ȣ(45��)�� �����ϰ�, 
		// 2. ����ڰ� ��ȣ�� �Է��ϸ� 
		// 3. ������� ����ϴ� �ڵ带 �ۼ��ϼ���
		
		/* 1�� : ��ȣ 6��
		 * 2�� : ��ȣ 5�� + ���ʽ�
		 * 3�� : ��ȣ 5��
		 * 4�� : ��ȣ 4��
		 * 5�� : ��ȣ 3��
		*/
		
		// computer : ���ʽ� ���� 7��
		// user : 6����

		// 1. �̾ƾ��� ���� 7��, 6���� �������� ����(�ߺ�x) 
		int lotto[] = new int[7]; // ���ʽ��� ���ڴϱ� 7�� �̴°���?����
		//int bonus[] = new int[1];
		int user[] = new int[6]; // lotto�� ���� ���ڶ� � ������, ���� �������
		
		int min = 1, max = 45; // ��ȣ�� 1���� 45���� 
		int bonus = lotto[6];
		int lotto2[] = new int[6]; 
		
//		System.out.println(bonus);
//		System.out.println(lotto2); // ���� ��ȣ�� �˰� �;��� ���ε�, �ּҰ��� ���͹����µ�...??
		
		// �ܼ�â �Է�
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̹��� �ζ� ��ȣ 6��!");
		Array.createRandomArray(min, max, lotto); 
		Array.printArray(lotto);
		System.out.println("���ʽ� ��ȣ : " + bonus);
		
		// ������ ���� ���ڸ� ���ʽ������?? ���ʽ��� ���� �̾ƾ��ҰŰ�����
		//Array.createRandomArray(min, max, bonus); 
		//Array.printArray(bonus);
		
		// �� �̷��� �ϸ� �ζǹ�ȣ�� ���ʽ���ȣ�� �ߺ��߻�.. 
		// ��� ���ʽ��� ���ʽ���� �˷��༭ 2���� �����?
		// �� �ζǰ� ���� ��ȣ �����ϰ�, �ϳ��� �� �̾ƴ޶�� �ϸ� �ȵ�???
		
		// 2+3. �ݺ���(������ �Է��ϰ� �Ǻ��ؾ���)
//		do {
//			// 2. ����ڰ� ���� 3���� �Է�
//			System.out.println("user : ");
//			for(int i = 0; i < user.length; i++) {
//				user[i] = sc.nextInt();
//			}
//			// ����� �Է� üũ/�ߺ��Ǹ� �Ǻ��� �ʿ� ����
//			if(Array.arrayCheck(user)) {
//				System.out.println("�ߺ��� ���� �Է����� ������!");
//				continue;
//			}
//		
//			// 3. �Ǻ�
//			normal = 0;
//			bonus = 0;
//			
//		} while();
			
		System.out.println("�����մϴ�. �� �Դϴ�");
		sc.close();
	}
	
	
}
