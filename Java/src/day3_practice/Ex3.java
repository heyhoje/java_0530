package day3_practice;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		/*���� num�� �Է¹޾Ƽ� num�� 0����, ��������, ��������� �Ǻ��ϴ� �ڵ带 if���� �̿��Ͽ� �ۼ��ϼ���.
		num�� 0�̸� 0�̶�� ����ϰ�, 
		num�� �����̸� ������� ����ϰ�,
		num�� ����̸� ������ ����ϴ� �ڵ带 �ۼ��ϼ���.
		 */
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input number : ");
		num = sc.nextInt();
		
		if(num == 0) {
			System.out.println(num + "�� 0�̴�");
		}
		if(num > 0) {
			System.out.println(num + "�� ����̴�");
		}
		if(num < 0) {
			System.out.println(num + "�� �����̴�");
		}
		
		sc.close();

	}
}
