package array;

public class Array {

	/** ��� : ������ �迭�� �־�����, ������ �迭�� ���� �ֿܼ� ����ϴ� �޼ҵ�
	 * �Ű����� : �迭 => int arr[]
	 * ����Ÿ�� : ���� => void
	 * �޼���� : printArray
	 */
	
	// �迭 ��ü ���
	public static void printArray(int arr[]) {
		//int i;// �ۿ��� ���� 100�� �˷��൵ �޼ҵ� �ȿ� ���� 0���� �ʱ�ȭ��. �˷��� �ʿ����. ��������ȭ.
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + (i == arr.length -1 ? "":", "));				
		}
		System.out.println("]");
		
	}
	
	/** �迭 �Ϻ�, <start�������� end-1��������> ��� (�޼ҵ� �����ε���) */
	public static void printArray(int arr[], int start, int end) {
		//int i;// �ۿ��� ���� 100�� �˷��൵ �޼ҵ� �ȿ� ���� 0���� �ʱ�ȭ��. �˷��� �ʿ����. ��������ȭ.
		System.out.print("[");
		for(int i = start; i < end; i++) {
			if(i >= arr.length) {
				break; // ������ �� ���� ������ �����ϸ� break; ��������
			}
			System.out.print(arr[i] + (i == end -1 ? "":", "));				
		}
		System.out.println("]");
		
	}
	
	/** ��� : ���� num�� �迭�� 0�������� count����ŭ Ȯ������ �� �ߺ��� ���� �ִ��� ������(boolean) �˷��ִ� �޼ҵ�
	 * �Ű����� : �ߺ��� Ȯ���� �迭(����), ���� ���� num, ���� ���� count
	 * 			=> int arr[]. int num, int count
	 * ����Ÿ�� �ִ��� ������ => boolean
	 * �޼ҵ�� : contains
	 */
	
	// num�� �迭�� ���� �߿��� 0�������� count�� �ȿ� �ִ��� Ȯ���ϴ� �޼ҵ�
	public static boolean contains(int arr[], int num, int count) {
		for(int i = 0; i < count; i++) {
			// �ߺ��Ǹ� �޼ҵ带 �����ϸ鼭 �ߺ��ƴٰ� �˷���
			if(num == arr[i]) {
				return true;
			}
		}
		// �� ��ġ���� �Դٴ°� return true(�ߺ��Ǵ� ���� ������?) �� �������ٴ� ���̰�
		// �� ���� �ߺ����� �ʾҴٴ� ��
		return false; // �ݺ����� �� ���Դµ� �� return false;�� �������? 
	}
	
	/** ��� : min���� max������ ������ ���� �����Ͽ� �迭�� �����ϴ� �޼ҵ�
	 * �Ű����� : �ּҰ�, �ִ밪, �迭 => int min, int max, int arr[]
	 * ����Ÿ�� : ����(���常) => void
	 * �޼ҵ�� : createRandomArray
	 */
	
	public static int[] createRandomArray(int min, int max, int arr[]) {
		// max�� min���� ������, �� ���� ��ȯ! 
		if(max < min) { // 9 < 1
			int tmp = max;
			max = min; 
			min = max; // �� ���� �ٲ���(���� ����?)
		}

		// �迭�� �����Ǿ� ���� ������(�迭�� null�̸�) �޼ҵ� ����
		if(arr == null) {
			arr = new int[max - min + 1]; // *(����)[max - min + 1]�� ¥�� �迭�� ���� �����Ѵ�
										  // 1���� 9���� �������� ����
		}	
		
		// �������� ��������� ���� ������ �迭�� ũ�⺸�� ������ �޼ҵ带 ����
		// min 1 ~ max 3 : �ߺ����� �ʰ� �ִ� 3�� ���� / 4�� �Ұ���, � ���� �ߺ���(=> ���ѷ�������)
		//				 : ������ �� 3���� 4��¥�� �迭�� �ߺ����� �ʰ� �� �� ����
		if(max - min + 1 < arr.length) {
			return null; // * (����)�迭�� ���� ���� ���ϰ� �����Ѵ�.
		}
			
		
		int count = 0;
		while(count < arr.length) {
			int random = (int)(Math.random()*(max - min + 1) + min);
			// �ߺ����� ������, �迭�� ������ �� count ����
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
			
		}
		return arr; // �迭�� null�̾ ���Ƿ� �迭�� ����� �ְڴ�. 
	}
	
	/** ��� : �־��� �迭�� �ߺ��� ���� �ִ��� ������ �˷��ִ� �޼ҵ� 
	 * �Ű����� : �迭 => int arr[]
	 * ����Ÿ�� : �ߺ����� => �ִ��� ������ => boolean
	 * �޼ҵ�� : arrayCheck
	 */
	public static boolean arrayCheck(int arr[]) {
		if(arr == null) {// �迭�� �ȸ������ ������
			return false;			
		}
		
		// arr �迭�� �ٸ� �����鳢�� ���ؼ� ���� ���� �ִ��� Ȯ���ϴ� �ݺ���
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) { //������ �̶� ����
				// ���� ������ �ǳʶ�
				if(i == j) {
					continue;
				}
				// �ٸ� ������ ���� ������ �ߺ��ƴٰ� ����
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		// �ݺ����� ���������� �ߺ�(return true)�� �ȵǸ� �ߺ��� �ȵƴٰ� ���� 
		return false;
	}
}
