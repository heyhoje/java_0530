package review_0723;

public class _nado_quiz_05 {

	public static void main(String[] args) {
		// 배열을 활용하여 쇼핑몰에서 구매 가능한 신발 사이즈 옵션을 출력하는 프로그램을 작성하시오
		int[] sizeArray = new int[10];
		for(int i = 0; i < sizeArray.length; i++) {
			sizeArray[i] = 250 + (5 * i);
		}
		// for-each(inhanced for) 향상된 for문이 이거였어???????띠용
		for(int size : sizeArray) {
			System.out.println("사이즈 " + size + " (재고 있음)");
		}
		
		// 배열 문젠데 배열 하나도 안씀;;;;;;
//		int size = 0;
//		for(int i = 0; i < 10; i++) {
//			size = 250 + 5 * i;
//			System.out.println("신발 사이즈 : " + size);
//		}
	}

}
