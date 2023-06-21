package day11.practice;

// �κ� ������.. �ߺ����� �ʰ� �̾Ƴ��°� ���ذ� �ȵǿ�..!
// �κ� ������.. ������� �����ذſ��� �ٷ� �޼ҵ常 �߰��ߴµ� �� ���������......
// >> 2. �Ű��������� int size ����, �żҵ� ������ size -> arr.length �� �ٲ������

public class _2_ArrayRandomEx2 {

	public static void main(String[] args) {
		// 2. 1~9 ������ ������ �� 3���� '�ߺ����� �ʰ�' ���� �迭�� ������ �� ����ϴ� �ڵ带 �ۼ��ϼ���.
	
		int min = 1, max = 9; 
		int [] arr = new int[3];
		
		System.out.println("----�� �� 1----");
		// ���1 : 9�������� �ִ� �迭�� �̿�
		// �迭�� üũ�ϸ� �Ǳ� ������ �۾��� �ܼ�.
		// but, ���� ������ �ʿ�. 10,000����� 10,000���� ���� �ʿ�
		
		boolean checkArr[] = new boolean[10]; // �⺻���� false
		
		int i;
		for (i = 0; i < 3;) {
			int random = (int)(Math.random()*(max - min +1) + min);
			// * �ٷ� int i �� �����ϴ°� �ƴ϶�, �ϴ� random�� �����, ������ �����ϸ� ���� ����ִ´�
			
			// checkArr �迭�� random ������ �ִ� ���� false�̸�(�յ�� �ִ� �л��� ������)
			if(!checkArr[random]) { //  == false / ���� ���ٴ�,,, ����
				// random�� �迭�� ����
				arr[i] = random;
				// i�� ����
				i++;
				// checkArr�迭�� random������ �ִ� ���� true�� ����
				// �� random ���� ���� ������ true�ϱ� ���� �������� �ʰ� �ǳʶڴ�.
				checkArr[random] = true;// *������ �� ����� ���� true�� �ٲ��ش�!
			}
	
		}
		for(i = 0; i < 3; i++) {
			System.out.println(arr[i]);
			// printArray(arr) �޼ҵ�ȭ
		}
	
		System.out.println("---- �� �� 2----");
		
		// ���� ���ذ� �ȵȴ�.
		
		// ���2 : ����� ������ ��(���� �ݺ��� �ʿ�)
		int count = 0; // ���� ����� ������ ����
		i = 0; // �ݺ������� ����� ����
		
		while(count < 3) {
			int random = (int)(Math.random()*(max - min +1) + min);
			// �̹� ����� ��������� �ϳ��ϳ� ���ؼ� ������ �ִ��� Ȯ���Ͽ�
			// ������ ������ �ݺ��� ����
			for (i = 0; i < count; i++) {// i(0) < count(0) �� �ƴѰ�? 
				if(random == arr[i]) {
					// * �ߺ��� ������ ������ ���ϰ� �ǳʶ�, �ٷ� �̾ random�� �� ����.
					// * �ߺ����� ���� ���� ���ö����� �ݺ��Ѵ�
					break;
					/* �� �ݺ������� break�� ������ ������ i�� count�϶� �����ϱ� ������
					 * �ݺ��� ���� �� i�� count�� ����
					 * ������ break�� ������ �߰��� ���������� i�� count���� �۴�		 
					 */
				}
			}
			if(i == count) { // i�� count�� ���ڰ� ��� ���ϴ��� �𸣰ڳ�???
				arr[count] = random;
				count++;
				// arr[couont++] = ramdom; �� ����
			}
		}
		printArray(arr);
	
	
		System.out.println("---- �� �� 3----");
		// ���3 : ���2�� �޼ҵ�� ����
		createRandomArray(min, max, arr);
			// ������ ���� �迭�� ����(�ּ� ~ �ִ�, �迭)
			// ��if(!contains(arr, random, count)) {
			//		arr[count] = random;
			//  	count++;
				//�ߺ��� ���� �ִ��� Ȯ��. 
		printArray(arr);
			// ������ �迭�� ���
		
		
	}
		// �޼ҵ�1 : printArray (������ �迭�� �� ���)
		/** ��� : ������ �迭�� �־�����, ������ �迭�� ���� �ֿܼ� ����ϴ� �޼ҵ�
		 * �Ű����� : �迭, �迭�� ���� => int arr[], int size = arr.length
		 * ����Ÿ�� : ���� => void
		 * �޼���� : printArray
		 */
		
