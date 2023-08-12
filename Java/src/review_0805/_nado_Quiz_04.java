package review_0805;

public class _nado_Quiz_04 {

	public static void main(String[] args) {
		int hour = 10;
		int fee = hour * 4000;
		
		boolean isSmallCar = false;
		boolean withDisabledPerson = true;
		
		if (fee >= 30000) {
			fee = 30000;
		}
		
		if(isSmallCar ||withDisabledPerson) {
			fee = fee / 2;
		}
		System.out.println("주차 요금은 " + fee + "원입니다");
		
	}

}
