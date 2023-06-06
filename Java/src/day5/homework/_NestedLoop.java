package day5.homework;

public class _NestedLoop {

	public static void main(String[] args) {
		// 별 사각형
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*"); // *****
			}
			System.out.println(" "); // 라인바꿔 위로반복
		} 
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print("*"); // * > ** > *** > **** > *****
			}
			System.out.println(""); // 라인바꿔 위로 반복 5회
		}
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5 - i - 1;j++) {
				System.out.print("S");
			}
			for (int k = 0; k < i + 1; k++) {
				System.out.print("*"); // for 안에 for문 2개/공백 4 + * 1
			}
			System.out.println(); // 라인바꿔 위로 반복 5회
		}
		
		System.out.println("----------------------------");

		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " * " + j + " = " + (i*j));
			}
			System.out.println();
		}
	}

}
