package day11.practice;

public class _1_ArrayRandomEx {

	public static void main(String[] args) {
		// 1. 1~9 사이의 랜덤한 수 3개를 만들어서 배열에 저장한 후 출력하는 코드를 작성하세요.
				
		int min = 1, max = 9; 
		int [] arr = new int[3]; 
		
//		arr[0] = (int)(Math.random()*(max - min +1) + min);
//		arr[1] = (int)(Math.random()*(max - min +1) + min);
//		arr[2] = (int)(Math.random()*(max - min +1) + min);
//
//		System.out.println(arr[0]);
//		System.out.println(arr[1]);
//		System.out.println(arr[2]);
		int i;
		for (i = 0; i < 3; i++) {
			arr[i] = (int)(Math.random()*(max - min +1) + min);
			System.out.println(arr[i]);
		}
	}
}


