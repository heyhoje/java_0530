package day11._07_array;

// system.arraycopy(arr1, ������ ù��° ��ġ, arr2, �ٿ��ֱ��� ù��° ��ġ, ������ ����)

public class _3_ArrayCopyEx {

	public static void main(String[] args) {
		// �迭�� arr1�� arr2�� ��������
		// �������� : ���� �ٲٸ� �ּҰ��� �˰��־ �����ؼ� ������ �����ϸ� �ٸ��ʵ� ������.
		int arr1[] = new int[] {1,2,3,4,5};
		int arr2[] = arr1; // ���������� ���� ����. 
						   // �� �ڵ�� �迭�� arr1�� arr2�� ����
		
		arr2[0] = 10; // arr2�� �ִ� 0������ �����ϸ� arr1�� ���� ������
		
		//���� for��
		for(int tmp : arr1) {
			System.out.println(tmp);
			// arr2[0]�� �ٲ�µ�, arr1[0] �� �ٲ����� : (���������̱⶧��) 
		}
		System.out.println("[arr2 �ʱⰪ����]");
		arr2[0] = 1; //�ʱⰪ���� �ǵ���
		
		arr2 = new int[arr1.length]; // arr1�� ũŰ��ŭ �迭�� ���� �ϳ� �����
									 // �����ϱ� ���� �迭�� ����. 
		
		
		// �ݺ������� ���� => � �׸��� ����Ǵ°���????????
		// maybe.. ���ο� �迭������ ��������, �ٽ� ���� �ν��Ͻ� �ּҰ��� �ִ°� ����?? ������?
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		

		arr2[0] = 10; // �ٽ� arr2�� �ٲ㺽
		// �ݺ����� ���� ����� arr2�� 0������ �����ص� arr1�� �Ⱥ���
		
		System.out.println("-----��������------");
		for(int tmp : arr1) {
			System.out.println(tmp);
		} 
		
		// �̰� ���� ���簡 �ƴϰ� ���� �����°���? 
		
		System.out.println("[arr3 ����]");
		int arr3[] = new int[arr1.length]; // arr1�� ũŰ��ŭ �迭�� ���� �ϳ� �����
		System.arraycopy(arr1, 2, arr3, 2, 3); // 2���� ���� ���� > 2�������� �ٿ��ֱ� > ��� 3����
		
		arr3[0] = 10; // 0������ 10���� ������
		
		System.out.println("-----��������------");
		for(int tmp : arr3) {
			System.out.println(tmp); // �̷����ϸ� 1������ ����ִ� ������ 0�̰�, 
									 // {10, 0, 3, 4, 5}�� �ȴٴ°�? �� ��������???
		} 
		
	}
	

}
