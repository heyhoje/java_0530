package day25.test;

public class Test8 {

	public static void main(String[] args) {
		
		int num = 3;
		System.out.println(num + "�� ¦���ΰ�? " + isEven(num));
	}
	
	//Ȧ¦�� �Ǻ��ϴ� �޼���
	// �޼ҵ�� ����Ÿ���� ������ � ��Ȳ������ �ݵ�� �ش� Ÿ������ ������ �������
	// �Ʒ� �ڵ�� Ȧ���� �� ������ ���� => ���� �߻�
	public static boolean isEven(int num) {
		if(num % 2 == 0) {
			return true;
		}
		return false;
	}

}
