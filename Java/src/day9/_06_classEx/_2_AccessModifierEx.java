package day9._06_classEx;

import day9._06_classEx2.B;

public class _2_AccessModifierEx {

	public static void main(String[] args) {
		// ���� ������
		A a = new A();
		B b = new B(); // ���� ��Ű���� �ƴϾ ã�� �� ���� >> import >> ctrl+shift_o
		
		// num3�� ���������ڰ� public
		// AccessModifier Ŭ������ AŬ������ ���� ��Ű���� �ִ� Ŭ����
		// AccessModifier Ŭ������ BŬ������ ���� ��Ű���� ���� Ŭ����
		// num3�� ���������ڰ� public, ���� ��Ű���̵� �ƴϵ� ��� ����
		a.num3 = 10; // ctrl+spacebar : ���� �ִ� �������? ������ ������
		b.num3 = 20;
		
		// num2�� ���������ڰ� defualt(������)
		// �ٸ� ��Ű���� �ִ� B Ŭ������ ��ü�� �ִ� num2�� ������ �ȵ�
		a.num2 = 10;
		// b.num2 = 20;
		
		// num1�� ���������ڰ� private.
		// ���� ��Ű���̵� �ƴϵ�, �ٸ� Ŭ�������� ������ �� ����
		// a.num1 = 10;
		// setter�� ���� ���� ���� 
		a.setNum1(10);
		// getter�� ���� ���� ������
		System.out.println(a.getNum1());
		// b.num1 = 20;
		
	}

}


class A{
	private int num1;
	int num2;
	public int num3;
	
	/** Ŭ���� A�� ��ü���� �� num1�� ����ϴ� �żҵ�
	 * �Ű����� : ���� -> �̹� ���� �˰� �ִ� �� ���� num1�̱� ������
	 * ����Ÿ�� : ���� -> void
	 * �޼ҵ�� : print
	 */
	 
	public void print() {
		//num1�� private�̱� ������ ���� AŬ������ �޼ҵ忡�� ȣ��� �� �ִ�.
		// �̹� �˰��ִ� �� ������ Ȱ���ϴ� ���, �Ű������� ���޹��� �ʾƵ���.
		System.out.println(num1); // ����
	}
	
	// private���� �� num1�� �����ϱ� ���ؼ� getter�� �߰�
	public int getNum1() {
		return num1;
	}
	
	// private���� �� num1�� ���� �����ϱ� ���ؼ� Setter�� �߰�
	public void setNum1(int _num1) {
		num1 = _num1;
	}
}