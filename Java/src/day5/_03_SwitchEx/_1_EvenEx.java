package day5._03_SwitchEx;

public class _1_EvenEx {

	public static void main(String[] args) {
		//Ȧ¦ ������ Switch ������
		
		int num = 4; 
		
		//Switch(num); // int ������ŭ. 0 ~ ���� �� �� ���������
		
		// num�� 2�� ���� ������ ���� �̿�
		switch(num % 2) {// ���ǽ��� �ƴ� �Ϲݽ��̳�, �����������̳� ���� �Է�
		case 0 : 
			System.out.println(num + "��/�� ¦��");
			break;
		default:
			System.out.println(num + "��/�� Ȧ��");
		}
	}

}
