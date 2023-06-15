package array;

public class Array {

	/** 기능 : 정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메소드
	 * 매개변수 : 배열 => int arr[]
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printArray
	 */
	
	// 배열 전체 출력
	public static void printArray(int arr[]) {
		//int i;// 밖에서 숫자 100을 알려줘도 메소드 안에 들어가면 0으로 초기화됨. 알려줄 필요없음. 지역변수화.
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + (i == arr.length -1 ? "":", "));				
		}
		System.out.println("]");
		
	}
	
	/** 배열 일부, <start번지부터 end-1번지까지> 출력 (메소드 오버로딩함) */
	public static void printArray(int arr[], int start, int end) {
		//int i;// 밖에서 숫자 100을 알려줘도 메소드 안에 들어가면 0으로 초기화됨. 알려줄 필요없음. 지역변수화.
		System.out.print("[");
		for(int i = start; i < end; i++) {
			if(i >= arr.length) {
				break; // 접근할 수 없는 번지에 접근하면 break; 빠져나감
			}
			System.out.print(arr[i] + (i == end -1 ? "":", "));				
		}
		System.out.println("]");
		
	}
	
	/** 기능 : 정수 num이 배열의 0번지부터 count개만큼 확인했을 때 중복된 값이 있는지 없는지(boolean) 알려주는 메소드
	 * 매개변수 : 중복을 확인할 배열(기준), 비교할 정수 num, 비교할 개수 count
	 * 			=> int arr[]. int num, int count
	 * 리턴타입 있는지 없는지 => boolean
	 * 메소드명 : contains
	 */
	
	// num가 배열의 원소 중에서 0번지부터 count개 안에 있는지 확인하는 메소드
	public static boolean contains(int arr[], int num, int count) {
		for(int i = 0; i < count; i++) {
			// 중복되면 메소드를 종료하면서 중복됐다고 알려줌
			if(num == arr[i]) {
				return true;
			}
		}
		// 이 위치까지 왔다는건 return true(중복되는 값을 만났다?) 를 못만났다는 뜻이고
		// 그 말은 중복되지 않았다는 뜻
		return false; // 반복문도 다 나왔는데 왜 return false;를 써야하지? 
	}
	
	/** 기능 : min에서 max사이의 랜덤한 수를 생성하여 배열에 저장하는 메소드
	 * 매개변수 : 최소값, 최대값, 배열 => int min, int max, int arr[]
	 * 리턴타입 : 없음(저장만) => void
	 * 메소드명 : createRandomArray
	 */
	
	public static int[] createRandomArray(int min, int max, int arr[]) {
		// max가 min보다 작으면, 두 수를 교환! 
		if(max < min) { // 9 < 1
			int tmp = max;
			max = min; 
			min = max; // 두 수를 바꿔줌(얕은 복사?)
		}

		// 배열이 생성되어 있지 않으면(배열이 null이면) 메소드 종료
		if(arr == null) {
			arr = new int[max - min + 1]; // *(수정)[max - min + 1]개 짜리 배열을 새로 생성한다
										  // 1부터 9까지 랜덤으로 섞음
		}	
		
		// 랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메소드를 종료
		// min 1 ~ max 3 : 중복되지 않게 최대 3개 가능 / 4개 불가능, 어떤 수라도 중복됨(=> 무한루프빠짐)
		//				 : 랜덤한 수 3개가 4개짜리 배열에 중복되지 않게 들어갈 수 없음
		if(max - min + 1 < arr.length) {
			return null; // * (수정)배열의 값을 저장 안하고 종료한다.
		}
			
		
		int count = 0;
		while(count < arr.length) {
			int random = (int)(Math.random()*(max - min + 1) + min);
			// 중복되지 않으면, 배열에 저장한 후 count 증가
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
			
		}
		return arr; // 배열이 null이어도 임의로 배열을 만들어 주겠다. 
	}
	
	/** 기능 : 주어진 배열에 중복된 값이 있는지 없는지 알려주는 메소드 
	 * 매개변수 : 배열 => int arr[]
	 * 리턴타입 : 중복여부 => 있는지 없는지 => boolean
	 * 메소드명 : arrayCheck
	 */
	public static boolean arrayCheck(int arr[]) {
		if(arr == null) {// 배열이 안만들어져 있으면
			return false;			
		}
		
		// arr 배열의 다른 번지들끼리 비교해서 같은 값이 있는지 확인하는 반복문
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) { //볼판정 이랑 같음
				// 같은 번지면 건너뜀
				if(i == j) {
					continue;
				}
				// 다른 번지고 값이 같으면 중복됐다고 리턴
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		// 반복문이 끝날때까지 중복(return true)이 안되면 중복이 안됐다고 리턴 
		return false;
	}
}
