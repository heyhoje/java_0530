package day5_practice;

import java.util.Scanner;

public class _5_PrimeNumberEx {

	public static void main(String[] args) {
		// 5. ���� num�� �Է¹޾� num�� �Ҽ����� �ƴ����� �Ǻ��ϴ� �ڵ带 �ۼ��ϼ���.
		// �Ҽ� : ����� 1�� �ڱ��ڽŹۿ� ���� �� ex) 2, 3, 5, 7, 11, 13 ��
		//		������� 2���� ��, 1�� �����ϰ� ó�� ���� ����� �ڽ��� ��
		
		// ���� �Է�
		int num, i, count;
		Scanner sc = new Scanner(System.in);
		System.out.println("���� num�� �Է��ϼ���.");
		num = sc.nextInt();
		
		// �ݺ�Ƚ�� : 1���� num���� 1�� ����
		// ��Ģ�� : i�� num�� ����̸�, ����� ���� count�� 1 ����
		// i�� ������ 2�����...../~~��� �Ҽ��̴�.
		// �ݺ��� ���� �� : count�� 2�̸� �Ҽ���� ���, �ƴϸ� �Ҽ��� �ƴ� �̶�� ���
		
		// �ݺ��� i�� 1���� num���� 1�� ����
			//i�� num�� ������ ����� ���� count�� 1 ����
		i = 1;
		count = 0;
		while(i <= num) {
			if(num % i == 0) {
				count += 1; // ����ϴ� �ڵ尡 �������� �ڵ�� �ٲ�.
				}
			++i;
		}
		// count�� 2�̸� �Ҽ���� ����ϰ�, �ƴϸ� �Ҽ��� �ƴ��̶�� ���
		if(count == 2 ) { 
			System.out.println(num + "��/�� �Ҽ�");
		}else {
			System.out.println(num + "��/�� �Ҽ��� �ƴ�");
		}	
		sc.close();
	}

}
