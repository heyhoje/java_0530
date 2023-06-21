package day16.abstractEx;

public class _1_AbstractEx {

	public static void main(String[] args) {
		// �߻� Ŭ������ �̿��Ͽ� ��ü�� ���� �� ����. 
		// A a = new A(); // cannot instantiate the type A
		
		/* ���� ���� ���� ������, 
		 * �������� ���� �߻�޼ҵ带 ��ü �����Ŀ� �������̵��� ���ָ� ����*/
		A a = new A() {
			public void test() { // test �޼ҵ带 �������̵�???
				System.out.println("class A Test.");
			}
		}; // �̷� ���¸� ���� �� �� ���� �Ŷ��?? ��?��???
		a.test();
		
		A a2 = new A() {
			public void test() { // test �޼ҵ带 �������̵�???
				System.out.println("class A Test.");
			}
		}; // ���� Ŭ������ �ƴϱ� ������ �ٽ� ��������� ������ �ȵǼ� �����ؾ���
		a2.test();
		
		// ChildA1�� �߻� Ŭ�����̱� ??���� ChildA1���� ��ü�� ������ �� ����.
		// ChildA1 ca1 = new ChildA1(); // �⺻������ ���� �ȵ�
		
		/* �߻� Ŭ������ ��ӹ��� ChildA2�� �Ϲ� Ŭ�����̱� ������ ��ü�� ������ �� �ִ�
		 * ��� ����� �����Ǿ� �ִ� => ��ü ������ ����
		 * ��� ����� �����Ǿ� ���� �ʴ� => �߻� �޼ҵ尡 �ִ� => ��ü ������ �Ұ���	 */
		ChildA2 ca2 = new ChildA2(); // �θ�κ��� ��ӹ��� �޼ҵ带 �������̵� �ؼ�? ���� �ȶ�
		ca2.test();
		
		// ������ : �ϳ��� ��ü�� ���� Ÿ���� �� �� �ִ� ��
		a = ca2; // ��ĳ���� ������ �θ� A a = 
		// ��ĳ���ÿ� ���� ca2��ü�� a�� �ٷ� �� �ִ�.
		a.test(); // ��� ȣ�� ����
		
	}

}

/* �߻� Ŭ������ �߻� �޼ҵ带 ������ �ְ�
 * �߻� �޼ҵ尡 �ִ� Ŭ������ abstract�� ������ ������ ���� �߻�
 */
abstract class A{
	public abstract void test(); // ������({}add body)�� ����. �߻� �޼ҵ�.
	// �޼ҵ忡 final�� ������ ����� �� ����???
	public final void test2() {
		System.out.println("Test2");		
	}
}

/* �߻� Ŭ���� ��� �޴� ��� 1
 * �߻� Ŭ���� A�� ��ӹ��� �ڽ� Ŭ������ �߻�Ŭ������ �������� */
abstract class ChildA1 extends A{ 
	// A��ӹ޾����� abstract void test() �� ������ ����
	// class �տ� abstract �ٿ�����
	
	/* final �޼ҵ带 �������̵� �� �� ����
	public void test2() {
		// final ���� �����ּ���� ��� ������
	}
	*/
}

/* �߻� Ŭ���� ��� �޴� ��� 2 (�ι�°�� �߿�)
 * �θ� Ŭ������ �߻� �޼ҵ带 �������̵��ؼ� ������ ����
 * - �ι�° ����� ���� ����
 */
class ChildA2 extends A{

	@Override
	public void test() { // test��� �߻�޼ҵ带 �������̵� ��..??	
		System.out.println("�׽�Ʈ");
	}
	
	
}
