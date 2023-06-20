package day15._084_Polymorphism;

public class _2_InstancePorlymrphism {
	// 포함 다형성, 객체 다형성 설명

	public static void main(String[] args) {
		/* TV 1대, 에어컨 2대, 라디오 3대를 객체로 생성한 후
		 * 전원을 켜는 기능을 실행해보세요*/
		
		RemoteControl remocon = new RemoteControl(); // 주석 포함 계속 쓰일 리모콘
		
		// 방법1
//		TV tv = new TV();
//		AirConditioner aircon1 = new AirConditioner();
//		AirConditioner aircon2 = new AirConditioner();
//		Radio radio1 = new Radio();
//		Radio radio2 = new Radio();
//		Radio radio3 = new Radio();
//		
//		remocon.turnOn(tv);
//		remocon.turnOn(aircon1);
//		remocon.turnOn(aircon2);
//		remocon.turnOn(radio1);
//		remocon.turnOn(radio2);
//		remocon.turnOn(radio3);
		
//		HomeAppliances homeAppliance = new HomeAppliances();
//		RemoteControl remocon = new RemoteControl();
		
		// 방법2
		// 다형성 아님, 배열을 이용한 것 
//		TV tv = new TV();
//		AirConditioner aircons[] = new AirConditioner[2];
//		Radio radios[] = new Radio[3];
//		
//		
//		for(int i = 0; i < aircons.length; i++) {
//			aircons[i] = new AirConditioner();
//			
//		for(int i = 0; i < radions.length; i++) {
//			radios[i] = new Radio();
//		}
//		
//		remocon.turnOn(tv); // remocon을 이용하는 것은 '매개변수의 다형성'
//		// 향상된 for문
//		for(AirConditioner aircon : aircons) { 
//			remocon.turnOn(aircon); //'매개변수의 다형성'
//		}
//		for(Radio radio : radios) {
//			remocon.turnOn(radio); //'매개변수의 다형성'
//		}
		
		// 방법3
		// 포함 다형성 예제, 객체 다형성 예제
		int tvCount = 1, airconCount = 2, radioCount = 3;
		int total = tvCount + airconCount + radioCount;
		HomeAppliances homeAppliances[] = new HomeAppliances[6];
		
		int count = 0; // 현재 만들어진 제품 대수
		int i = 0;
		// tv 1대 생성
		for(i = 0; i < tvCount; i++) {
			homeAppliances[count++] = new TV(); // 업캐스팅
			// 왼 - 가전제품 관리 / 오 - tv 만들어줌
		}
		// aircon 2대 생성
		for(i = 0; i < airconCount; i++) {
			homeAppliances[count++] = new AirConditioner(); // 업캐스팅
		}
		// radio 3대 생성
		for(i = 0; i < radioCount; i++) {
			homeAppliances[count++] = new Radio(); // 업캐스팅
		}
		// 모든 제품의 전원을 켬 
		for(HomeAppliances homeAppliance : homeAppliances) { 
			remocon.turnOn(homeAppliance);
			// 배열 하나만 관리
		}
		
		System.out.println("----라디오만-----");
		// 전체 제품 중 라디오의 전원을 끔
		for(HomeAppliances homeAppliance : homeAppliances) { 
			// homeAppliance 객체가 Radio 클래스의 인스턴스 변수인가?
			// HomeAppliance 클래스만큼 쓰던 것 >> Radio 클래스 만큼으로 변환 가능한가?
			// [라디오로 다운캐스팅이 가능한 객체만 끔]
			if(homeAppliance instanceof Radio) {
				remocon.turnOn(homeAppliance); // 다운캐스팅이 아님!!!(부모클래스를 호출했기 때문)
				//System.out.println(homeAppliance.frequncy); // 부모클래스에 있는 기능이 아님
				Radio radio = (Radio)homeAppliance; //  다운캐스팅!!!(home >> Radio로 형변환)
				System.out.println(radio.frequency);
				
				
			}
		}
		// System.out.println(radio.frequency); // radio에는 주파수 기능이 있는데 왜 이렇게는 바로 출력이 안되지???

	}
	// 상속 개념도 중요하지만, 다형성 개념이 진짜 중요합니다. 
	// 매개변수의 다형성, 객체 다형성을 통해 

}

class HomeAppliances{
	boolean power;
	void turnOn() {
		power = true;
	}
	void turnOff(){
		power = false;
	}
}
class RemoteControl {
	public void turnOn(HomeAppliances appliance) {
		appliance.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	
	public void turnOff(HomeAppliances appliance) {
		appliance.turnOff();
		System.out.println("전원이 꺼졌습니다.");
	}
}

class TV extends HomeAppliances {
	int channel;
	}

class AirConditioner extends HomeAppliances {
	double currentTemperature;
	double desiredTemperature;
}

class Radio extends HomeAppliances {
	double frequency;
	}


