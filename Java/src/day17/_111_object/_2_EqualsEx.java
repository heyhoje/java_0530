package day17._111_object;

import java.util.Objects;
import lombok.Data;

// 2. equals를 오버라이딩 하면 코드가 간결해진다.

public class _2_EqualsEx {

	public static void main(String[] args) {
		//1. 
		Customer list[] = {
				new Customer("홍", "010-1234-5678"),
				new Customer("임", "010-1111-5678"),
				new Customer("유", "010-5555-5678")
		}; // 배열 초기화
		
		Customer customer = new Customer("홍", "010-1234-5678");
		
		// 1. equals()가 오버라이딩 안됐을 때 고객이 명단에 있는지 조회하는 코드
		
		/*
		//전체 탐색 = 향상된 for문
		for(Customer tmp : list) {
			if(tmp.getPhoneNumber().equals(customer.getPhoneNumber())) {
				System.out.println("명단에 있습니다. OK");
				return;
			}
		}
		System.out.println("명단에 없습니다. FAIL");
		*/
		
		// 2. equals()가 오버라이딩 됐을 떄 고객이 명단에 있는지 조회
		for(Customer tmp : list) {
			if(tmp.equals(customer)) { // phoneNumber와 비교하는게 아니라 <tmp와 customer를 비교>
				System.out.println("명단에 있습니다. OK");
				return;
			}
		}
		System.out.println("명단에 없습니다. FAIL");
		
		// 결과는 같음. 코드가 간결해짐. 
	}

}

@Data // getter, setter 필요
class Customer {
	// 멤버변수
	private String id;
	private String name;
	private String phoneNumber;
	
	// 생성자 
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		// 번호만 같으면 같은 고객이라고 판별
	}

	@Override // 2. equals 가 오버라이딩 됨!! 
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