		public static void printArray(int arr[]) {
			int i;// �ۿ��� ���� 100�� �˷��൵ �޼ҵ� �ȿ� ���� 0���� �ʱ�ȭ��. �˷��� �ʿ����. ��������ȭ.
			for(i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);				
			}
			
		}
		
		// �޼ҵ�2 : contains (�ߺ��� �� �ִ��� Ȯ��, count��)
		/** ��� : ���� num�� �迭�� 0�������� count����ŭ(��ü�� �ƴ϶� ���� ������ count������ŭ)
		 * 		  Ȯ������ �� �ߺ��� ���� �ִ��� ������(boolean) �˷��ִ� �޼ҵ�
		 * �Ű����� : �ߺ��� Ȯ���� �迭(����), ���� ���� num, ���� ���� count
		 * 			=> int arr[]. int num, int count
		 * ����Ÿ�� : �ִ��� ������ => boolean
		 * �� '�˷��ش�', '��ȯ�Ѵ�', '�����ش�'
		 * �޼ҵ�� : contains
		 */
		
		public static boolean contains(int arr[], int num, int count) {
			for(int i = 0; i < count; i++) {
				// �ߺ��Ǹ� �޼ҵ带 �����ϸ鼭 �ߺ��ƴٰ� �˷���
				if(num == arr[i]) { // <- �ߺ��Ȱ� ����
					return true;
				}
				// �� ��ġ���� �Դٴ°� return true(�ߺ��Ǵ� ���� ������?) �� �������ٴ� ���̰�
				// �� ���� �ߺ����� �ʾҴٴ� ��
			} // �Ʒ� if�� ������ �ʿ���� �ٷ� return false; �ϸ��
			// if(i = count) {
			//arr[count] = random;
			//count++
			//}
			return false; 
			  
		}
		
		// �޼ҵ�3 : ������ �� ����, �迭�� ����
		/** ��� : min���� max������ ������ ���� �����Ͽ� �迭�� �����ϴ� �޼ҵ�
		 * �Ű����� : �ּҰ�, �ִ밪, �迭 => int min, int max, int arr[]
		 * ����Ÿ�� : ����(���常) => void
		 * �޼ҵ�� : createRandomArray
		 */
		
		public static void createRandomArray(int min, int max, int arr[]) {
			// ����2) �迭�� �����Ǿ� ���� ������(�迭�� ����������� ������, null�̸�) �޼ҵ� ����
			if(arr == null) {
				return; //������ �ǹ̴�? �׳� ���ǹ��� ������??? * �޼ҵ带 �����Ѵ�.
			}
			
			// ����1) �������� ��������� ���� ������ �迭�� ũ�⺸�� ������ �޼ҵ带 ����
			// min 1 ~ max 3 : �ߺ����� �ʰ� �ִ� 3�� ���� / 4�� �Ұ���, � ���� �ߺ���(=> ���ѷ�������)
			//				 : ������ �� 3���� 4��¥�� �迭�� �ߺ����� �ʰ� �� �� ����
			if(max - min + 1 < arr.length) {
				return; // �迭�� ���� ���� ���ϰ� �����Ѵ�.
			}
			
			// ���ų� ũ�� �����ϰ� �����Ѵ�
			int count = 0;
			while(count < 3) {
				int random = (int)(Math.random()*(max - min + 1) + min);
				// �ߺ����� ������, �迭�� ������ �� count ����
				if(!contains(arr, random, count)) {
					arr[count] = random;
					count++;
				}
				
			}
		}
}
	

	
	


//		if(arr[0] != arr[1] || arr[0] != arr[2] || arr[1] != arr[2])