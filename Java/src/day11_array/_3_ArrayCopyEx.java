package day11_array;

// system.arraycopy(들어가는 순서 모름)

public class _3_ArrayCopyEx {

	public static void main(String[] args) {
		// 배열인 arr1과 arr2는 참조변수
		// 참조변수 : 값을 바꾸면 주소값을 알고있어서 공유해서 한쪽을 수정하면 다른쪽도 수정됨.
		int arr1[] = new int[] {1,2,3,4,5};
		int arr2[] = arr1; // 문법적으론 문제 없음. 
						   // 이 코드는 배열을 arr1과 arr2가 공유
		
		arr2[0] = 10; // arr2에 있는 0번지를 수정하면 arr1도 같이 수정됨
		
		//향상된 for문
		for(int tmp : arr1) {
			System.out.println(tmp);
			// arr2[0]만 바꿨는데, arr1[0] 도 바뀌어버림 : (참조변수이기때문) 
		}
		System.out.println("----arr2 초기값으로----");
		arr2[0] = 1; //초기값으로 되돌림
		
		arr2 = new int[arr1.length]; // 배열을 새로 하나 만들고????
									 // 복사하기 위한 배열을 생성. arr1의 크키만큼
		
		
		//반복문으로 복사 => 어떤 그림이 진행되는거죠????????
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		

		arr2[0] = 10; // 다시 arr2만 바꿔봄
		// 반복문을 통해 복사된 arr2에 0번지를 수정해도 arr1은 안변함
		
		System.out.println("-----얕은복사------");
		for(int tmp : arr1) {
			System.out.println(tmp);
		} 
		
		System.out.println("----arr3 생성----");
		int arr3[] = new int[arr1.length];
		System.arraycopy(arr1, 2, arr3, 2, 3);
		
		arr3[0] = 10;
		
		System.out.println("-----얕은복사------");
		for(int tmp : arr3) {
			System.out.println(tmp);
		} 
		
	}
	

}
