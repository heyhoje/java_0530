package day8_Practice;

import java.util.Scanner;

public class _3_MethodGCDEx {

	public static void main(String[] args) {
		// ���� num1�� num2�� �Է¹޾� �� ������ �ִ� ������� ���ϴ� �ڵ带 �ۼ��ϼ���
		// ��, �޼ҵ带 �̿��� ��
		
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�� ������ �Է��ϼ��� : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int GCD = GCD(num1, num2);
		
		System.out.println(num1 + "�� " + num2 + "�� GCD(�ִ�����) : " + GCD);
		
		sc.close();
	}
	
	/**��� �Ǻ��ϴ� �޼ҵ�
	 * �Ű����� : �� ���� => num1, num2
	 * ����Ÿ�� : ������� �ƴ��� => boolean
	 * �޼ҵ�� : isMultiple
	 */
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	/** �� ������ �־����� �� ������ �ִ� ������� �˷��ִ� �޼ҵ�
	 * �Ű����� : �� ���� => int num1, int num2
	 * ����Ÿ�� : �ִ����� => ���� => int
	 * �żҵ�� : GCD
	 */
	
	public static int GCD(int num1, int num2) {
		for(int i = num1; i >= 1; i--) {
			// i�� num1�� ����̴� == num1�� i�� ����̴�!!
			if(isMultiple(num1, i) && isMultiple(num2, i)) {
				//num1�� ��� && num2�� ��� ==> �ִ� �����
				return i;
			}
		}
		return 1; // num1�� �߸��Ǵ��� 1�� ����ϰ� �������� �� �ֵ���???
	}
}
