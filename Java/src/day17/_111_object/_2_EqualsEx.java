package day17._111_object;

import java.util.Objects;
import lombok.Data;

// 2. equals�� �������̵� �ϸ� �ڵ尡 ����������.

public class _2_EqualsEx {

	public static void main(String[] args) {
		//1. 
		Customer list[] = {
				new Customer("ȫ", "010-1234-5678"),
				new Customer("��", "010-1111-5678"),
				new Customer("��", "010-5555-5678")
		}; // �迭 �ʱ�ȭ
		
		Customer customer = new Customer("ȫ", "010-1234-5678");
		
		// 1. equals()�� �������̵� �ȵ��� �� ���� ��ܿ� �ִ��� ��ȸ�ϴ� �ڵ�
		
		/*
		//��ü Ž�� = ���� for��
		for(Customer tmp : list) {
			if(tmp.getPhoneNumber().equals(customer.getPhoneNumber())) {
				System.out.println("��ܿ� �ֽ��ϴ�. OK");
				return;
			}
		}
		System.out.println("��ܿ� �����ϴ�. FAIL");
		*/
		
		// 2. equals()�� �������̵� ���� �� ���� ��ܿ� �ִ��� ��ȸ
		for(Customer tmp : list) {
			if(tmp.equals(customer)) { // phoneNumber�� ���ϴ°� �ƴ϶� <tmp�� customer�� ��>
				System.out.println("��ܿ� �ֽ��ϴ�. OK");
				return;
			}
		}
		System.out.println("��ܿ� �����ϴ�. FAIL");
		
		// ����� ����. �ڵ尡 ��������. 
	}

}

@Data // getter, setter �ʿ�
class Customer {
	// �������
	private String id;
	private String name;
	private String phoneNumber;
	
	// ������ 
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		// ��ȣ�� ������ ���� ���̶�� �Ǻ�
	}

	@Override // 2. equals �� �������̵� ��!! 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(phoneNumber, other.phoneNumber);
	}


}