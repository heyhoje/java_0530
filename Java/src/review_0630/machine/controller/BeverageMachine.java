package review_0630.machine.controller;

import java.util.Scanner;

import review_0630.machine.vo.Beverage;

public class BeverageMachine {

	int menu;
	private Scanner sc = new Scanner(System.in);
	private Beverage list[] = new Beverage[3]; // vo.Beverage
	
	private int money; // ���Ǳ⿡ �ִ� �ݾ�
	
	private final static int COKE = 0;
	private final static int SPRITE = 1;
	private final static int FANTA = 2;
	private final static int EXIT = 4;
	
	// �������Ǳ� �迭�� ���� �������� �ֳ�? �� �Ű������ִ� ������ �����ϴ� �κ��� ��� �Ǵ°ǰ�?
	public BeverageMachine() {
		list[COKE] = new Beverage("�ݶ�", 1200, 10);
		list[SPRITE] = new Beverage("���̴�", 1100, 10);
		list[FANTA] = new Beverage("ȯŸ", 1000, 10);
	}
	
	
	public void printMenu() {
		System.out.println("-----------");
		System.out.println("�޴�");
		System.out.println("1. �ݾ� ����");
		System.out.println("2. �޴� ����");
		System.out.println("3. ��ǰ �԰�");
		System.out.println("4. ���α׷� ����");
		System.out.println("�޴� ���� : ");
		System.out.println("-----------");

	}
	
	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1: // �ݾ� ����
			insertCoin();
			break;
		case 2: // �޴� ���� - ���� ����
			selectBeverage();
			break;
		case 3: // ��ǰ �԰�
			insertBeverage();
			break;
		case 4:  // EXIT
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default: 
			System.out.println("�߸��� �޴��Դϴ�.");
		}
	}
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�	
	/** ��� : ���� �����Ѵ�
	 * �Ű����� : �� ������ �𸣰ڴ�
	 * ����Ÿ�� : ���� �ְ� �ݾ��� ������ �˷���(���) => void */
	private void insertCoin() {
		System.out.print("�ݾ� ���� : ");
		int money = sc.nextInt();
		this.money += money;
		System.out.println("���� �ݾ� : " + this.money);
		System.out.println();
		System.out.println("�޴�2�� ���� ���Ḧ �����ϼ���!");
	}
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	/** ��� : ��¥ ����� ���� Ÿ��
	 * �Ű����� : �����Է�
	 * ����Ÿ�� : �Է��Ѱ��߿� ���õ� -> void */
	private void selectBeverage() {
		System.out.println("1. �ݶ�");
		System.out.println("2. ���̴�");
		System.out.println("3. ȯŸ");
		System.out.print("���� ���� : ");
		
		int selectBeverage = sc.nextInt() -1; // ��?? ��???? �� �´ٸ´� ������ ã��
		// int index = indexOf(title) <- ����ܾ��忡�� ���� �����Ұ� ���� �� �������� ������
		
		switch(selectBeverage) {
		case COKE:
		case SPRITE:
		case FANTA:
			// �� �������� �𸣰����� generate�� ����
			generate(selectBeverage); // ���ٰ� �����ߴϱ� �� �޼ҵ� ���鷯 �������
			//System.out.println("���ᰡ ���Խ��ϴ�");
			break;
		default: 
			System.out.println("�߸� �����߽��ϴ�.");
			return;
		}
		// ++���� ���Խ��ϴ�. �˷��ְ� ������, generate�� break;�� case3 �ؿ� �־ �� ��µǹ���
	}
	
	/** ��� : �Ѱ����⵵? ��ü������ �߻��ϴ� �帧? - ���������� generate�� ������ �𸣰���
	 * �Ű����� : beverage <- �� ���� �� �����sB�� �ƴϰ� beverage�� ���ɱ�? �׳� �Ű������� ���ϵȰǰ�?
	 * ����Ÿ�� : �Է��Ѱŵ��� ����ϰ�, ����ϰ� �� => void */
	private void generate(int beverage) {
		int amount = list[beverage].getAmount();
		if(amount < 0) {
			System.out.println("�˼��մϴ� ��� �����ϴ�");
			return;
		}
		
		int money = list[beverage].getPrice();
		if(this.money < money) {
			System.out.println("�ݾ��� �����մϴ�.");
			return;
		}
		
		list[beverage].setAmount(amount -1);
		this.money -= money;
	}
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	/** ��� : ��������� ������ Ȯ���Ѵ�?
	 * �Ű����� : �̰͵� ���ڸ� ���� �Է��ϱ� ������ �Ű������� ����?
	 * ����Ÿ�� : �Է��ϰ� ��� => void */
	private void insertBeverage() {
		System.out.println("1. �ݶ�");
		System.out.println("2. ���̴�");
		System.out.println("3. ȯŸ");
		System.out.print("���� ���� : ");
		
		int selectBeverage = sc.nextInt() -1; // �ε��������� ã�ư����� -1 �Ѱǰ�?
		System.out.print("���� : "); // ���� ���� ���ϴ� �Ű���? ���� �����ΰǰ�??
		int amount = sc.nextInt();
		
		switch(selectBeverage) {
		case COKE:
		case SPRITE:
		case FANTA:
			// �ݶ�, ���̴�, ȯŸ�� ��� Ȯ���Ϸ� ����. 
			store(selectBeverage, amount);
			break;
		default: 
			System.out.println("�߸� �����߽��ϴ�.");
			return;
		}
		// ������ �ִ��� Ȯ���ؾ� ������� �� �� �־ store(�������, ���) �� Ȯ���Ϸ� ���°ɱ�?
	}
	
	/** ��� : ��� ���Ѵ�
	 * �Ű����� : �������ȣ, ����� �� => 
	 * ����Ÿ�� : �ȿ��� ����ϰ� ������ void? */
	private void store(int selectBeverage, int amount) {
		if(amount < 0) {
			System.out.println("���� ����");
			return;
		}
		int remainAmount = list[selectBeverage].getAmount();
		list[selectBeverage].setAmount(remainAmount+amount);
		System.out.println("�԰� �Ϸ�!");
		
		// ++������ � �԰� �Ǿ���. ��� �˷��� ���� ����? 
	}
	
	

}
