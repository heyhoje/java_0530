package day22._131_lambda;

public class _1_LambdaEx1 {

	public static void main(String[] args) {
		InterfaceA a = new InterfaceA() {

			@Override
			public int getMax(int num1, int num2) {
				return num1 >= num2 ? num1 : num2;
			}
		};
		System.out.println(a.getMax(10, 20));
		
		InterfaceA b = (num1, num2)->{ // �������̽��� ���� ���� ������, �ڷ���Ÿ���� �����ȴ�
			return num1 >= num2 ? num1 : num2;
		};
		System.out.println(b.getMax(10, 20));
		
		// �Ű������� 1���̸� ()�� ����.
		// ���๮�� 1���̸� {}, return �� ���� ����!
		InterfaceA c = (num1, num2)-> num1 >= num2 ? num1 : num2;
		System.out.println(b.getMax(10, 20));
	}
}

interface InterfaceA {
	int getMax(int num1, int num2);

}