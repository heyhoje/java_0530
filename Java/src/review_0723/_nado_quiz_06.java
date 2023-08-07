package review_0723;

public class _nado_quiz_06 {

	public static void main(String[] args) {
		// 주어진 코드의 getHiddenData(...) 메소드를 완성하시오
		String name = "나코딩"; // 0 1 2
		String id = "990130-1234567"; // 0 1 2 ... 13  
		String phone = "010-1234-5678"; // 0 1 2 ... 12
		
		System.out.println("이름 : " + getHiddenData(name, 1));// 개인정보, 비공개 시작
		System.out.println("주민번호 : " + getHiddenData(id, 8));
		System.out.println("전화번호 : " + getHiddenData(phone, 9));

	}
	
	/** 기능 : 몇번째 인덱스 부터 잘라낼지 
	 * 매개변수 : 멤버변수, 인덱스번호
	 * 리턴타입 : *처리로 보호된 개인정보 => String
	 * 메소드 : getHiddenData
	 */
	private static String getHiddenData(String data, int index) {
		String hiddenData = data.substring(0, index); // 나코딩 -> 나**

		for(int i = 0; i < data.length() - index; i++) {
			hiddenData += "*";
		}
		
		return hiddenData;
	}
	
//	String hiddenData = data + "*" * (index+1);
//	 for(int i = 0; i < data.length() - index; i++)

}
