package review_0723;

public class _nado_quiz_05 {

	public static void main(String[] args) {
		// �迭�� Ȱ���Ͽ� ���θ����� ���� ������ �Ź� ������ �ɼ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�
		int[] sizeArray = new int[10];
		for(int i = 0; i < sizeArray.length; i++) {
			sizeArray[i] = 250 + (5 * i);
		}
		// for-each(inhanced for) ���� for���� �̰ſ���???????���
		for(int size : sizeArray) {
			System.out.println("������ " + size + " (��� ����)");
		}
		
		// �迭 ������ �迭 �ϳ��� �Ⱦ�;;;;;;
//		int size = 0;
//		for(int i = 0; i < 10; i++) {
//			size = 250 + 5 * i;
//			System.out.println("�Ź� ������ : " + size);
//		}
	}

}
