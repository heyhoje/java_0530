package day25.test;

public class PhoneNumber {
	private String name, number;
		
	public PhoneNumber() {}; // 기본생성자 생성
	public PhoneNumber(String name, String number) {
		this.name = name;
		this.number = number;
	}

		
		//toString 메소드는 Object클래스에게서 상속을 받음
		/*
		 * public String soString(){
		 * 		return xxx;
		 * }
		 * */
	@Override
	// 오버라이드 하려면 메소드 선언부가 같아야함. 그런데 매개변수가 다름
	// 1. @Override 어노테이션을 제거 => 메소드 오버로딩이 되기 때문(이름o, 매개변수x)
	// 2. 오버라이드를 하기 위해 매개변수를 제거
	public String toString() {
		return "이름 : " + name + ",번호 : " + number;
	}

}

// Object 


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String(String str) {
			str = "이름 : " + name + ",번호 : " + number;
			return str;
		}
}
