package day10_copy;

// ���� �ƴѰ� ������ �� �����ϰ� �Ѿ����. ������ ����
//

public class _1_CopyEx {

	public static void main(String[] args) {
		/* �⺻ �ڷ������� �� ������ ���� �����ϴ��� '����' ����Ǳ� ������
		 * ������ �ȴ� (���� ����)
		 */
		int num1 = 10;
		int num2 = num1;
		System.out.println(num1 + " , " + num2);
		num2 = 30; // num1 �⺻�� �ڷ����� ������ ����
		System.out.println(num1 + " , " + num2);
		
		System.out.println("=========");
		
		A a1 = new A();
		A a2 = a1;
		System.out.println(a1.num1 + " , " + a2.num1);
		a2.num1 = 20;
		System.out.println(a1.num1 + " , " + a2.num1);
		
		/* ���� ������ �����Ϸ��� ���� �����ڸ� �̿��Ͽ� ��ü�� ������ ��
		 * ��� �������� �����Ϸ��� ��ü�� ��������� �ʱ�ȭ 
		 * (���� ����) ������ �ٲ� ������ �ȹٲ�
		 */
		System.out.println("=========");
		A a3 = new A(a1);
		System.out.println(a1.num1 + " , " + a3.num1);
		a3.num1 = 50;
		System.out.println(a1.num1 + " , " + a3.num1);
		
	}

}

class A {
	public int num1;
	public A() {}
	
	// ���� ������
	public A(A a) {
		num1 = a.num1;
	}

}
