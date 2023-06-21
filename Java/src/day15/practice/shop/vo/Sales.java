package day15.practice.shop.vo;

import lombok.Data;

@Data
public class Sales {
	// �Ǹ� ���� : ���� � ��ǰ�� ����� �����ϴ� Ŭ����
	private Customer customer;
	private Product product;
	private int totalPrice; // �Ǹ� ������ �� �ݾ�(��ü ������ �� �ݾ��� �ƴ�)
	
	public Sales(Customer customer, Product product) {
		//super();
		this.customer = customer;
		this.product = product;
		totalPrice = product.getAmount()*product.getPrice();
	}
	
	public void print() {
		System.out.println("---------");
		System.out.println("��ǰ : " + product.getName());
		System.out.println("���� : " + product.getAmount());
		System.out.println("�� : " + customer.getCustomerId());
		System.out.println("�ݾ� : " + totalPrice);
		System.out.println("---------");
	}
	


}
