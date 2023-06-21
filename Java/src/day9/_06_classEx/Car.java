package day9._06_classEx;

public class Car {
	// 멤버 변수(필드)
	 private String name;		// 차명
	 private String company;  // 제조사
	 private int year; 		// 연식
	 
	 private int speed;		// 속력
	 private char gear;		// P:주차, R:후진, D:주행, N:중립
	 private boolean power;		// 전원
	 
	// (멤버변수 초기화하는)생성자
	 public Car(String _name, String _company, int _year) {
		name = _name;
		company = _company;
		year = _year;
		gear = 'p';
	 
		// power = false;
		// speed = 0; 기본값으로 초기화 되있음
		
		//멤버변수 파랑, 매개변수 갈색
		//클래스 = 멤버변수 + 메소드
	 }
	// 메소드 (기능추가)
		/** 자동차 정보를 출력하는 메소드
		 * 매개변수 : 없음 (내 정보를 갖다 쓸 때)
		 // 멤버변수가 이미 알고있어서, 알려줄 필요 없음...(이름, 제조사, 연식, 속력, 기어상태, 전원상태 => String, int, char, boolean)
		 * 리턴타입 : 없음? => void
		 * 메서드명 : printInfo
		 */
		//콘솔에 입력되는 변수는 리턴타입이 없다고 보면 된다. 
		
		//public 리턴타입 메소드명(매개변수)
	public void printInfo() {
		System.out.println("자동차 조회");
		System.out.println("제조사 : " + company);
		System.out.println("모델 : " + name);
		System.out.println("연식 : " + year);
		System.out.println("전원 : " + (power?"On":"Off"));
		System.out.println("기어 : " + gear);
		System.out.println("속력 : " + speed);
		System.out.println("---------");
		}
		/** 속력이 <1 증가 또는 1 감소>하는 메소드
		 * 매개변수 : 증가할건지(참) 아니면 감소시켜(거짓) => boolean positive
		 * 리턴타입 : 없음 (int내 정보니까 알려줄 필요 없음)
		 * 메소드명 : speedChange
		 */
		
	public void speedChange(boolean positive) {
			
		// 전원이 꺼져있으면 종료
		if (!power) {
			return;
		}
		// 기어가 중립 또는 주차중이면 종료
		if (gear == 'N'||gear == 'P') {
			return;
		}
		// 속력이 증가하는 경우이면, 속력을 증가하면
		if (positive) {
			speed += 1;
			// 위에가 아니면, (증가하는게 아니고) 감소하는 경우이고 속력이 0보다 크면 
		}else if(speed > 0){
			speed -=1;
		}
	}	
	/** 자동차 시동을 켜거나 끄는 메소드
	 * 매개변수 : 또 없음.. (power를 켜거나 power를 끄거나)
	 * 리턴타입 : 없음
	 * 메소드명 : powerOn
	 */
	public void turn() {
		if(!power) {
			power = true;
		}else if(gear == 'P') {
			power = false;
		}
	}
	
	public void setGear(char gear) {
		this.gear = gear;
	}
	
	 
	 
	 
}
