package day11_practice;

// �κ� ������.. �ߺ����� �ʰ� �̾Ƴ��°� ���ذ� �ȵǿ�..!
// �κ� ������.. ������� �����ذſ��� �ٷ� �޼ҵ常 �߰��ߴµ� �� ���������......
// >> 2. �Ű��������� int size ����, �żҵ� ������ size -> arr.length �� �ٲ������

public class _2_ArrayRandomEx2 {

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
	

	// ���3 : ���2�� �޼ҵ�� ����
	count = 0;
	while(count < 3) {
		int random = (int)(Math.random()*(max - min +1) + min);
		// �ߺ����� ������ �迭�� ���� �� count ����
		if(!contains(arr, random, count)) {
			arr[count] = random;
			count++;
		}
	}
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
	 * 	������ �˷��ִ�(return) �޼ҵ�
	 * �Ű����� : �ߺ��� Ȯ���� �迭(����), ����num(��), count(���� ����) 
	 * 			=>  int arr[], int num, int count
	 * ����Ÿ�� : �ִ��� ������ => boolean 
	 * �޼ҵ�� : contains
	 */
	
	public static boolean contains(int arr[], int num, int count) {
		// ������ �޼ҵ忡 static�� �־ + �� ��...? 
			
			for (int i = 0; i < count; i++) {
				// �ߺ��Ǹ� break ����, �޼ҵ带 �����ϸ鼭 �ߺ��ƴٰ� �˷���
				if(num == arr[i]) {
					return true;
					//break;
				}
			}
			// �� ��ġ���� �Դٴ°� return true�� �� �����ٴ� ���̰�,
			// �� ���� �ߺ����� �ʾҴٴ� ��
			return false;
	}
	/** min���� max������ ������ ���� �����ؼ� �迭�� �����ϴ� �޼ҵ�
	 * �Ű����� : �ּҰ�, �ִ밪, �迭 => int min, int, max, int arr[]
	 * ����Ÿ�� : ���� => void
	 * �޼ҵ�� : createRandomArray
	 */
	
	public static void createRandomArray(int min, int max, int arr[]) {
		// �迭�� �����Ǿ� ���� ������(�迭�� ��������� ������, null�̸�)
		if(arr == null) {
			return;
		}
		// �������� ��������� ���� ������ �迭�� ũ�⺸�� ������, �޼ҵ带 ����
		// min 1 ~ max 3 : �ߺ����� �ʰ� �ִ� 3�� ���� / 4�� �Ұ���, � ���� �ߺ���(=> ���ѷ�������)
		// 				 : 3���� 4��¥�� �迭�� �� �� ����
		
		if(max - min +1 < arr.length) {
			return; // �迭�� ���� ���� ���ϰ� �����Ѵ�.
		} 
		int count = 0;
		while(count < 3) {
			int random = (int)(Math.random()*(max - min +1) + min);
			// �ߺ����� ������ �迭�� ���� �� count ����
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
		}
		
	}
}
	

	
	


//		if(arr[0] != arr[1] || arr[0] != arr[2] || arr[1] != arr[2])