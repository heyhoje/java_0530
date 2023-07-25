package review_0723;

public class _nado_quiz_03 {

	public static void main(String[] args) {
		// 주민등록번호에서 <생년월일 및 성별>까지만 출력하는 프로그램을 작성하시오
		String id = "030708-4567890";
		System.out.println(id.substring(0, 8));// 시작 인덱스부터 끝 인덱스 직전까지
		id = "901231-1234567";
		System.out.println(id.substring(0, id.indexOf("-")+2));// indexOf 위치를 찾기
	}
}
