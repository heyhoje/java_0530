package day11.homework;

import java.util.Scanner;

import array.Array; // Array Method ��������

public class _1_BassballGameEx {

	public static void main(String[] args) {
		// 1. ���� �߱� ������ �����ϼ���
		// 1 ~ 9 ������ �ߺ����� ���� �� ���� ���ߴ� ����
		// ��Ģ : 
		/* B : ���� ���ڰ� ������ ��ġ�� �ٸ�
		 * S : ���� ���ڰ� �ְ� ��ġ�� ����
		 * 3O : ��ġ�ϴ� ���ڰ� �ϳ��� ����
		 */
		
		
		// 1 ~ 9 ������
//		int min = 1, max = 9;
//		int [] arr = new int[3];
//		
//		// �ߺ����� ���� ������ 3 ���� ���
		
// 		boolean checkArr[] = new boolean[10];
// 		//�ڷ��� ����/�迭	   = new �ڷ���[����]
// 		
// 		// ������ ���� 3��
// 		System.out.println("�߱� ���� ����!");
//		int i;
//		for(i = 0; i < 3; ) {
//			int random = (int)(Math.random()*(max - min + 1) + min);
//			if(!checkArr[random]) {
//			arr[i] = random;
//			i++;
//			checkArr[random] = true;
//			}
//		}
//		for(i = 0; i < 3; i++) {
//			System.out.print(arr[i] + " ");
//		}
//		System.out.println();
//		System.out.println("-------");
//		
//		// ����ڰ� �Է��� ��
//		// int num1, num2, num3;
//		int [] baseball = new int[3];
//		
//		Scanner sc = new Scanner(System.in);
//		// num1 = sc.nextInt();
//		System.out.println("���� 3���� �Է��ϼ��� : ");
//		
//		for(i = 0; i < 3; i++) {
//			baseball[i] = sc.nextInt();			
//		}
//		for(i = 0; i < 3; i++) {
//			System.out.print(baseball[i] + " ");
//		}
		
		//System.out.println("---- t e s t----");
//		int arr[] = {1,2,3,4};
//		Array.printArray(arr);
//		
//		Array.printArray(arr, 0, arr.length);
		
		int arr[] = new int[3];
		Array.createRandomArray(1, 9, arr);
		Array.printArray(arr);
	}
	
	// ��Ģ : 
			/* B : ���� ���ڰ� ������ ��ġ�� �ٸ�
			 * S : ���� ���ڰ� �ְ� ��ġ�� ����
			 * 3O : ��ġ�ϴ� ���ڰ� �ϳ��� ����
			 */
	
	/** ��� : �ߺ��Ǵ� / ���� ���ڰ� �ִ��� Ȯ���ϴ� �޼ҵ�
	 * �Ű����� : 
	 * ����Ÿ�� : 
	 * �޼ҵ�� : checkNum
	 * 
	 */
	
	/** ��� : ������ ��ġ�� ������ Ȯ���ϴ� �޼ҵ�
	 * �Ű����� : 
	 * ����Ÿ�� : 
	 * �޼ҵ�� : 
	 * 
	 */

}
