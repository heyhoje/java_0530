package day4_practice;

import java.util.Scanner;

public class _1_IfAdultEx {

	public static void main(String[] args) {
		// ���̸� �Է¹޾� ���̰� 20�� �̻��̸� adult�� ����ϰ�, 20�� �̸��̸� minor�� ����ϴ� �ڵ带 �ۼ��ϼ���.
		// * if else���� �̿�
		
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("�����Դϱ�?"); // "input age : "
		age = sc.nextInt(); // age�� ������ ���������ϱ� nextInt(); // ��ǲ ����� > age�� �ް�,
	
		
		if (age >= 20) {
			System.out.println("adult �Դϴ�");
		} else {
			System.out.println("minor �Դϴ�");
		}
		
	    sc.close();
	}

}
