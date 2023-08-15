package review_0805;

public class _nado_Quiz_05 {

	public static void main(String[] args) {
		int i = 0;
		
		for (i = 0; i < 10; i++) {
			int size = 250 + (i*5);
			System.out.println("신발 사이즈 : " + size + " (재고 있음)");
		}
		// 왜 맨날 배열 배워놓고 안배열로 문제를 풀까...;;
		
		System.out.println("---------------");
		
		int[] sizeArray = new int[10];
		for ( int j = 0; j < sizeArray.length; j++) {
			sizeArray[j] = 250 + (5 * j);
		}
		
		for(int size : sizeArray) {
			System.out.println("사이즈 : " + size + " (재고 있음)");
		}
		
		// 중간에 재고없음으로 못바꾸나요
		// sizeArray[7] = ;  
	}

}
