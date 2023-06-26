package day19._114_math;

public class MathEx {

	public static void main(String[] args) {
		System.out.println(Math.abs(-1.2)); // -1.2�� ���밪
		System.out.println(Math.ceil(1.29));; // 1.29�� �Ҽ��� ù��° �ڸ����� �ø�
		System.out.println(Math.floor(1.29)); // 1.29�� �Ҽ��� ù��° �ڸ����� ����
		System.out.println(Math.round(1.29));// 1.29�� �Ҽ��� ù��° �ڸ����� �ݿø�
		System.out.println(Math.pow(2, 3)); // 2�� 3����
		System.out.println(Math.random()); // 0�̻� 1�̸��� ����
		
		// 1.29�� �Ҽ��� ��°�ڸ����� �ݿø�
		double num = 1.29;
		int pos = 2; // �Ҽ��� pos�ڸ����� �ݿø�
		
		num *= Math.pow(10, pos-1);// 12.9
		num = Math.round(num); // 1.29�� �Ҽ��� ù��° �ڸ����� �ݿø�
		num /= Math.pow(10, pos-1);
		System.out.println(num); // 1.29�� �Ҽ��� �ι�° �ڸ����� �ݿø�
		
	}

}
