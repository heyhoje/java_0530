package day5_practice;

import java.util.Scanner;

public class _4_DivisorEx {

	public static void main(String[] args) {
		// 4. ���� num�� �Է¹޾� num�� ����� ����ϴ� �ڵ带 �ۼ��ϼ���.
		// ��� : A�� B�� �������� �� �������� 0�̸� B�� A�� ����̴�. 
		// 12�� ��� : 1, 2, 3, 4, 6, 12
		
		int num, i;
		Scanner sc = new Scanner(System.in);
		//�����Է�
		System.out.println("���� num�� �Է��ϼ���.");
		num = sc.nextInt();
		
		// �ݺ�Ƚ�� : 1���� num���� 1�� ���� 
		//        i�� num�� ������ i�� ��� =>
		// ��Ģ�� : (num % i == 0) �̶��, i�� num�� ����̴�. 
		
		//�ݺ���, i�� �ʱ�ȭ
		//      i�� 1���� num ���� 1�� ����
		//     	num�� i�� �������� �� �������� 0�� ���ٸ�, i�� ���
		i = 1;
		while(i <= num) {
			if(num % i == 0) {
				//System.out.println(i + "�� " + num + "�� ����̴�.");
				System.out.println(i);
			}
			++i;
			
		sc.close();	
		}
		
	}

}
