package review_0805;

public class _nado_Quiz_06 {

	public static void main(String[] args) {
		String name = "나코딩"; // 이름
		String id = "990130-1234567"; // 주민등록번호
		String phone = "010-1234-5678"; // 전화번호
		
		System.out.println("이름 : " + getHiddenData(name, 1)); // 개인정보, 비공개 시작 위치
		System.out.println("주민등록번호 : " + getHiddenData(id, 8) );
		System.out.println("전화번호 : " + getHiddenData(phone, 9));
	}
	
	/** 기능 : 인덱스번지부터 *로 개인정보를 가리는 메소드
	 * 매개변수 : String data, int index
	 * 리턴타입 : *처리된 개인정보 => String
	 * 메소드명 : getHiddenData
	*/
	public static String getHiddenData(String data, int index) {
			String hiddenData = "";
			for(int i = 0; i < data.length() - index; i++) {
				hiddenData = data.substring(0, index);
				System.out.print("*");
//			 System.out.print("*");
//			 이렇게 하니까 *표가 앞으로 가버림.. 왜그럴까요?
		}
		return hiddenData;
		
	}

}
