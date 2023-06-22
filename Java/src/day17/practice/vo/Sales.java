package day17.practice.vo;

import lombok.Data;

@Data
// �Ǹ� ���� : ���� � ��ǰ�� ����� �����ϴ� Ŭ����
public class Sales {
	
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
