package review_0805;

public class _nado_Quiz_05 {

	public static void main(String[] args) {
		int i = 0;
		
		for (i = 0; i < 10; i++) {
			int size = 250 + (i*5);
			System.out.println("�Ź� ������ : " + size + " (��� ����)");
		}
		
		System.out.println("---------------");
		
		int[] sizeArray = new int[10];
		for ( int j = 0; j < sizeArray.length; j++) {
			sizeArray[j] = 250 + (5 * j);
		}
		
		for(int size : sizeArray) {
			System.out.println("������ : " + size + " (��� ����)");
		}
		
		// �߰��� ���������� ���ٲٳ���
		// sizeArray[7] = ;  
	}

}
