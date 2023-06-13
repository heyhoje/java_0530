package day10_062_singleTon;

public class _1_singleTonEx {

	public static void main(String[] args) {
		// SamsungCompany company; = new SamsungCompany();
		SamsungCompany company1 = SamsungCompany.getInstance();
		SamsungCompany company2 = SamsungCompany.getInstance();
		System.out.println(company1);
		System.out.println(company2); // ���������� ��Ű���̸�.Ŭ�����̸�.�ش� ��������(�� ����Ǿ��ִ�)�� �ּҰ�
		// �����ּҳ���. �ϳ��� ��ü�� �����ϰ� �ִ�. 
	}

}

class SamsungCompany {
	
	private static SamsungCompany company = new SamsungCompany(); // static Ŭ����
	
	private String name;
	private String address;
	
	private SamsungCompany() {
		name = "Samsung";
		address = "korea";
		
	}
	public static SamsungCompany getInstance() {
		return company; // �ܺο��� �ش� ��ü?Ŭ����?�� ����� �� �ְ� ����
	}
}
