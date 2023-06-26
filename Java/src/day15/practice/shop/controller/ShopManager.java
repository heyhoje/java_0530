package day15.practice.shop.controller;

import java.util.Scanner;

import day15.practice.shop.vo.Customer;
import day15.practice.shop.vo.Product; //import���ؼ�. product�� list[] ���� ������
import day15.practice.shop.vo.Sales;
import day17._10_interfaceEx.RunInterface;

public class ShopManager implements RunInterface{
	
	private Scanner sc = new Scanner(System.in); // ��ĳ�ʸ� ����� ������ ������ �Ź� �������� �ʾƵ���
	private Product list[] = new Product[10]; // ��ǰ ����Ʈ
	private int count = 0; // ����� ��ǰ ����
	
	private Customer customerList[] = new Customer[10]; // �ִ� 10���� �� ����
	private int customerCount = 0; //����� �� ��
	
	private Sales salesHistory[] = new Sales[100]; // �Ǹ� ���
	private int salesCount; // ��ϵ� �Ǹż�
	private int totalPrice;
	
	
	public void run () {
		// ������� / ��� 
		System.out.println("���α׷��� ����!!");
		
		int menu = -1;
		final int EXIT = 6;
		// �ݺ� : ������ �޴��� ���ᰡ �ƴҶ����� & �ݵ�� �ѹ��� �����
		do {// 1. �޴� ���
			printMenu();
			
			// 2. �޴� ����
			menu = sc.nextInt();
			
			// 3. �޴��� ���� ��� ����
			runMenu(menu);
				
		}while(menu != EXIT);
		
		System.out.println("���α׷� ����!!");
		
		sc.close();
	}
	
	// �޼ҵ�1 : ���θ޴� ���
		/** ��� : �޴��� ����ϴ� �޼ҵ�
		 * �޼ҵ�� : printMenu
		 */
		private void printMenu() {
			System.out.println("----------");
			System.out.println("�޴��Դϴ�");
			System.out.println("1. ��ǰ �Ǹ�");
			System.out.println("2. ��ǰ �԰�");
			System.out.println("3. ��ǰ ��ȸ");
			System.out.println("4. ���� ��ȸ");
			System.out.println("5. �� ���");
			System.out.println("6. ���α׷� ����");
			System.out.println("----------");
			System.out.print("�޴��� �����ϼ��� : ");
		}
			
		// �޼ҵ�2 : �޴� ��� ����
		/** ��� : �޴��� ���� ����� �����ϴ� �޼ҵ�
		 * �Ű����� : �޴� => int menu
		 * ����Ÿ�� : (�ȿ��� ����) ���� => void
		 * �޼ҵ�� : runMenu
		 */
		private void runMenu(int menu) {
			// sysout("menu+����")
			switch(menu) {
			case 1: 
				// '� ��'�� '� ��ǰ'�� �����ߴ��� ����
				// System.out.println("��ǰ �Ǹ� ���");
				sell();
				break;
			case 2: 
				// �� ��ǰ�� �߰���. '� ��ǰ'�� '� �߰�'�Ǿ����� ����
				//System.out.println("�� ��ǰ �߰�/�԰�");
				store();
				break;
			case 3:
				//��ǰ ���� ��ȸ. '��ǰ��'���� ��ǰ�� ��ȸ
				//System.out.println("��ǰ ���� ��ȸ");
				printProduct();
				break;
			case 4: 
				// '�Ǹŵ� ��ǰ' '����' ��ȸ. ���� ����
				//System.out.println("�Ǹ� ���� ��ȸ");
				printSales();
				break;
				
			case 5:
				// ���� �߰��Ͽ� �� ����
				System.out.println("�� �߰� �� ����");
				registerCustomer();
				break;
			default:
				System.out.println("�߸��� �޴��Դϴ�.");

			}
		}
		
		// �޼ҵ�4 : �����
		private void registerCustomer() {
			// �� ����(�̸�, ��ȭ��ȣ)�� �Է�
			System.out.print("�̸� : ");
			String name = sc.next();
			System.out.println("��ȣ : ");
			String phoneNumber = sc.next();
			
			// (�� ����Ʈ��) ���� ���
			// �̹� ��ϵ� ��ȭ��ȣ�̸� ���x
			for (int i = 0; i < customerCount; i++) {
				// customerList[i] : �� ����Ʈ���� i������ �ִ� �� ����
				// customerList[i].getPhoneNumber() : i���� ���� ��ȭ��ȣ
				// i���� ���� ��ȭ��ȣ�� ����Ϸ��� ���� ��ȭ��ȣ�� ������ ��� ����
				if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
					System.out.println("��ϵ� ��ȣ! �� ��� ����!");
					return;
				}
			}
			// �� ��ȭ��ȣ�̸� ���
			// �Է¹��� �� ������ �̿��Ͽ� �� ��ü�� ������ ��, ������ �� ������ �� ���� �߰�
			// ��ϵ� ���� ���� ����
			customerList[customerCount] = new Customer(name, phoneNumber);
			customerCount++;
		}
			
		private void printSales() {
			// ���� ���� ���
			for(int i = 0; i < salesCount; i++) {
				salesHistory[i].print();
			}
			
			// ���� ����� ���
			System.out.println("���� ����� : " + totalPrice);
		}
		
		// �޼ҵ�5 : ��ǰ ��ȸ
		private void printProduct() {
			//�˻��� ��ǰ�� �Է�
			System.out.println("��ǰ�� : ");
			sc.nextLine(); // ����. ���� �Է¿��� ���͸� �Ʊ� ������ ���� ����
			String name = sc.nextLine();
			
			// �Է��� �˻���� �´� ��ǰ�� ���
			int index = indexOf(name);// ��ϵ� ��ǰ�� �߿� �˻���� ��ġ�ϴ� ��ǰ�� ����ִ��� Ȯ��

			// ��ǰ�� ������ ��ǰ ������ ���
			if(index >= 0) {
				list[index].print();
				return;
			}
			// ������ ���� ��ǰ�̶�� ���
			System.out.println("���� ��ǰ!");
		}

		// �޼ҵ�3 : �԰�(��ǰ��, ����, ����, �з�)
		private void store() {
			// �԰��� ��ǰ�� �Է�
			System.out.print("��ǰ�� : ");
			sc.nextLine(); // *
			String name = sc.nextLine();

			// �԰��� ��ǰ ����
			System.out.println("���� : ");
			int amount = sc.nextInt();
			
			if(amount < 0) { // ����ó��, ���������� �ϱ�����
				System.out.println("�԰� ���� ����!");
				return;
			}
			
			// ��ǰ ����Ʈ���� �԰��� ��ǰ���� �ִ��� ã��
			// ��ǰ �迭�� �ִ� ��ǰ��� �԰��� ��ǰ���� ������ Ȯ���ؼ�
			// ������ ��ġ�� ���(������� �ִ���)
			int index = indexOf(name);
			
			// ������, �԰��� ��ǰ ������ŭ �ش� ��ǰ�� �԰�
			// (��ġ�� 0�̻��̸�)
			if(index != -1) {
				list[index].store(amount);
				System.out.println("�԰� �Ϸ�");
				return;
			}
			// ������, ��ǰ����Ʈ�� ��ǰ ������ �߰�(�԰��� ������ �Բ�)
			// (��ġ�� -1�̸�)
			// �ִ�ġ�� ��ϵǾ� ������
			if(count == list.length) {
				System.out.println("��ǰ ����Ʈ ����");
				return;
			}
			
			// �𵨸� �Է�
			System.out.println("�� ��ǰ ���");
			System.out.println("�𵨸� : ");
			sc.nextLine(); //* nextLine ���� ó���Ϸ���
			String modelName = sc.nextLine();
			// ������ �Է�
			System.out.println("���� : ");
			int price = sc.nextInt();
			// �з� �Է�
			System.out.println("�з� : ");
			String category = sc.next();

			// ��ǰ ����Ʈ�� �߰�
			list[count++] = new Product(name, modelName, price, amount, category);
			System.out.println("��ǰ �߰� �� �԰� �Ϸ�!");
		}

		// �޼ҵ� 3.5 : ��ǰ ��ġ ã��
		/** ��� : ��ǰ ����Ʈ�� ��ǰ��� ��ġ�ϴ� ��ǰ�� ������ ������ ������ -1�� �˷��ִ� �޼ҵ�
		 * �Ű����� : ��ǰ�� => String name
		 * ����Ÿ�� : ��ǰ�� �ִ� ������ -1 => ���� => int
		 * �޼ҵ�� : indexOf
		 */
		public int indexOf(String name) {
			for(int i = 0; i < count; i++) {
				if(list[i].getName().equals(name)){
					// ��ǰ �������� i����, �̸��� �����ͼ� ���� ��???
					return i;
				} 
			}
			return -1;
		}
		
		private void sell() {
			// ���ĸ� �Է�
			System.out.print("��ǰ�� : ");
			sc.nextLine();
			String name = sc.nextLine();
			
			// ��ǰ ���� �Է�
			System.out.print("���� : ");
			int amount = sc.nextInt();
			
			// �� ���� �Է�
			System.out.print("��ȣ : ");
			String phoneNumber = sc.next();
			
			// �ִ� ��ǰ���� Ȯ��
			int index = indexOf(name);
			if (index < 0) {
				System.out.println("��ǰ�� ����!");
				return;
			}
			if (amount <= 0) {
				System.out.println("��ǰ ���� ����!");
				return;
			}
			
			// �ִ� ������ Ȯ��
			int customerIndex = indexOfCustomer(phoneNumber);
			if(customerIndex < 0) {
				System.out.println("��ȭ��ȣ ����!");
				return;
			}
			
			// �Ǹ� ������ �߰�
			// ��ǰ ����
			// ���� �����ڸ� �̿��ؼ� ��ǰ ������ ����(���� ����)
			Product product = new Product(list[index]);
			product.setAmount(amount);
			
			// �� ����
			Customer customer = customerList[customerIndex];
			
			Sales sales = new Sales(customer, product);
			salesHistory[salesCount++] = sales; 
			
			// �Ǹŵ� ������ŭ ������� �������
			list[index].release(amount);
			
			// ���� �ݾ��� �߰�
			totalPrice += sales.getTotalPrice();
		}
		
		
		
		private int indexOfCustomer(String phoneNumber) {
			for (int i = 0; i < customerCount; i++) {
				// ���� ��ȣ�� ������
				if(customerList[i].getPhoneNumber().equals(phoneNumber))
					return i;
			}
			return -1;
		}
		// �޼ҵ�3 : ��ǰ �Ǹ� ���(��ǰ��, ���count)
		// �޼ҵ�4 : �� ��ǰ �߰�/�԰�(count++)
		// �޼ҵ�5 : ��ǰ ���� ��ȸ(��ǰ��, ����, ���)
		// �޼ҵ�6 : �Ǹ� ���� ��ȸ(���� * �Ǹŷ�)
		// �޼ҵ�7 : �� �߰� �� ����(����, ��ȭ��ȣ, �ּ�, ������ ����Ʈ ��)

}
