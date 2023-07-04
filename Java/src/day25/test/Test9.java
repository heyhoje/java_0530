package day25.test;

public class Test9 {
	public static void main(String[] args) {
		//0부터 차례대로 저장하는 예제
		// 배열을 생성하지 않아서 저장할 수 없음
		int [] arr = new int[10];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i;
			System.out.print(i);
		}
	}
}
