package day12.homework;

import java.util.Scanner;

import array.Array;

public class _Answer1 {

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
		// user : 6��

		// 1. �������� �ζǹ�ȣ 6���� ���ʽ� ��ȣ 1�� ����(�ߺ�x)
			// 7��¥�� �迭�� �ζǹ�ȣ�� �����ϰ�, �տ� 6���� �ζǹ�ȣ, ������ 1���� ���ʽ��� Ȱ��
		
		// 7��¥�� �迭�� �ζǹ�ȣ�� ����
		int lotto[] = new int [7];
		Array.createRandomArray(1, 45, lotto);
		
		//������ 1���� ���ʽ���
		int bonus = lotto[6];
		int lotto2[] = new int[6];
		// �տ� 6���� �ζǹ�ȣ
		System.arraycopy(lotto, 0, lotto2, 0, 6);
		Array.sort(lotto2); // * ���� ����
		
		System.out.print("�ζǹ�ȣ : ");
		Array.printArray(lotto);
		System.out.println("���ʽ� ��ȣ : " + bonus);
		
		System.out.println("-----l o t t o------");
		// 2. ����ڰ� ��ȣ�� 6�� �Է�
		Scanner sc = new Scanner(System.in); //�Է¹������� ����?
		int user[] = new int[6];
		
		System.out.println("�̹��� �ζǹ�ȣ 6���� ������!");
		System.out.println("����� : ");
		for(int i = 0; i < user.length; i++) {
			user[i] = sc.nextInt();
		}
		
		// 4. �ߺ��Է��ϸ� �Ǻ��� ����(�߰����� ��)
		if(Array.arrayCheck(user)) {
			System.out.println("�ߺ��� ���� �Է��߽��ϴ�");
			return;
		}
		
		// 3. ��� �Ǻ�(switch?)
		int count = count(lotto2, user);
		printResult(count, Array.contains(user, bonus, user.length));
		
		//System.out.println("�����մϴ�. " + printResult + " ��÷�Դϴ�!");
//		System.out.println(count(lotto2, user) + "��");
//		System.out.println("�����մϴ�. �� �Դϴ�");
		
	}
	
	// �޼ҵ�1 : � �������
	/** ��� : �ζǹ�ȣ�� ����� ��ȣ�� �־����� ��� ������ �˷��ִ� �޼ҵ�
	 * �Ű����� : �ζǹ�ȣ, ����ڹ�ȣ, count => int lotto[], int user[]
	 * ����Ÿ�� : � ������ => ���� -> int
	 * �޼ҵ�� : count
	 */
	
	public static int count(int lotto[], int user[]) {
		if(lotto == null || user == null) {
			return 0;
		}
		// �ƴϸ� �ݺ������� �۾�
		int count = 0;
		// for(int i = 0 , i < lotto.length, i++) // ���� for���� �� ���
		for(int tmp : lotto) { // �ζǿ��� �ϳ� ������
			if(Array.contains(user, tmp, user.length)) {
				count++;
			}
		}
		return count;
	}
	
	/** ��� : ��ġ�ϴ� ������ ���ʽ���ȣ�� ����� ��ȣ�� ��ġ�ϴ��� ���θ� �˷��ָ�,
	 * 		  ����� ����ϴ� �޼ҵ�
	 * �Ű����� : ��ġ�ϴ� ����, ���ʽ� ��ȣ�� ��ġ���� 
	 * 			=> int count, boolean checkBonus 
	 * ����Ÿ�� : (��¸�) ���� => void
	 * �޼ҵ�� : printResult
	 */
	
	public static void printResult(int count, boolean checkBonus) {
		switch(count) {
		case 6:
			System.out.println("1��");
			break;
		case 5:
			if(checkBonus) {
			System.out.println("2��");
			}else {
			System.out.println("3��");
			}
			break;
		case 4:
			System.out.println("4��");
			break;
		case 3:
			System.out.println("5��");
			break;
		default:
			System.out.println("���Դϴ�");
		}
		
	}
	
	
	
}
