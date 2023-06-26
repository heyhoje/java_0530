package day13._072_sort;

import java.util.Arrays;
import java.util.Comparator;

import array.Array;

public class _1_ArraySortEx {

	public static void main(String[] args) {
		// 버블 정렬 예제
		int arr[] = {1, 4, 6, 2, 9, 3, 8};
		System.out.println("--정렬전--");
		Array.printArray(arr); 
		
		// 이중반복문(한줄씩/옆에 요소와 비교)
		for(int i = 0; i < arr.length -1; i++) {//마지막에 1만 남아서 굳이 비교한번더 안해도됨
			for(int j = 0; j < arr.length -1-i; j++) { // 왜 마이너스 1??? 비교하는 수라?
							  // 6개 - 01 12 23 34 45 / 56(X) 
			if(arr[j] > arr[j+1]) {
				int tmp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = tmp;
				}		
			}
			System.out.println("--정렬후--");
			Array.printArray(arr);
		}
		Integer arr2[] = {1, 4, 6, 2, 9, 3, 8};// integer 정수형 '클래스' => 정수 + null
		Arrays.sort(arr2); // 오름차순
		
		Arrays.sort(arr2, Comparator.reverseOrder()); // 내림차순
		
		
		//향상된 for문
		for(Integer tmp : arr2) {
			System.out.println(tmp + " ");
		}
	}

}
