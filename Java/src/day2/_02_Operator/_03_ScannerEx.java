package day2._02_Operator;

import java.util.Scanner;

public class _03_ScannerEx {

	public static void main(String[] args) {
		//System.in : ǥ���Է�
		//ǥ�� �Է��� �̿��ؼ� ��ĳ�ʸ� ����
		Scanner scan = new Scanner(System.in); // �ֿܼ��� �Է¹������� �� ����ؾ��ϴ� Ŭ����?����?
	
		System.out.println("������ �Է����ּ���.");
		
		int num1 = scan.nextInt();//scan�̶�� ��ü���� ������ �Է¹���
		System.out.println(num1);
		
		System.out.println("�Ǽ��� �Է����ּ���.");
		double num2 = scan.nextDouble();//�Ǽ��� �Է� ����
		System.out.println(num2);
		
		System.out.println("���ڿ�1�� �Է��ϼ���.");
		scan.nextLine();//
		String str1 = scan.nextLine();//�����̽��� ������ ���ڿ� ������ �о��(������ �Է��� ���� ����)
		System.out.println(str1);
		
		System.out.println("���ڿ�2�� �Է��ϼ���.");
		String str2 = scan.next();//ù ��° ���ں��� �о�ͼ� ���� ����(����, �����̽�)�� ���� ������ �о��
		System.out.println(str2);
		
		System.out.println("���ڸ� �Է��ϼ���.");
		char ch = scan.next().charAt(0);//next()�� �̿��Ͽ� �� �ܾ �о���� �о�� �ܾ��� ù���ڸ� ������ << String Ŭ�������� �ڼ��� ����
		System.out.println(ch);	
		
		
		scan.close();//close() �� ���� �ʾƵ� ũ�� ������ ������ �Ⱦ��� ����ǥ�ð� ����
	}

}
