package day14._081_member.variable;

// �����߰� ���� �ʱ� ��ħ
// Ŭ���� ��������� ��ü ��������� �𸣰���

public class _1_Ex {

	public static void main(String[] args) {
		// �ʱ�ȭ ��� �� �˾Ƶα�
		
		/* ������� �ʱ�ȭ ����
		 * ��ü ������� num �ʱ�ȭ ����
		 * 1. �⺻�� : int�� �⺻���� 0���� �ʱ�ȭ
		 * 2. ����� �ʱ�ȭ : ������� ����� ���ÿ� �ʱ�ȭ �Ǵ� �� => 1
		 * 3. �ʱ�ȭ �� : {} �� �� �ʱ�ȭ ������ �ʱ�ȭ => 2
		 * 4. ������ : �����ڿ��� �ʱ�ȭ => 3 / ������!! 
		 */
		
		System.out.println(TestA.num2);
		TestA a = new TestA(TestA.num2);
	}

}

class TestA {
	int num = 1; // �⺻�� 0 => ����� �ʱ�ȭ
	// �ʱ�ȭ ���
	{
		num = 2;
	}
	public TestA() { // �����ڿ��� �ʱ�ȭ
		num = 3;
	}
	
	static int num2 = 1;
	//���� �ʱ�ȭ ���
	static {
		num2 = 2;
	}
	
}	
