package day2._02_Operator;

public class _02_IncreaseOperator {

	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		System.out.println("�۾� �� : " + num1 + "(������), " + num2 + "(������)");
		// �������� ���� ������ �ϰ� ����, num1�� ������Ų�� �۾��� ���ڿ��� ����
		// �������� ���� ������ �ϰ� ����, num2�� ���� ���ڿ��� ���� �Ŀ� num2�� ������Ŵ
		System.out.println("�۾� �� : " + ++num1 + "(������), " + num2++ + "(������)");
		System.out.println("�۾� �� : " + num1 + "(������), " + num2 + "(������)");

		System.out.println("---------------------------");
		num1 = num2 = 10;
		System.out.println("�۾� �� : " + num1 + "(������), " + num2 + "(������)");
		++num1;
		System.out.println("�۾� �� : " + num1 + "(������), " + num2 + "(������)");
		++num2;
		System.out.println("�۾� �� : " + num1 + "(������), " + num2 + "(������)");
	}

}
