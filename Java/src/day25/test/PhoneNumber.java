package day25.test;

public class PhoneNumber {
	private String name, number;
		
	public PhoneNumber() {}; // �⺻������ ����
	public PhoneNumber(String name, String number) {
		this.name = name;
		this.number = number;
	}

		
		//toString �޼ҵ�� ObjectŬ�������Լ� ����� ����
		/*
		 * public String soString(){
		 * 		return xxx;
		 * }
		 * */
	@Override
	// �������̵� �Ϸ��� �޼ҵ� ����ΰ� ���ƾ���. �׷��� �Ű������� �ٸ�
	// 1. @Override ������̼��� ���� => �޼ҵ� �����ε��� �Ǳ� ����(�̸�o, �Ű�����x)
	// 2. �������̵带 �ϱ� ���� �Ű������� ����
	public String toString() {
		return "�̸� : " + name + ",��ȣ : " + number;
	}

}

// Object 


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		String(String str) {
			str = "�̸� : " + name + ",��ȣ : " + number;
			return str;
		}
}
