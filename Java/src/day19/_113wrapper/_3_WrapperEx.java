package day19._113wrapper;

//wrapper, �ڽ̾�ڽ� �ٽ�,,,

public class _3_WrapperEx {

	public static void main(String[] args) {
		// 1. �⺻
		Integer num1 = 10; // �ڽ� : ���� 10�� Integer Ŭ���� ��ü num1�� ����
		// num1 = null;
		int num2 = 0;
		if(num1 != null) {// ����ó�� �ʿ�
			num2 = num1; // ��ڽ� : IntegerŬ���� ��ü num1�� �ִ� ���� num2�� ����. 
		}
		// 2. �ڽ̾�ڽ�
		
		System.out.println(num1);
		System.out.println(num2);
		
		//���׸�
		//ArrayList<Integer> list;
		
 
		//Integer.parseInt�� ���� ���ڿ��� �⺻�ڷ������� ��ȯ�ϴ� �޼ҵ带 ����� �� ����ó�����ִ°��� ����
		int num3 = Integer.parseInt("123");
		System.out.println(num3);
	}

}
