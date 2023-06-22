package day17.practice.vo;

import lombok.Data;

@Data
public class Product {
	// ��� ���� : ��ǰ �Ǹſ� ���õ� ��ǰ ����(���� ��ǰ�� ��� ����x)
	// ��ǰ��, �𵨸�, ����, ����(�Ǹ� ����, ��ü ���), �з�
	private String name;
	private String modelName;
	private int price;
	private int amount;
	private String category;

	// ������ 1
	public Product(String name, String modelName, int price, int amount, String category) {
		// super(); // �θ�Ŭ������ ������ ��� <- object
		this.name = name;
		this.modelName = modelName;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}	
	
	// ������ 1.2
	public Product(Product product) {
		this.name = product.name;
		this.modelName = product.modelName;
		this.price = product.price;
		this.amount = product.amount;
		this.category = product.category;
	}
	
	// ������ 1.3
	public Product(String search) {
		this.name = search;
	}

	// �޼ҵ�
	// �޼ҵ�1 : ��ǰ �԰�(���� ����)
	/** ��� : ��ǰ �԰� ��� => ���� ������ �־��� ������ ���� */
	public void store(int amount) {
		// â�� ��ǰ�� �߰��ؾ��ϴµ� ������ ���� �ȵ�
		if(amount < 0) {
			return;
		}
		//this.amount += amount;
		accumulate(amount);
	}
	
	// �޼ҵ�2 :
	/** ��ǰ ��� ��� => ���� �������� �־��� ������ ����*/
	public void release(int amount) {
		if(amount < 0) {
			return;
		}
		//this.amount -= amount;
		accumulate(-amount);
	}
	
	private void accumulate(int amount) {
		this.amount += amount;
	}
	
	public void print() {
		System.out.println("��ǰ�� : " + name);
		System.out.println("�𵨸� : " + modelName);
		System.out.println("�з� : " + category);
		System.out.println("��� : " + amount);
		System.out.println("���� : " + price);
	} 
}
