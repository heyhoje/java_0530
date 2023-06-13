package day10_062_singleTon;

public class _1_singleTonEx {

	public static void main(String[] args) {
		// SamsungCompany company; = new SamsungCompany();
		SamsungCompany company1 = SamsungCompany.getInstance();
		SamsungCompany company2 = SamsungCompany.getInstance();
		System.out.println(company1);
		System.out.println(company2); // 참조변수의 패키지이름.클래스이름.해당 참조변수(와 연결되어있는)의 주소값
		// 같은주소나옴. 하나의 객체를 공유하고 있다. 
	}

}

class SamsungCompany {
	
	private static SamsungCompany company = new SamsungCompany(); // static 클래스
	
	private String name;
	private String address;
	
	private SamsungCompany() {
		name = "Samsung";
		address = "korea";
		
	}
	public static SamsungCompany getInstance() {
		return company; // 외부에서 해당 객체?클래스?를 사용할 수 있게 해줌
	}
}
