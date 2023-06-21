package day10._062_singleTon;

public class _1_singleTonEx {
	// �� �ϳ��� �ν��Ͻ��� �ʿ��� ���. 
	// static�� �����Ͽ� ���α׷� ���ݿ��� ����ϴ� �ν��Ͻ��� �ϳ��� �����ϴ� ���
	// ex) ������ �������̰�����, ȸ�� ��ü�� �ϳ�!
	//	   �̱��� �������� Company Ŭ���� �����
	
	public static void main(String[] args) {
		//SamsungCompany company; = new SamsungCompany();
		
		// 4. ������ ����ϴ� �ڵ� �����
		SamsungCompany company1 = SamsungCompany.getInstance();
		SamsungCompany company2 = SamsungCompany.getInstance();
		// �ܺ� Ŭ���������� Company�� ������ �� �����Ƿ� static���� �����Ǵ� getInstance() �޼ҵ带 ȣ��
		// Ŭ���� �̸����� getInstance() ȣ���Ͽ� '���� ����'�� ����
		// Company.getInstance(); �� ���� ȣ���ϸ� ��ȯ������ ������ �ν��Ͻ��� �޾ƿ�

		// ������ �ν��Ͻ��� ������ �� ������ �ּҰ��� ������ Ȯ��~
		
		System.out.println(company1);
		System.out.println(company2); // ���������� ��Ű���̸�.Ŭ�����̸�.�ش� ��������(�� ����Ǿ��ִ�)�� �ּҰ�
		// ���� �ּ� ����. '�ϳ��� ��ü(�̱���)'�� �����ϰ� �ִ�. 
	}

}

class SamsungCompany {
	// 2. �����ϰ� ������ �ν��Ͻ� / �Ű����� �ڸ�
	private static SamsungCompany company = new SamsungCompany(); // static Ŭ����
	
	private String name;
	private String address;
	
	// 1. private ������ �����
	private SamsungCompany() {
		name = "Samsung";
		address = "korea";
	}
	// 3. �ܺο��� ������ �� �ִ� public �޼ҵ� ����� 
	public static SamsungCompany getInstance() {
		// �ν��Ͻ��� �ܺο��� ������ �� �ֵ��� public get() �޼ҵ� ����
		// �̶� �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�� �ݵ�� static���� �����ؾ���
		// getInstance() �޼ҵ�� �ν��Ͻ� ������ ������� ȣ���� �� �־�� �ϱ� ����
		
		return company; // �ش� �ν��Ͻ� ��ȯ 
		// �ܺο��� �ش� ��ü(private���� ������ ������ �ν��Ͻ�)�� ����� �� �ְ� ����
	}
}
