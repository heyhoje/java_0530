package day2_02_Operator;

public class _01_Arithmetic {

	public static void main(String[] args) {
		int num1 = 1, num2 = 2;
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)num1 / num2;// 1/2�� ����� 0�̾, 1.0/2�� �ٲپ� 0.5�� ������ ��
		int mod = num1 % num2;
		
		System.out.println("" + num1 + '+' + num2 + "=" + sum);
		System.out.println("" + num1 + '-' + num2 + "=" + sub);
		System.out.println("" + num1 + '*' + num2 + "=" + mul);
		System.out.println("" + num1 + '/' + num2 + "=" + div);
		System.out.println("" + num1 + '%' + num2 + "=" + mod);
		
		int res = 0;
		// 1 + res = 2;// ���Կ����� = ���ʿ� ���� �ͼ� ������ �߻�(���ʿ��� ����� ������) 
		res = 2 - 1;// ���Կ����� = �����ʿ� ���� �ͼ� ���� ���� �� ����
		//1 = res + 1 // ���Կ����� = ���ʿ��� ���ͷ��� �� �� ����!! 
	}

}
