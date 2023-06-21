package day11._07_array;

// system.arraycopy(arr1, 복사할 첫번째 위치, arr2, 붙여넣기할 첫번째 위치, 복사할 개수)

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
		System.out.println("[arr2 초기값으로]");
		arr2[0] = 1; //초기값으로 되돌림
		
		arr2 = new int[arr1.length]; // arr1의 크키만큼 배열을 새로 하나 만들기
									 // 복사하기 위한 배열을 생성. 
		
		
		// 반복문으로 복사 => 어떤 그림이 진행되는거죠????????
		// maybe.. 새로운 배열공간을 만들어놓고, 다시 같은 인스턴스 주소값을 넣는것 같죠?? 맞을까?
		for(int i = 0; i < arr1.length; i++) {
			arr2[i] = arr1[i];
		}
		

		arr2[0] = 10; // 다시 arr2만 바꿔봄
		// 반복문을 통해 복사된 arr2에 0번지를 수정해도 arr1은 안변함
		
		System.out.println("-----얕은복사------");
		for(int tmp : arr1) {
			System.out.println(tmp);
		} 
		
		// 이게 깊은 복사가 아니고 얕은 복사라는거죠? 
		
		System.out.println("[arr3 생성]");
		int arr3[] = new int[arr1.length]; // arr1의 크키만큼 배열을 새로 하나 만들고
		System.arraycopy(arr1, 2, arr3, 2, 3); // 2번지 부터 복사 > 2번지부터 붙여넣기 > 요소 3개만
		
		arr3[0] = 10; // 0번지는 10으로 정해줌
		
		System.out.println("-----얕은복사------");
		for(int tmp : arr3) {
			System.out.println(tmp); // 이렇게하면 1번지는 비어있는 상태인 0이고, 
									 // {10, 0, 3, 4, 5}가 된다는것? 도 얕은복사???
		} 
		
	}
	

}
