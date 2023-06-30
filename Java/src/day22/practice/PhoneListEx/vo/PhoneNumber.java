package day22.practice.PhoneListEx.vo;

import java.util.Objects;
import java.util.regex.Pattern;

import lombok.Data;

// �� ����� ��ȭ��ȣ ����
@Data
public class PhoneNumber {
	private String name;
	private String number; // 010-1234-5678 // ����ǥ��????
	// 01012345678 => 0�� ����� �� ����/ 8��������
	
	public PhoneNumber(String name, String number) {
		this.name = name;
		
		if(checkNumber(number)) { // checkNumber �޼ҵ� �̿��ؼ�, ����ǥ���Ŀ� �´°�쿡�� ��ȭ��ȣ �Է�
			this.number = number;
		}else {
			this.number = ""; //���ǰ� ���� �ʴ� ���, ���ڿ�
		}
		// this.number = checkNumber(number? number : ""; // �̷��� ���ٷ� ǥ���� ���� ����! 
	}
	// �޼ҵ�0 : ��ȭ��ȣ�� 010-xxxx-xxxx ������ �´��� Ȯ�����ִ� �޼ҵ� (�Ϲ�����ȭx) - ����ǥ����
	// �ܺο����� ��ü �������� �� �� �ְ�, static�� public�� �ٿ���
	public static boolean checkNumber(String num) {
		String regex = "^010(-\\d{4}){2}$"; // regex101 ����Ʈ���� ����ǥ���� ����
		return Pattern.matches(regex, num); // ���ڿ��� ���ؼ� ����ǥ������ �´��� Ȯ��
	}
	
	public void setNumber(String number) {
		this.number = checkNumber(number) ? number : this.number; 
		// ������ �� �ڵ尡 �ڵ����� ����������,
		// 
		
	}
	
	// �̸����� �˻�
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneNumber other = (PhoneNumber) obj;
		return Objects.equals(name, other.name);
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(name);
		 // hastSet, HashMap �� ����Ҷ��� �ʿ�. �ٵ� �츮�� list 
	
	
}
