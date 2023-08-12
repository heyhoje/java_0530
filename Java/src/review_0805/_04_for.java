package review_0805;

public class _04_for {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 10 ; i++) {
			sum = sum + i;
			System.out.println("현재까지 총합은 " + sum + "입니다");
		}
		System.out.println("1부터 10까지의 모든 수의 총합은" + sum + "입니다");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("---------------");
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4 - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k < i + 2; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------");
		for(int i = 2; i < 10; i++) {
			for(int j = 1; j < 10; j++) {
			System.out.println(i + " * " + j + " = " + (i*j));
			}
			System.out.println();
		}
	}
	

}
