package day9._06_classEx;

public class CarMain {

	public static void main(String[] args) {
		/* car				// 자동차
		 * String name;		// 차명
		 * String company;  // 제조사
		 * int year 		// 연식
		 * 
		 * int speed;		// 속력
		 * char gear;		// P:주차, R:후진, D:주행, N:중립
		 * boolean power	// 전원
		 * */
		
		/*현대 뉴 아반떼 2023년식 자동차 객체를 생성하는 코드를 작성하세요
		 * */
		
		//클래스명 객체명 = new 클래스명(매개변수들)
		Car myCar = new Car("뉴 아반떼", "현대", 2023);
		
//		String name = "뉴 아반떼";
//		String company = "현대"; 
//		int year = 2023;
		
		// System.out.println(company + name +" " + year + "년식");
		
		// 현재 내 차 정보 조회
		myCar.turn();
		myCar.setGear('D');
		myCar.printInfo();
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.printInfo();
		myCar.speedChange(true);
		myCar.speedChange(true);
		myCar.speedChange(true);
		myCar.printInfo();
		myCar.speedChange(false);
		myCar.printInfo();
	}

}
