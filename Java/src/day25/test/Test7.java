package day25.test;

public class Test7 {
	public static void main(String[] args) {
		System.out.println(sum(10,20));
		System.out.println(sum(10.4,12.2));
	}
	
	// �޼ҵ� �����ε� : �޼ҵ���� ����, �Ű������� �ٸ���(����Ÿ���� ����)
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	// �̹� sum(����, ����)�� �ֱ� ������ �Ʒ� �޼ҵ�� �����ε� �� �� ����
	// int -> double
	public static double sum(double num1, double num2) {
		return num1 + num2;
	}
}

// �޼ҵ� �������̵