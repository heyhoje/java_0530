package review_0723;

public class _nado_quiz_04 {

	public static void main(String[] args) {
		// ���ǹ��� Ȱ���Ͽ� <���� ��� ����> ���α׷��� �ۼ��Ͻÿ�
		int hour = 10;
		
		boolean isSmallCar = false;
		boolean withDisabledPerson = true;
		
		int fee = 4000 * hour;
		
		if(fee > 30000) {
			fee = 30000;
		}
		if(isSmallCar == true || withDisabledPerson == true) {
			fee /= 2;
		}
		
		// ���� ��� ���
		System.out.println("��������� " + fee + "�� �Դϴ�.");	
	}
}
