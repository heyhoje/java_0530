package day18.practice;

public class _1_StringIndexOfEx {

	public static void main(String[] args) {
		// 1. Hello world 에서 l이 몇개 있는지 확인하는 코드를 작성하세요.
		// int index = str.indexOf("wo", 7);// 5번지부터 시작하여 wo 찾기 활용
		
		String str = "Hello world!";
		int count = 0; // 몇 개인지 저장할 변수
		String search = "l"; // 찾을 단어 변수설정
		int index = -1;
		
		// 적어도 1번 이상 반복됨.
		// 반복 : 찾으면 반복 / 못찾으면 종료
		do {
			index = str.indexOf(search, ++index);
			if(index != -1) {
				count++;
			}
		} while(index != -1);
		System.out.println(str + " : " + search + " : " + count);

		//3. 반복
			// 1. Hello world에서 l의 위치를 찾음 => lo world => o world
			// => d에서 l의 위치를 찾음
		
			// 2. 찾았으면 개수를 증가
		// 4. 개수를 출력
	
	}
}
// 시도2
//		for(int j = 0; j < str.length(); j++){
//			index = str.indexOf("l", j);
//			count++;
//			}
//			System.out.println(count);

// 시도1
// boolean result = str.contains("l");

//		for(int i = 0; i < str.length(); i++) {
//				if(result = str.contains("l")) {
//					count++;
//				}
//		}
//		System.out.println(count); // 문자열 길이(11)만큼 반복해서 11이 나왔다는거 같은데... 
//								   //3이 어떻게 나오게 하지...
//		