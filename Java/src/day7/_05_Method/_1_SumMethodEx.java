package day7._05_Method;

public class _1_SumMethodEx {

	public static void main(String[] args) {
		/* 1. �� ������ ���� ���ϴ� �Լ�(�޼ҵ�)�� ���弼��
		 */
		int num1 = 1, num2 = 2;
		int result = sum(1, 2);
		System.out.println(result);
		
		/** 
		 * ���	: �� ������ �־�����, �� ������ ���� �˷��ִ� �޼ҵ�
		 * �޼ҵ�� : sum   / ����ܾ� �˻��ؼ�
		 * ����Ÿ�� : �� ������ �� => int
		 * �Ű����� : �� ���� => int num1, int num2
		 * @return
		 */
		/**
		 * ���	: �� ������ �־����� �� ������ ���� �˷��ִ� �޼ҵ�
		 * @param num1 ����1
		 * @param num2 ����2
		 */
		// public static ����Ÿ�� �żҵ��(�Ű�������) {
		// 	return xx;
		// }
		
	}

	public static int sum(int num1, int num2) {
		int result = num1 + num2;
		return result; // int�� �⺻�� = 0 -> ���� �Ǵ� ���� ���� �˷������
		// return num1 + num2;  // �Ϲ������δ� �ּ�ó���� �ش� ������ ���� ��
	}

}
