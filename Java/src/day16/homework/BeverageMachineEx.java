package day16.homework;

import java.util.Scanner;

public class BeverageMachineEx {

	public static void main(String[] args) {
		//1. ������� �̴� ���Ǳ� ���α׷��� �ۼ��ϼ���
		// �� ����� ���Ǳ⿡ ������� ���̴�, �ݶ� ȯŸ�� ����(�޴� �߰�x)�̶�� ����.
		// �޴��� �����ϸ� ������� �ܾ��� ����(���)
		
		/* �޴�
		 * 1.�ݾ� ����
		 * 2. �޴� ����
		 * 3. ��ǰ �԰�
		 * 4. ���α׷� ����
		 * �޴� ���� : 
		 * 1. ���̴�
		 * 2. �ݶ�
		 * 3. ȯŸ
		 * ���� ���� : 1
		 * ���̴ٸ� �����߽��ϴ�.
		 * ���̴ٰ� ���ɴϴ� [�ݾ��� ����� ���]
		 * �ܵ� xxx�� ���ɴϴ�.
		 * �ݾ��� �����մϴ�. [�ݾ��� ������ ���]
		 * �ܵ� xxx�� ���ɴϴ�.
		 */
		
		int money;
		int menu = 0;
		
		Scanner sc = new Scanner(System.in);
		
		do {
			// �޴� ��� �� ����
			System.out.println("�޴�");
			System.out.println("1. �ݾ� ����");
			System.out.println("2. �޴� ����");
			System.out.println("3. ��ǰ �԰�");
			System.out.println("4. ���α׷� ����");
			System.out.println("�޴��� �����ϼ��� : ");
			menu = sc.nextInt(); // �̰� �Ƚ�ٰ� ���ѷ��� �ɸ��±���;;;
			
			// ������ �޴��� ���� ��¹� ����
			switch(menu) {
			case 1: 
				System.out.println("1. �ݾ��� �����ϼ���");
				break;
			case 2:
				System.out.println("2. �޴� ����");
				break;
			case 3:
				System.out.println("3. ��ǰ �԰�");
				break;
			case 4: 
				System.out.println("4. ���α׷� ����");
				break;
			}
		} while(menu != 4);
		
		sc.close();
		
	}

}
