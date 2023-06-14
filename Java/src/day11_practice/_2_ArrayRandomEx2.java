package day11_practice;

// 두별 선생님.. 중복되지 않게 뽑아내는거 이해가 안되요..!
// 두별 선생님.. 강사님이 고쳐준거에서 바로 메소드만 추가했는데 또 오류났어요......
// >> 2. 매개변수에서 int size 빼고, 매소드 내에서 size -> arr.length 로 바꿔야했음

public class _2_ArrayRandomEx2 {

	public static void main(String[] args) {
		// 2. 1. 1~9 사이의 랜덤한 수 3개를 '중복되지 않게' 만들어서 배열에 저장한 후 출력하는 코드를 작성하세요.
	
		int min = 1, max = 9; 
		int [] arr = new int[3];
		
		// 방법1 : 9번지까지 있는 배열을 이용
		// 배열만 체크하면 되기 때문에 작업이 단순.
		// but, 저장 공간이 필요. 10,000개라면 10,000개의 공간 필요
		boolean checkArr[] = new boolean[10]; // 기본값은 false
		
		int i;
		for (i = 0; i < 3;) {
			int random = (int)(Math.random()*(max - min +1) + min);
			// checkArr 배열에 random 번지에 있는 값이 false이면
			//System.out.println(arr[i]);
			if(!checkArr[random]) { //  == false / 멋이 없다니,,, 허허
				// random을 배열에 저장
				arr[i] = random;
				// i를 증가
				i++;
				// checkArr배열에 random번지에 있는 값을 true로 변경
				checkArr[random] = true;
			}
	
		}
		for(i = 0; i < 3; i++) {
			System.out.println(arr[i]);
		}
	
		System.out.println("--------------");
		// 방법2 : 저장된 값들을 비교(이중 반복문 필요)
		int count = 0; // 현재 저장된 랜덤수 개수
		i = 0; // 반복문에서 사용할 변수
		
		while(count < 3) {
			int random = (int)(Math.random()*(max - min +1) + min);
			// 이미 저장된 랜덤수들과 하나하나 비교해서 같은게 있는지 확인하여
			// 같은게 있으면 반복문 종료
			for (i = 0; i < count; i++) {
				if(random == arr[i]) {
					break;
				}
			}
			/* 위 반복문에서 break를 만나지 않으면 i는 count일때 종료하기 때문에
			 * 반복문 종료 후 i는 count와 같다
			 * 하지만 break를 만나서 중간에 빠져나오면 i는 count보다 작다		 
			 */
			if(i == count) {
				arr[count] = random;
				count++;
			}
		}
		printArray(arr);
	

	// 방법3 : 방법2를 메소드로 변형
	count = 0;
	while(count < 3) {
		int random = (int)(Math.random()*(max - min +1) + min);
		// 중복되지 않으면 배열에 저장 후 count 증가
		if(!contains(arr, random, count)) {
			arr[count] = random;
			count++;
		}
	}
}

	
	
	/** 정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메소드
	 * 매개변수 : 배열과 배열의 개수(3, arr[]) => int arr[], int size -> arr.length
	 * 리턴타입 : (출력) 없음=> void
	 * 매소드명 : printArray
	 */
	
	public static void printArray(int arr[]) {
		int i; // 밖에서 숫자 100을 알려줘도 메소드 안에 들어가면 0으로 초기화됨. 알려줄 필요없음. 지역변수화.
		for(i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/** 정수 num가 배열의 0번지부터 count개만큼 확인했을 때 중복된 값이 있는지 
	 * 	없는지 알려주는(return) 메소드
	 * 매개변수 : 중복을 확인할 배열(기준), 정수num(비교), count(비교할 갯수) 
	 * 			=>  int arr[], int num, int count
	 * 리턴타입 : 있는지 없는지 => boolean 
	 * 메소드명 : contains
	 */
	
	public static boolean contains(int arr[], int num, int count) {
		// ㄴ메인 메소드에 static이 있어서 + 또 왜...? 
			
			for (int i = 0; i < count; i++) {
				// 중복되면 break 말고, 메소드를 종료하면서 중복됐다고 알려줌
				if(num == arr[i]) {
					return true;
					//break;
				}
			}
			// 이 위치까지 왔다는건 return true를 못 만났다는 뜻이고,
			// 그 말은 중복되지 않았다는 뜻
			return false;
	}
	/** min에서 max사이의 랜덤한 수를 생성해서 배열에 저장하는 메소드
	 * 매개변수 : 최소값, 최대값, 배열 => int min, int, max, int arr[]
	 * 리턴타입 : 없음 => void
	 * 메소드명 : createRandomArray
	 */
	
	public static void createRandomArray(int min, int max, int arr[]) {
		// 배열이 생성되어 있지 않으면(배열이 만들어있지 않으면, null이면)
		if(arr == null) {
			return;
		}
		// 랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면, 메소드를 종료
		// min 1 ~ max 3 : 중복되지 않게 최대 3개 가능 / 4개 불가능, 어떤 수라도 중복됨(=> 무한루프빠짐)
		// 				 : 3개가 4개짜리 배열에 들어갈 수 없음
		
		if(max - min +1 < arr.length) {
			return; // 배열의 값을 저장 안하고 종료한다.
		} 
		int count = 0;
		while(count < 3) {
			int random = (int)(Math.random()*(max - min +1) + min);
			// 중복되지 않으면 배열에 저장 후 count 증가
			if(!contains(arr, random, count)) {
				arr[count] = random;
				count++;
			}
		}
		
	}
}
	

	
	


//		if(arr[0] != arr[1] || arr[0] != arr[2] || arr[1] != arr[2])