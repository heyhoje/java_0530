package day8_05_MethodOverloading;

public class _1_BasicEx1 {

	public static void main(String[] args) {
		// pringln�� �޼ҵ� �����ε�
		// ��ǥ���� �޼ҵ� �����ε� ����
		// �Ű������� �ٸ�����, ���� ����� ��
		System.out.println("----- p r i n t l n -----");
		
		System.out.println(1);
		System.out.println("1");
		System.out.println(1.1);
		System.out.println("c");
		
		System.out.println("----- s u m -----");
		
		System.out.println(sum(1, 1));
		System.out.println(sum(1.1, 1)); // �Ǽ��ε� ó���ϰ� ����
		System.out.println(sum(1, 1.1));
		System.out.println(sum(1.1, 1.1));
	}
	// �Ű������� �ٸ� ���
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}

	public static double sum(double num1, int num2) {
		return num1 + num2;
	}
	
	public static double sum(int num1, double num2) {
		return num1 + num2;	
	}
	
	// �Ű������� Ÿ���� �ٸ� ���
	public static double sum(double num1, double num2) { // ���� -> �Ǽ� �� ���ϴ°� �ڵ� ����ȯ�� ��. �Ǽ� -> ���� �� �ȵ�
		return num1 + num2;								// ȿ������ �޼ҵ�� 4���� �־ �ȴ�
	}
	
	// ����Ÿ�Ը� �ٸ� �żҵ�� �����ε��� �� �� ����
//	public static double sum(int num1, int num2) { // ��ȯ��Ÿ�Ը� �ٸ��� <�Ű�����>�� Ÿ�Ե� ������ ���� -> �����ε� �ȵ�xxxxx
//		return num1 + num2;						   // ����Ÿ���� �߿����� ���� 
	
	// �Ű������� ������ �ٸ� ���
	public static int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
}
