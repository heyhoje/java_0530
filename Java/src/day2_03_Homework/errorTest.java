package day2_03_Homework;

import java.util.Scanner;

public class errorTest {

	public static void main(String[] args) {
		System.out.println("�� ������ �Է��ϼ���.");// �ȳ� ���� ���
		Scanner sc = new Scanner(System.in);
		// �ֿܼ��� �Է¹��� �� �ִ� ��ĳ�� ����
		// �� ������ �Է¹���
		int num3 = sc.nextInt();// ��������. ���� ����� ���ÿ� �ʱ�ȭ.???????
		int num4 = sc.nextInt();
		// �� ������ ��� ������ ���
		int sum = num3 + num4;
		int sub = num3 - num4;
		int mul = num3 * num4;
		double div = num3 / (double)num4; // ������� ����!!!!!!! ������ �������� ����!! �ϳ��� �Ǽ��� ��������.
		int mod = num3 % num4;
		
		//����� �ֿܼ� ���
		System.out.println("" + num3 + " + " + num4 + " = " + sum);
		System.out.println("" + num3 + " - " + num4 + " = " + sub);
		System.out.println("" + num3 + " * " + num4 + " = " + mul);
		System.out.println("" + num3 + " / " + num4 + " = " + div);
		System.out.println("" + num3 + " % " + num4 + " = " + mod);
		
		sc.close();
	}

}
