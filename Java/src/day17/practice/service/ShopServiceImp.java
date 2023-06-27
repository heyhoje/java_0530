package day17.practice.service;

//230622 ���󺹽� ������....��������
//230627 �ٺ��� �� ä���ٸ�

import day17.practice.vo.Customer;
import day17.practice.vo.Product;
import day17.practice.vo.Sales;

public class ShopServiceImp implements ShopService { // ���񽺸� ������ '����Ŭ����'


//	System.out.println("-----���� �������̵�-----");
	
	// ��ǰ �԰�
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

	// ��ǰ ��ȸ
	@Override
	public void printProduct(Product[] list, int count, String search) {
		if(list == null || search == null) {
			System.out.println("��ǰ ������ �����ϴ�.");
			return;
		}
		int index = indexOf(list, count, new Product(search)); // ��ǰ ����
		if(index == -1) {
			System.out.println("��ǰ ������ �����ϴ�.");
			return;
		}		
		list[index].print(); //����Ʈ�� �ִ� ��ǰ ���� ���
	}

	// �� ���
	@Override
	public int registerCustomer(Customer[] list, int count, Customer customer) {
		if(list == null || count < 0 || customer == null 
			|| customer.getPhoneNumber() == null || list.length <= count) {
			return -1;
		}
		// ������ȣo, ��ϵ� ���� ������, ��ϸ��ϰ� �����ְ�
		for(int i = 0; i < count; i++) {
			if(list[i].getPhoneNumber().equals(customer.getPhoneNumber())) {
				return -1;
			}
		}
		// ���� ��ȣ�� ������,
		list[count] = new Customer(customer);
		//list[count] = new Customer(customer.getName(),customer.getPhoneNumber());
		// ��������ڷ� ���� �Ǵµ� �Ű������� 2���� get ���ٰ�?? �׷� ��������ڷ� ����� ��� �Ǵµ���?
		return count+1;
	}

	// ��ǰ �Ǹ�
	@Override
	public int sell(Product[] list, int count, Customer[] customerList, int customerCount, Sales[] salesHistory,
			int salesCount, // ���߿� �����ͺ��̽� ���� �����ͺ��̽��� �����ؼ� ������ 
			String name, int amount, String phoneNumber) {
		// �� ����Ʈ�� �����ϴ���(�������) Ȯ��
		if(list == null || customerList == null || salesHistory == null) {
			return -1;
		}
		// �� ����Ʈ�� �ִ� ũ�Ⱑ �� �������� ũ�ų� �������� üũ
		if(list.length < count 
			|| customerList.length < customerCount 
			|| salesHistory.length <= salesCount) { // �� sales�� ���ٰ� ���ٰ�???????
			return -1; // ����� ���� �ʰڴ�
		}
		
		// ��ǰ ���� �˻�
		int productIndex = indexOf(list, count, new Product(name));
		// �� ���� �˻�
		int customerIndex = indexOf(customerList, customerCount, phoneNumber); // ��� �� new Customer() ���ϰ� �׳� ���ѹ���???
		
		if(productIndex == -1 || customerIndex == -1) {
			return -1; // ��ǰ������ �������� ��� �Ǹű���� �� �� ����
		}
		// �Ǹ� ����(sellProduct)�� ����
		Product sellProduct = new Product(list[productIndex]);// �˻��� ��ǰ������ ���� > �����δ�Ʈ�� �ְ�
		sellProduct.setAmount(amount); // �Ǹ� ��ǰ������ �����
		
		Sales sales = new Sales(customerList[customerIndex], sellProduct);
		// �ǸŸ���Ʈ�� �Ǹ� ������ �߰�
		salesHistory[salesCount] = sales;
		return salesCount +1;
	}

	// ��Ʈ�ѷ��� �������ִ� �޼ҵ��ε�, �Ű������� �޶�����
	private int indexOf(Customer[] customerList, int customerCount, String phoneNumber) {
		if(customerList == null || phoneNumber == null) {
			return -1; // ������Ʈ�� ��ȭ��ȣ�� ������
		}
		for(int i = 0; i < customerCount; i++) {
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				return i;
			}
		}
		return -1;
	}

	//[���� ��ȸ]
	@Override
	public void printSales(Sales[] salesHistory, int salesCount) {
		int totalPrice = 0;
		// ���� ���� ���
		for(int i = 0; i < salesCount; i++) {
			salesHistory[i].print();
			totalPrice += salesHistory[i].getTotalPrice(); // �� ���� ���ϰ� �� �߰��ϼ���..��
		}
		
		// ���� ����� ���
		System.out.println("���� ����� : " + totalPrice);		
	}

}
		