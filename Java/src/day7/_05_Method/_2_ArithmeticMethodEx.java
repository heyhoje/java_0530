package day7._05_Method;

public class _2_ArithmeticMethodEx {

	public static void main(String[] args) {
		System.out.println(sum(1, 2));
		System.out.println(sub(1, 2));
		System.out.println(mul(1, 2));
		System.out.println(div(1, 2));
		System.out.println(mod(1, 2));
		sum2(1,2);  // sysout(sum2(1,2)); ��� ���� return ���� ��� ��¾ȵ�
		//sysout(1+2)
		
		//1+2+3   1�� ���� ����! / 2�� ����ϰ� ������ ����x ������ �� ����.
		int num1=1, num2=2, num3=3;
		int result = sum(num1, num2);
		result = sum(result, num3);
		System.out.println(result); // 6�� ���ɴϴ�! �����!!
		
	}
	/**
	 * �־��� num1, num2�� ���� ����ϴ� �޼ҵ�
	 * (���ϴ� ��� + ����ϴ� ���) ���� �������. ���� ������ �޼ҵ�(�ϳ��� ��ɸ� �ϴ�)�� �ƴ� ^��^
	 * @param num1 ����1
	 * @param num2 ����2
	 *
	 */
	//������ ����. �ֿܼ� ��� ��
	
	public static void sum2(int num1, int num2) {
		System.out.println(num1 + num2);
	}

	/**
	 * �־��� num1, num2�� ���� �˷��ִ� �޼ҵ�
	 * @param num1 ����1
	 * @param num2 ����2
	 * @return num1�� num2�� ��
	 */
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	public static double div(int num1, int num2) { // ������� ����Ÿ���� double�̰�
		return num1 / (double)num2; 				// ����ȯ�� ������Ѵ�.
	}
	
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
}
