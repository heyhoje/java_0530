package day17.practice.service;

import day17.practice.vo.Customer;

//230622 ���󺹽� ������....��������
//230627 �ٺ��� �� ä���ٸ�

import day17.practice.vo.Product;
import day17.practice.vo.Sales;

public interface ShopService {// �������̽��� ����� �߻�޼ҵ带 �ϳ��� ä�� ����

		// ��ǰ �԰� - ��ǰ ������ �߰��ϴ� ���(���� ��ǰ�̸� ��ǰ �߰�)
		int store(Product[] list, int count, Product product);
		
		// ��ǰ ��ȸ - ��ǰ���� �־����� ��ǰ ������ ����ϴ� ���
		void printProduct(Product[] list, int count, String search);

		
		// �� ��� - ���� �߰��ϴ� ���
		int registerCustomer(Customer[] customerList, int customerCount, Customer customer);

		// ��ǰ �Ǹ� - ������ ��ǰ�� �Ǹ��ϴ� ���
		int sell(Product[] list, int count, Customer[] customerList, int customerCount, Sales[] salesHistory,
				int salesCount, String name, int amount, String phoneNumber);

		// ���� ��ȸ - ���� ������ ����ϴ� ���
		void printSales(Sales[] salesHistory, int salesCount);
}
