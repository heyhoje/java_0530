package day13._072_sort;

import java.util.Arrays;
import java.util.Comparator;

import array.Array;

public class _1_ArraySortEx {

	public static void main(String[] args) {
		// ���� ���� ����
		int arr[] = {1, 4, 6, 2, 9, 3, 8};
		System.out.println("--������--");
		Array.printArray(arr); 
		
		// ���߹ݺ���(���پ�/���� ��ҿ� ��)
		for(int i = 0; i < arr.length -1; i++) {//�������� 1�� ���Ƽ� ���� ���ѹ��� ���ص���
			for(int j = 0; j < arr.length -1-i; j++) { // �� ���̳ʽ� 1??? ���ϴ� ����?
							  // 6�� - 01 12 23 34 45 / 56(X) 
			if(arr[j] > arr[j+1]) {
				int tmp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = tmp;
				}		
			}
			System.out.println("--������--");
			Array.printArray(arr);
		}
		Integer arr2[] = {1, 4, 6, 2, 9, 3, 8};// integer ������ 'Ŭ����' => ���� + null
		Arrays.sort(arr2); // ��������
		
		Arrays.sort(arr2, Comparator.reverseOrder()); // ��������
		
		
		//���� for��
		for(Integer tmp : arr2) {
			System.out.println(tmp + " ");
		}
	}

}
