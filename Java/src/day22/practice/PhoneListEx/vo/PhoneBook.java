package day22.practice.PhoneListEx.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneBook {

	// ��ȭ��ȣ ����Ʈ�� ����
	private List<PhoneNumber> list = new ArrayList<>();

	///����߰�
	// ��ȭ��ȣ �߰�
	public boolean insertPhone(String name, String number) {
		// �̸��� ��ȭ��ȣ�� �̿��Ͽ� ��ȭ��ȣ ��ü�� ����
		PhoneNumber pn = new PhoneNumber(name, number);
		// ��ȭ��ȣ�� ��� ������ => ��ȭ��ȣ ���Ͽ� ���� ������ ����x
		if(pn.getNumber().length() == 0) {
			return false;
		}
		// ��ȭ��ȣ�� ���Ͽ� ������ ��ȭ��ȣ�ο� ��ȣ�� �߰�
		list.add(pn); // ���Ͽ� ������ �߰��ϰ� ����
		return true;
	}
	// ��ȭ��ȣ ���� : �̸�
	public boolean updateName(String name, String undateName) {
		// name�� ��ġ�ϴ� ��ȭ��ȣ�� ã�ƾ���
		// index�� contains �Ѵ� ����. but �����ؾ��ϱ⶧���� index�� ����
		
		// ��ȭ��ȣ�ο� ������ �̸��� �ش��ϴ� ��ȭ��ȣ�� ��� �ִ��� Ȯ��
		int index = list.indexOf(new PhoneNumber(name, ""));
			// index�� equals�� �ҷ����°� �ƴ϶� Objects�� ȣ��
			// list�� phoneNumber / undateName�� String ���� �ڷ����� �ٸ�
			// ���� �������ϴµ� �׷��� new PhoneNumber() �ϴµ� �� ���ش� �ȵ�
		
		// ������ ������ �ȵ� => �޼ҵ带 ����
		if(index == -1) {
			return false;
		}
		// ã�� ��ȭ��ȣ�� �̸��� ����
		// ��ȭ��ȣ�ο��� �̸��� ��ġ�ϴ� ��ȭ��ȣ�� ������(����Ʈ���� �ε����� �ִ� ���� ��������)
		PhoneNumber pn = list.get(index); 
		// ������ ��ȭ��ȣ�� �̸��� ���� (������Ʈ �̸��� ���Ѵ�.)
		// ���������� setter�� ���ؼ� ������� ������ ���� �����ϴ�.
		pn.setName(undateName); 
		// => list.get(index).setName(updateName); ���� ���ļ� ������ ����
		
//			// �⺻�ڷ����� = �� �̿��ϸ� '��'�� �����ϱ� ������ ������ ���� �ٲ� �ٸ����� �ȹٲ�
//		int num1 = 1;
//		int num2 = num1;
//		num2 = 10;
//			// ���������� = �� �̿��ϸ� '�ּҰ�'�� �����ϱ� ������ ������ ���� �ٲ�� �ٸ��ʵ� �ٲ�
//			// ���� ��� pn1�� ����� �ּ� 0x1000
//		PhoneNumber pn1 = new PhoneNumber("a", "010-1111-2222");
//			// pn1�� ����� �ּ� : 0x1000, pn2�� ����� �ּҵ� 0x1000
//		PhoneNumber pn2 = pn1;
//			//0x1000������ �ִ� ��ü�� name�� Lim���� ����
//		pn2.setName("Lim);
		return true; // ��ȭ��ȣ�� �ִٸ� �̸��� ���� üũ�� ���ϱ� ������ true
	}
	
	// ��ȭ��ȣ ���� : ��ȣ
	public boolean updateNumber(String name, String number) {
		// name�� ��ġ�ϴ� ��ȭ��ȣ�θ� ã��
		int index = list.indexOf(new PhoneNumber(name, number));
		// ��ġ�ϴ� ��ȭ��ȣ�ΰ� ������ ���� ����
		if(index == -1) {
			return false;
		}
		// number�� ��ȭ��ȣ ������ �´��� Ȯ���ϱ� ���ؼ�(����?????)
			// ��ȭ��ȣ ������ ������, ��ȭ��ȣ ��ü�� ����������, ��ȭ��ȣ�� ����
			// ������ ���� ������, �� ���ڿ��� �ֱ� ������(�����ؾ���.....)
		// ������, name�� number�� �̿��Ͽ� ��ȭ��ȣ ��ü�� ����
			// => public static boolean checkNumber �� �ٲ㼭 ���� �������ص���
			// ��ȭ��ȣ ��ü�� �����ϴ� ��� checkNumber�� �̿�!!!! good!!

		// number�� ��ȭ��ȣ �����̸� ��ȭ��ȣ�� ����
		if(!PhoneNumber.checkNumber(number)) {
			return false;
		}
		list.get(index).setNumber(number);
		return true;
	}
	
	// ��ȭ��ȣ ���� : �̸�, ��ȣ
	public boolean update(String name, String updateName, String number) {
		PhoneNumber pn = new PhoneNumber(name, number);
		
		// name�� �̿��Ͽ� ��ȭ��ȣ�� �˻�
		int index = list.indexOf(pn); // pn <= new PhoneNumber(name, number)
		// ������ �������� 
		if(index == -1) {
			return false;
		}
		// number�� ��ȭ��ȣ ���Ͽ� �ȸ����� ����
		if(!PhoneNumber.checkNumber(number)) {
			return false;
		}
		// ã������, ������ �ִ� ��ȭ��ȣ�� �����ϰ�
		list.remove(index);
		// updateName�� number�� �̿��Ͽ� ��ȭ��ȣ ��ü�� ������ �� �߰� (�ϴ°� �ڵ尡 ����)
		pn.setName(updateName); // <<<<< �̰� �� �ִ°���?????????????
		list.add(pn);
		return true;
	}
	// ���Ϲ�ȣ ����
	public boolean delete(String name) {
		// name���� PhoneNumber ��ü�� ���� �� �ٷ� ���� ��û
		return list.remove(new PhoneNumber(name, ""));
		// �˾Ƽ� ���������� true, ���������� false �˷��ֱ� ����;;;;;
	}
		
//���� ���ó�� // name�� ��ġ�ϴ� ��ȭ��ȣ �ִ��� Ȯ��
//			int index = list.indexOf(new PhoneNumber(name, ""));
//			// ������ ����
//			if(index == -1) {
//				return false
//			}
//			// ������ ����
	
	// ��ȭ��ȣ ���
	public void print(Predicate<PhoneNumber> p) {
		for(PhoneNumber pn : list) {
			if(p.test(pn)) {
				System.out.println(pn);
			}
		}
	}
}
