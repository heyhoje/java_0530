package day15.quiz;

public class _Quiz {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			System.out.println("Hello!");
		}
		
		for(int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		
		/* 3.
		 * ��ü�� <������� , ������, �޼ҵ�> ���� �̷���� �ִ�.
		 * ��ü�� �Ӽ��� <��� ����?>�� �Ѵ�.
		 * ��ü�� ����� <�޼ҵ�>�� �Ѵ�.
		 * ��� ������ �ʱ�ȭ �ϴ� ���� <������?>�� �Ѵ�.
		 * �޼ҵ忡�� ��� ������ �Ű������� �̸��� ���� �� �����ϱ����� <this>Ű���带 ����Ѵ�.
		 * */
		
		/*4. 
		 * ��� ��ü���� �����ϸ� 1���� ������ �����ϱ� ���ؼ� <static>Ű���带 ��� ���� �տ� ���δ�
		 * ���� �ڷ����� ��Ƴ��� ���� <�迭>�� �Ѵ�.
		 * �迭�� (0)�������� ����
		 * �迭�� ���̴� �迭��.<length>�� �̿��Ͽ� �� �� �ִ�.
		 */
		
		int arr[] = new int [10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
			System.out.print(i);
		}
		
		
		
	}
	class A {
		int num;
		public A(int num) {
			this.num = num;
		}
		// public A() {} 1. �⺻�����ڸ� �߰��ϰų� 
	}
	//main �޼ҵ�
	public A a = new A(10); // �⺻������ ����, but AŬ������ ����
					   // 2. 10�� �߰���

}
