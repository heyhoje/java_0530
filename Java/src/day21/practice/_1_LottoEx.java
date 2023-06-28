package day21.practice;

import java.util.HashSet;
import java.util.Scanner;

// set�� equals�� �������� �ߺ�üũ��. �������̵� �� �������. 

public class _1_LottoEx {

	public static void main(String[] args) {
		/* Set�� �̿��� �ζ� ���α׷� */
		int bonus;
		HashSet<Integer> lotto = new HashSet<>();
		HashSet<Integer> user = new HashSet<>();
		int min = 1, max = 45;
		
		// �ζ� ��ȣ�� �������� ����(1~45)
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random()*(max-min+1) +min));
		}
		// ���ʽ� ����
		do {
			bonus = (int)(Math.random()*(max-min+1) +min);
		} while(lotto.contains(bonus));
		
		System.out.println("----�ζǹ�ȣ Ȯ��----");
		System.out.println(lotto);
		System.out.println("bonus : " + bonus);
		
		// ����� �Է�
		Scanner sc = new Scanner(System.in);
		System.out.print("���� 6���� �Է��ϼ��� : ");
		while(user.size() < 6) {
			user.add(sc.nextInt());
		}
		sc.close();
		
		// ��� üũ
		// ��ġ�ϴ� ���� Ȯ��
		int count = 0;
		for(Integer tmp : user) {
			if(lotto.contains(tmp)) {
				count++;
			}
		}
		// ������ �̿��Ͽ� ��� üũ
		switch(count) {
		case 6: System.out.println("1��"); break;
		case 5:
			if(user.contains(bonus)) {
				System.out.println("2��");
			}else {
				System.out.println("3��");
			}
			break;
		case 4: System.out.println("4��"); break;
		case 3: System.out.println("5��"); break;
		default: System.out.println("��");
		}
	}

}
