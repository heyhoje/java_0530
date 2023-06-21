package day11._07_array;

// tmpArr 호출하는데서 놓침 
// 그냥 난장판임... 깃헙 봐도 쓸게 너무 많아서 골라내기 어렵겠는걸? 이해는 될까? 

public class _5_ArrayMethodEx1 {

	public static void main(String[] args) {
		//메소드의 매개변수와 관련된 예제
		int num1 = 10;
		int num2 = 20;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		//1. 두 정수를 교환하는 코드 작성
		int tmp = num1;
		num1 = num2;
		num2 = tmp; // 두 수를 교환하려면 변수 하나가 더 필요
		
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		System.out.println("----호출전------");
		num1 = 10; 
		num2 = 20;
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		swap(num1, num2);
		System.out.println("----호출후------");
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		// 배열
		System.out.println("-------");
		int arr1[] = {1,2,3,4};
		int arr2[] = {5,6,7,8};
		// 두 배열을 교환하려면, 삼각형으로 회전 교환해야함.
		// 주소를 바꿔주는것
		int tmpArr[] = new int [arr1.length];
		
		System.out.println("---------");
		printArr(arr1);
		printArr(arr2);
		
		// 2. 두 배열을 교환
		tmpArr = arr1;
		arr1 = arr2;
		arr2 = tmpArr;
		
		System.out.println("---------");
		printArr(arr1);
		printArr(arr2);
		
		// 매개변수로 넘겨준 배열의 주소가 메소드 안에서 바뀌면 원본에 영향이 없음
		swap(arr1, arr2);
		System.out.println("---------");
		printArr(arr1);
		printArr(arr2);
		
		// 매개변수로 넘겨준 배열의 주소가 아닌 배열의 값이 메소드 안에서 바뀌면ㄴ
		
		// 원본이 영향을 받음
		swap2(arr1, arr2);
		System.out.println("---------");
		printArr(arr1);
		printArr(arr2);
		
		System.out.println("----------");
		int arr3[] = {1,2,3,4};
		printArr(arr3);
		test1(arr3);
		printArr(arr3);
		
		System.out.println("------------");
		int arr4[] = {1,2,3,4};
		printArr(arr4);
		test2(arr4);
		printArr(arr4);
		
//		//메소드 오버로딩 (정수 1개/정수2개)
//		swap(arr1, arr2);
//		System.out.println("--------");
//		printArr(arr1);
//		printArr(arr2);
//		
//		swap2(arr1, arr2);
//		System.out.println("--------");
//		printArr(arr1);
//		printArr(arr2);
  	
	
	System.out.println("----------");
	}	


	public static void test1(int arr[]) {
		// 기존 배열을 버리고 새로운 배열을 만듬
		// => main에서 연결되었던 배열과 연결이 끊김
		arr = new int [4];
		arr[0] = 3;
	}
	
	public static void test2(int arr[]) {
		arr[0] = 3;
	}
	
	public static void printArr(int arr[]) {
		for(int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
	
	/** 두 배열을 교환하는 매소드2 : 교환이 됨 */
	public static void swap2(int arr1[], int arr2[]) {
		int tmp[] = new int [arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			tmp[i] = arr1[i];
			arr1[i] = arr2[i];
			arr2[i] = tmp[i];
		}
	}
	
	/** 두 배열을 교환하는 메소드1 : 교환이 안됨*/
	public static void swap(int arr1[], int arr2[]) {
		// 두 배열을 교환
		int tmpArr[] = arr1;
		arr1 = arr2;
		arr2 = tmpArr;
		
	}
	
	/** 두 정수의 값을 교환하는 메소드	: 교환이 안됨 */
	public static void swap(int num1, int num2) {
		/* 매개변수 num1과 num2는 메소드가 호출되면 새로 변수를 만들어서
		 * 호출한 곳에서 넘겨준 값을 복사해 옴(복사본으로 메소드를 실행)
		 */
		
		int tmp = num1;
		num1 = num2;
		num2 = tmp;
	}

}
