package day3_03_IfEx;

public class _01_IfEx1 {

	public static void main(String[] args) {
		//���ǹ��� ���϶� ������ �Ѵ�.
		
		//���� num�� 0�̸� "0�Դϴ�."��� ����ϴ� �ڵ带 �ۼ��ϼ���
		//���� (���� num�� 0�̴�) {
		   //0�Դϴ�.��� ���;
		int num = 10;// 10, 0
		if(num == 0) {
			System.out.println("0�Դϴ�.");
		}
		//���� num�� 0�� �ƴϸ� num is not 0 ��� ����ϴ� �ڵ带 �ۼ��ϼ���
		//if(num�� 0�� �ƴϴ�)
		//if(num�� 0�� ���� �ʴ�)
		if(num != 0) {
			System.out.println(num + "�� 0�� �ƴմϴ�.");
			
		}
		// if �� �ΰ�������, ù��°�͸� �����ϴ� ���� �ƴ϶� ����! �����Ѵ�. d
	}
}
