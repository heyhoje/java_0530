package day17.practice.service;

//230622 ���󺹽� ������....��������

import day17.practice.vo.Customer;
import day17.practice.vo.Product;

public class ShopServiceImp implements ShopService { // ���񽺸� ������ '����Ŭ����'

	

	public void printProduct(Product[] list, int count, String search) {
		if(list == null || search == null) {
			System.out.println("��ǰ ������ �����ϴ�.");
			return;
		}
		
		int index = indexOf(list, count, new Product(search));
		
		if(index == -1) {
			System.out.println("��ǰ ������ �����ϴ�.");
			return;
		}
		list[index].print();
	}
	
	public int registerCustomer(Customer[] list, int count, Customer customer){
		if(list == null 
			|| count < 0 
			|| customer == null 
			|| customer.getPhoneNumber == null
			|| list.length <= count) {
			return -1;
		}
		
		for(int i = 0; i < count; i++) {
			if(list[i].getPhoneNumber().equals(customer.getPhoneNumber())) {
				return -1;
			}
		}
		list[count] = new Customer(customer); 
		return count+1;
	}
	
	public int sell(Product[] list, int count, Customer[] customerList, 
			int slaesCount, String name, int amount, String phoneNumber) {
		// �� ����Ʈ�� �����ϴ��� Ȯ��
		if(list == null|| customerList == null || salesHistory == null) {
			return -1;
		}
		
		// �� ����Ʈ�� �ִ� ũ�Ⱑ �� �������� ũ�ų� �������� üũ
		if(list.length < count 
			|| customerList.length < customerCount 
			|| salesHistory.lengh <= salesCount) {
			return -1;
		}
		
		// ��ǰ ���� �˻�
		int productIndex = indexOf(list, Count, new Product(name));
		// �� ���� �˻�
		int customerIndex = indexOf(customerList, customerCount, phoneNumber);
		
		if(productIndex == -1 || customerIndex == -1) {
			return -1; // �ϳ��� ������ �Ǹ� ����� �� �� ����
		}
		
		// �Ǹ� ������ ���� 
		Product sellProduct = new Product(list[productIndex]);
		sellProduct.setAmount(amount); // �Ǹ� ��ǰ����
		Sales sales = new Sales(customerList[customerIndex], sellProduct);
		
		// �ǸŸ���Ʈ�� �Ǹ� ������ �߰�
		salesHistory[salesCount] = sales;
		return salesCount+1;
	}
	
	private int indexOf(Customer[] customerList, int customerCount, String phoneNumber) {
		if(customerList == null || phoneNumber == null) {
			return -1;
		}
		for(int i = 0; i < customerCount; i++) {
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}

//	System.out.println("-----���� �������̵�-----");
	
	@Override
	public int store(Product[] list, int count, Product product) {
		// ��ǰ ����ϸ��� �˷��ִµ�, ��ǰ�� �ִ��� ������ �켱 üũ�ؾ���
		// �԰��� ��ǰ�� ������, �԰������ʰ� '���� ��ǰ ��(��������)'�� �˷���
		if(product == null) { // �Ű�����, ���������� �Ѱ��ִ°� null ó���� �ؾ���
			return count;
		}
		// ��ǰ����Ʈ�� ������
		if(list == null) {
			return 0;
		}
		// ��ǰ ����Ʈ�� ũ�Ⱑ count���� ������,
		if(list.length < count) {
			return list.length;
		}
				
		// count : int �� null�� ó���� �� ����
		// ��ǰ ���� �߸��Ǹ�(�����̸�),
		if(count < 0) {
			return 0;
		}
		// ---- ���α׷��� ���� ����ó�� �� ---- �������� �� ���ִ� ���� ���̱�
		
		int index = indexOf(list, count, product);
		// ���� ��ǰ �԰�
		if(index != -1) {
			list[index].store(product.getAmount());
			return count;
		}
		
		// �԰� �� ����ó�� Ȯ�� �� �迭�� �� ����(�� �߰�x)
		if(count == list.length) {
			return count;
		}
		// �� ��ǰ �԰�
		list[count] = new Product(product);
		return count+1; // �� ��ǰ ������ְ� ī��Ʈ ����
	}
		
	private int indexOf(Product[] list, int count, Product product) {
		// ��ǰ ������ ���ų� ��ǰ���� ������ �� ã��
		if(product == null || product.getName() == null) {
			return -1;
		}
		// ��ǰ ����Ʈ�� ������
		if(list == null) {
			return -1;
		}
		// �˻��� ��ǰ ���� �߸� �ԷµǸ�
		if(count > list.length || count < 0) {
			count = list.length; // 11�� �˻��϶��ص� 10�������� �˻��ϸ��.
		}
			
		for(int i = 0; i < count; i++) {
			// ��ǰ ����Ʈ���� ���� ��ǰ ������ tmp�� ����
			Product tmp = list[i];
			// ��ǰ ����Ʈ�� �ִ� ��ǰ�� ���ų�, �̸��� ���ų�, ã�� ��ǰ���� ������
			if(tmp == null || tmp.getName() == null|| product.getName() == null) {
				return -1; // ��ã�ڴ�. ��� �˷��ְ�
			}
			
			// ��ǰ���� ���Ͽ� ������ i������ ��ȯ
			if(tmp.getName().equals(product.getName())) {
				return i;
			} 
		}
		return -1;
	}
		
		