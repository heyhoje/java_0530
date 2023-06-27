package day17.practice.controller;

// 230622 ���󺹽� ������....��������
// shopService�� ���� �ȵǼ�, �� �ڿ� �޼ҵ尡 �ڵ��߰� Override �ȵǰ� ���� �߰���....
//230627 �ٺ��� �� ä���ٸ�

import java.util.Scanner;

import day17._10_interfaceEx.RunInterface;
import day17.practice.service.ShopService;
import day17.practice.service.ShopServiceImp;

// 15 >> 17�� ctrl+shift_o �ؼ� �ٲ�

import day17.practice.vo.Customer;
import day17.practice.vo.Product;
import day17.practice.vo.Sales;

public class ShopController implements RunInterface {
	
	private Scanner sc = new Scanner(System.in); // ��ĳ�ʸ� ����� ������ ������ �Ź� �������� �ʾƵ���
	private Product list[] = new Product[10]; // ��ǰ ����Ʈ
	private int count = 0; // ����� ��ǰ ����
	
	private Customer customerList[] = new Customer[10]; // �ִ� 10���� �� ����
	private int customerCount = 0; //����� �� ��
	
	private Sales salesHistory[] = new Sales[100]; // �Ǹ� ���
	private int salesCount; // ��ϵ� �Ǹż�
	
	private ShopService shopService= new ShopServiceImp(); // ��� ���� service �ϳ� �߰�! 
	// <- import�ϴϱ� shopService.�޼ҵ�() ������ �����
	// �׷����� override �ȵƴ� �޼ҵ���� �� ������ ������
	
	
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
			case 1: // [��ǰ �Ǹ�]
				// ���ĸ� �Է�
				System.out.print("��ǰ�� : ");
				sc.nextLine();
				String name = sc.nextLine();
				
				// ��ǰ ���� �Է�
				System.out.print("���� : ");
				int amount = sc.nextInt();
				
				// �� ����(��ȭ��ȣ) �Է�
				System.out.print("��ȣ : ");
				String phoneNumber = sc.next();
				
				int salesCount = shopService.sell(
						list, count, // ��ǰ ����Ʈ ����
						customerList, customerCount, // �� ����Ʈ ����
						salesHistory, this.salesCount, // �Ǹ� ���� ����
						// �⺻ �������� �����ϱ� ���� �ʿ��� �͵�
						name, amount, phoneNumber // ���� ��ǰ �Ǹ������� Ȯ���ϱ� ���� �ʿ�
					);
				if(salesCount == -1) {
					System.out.println("��ǰ �Ǹ� ����!");
				}else {
					System.out.println("��ǰ �Ǹ� ����!");
					this.salesCount = salesCount;
				}
				break;
				
			case 2: // [�԰�  ����]
				// �԰��� ��ǰ ������ �Է¹޾� ��ǰ ��ü�� �����ϴ� �ڵ� �ۼ�
				Product product = inputStoreProduct();
				// ��ǰ ����Ʈ�� ��ǰ ��, �԰�� ��ǰ�� �ְ�, ��ǰ �԰� �����϶�� ��Ŵ
				// ���ϰ��� �� count�� �����ؾ��ұ��?
				// (�� ��ǰ�� �԰�� ��� ��ǰ ����Ʈ�� �߰��ǰ�, ��ǰ���� 1���� �ؾ��ϱ� ����)
				count = shopService.store(list, count, product);
				// list; // �ٲ�(���������� �ּҸ� ����. �ȿ��� ������ �ٲ�� �ۿ��� �ٲ� �� ����)
				// count; // �⺻�ڷ����� �ۿ��� �ȹٲ�(), �׷��� return���� �˷������
				break;
				
			case 3: // [��ǰ ��ȸ]
				// ��ǰ���� �Է�
				System.out.print("��ǰ�� : ");
				sc.nextLine();
				String search = sc.nextLine();
				
				// ��ǰ�� �˻��ؼ� ���
				shopService.printProduct(list, count, search);
				break;
				
			case 4: // [���� ��ȸ]
				shopService.printSales(salesHistory, this.salesCount); //�� �길 �� this �ٿ�????
				break;
				
			case 5: // [�� ���]
				// �� ������ �Է��� �޾� �� ��ü�� ���� �߰��ϰ�, 
				Customer customer = inputRegisterCustomer();
				
				// �� ����Ʈ, ����, ��ϵ� �������� �ְ� �����϶�� ��Ŵ. �߰���.
				int Count = shopService.registerCustomer(customerList, customerCount, customer);
				if(count == -1) {
					System.out.println("�� ��� ����!");
				}else {
					System.out.println("�� ��� ����!");
					customerCount = count;
				}
				break;
			default:
				System.out.println("�߸��� �޴��Դϴ�.");

			}
		}
		
//		System.out.println("-----�޼ҵ� ������-----");
		
		// �޼ҵ�1 : �԰�(��ǰ��, ����, ����, �з�)
		private Product inputStoreProduct() {// store > inputStoreProduct, ����Ÿ�� Product
			// �԰��� ��ǰ�� �Է�
			System.out.print("��ǰ�� : ");
			sc.nextLine(); // *
			String name = sc.nextLine();
				// �԰��� ��ǰ ����
			System.out.println("���� : ");
			int amount = sc.nextInt();
			
			if(amount < 0) { // ����ó��, ���������� �ϱ�����
				System.out.println("�԰� ���� ����!");
				return null; // ��ü�� ���� null > ���� �߸��ƴ�!!�� ��
			}
			
			int index = indexOf(name);
		
			if(index != -1) { // ���������� ����
				Product product = new Product(list[index]);
				product.setAmount(amount); // �������� �������� ������ �ٲ�
				// new Product(name, "", 0, amount, "");
				// ��������� ����, �Ű����� �� Product�� ������
				// (���̸�, ����, ī�װ��̸� ���ʿ����/�̸��� ������)
				return product;
			}
					
			if(count == list.length) { // ����Ʈ�� �� ����, 
				System.out.println("��ǰ ����Ʈ ����");
				return null;
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
				// ���� �԰� -> '�԰� �ʿ��� ����'�� �޾Ƽ� '��ǰ���� �ϳ�' �������.
			
			Product product = new Product(name, modelName, price,
					amount, category);
			
			return product;
		}
		
		// �޼ҵ�4 : �� ������ �Է¹޾� ��ü�� ����?
		private Customer inputRegisterCustomer() {
			// �� ����(�̸�, ��ȭ��ȣ)�� �Է�
			System.out.print("�̸� : ");
			String name = sc.next();
			System.out.println("��ȣ : ");
			String phoneNumber = sc.next();
			
			return new Customer(name, phoneNumber);
			// �Ʒ� ������ �ٿ� ������ ���̴�!
//			Customer customer = new Customer(name, phoneNumber);
//			return customer; 
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
		
		// �޼ҵ�3 : ��ǰ �Ǹ� ���(��ǰ��, ���count)
		// �޼ҵ�4 : �� ��ǰ �߰�/�԰�(count++)
		// �޼ҵ�5 : ��ǰ ���� ��ȸ(��ǰ��, ����, ���)
		// �޼ҵ�6 : �Ǹ� ���� ��ȸ(���� * �Ǹŷ�)
		// �޼ҵ�7 : �� �߰� �� ����(����, ��ȭ��ȣ, �ּ�, ������ ����Ʈ ��)

}
