package review_0723;

import java.util.Scanner;

import array.Array;

public class _11_BaseballGame {

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
		int com[] = new int[3];
		int user[] = new int[3];
		
		int min = 1, max = 9;
		int strike = 0;
		int ball = 0;
		
		// ������ ���� 3�� (�Է�)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�߱� ���� ����!");
		Array.createRandomArray(min, max, com);
		Array.printArray(com);
		
		// 2. �ݺ���
		do {
			// ����ڰ� ���� 3���� �Է�
			System.out.println("���� 3���� �Է��ϼ���");
			System.out.println("user : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			// ����� �Է� üũ / �ߺ��Ǹ� �Ǻ��� �ʿ� ����
			if(Array.arrayCheck(user)) {
				System.out.println("�ߺ��� ���� �Է����� ������");
				continue;
			}
		
		// 3. �Ǻ�!
			strike = 0;
			ball = 0;
		
		// ��Ʈ����ũ ���� �Ǻ�
			strike = strike(com, user);
//			System.out.println("S : " + strike);
		// �� ���� �Ǻ�
			ball = ball(com, user);
//			System.out.println("B : " + ball);
		// ��Ʈ����ũ�� ���� ������ �°� ���
			printResult(strike, ball);

		}while(strike < 3);
		
		System.out.println("Good!");
		sc.close();
	}
	
	// �޼ҵ�1 : strike �Ǻ�
	public static int strike(int arr1[], int arr2[]) {
		if(arr1 == null||arr2 == null) {
			return 0;
		}
		
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		int count = 0;
		for(int i = 0; i < size; i++){
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	
	// �޼ҵ�2 : ball �Ǻ�
	public static int ball(int arr1[], int arr2[]) {
		if(arr1 == null | arr2 == null) {
			return 0;
		}
		int count = 0;
		
		for(int tmp : arr1) {
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1, arr2);
	}
	
	// �޼ҵ�3: printResult
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.println("S : " + strike);
		}
		if(ball != 0) {
			System.out.println("B : " + ball);
		}
		if(strike == 0 && ball == 0) {
			System.out.println("3OUT");
		}
		System.out.println();
	}

}
