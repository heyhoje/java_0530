package day11.homework;

import java.util.Scanner;

import array.Array;

public class _Answer1 {

	public static void main(String[] args) {
		// 1. ���� �߱� ������ �����ϼ���
		// 1 ~ 9 ������ �ߺ����� ���� �� ���� ���ߴ� ����
		// ��Ģ : 
		/* B : ���� ���ڰ� ������ ��ġ�� �ٸ�
		 * S : ���� ���ڰ� �ְ� ��ġ�� ����
		 * 3O : ��ġ�ϴ� ���ڰ� �ϳ��� ����
		 * => 3S�� ����°� ����!
		 */
		
		// 1. ������� ���� 3���� �������� ����(�ߺ�x)!
		int com[] = new int[3]; // �������� ������ ���� ������ �迭
		int user[] = new int[3]; // ����ڰ� �Է��� ���� ������ �迭
		int min = 1, max = 9;
		int strike = 0; // ��Ʈ����ũ ����
		int ball = 0; // ���� ����  // �ƿ��� ī��Ʈ ���ص���
		
 		// ������ ���� 3��
		Scanner sc = new Scanner(System.in);
		
 		System.out.println("�߱� ���� ����!");
 		Array.createRandomArray(min, max, com);
		Array.printArray(com); // ������ ����� �Ǵ��� �׽�Ʈ �غ���, ���߿� �ּ�ó��
		
		// 4. �ݺ���(������ �Է��ϰ� �Ǻ��ؾ���)
		do {
			// ����ڰ� ���� 3���� �Է�
			System.out.println("user : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			// ����� �Է� üũ/�ߺ��Ǹ� �Ǻ��� �ʿ� ����
			if(Array.arrayCheck(user)) {
				System.out.println("�ߺ��� ���� �Է����� ������!");
				continue;
			}
			
			// 3. �Ǻ�!
			strike = 0;
			ball = 0;
			
			// ��Ʈ����ũ ���� �Ǻ�/ �޼ҵ�1
			strike = strike(com,user);
			System.out.println("S : " + strike);
			
			// ���� ���� �Ǻ�
			ball = ball(com, user);
			System.out.println("B : " + ball);
			
			// ��Ʈ����ũ�� ���� ������ �°� ���
			printResult(strike, ball);
	
			
		} while(strike < 3);
		
		System.out.println("Good!");
		sc.close();
		
	}

	// �޼ҵ�1 = strike �Ǻ�
	/** ��� : ��Ʈ����ũ ������ �Ǻ��ϴ� �޼ҵ�
	 * => �� �迭���� ���� ������ �ִ� ������ � ������ �˷��ִ� �޼ҵ�
	 * �Ű����� : �� �迭 => int arr1[], int arr2[]
	 * ����Ÿ�� : ���� ������ �ִ� ������ � ������ => � => ���� int
	 * �޼ҵ�� : strike 
	 */
		
	public static int strike(int arr1[], int arr2[]) {
		//����ó��, ���ϴ� ���忡���� �迭�� �¥���� ������ ��
		// �迭 ������ �ȵ� �迭�� 1�̶� ������ ���� �� ��� 0�� ����
		if(arr1 == null || arr2 == null) {
			return 0; // ����ִ°͵� ���
		}
		
		// �迭�� ������ �ٸ� ��� ���� ũ���� �迭�� �������� ���ϱ� ���� size ���
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
				// ���� ũ�⸦ �������� (���������� ó���ϴ°� ����)
				// �ΰ��� ������ �ٸ� �� �ִ°͵� ���
		
		int count = 0; // ��Ʈ����ũ ����
		for(int i = 0; i < size; i++) {
			// ���� ������ �ִ� ������ ���� ������(��Ʈ����ũ)
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;// ��� ��ġ�ϴ��� �˷���
	}
	// �޼ҵ�2 : ���� ���� �Ǻ�
	/** ��� : ���� ������ �Ǻ��ϴ� �޼ҵ�
	 * => ���� ���ڰ� �ְ� ��ġ�� �ٸ� ������ � ������
	 * => �� �迭���� �ٸ� ������ �ִ� ������ � ������ �˷��ִ� �޼ҵ�
	 * �Ű����� : �� �迭 => int arr1[], int arr2[]
	 * ����Ÿ�� : ���� ������ �ִ� ������ � ������ => � => ���� int
	 * �޼ҵ�� : ball
	 */
	public static int ball(int arr1[], int arr2[]) {
		//�迭 ������ �ȵ� �迭�� 1�̶� ������ ���� �� ��� 0�� ����
		if (arr1 == null || arr2 == null) {
			return 0;
		}
		int count = 0;
		// �ٸ� ������ ���ؼ� ã�Ƶ� ������
		// �� �迭���� ���� ������ �������� ��Ʈ����ũ ������ ���� ���� ����

		// ���� for��
		for(int tmp : arr1) {
			// �� �迭���� 
			// �迭 1���� ���� ��(tmp)�� arr2�� ������ ������ ����
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1, arr2); // �� �� ������ �������� ���ؾȵ�
	}
	
	// �޼ҵ�3 : 
	/** ��� : ��Ʈ����ũ�� ���� ������ �־����� ����� ����ϴ� �޼ҵ�
	 * �Ű����� : ��Ʈ����ũ ����, ���� ���� => int strike, int ball
	 * ����Ÿ�� : (���) ���� => void
	 * �޼ҵ�� : printResult
	 */
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("3OUT");
		}
		System.out.println();
	}
	
	
		
		// �ٸ� ����?? ���� �ڵ�
		// ���� ���� = ���߹ݺ����� �̿��ؼ� �ٸ� ������ ���ϴ� �ڵ�!
//		for(int i = 0; i < arr1.length; i++) {
//			for(int j = 0; j < arr2.length; j++) {
//				//���� ������ �ǳʶٰ�
//				if(i == j) {
//				continue;
//				}
//				if(arr1[i] == arr2[i]) {
//					count++;
//				}
//			}
//		}
//		return count;
	
	
	//com  1 2 3   => ������ �Ѿ�� ����ó��
	//user 4 5 6 7 => size�Ű澵 �ʿ� ����
	
	// 1 2 3
	// 1 4 2 
	// contains 
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


