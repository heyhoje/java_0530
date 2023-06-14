package day11_array;

// tmpArr ȣ���ϴµ��� ��ħ 

public class _5_ArrayMethodEx1 {

	public static void main(String[] args) {
		//�޼ҵ��� �Ű������� ���õ� ����
		int num1 = 10;
		int num2 = 20;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		//�� ������ ��ȯ�ϴ� �ڵ� �ۼ�
		int tmp = num1;
		num1 = num2;
		num2 = tmp; // �� ���� ��ȯ�Ϸ��� ���� �ϳ��� �� �ʿ�
		
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		System.out.println("----ȣ����------");
		num1 = 10; num2 = 20;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		swap(num1, num2);
		System.out.println("----ȣ����------");
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		// �迭
		System.out.println("-------");
		int arr1[] = {1,2,3,4};
		int arr2[] = {5,6,7,8};
		// �� �迭�� ��ȯ�Ϸ���, �ﰢ������ ȸ�� ��ȯ�ؾ���.
		// �ּҸ� �ٲ��ִ°�
		int tmpArr[] = new int [arr1.length];
		
		
		tmpArr = arr1;
		arr1 = arr2;
		arr2 = tmpArr;
		
		//�޼ҵ� �����ε� (���� 1��/����2��)
		swap(arr1, arr2);
		System.out.println("--------");
		printArr(arr1);
		printArr(arr2);
		
		swap2(arr1, arr2);
		System.out.println("--------");
		printArr(arr1);
		printArr(arr2);
  	}
	
	public static void printArr(int arr[]) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	/** �� �迭�� ��ȯ�ϴ� �żҵ�2 : ��ȯ�� �� */
	public static void swap2(int arr1[], int arr2[]) {
		int tmp[] = new int [arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			tmp[i] = arr1[i];
			arr1[i] = arr2[i];
			arr2[i] = tmp[i];
			
			
		}
		
	}
	
	/** �� �迭�� ��ȯ�ϴ� �޼ҵ�1 : ��ȯ�� �ȵ�*/
	public static void swap(int arr1[], int arr2[]) {
		// �� �迭�� ��ȯ
		int tmpArr[] = arr1;
		arr1 = arr2;
		arr2 = tmpArr;
		
	}
	
	/** �� ������ ���� ��ȯ�ϴ� �޼ҵ�	: ��ȯ�� �ȵ� */
	public static void swap(int num1, int num2) {
		/* �Ű����� num1�� num2�� �޼ҵ尡 ȣ��Ǹ� ���� ������ ����
		 * ȣ���� ������ �Ѱ��� ���� ������ ��(���纻���� �޼ҵ带 ����)
		 */
		
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
		
	}

}
