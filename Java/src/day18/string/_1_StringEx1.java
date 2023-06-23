package day18.string;

// String은 많이 쓰이지만, 외울필요는 없고 필요할때마다 찾아서 쓰면 됨.

public class _1_StringEx1 {

	public static void main(String[] args) {
		/* 문자열 관련 메소드 */
		// 1. indexOf : 기준 문자열에서 검색 문자||문자열을 (왼쪽부터 검색해서) '처음'으로 만나는 위치를 반환
		// 1.2 lastIndexOf : "" (오른쪽부터 검색해서) 처음으로 만나는 위치를 반환
		String str = "Hello world";
		
		// 여러 방식으로 오버로딩되있음
		// str에서 7번지부터 wo가 있는지 확인. orld에서 wo가 있는지 확인 => 없음 => -1
		int index = str.indexOf("wo", 7);// 5번지부터 시작하여 wo 찾기
		System.out.println(str + "에서 7번지부터 " + "wo" + "가 있나요? " + index); // 없음 => -1
		
		index = str.indexOf("wo");
		System.out.println(str + "에서 0번지부터 " + "wo" + "가 있나요? " + index); // 6번지에 있음
		
		index = str.indexOf("o");
		System.out.println(str + "에서 0번지부터 " + "o" + "가 있나요? " + index); // 처음 만나는 4번지만 출력
		
		// 2. 비슷한 기능 contains : 기준 문자열에서 검색 문자||문자열이 있는지 없는지 알려줌 => T/F
		boolean result = str.contains("o");
		System.out.println(str + "에서 0번지부터 " + "wo" + "가 있나요? " + result); // 처음 만나는 4번지만 출력

		// 3. 문자열.length : 값이 들어있는 크기를 알려줌
		System.out.println(str + "의 길이는? " + str.length());
		
		// 4. replace : 특정 문자||문자열을 바꿀 떄 사용. 
		// 	  replaceAll : '정규표현식 - 문자열에 특정 패턴이 있는지 없는지 
		// 				ex)ID, e-mail'에 맞는 모든 문자||문자열을 수정
		String str2 = str.replace(" ", ",");
		System.out.println(str2);
		
		// 5. substring : 부분문자열 추출
		String str3 = str.substring(6); // 6번지부터 끝까지
		System.out.println(str + "에서 6번지부터 가져온 부분 문자열 : " + str3);
		
		// 1.2 lastIndexOf : "" (오른쪽부터 검색해서) 처음으로 만나는 위치를 반환
		index = str.lastIndexOf("o", 7);// 5번지부터 시작하여 o 찾기
		System.out.println(str + "에서 0번지부터 " + "o" + "가 오른쪽에서부터 몇번지에 있나요? " + index);
		
		// 6. toLowerCase : 소문자로
		System.out.println(str + " : 소문자 : " + str.toLowerCase());
		// 6. toUpperCase : 대문자로
		System.out.println(str + " : 소문자 : " + str.toUpperCase());
		
		System.out.println("\n\t\t-------------------");
		String str4 = "\n\t\tabc\t\tdef\t\n";
		
		// 7. .trim() : 시작앞(a) 전 공백/마지막뒤(f) 후 공백을 지워줌(사이에 있는 공백은 처리 못함)
		System.out.println(str4.trim());
		System.out.println(str4.replace(" ",""));
		
		// 8. split : 구분자를 기준으로 문자열을 추출해서 순서대로 배열에 저장
		String str5 = "사과,배,포도";
		String fruits[] = str5.split(","); // 콤마를 기준으로 앞뒤 문자 추출, 순서대로 배열에 저장
		for(String fruit : fruits) {
			System.out.println(fruit);
		}
		
	}

}
