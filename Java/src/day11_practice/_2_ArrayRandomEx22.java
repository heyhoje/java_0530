package day11_practice;

// ����� �ڵ� ���� ��, �κ� �����Բ� sos

public class _2_ArrayRandomEx22 {

	public static void main(String[] args) {
		// 2. 1. 1~9 ������ ������ �� 3���� '�ߺ����� �ʰ�' ���� �迭�� ������ �� ����ϴ� �ڵ带 �ۼ��ϼ���.
		
			int min = 1, max = 9; 
			int [] arr = new int[3];
			
			// ���1 : 9�������� �ִ� �迭�� �̿�
			// �迭�� üũ�ϸ� �Ǳ� ������ �۾��� �ܼ�.
			// but, ���� ������ �ʿ�. 10,000����� 10,000���� ���� �ʿ�
			boolean checkArr[] = new boolean[10]; // �⺻���� false
			
			int i;
			for (i = 0; i < 3;) {
				int random = (int)(Math.random()*(max - min +1) + min);
				// checkArr �迭�� random ������ �ִ� ���� false�̸�
				//System.out.println(arr[i]);
				if(!checkArr[random]) { //  == false / ���� ���ٴ�,,, ����
					// random�� �迭�� ����
					arr[i] = random;
					// i�� ����
					i++;
					// checkArr�迭�� random������ �ִ� ���� true�� ����
					checkArr[random] = true;
				}
		
			}
			for(i = 0; i < 3; i++) {
				System.out.println(arr[i]);
			}
		
			System.out.println("--------------");
			// ���2 : ����� ������ ��(���� �ݺ��� �ʿ�)
			int count = 0; // ���� ����� ������ ����
			i = 0; // �ݺ������� ����� ����
			
			while(count < 3) {
				int random = (int)(Math.random()*(max - min +1) + min);
				// �̹� ����� ��������� �ϳ��ϳ� ���ؼ� ������ �ִ��� Ȯ���Ͽ�
				// ������ ������ �ݺ��� ����
				for (i = 0; i < count; i++) {
					if(random == arr[i]) {
						break;
					}
				}
				/* �� �ݺ������� break�� ������ ������ i�� count�϶� �����ϱ� ������
				 * �ݺ��� ���� �� i�� count�� ����
				 * ������ break�� ������ �߰��� ���������� i�� count���� �۴�		 
				 */
				if(i == count) {
					arr[count] = random;
					count++;
				}
			}
			printArray(arr);
	}
	
	/** ������ �迭�� �־�����, ������ �迭�� ���� �ֿܼ� ����ϴ� �޼ҵ�
	 * �Ű����� : �迭�� �迭�� ����(3, arr[]) => int arr[], int size -> arr.length
	 * ����Ÿ�� : (���) ����=> void
	 * �żҵ�� : printArray
	 */
	
	public static void printArray(int arr[]) {
		int i; // �ۿ��� ���� 100�� �˷��൵ �޼ҵ� �ȿ� ���� 0���� �ʱ�ȭ��. �˷��� �ʿ����. ��������ȭ.
		for(i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/** ���� num�� �迭�� 0�������� count����ŭ Ȯ������ �� �ߺ��� ���� �ִ��� 
	 * 	������ �˷��ִ� �޼ҵ�
	 * �Ű����� : 
	 * ����Ÿ�� :
	 * �޼ҵ�� : contains
	 */
	
	

}
