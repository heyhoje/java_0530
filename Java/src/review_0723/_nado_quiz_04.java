package review_0723;

public class _nado_quiz_04 {

	public static void main(String[] args) {
		// 조건문을 활용하여 <주차 요금 정산> 프로그램을 작성하시오
		int hour = 10;
		
		boolean isSmallCar = false;
		boolean withDisabledPerson = true;
		
		int fee = 4000 * hour;
		
		if(fee > 30000) {
			fee = 30000;
		}
		if(isSmallCar == true || withDisabledPerson == true) {
			fee /= 2;
		}
		
		// 실행 결과 출력
		System.out.println("주차요금은 " + fee + "원 입니다.");	
	}
}
