package review_0805;

public class _nado_Quiz_03 {

	public static void main(String[] args) {
		/* 3. 주민등록번호에서 생년월일 및 성별까지만 출력하는 프로그램을 작성하시오
		 * (실행결과)
		 * "901231-1234567"인 경우 901231-1 까지 출력
		 * "030708-4567890"인 경우 030708-4 까지 출력
		 */
		String id = "901231-1234567";
		
		System.out.print(id.substring(0, 8));
		for(int i = 0; i < id.length() - 8;i++) {
			System.out.print("*");	
		}
		System.out.println();
		
		id = "030708-4567890";

		System.out.print(id.substring(0, 8));
		for(int i = 0; i < id.length() - 8;i++) {
			System.out.print("*");	
		}
		System.out.println();
		
		id = "940418-2465710";
		System.out.println(id.substring(0, id.indexOf("-")+2));
	}

}
