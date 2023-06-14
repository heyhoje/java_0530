package day11_array;

public class _2_ForEx {

	public static void main(String[] args) {
		int arr[] = new int[] {4, 5, 2, 1, 9};
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = 0; // 배열의 값 0
			int tmp = arr[i];
			System.out.println(tmp);
		}
		System.out.println("-----향상된 for문-----");
		arr = new int[] {4,2,3,6,2};
		for(int tmp : arr) {
			tmp = 0; // 변수 값 0
			System.out.println(tmp);
		}
		System.out.println("----다시 값 나옴----");
		for(int tmp : arr) {
			System.out.println(tmp);
		}
		
	}

}
