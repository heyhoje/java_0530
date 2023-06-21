package day10._062_singleTon;

public class _1_singleTonEx {
	// 단 하나의 인스턴스만 필요한 경우. 
	// static을 응용하여 프로그램 전반에서 사용하는 인스턴스를 하나만 구현하는 방식
	// ex) 직원은 여러명이겠지만, 회사 객체는 하나!
	//	   싱글톤 패턴으로 Company 클래스 만들기
	
	public static void main(String[] args) {
		//SamsungCompany company; = new SamsungCompany();
		
		// 4. 실제로 사용하는 코드 만들기
		SamsungCompany company1 = SamsungCompany.getInstance();
		SamsungCompany company2 = SamsungCompany.getInstance();
		// 외부 클래스에서는 Company를 생성할 수 없으므로 static으로 제공되는 getInstance() 메소드를 호출
		// 클래스 이름으로 getInstance() 호출하여 '참조 변수'에 대입
		// Company.getInstance(); 와 같이 호출하면 반환값으로 유일한 인스턴스를 받아옴

		// 유일한 인스턴스를 대입한 두 변수의 주소값이 같은지 확인~
		
		System.out.println(company1);
		System.out.println(company2); // 참조변수의 패키지이름.클래스이름.해당 참조변수(와 연결되어있는)의 주소값
		// 같은 주소 나옴. '하나의 객체(싱글톤)'를 공유하고 있다. 
	}

}

class SamsungCompany {
	// 2. 유일하게 생성한 인스턴스 / 매개변수 자리
	private static SamsungCompany company = new SamsungCompany(); // static 클래스
	
	private String name;
	private String address;
	
	// 1. private 생성자 만들기
	private SamsungCompany() {
		name = "Samsung";
		address = "korea";
	}
	// 3. 외부에서 참조할 수 있는 public 메소드 만들기 
	public static SamsungCompany getInstance() {
		// 인스턴스를 외부에서 참조할 수 있도록 public get() 메소드 구현
		// 이때 인스턴스를 반환하는 메소드는 반드시 static으로 선언해야함
		// getInstance() 메소드는 인스턴스 생성과 상관없이 호출할 수 있어야 하기 때문
		
		return company; // 해당 인스턴스 반환 
		// 외부에서 해당 객체(private으로 선언한 유일한 인스턴스)를 사용할 수 있게 해줌
	}
}
