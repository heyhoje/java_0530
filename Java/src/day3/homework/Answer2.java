package day3.homework;

import java.util.Scanner;

public class Answer2 {

	public static void main(String[] args) {
		//���ڸ� �Է¹޾Ƽ� �ߴٸ�, m�̶�� ���ڿ��� �޾Ƽ� ó���ϴ� ����
		//���ڿ��� �޾Ƽ� ó���� �� �ִ��� Ȯ���ϴ� ����
		
		/*Ex1. ����(M:����, W:����)�� �Է¹޾� �������� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
		input gender : M
		Are you a women? false
		
		input gender : W
		Are you a women? true
		*/
		// 1. ���� 2. ���ڿ� �� �Է¹޴¹��
		
		//���ڿ��� ��� �ϴ��� 
		String gender;//�ʿ��� ��������
		System.out.println("input gender : "); // ���
		Scanner scan = new Scanner(System.in); //�Է¹޾ƾ��ϴϱ�
		// gender = scan.next().charAt(0); // ���ڿ��� ���� �ʵ��� //���ڿ��� ���簡�� "", ���ڴ� �Ұ���'' 
										// next(); ���� / nextLine(); �Ұ���
		gender = scan.next();
		
		// boolean result = gender == 'M' ? false : true; / m�̾ƴ� ��� ���ڸ� �������� �ν��� �� ����
		boolean result = gender.equals("W") ? true : false; //���ڿ� equals
		System.out.println("Are you a women? " + result);//��¹���

		
		scan.close();
	}

}
