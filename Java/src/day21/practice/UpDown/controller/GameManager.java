package day21.practice.UpDown.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import day21.practice.UpDown.vo.RecordGame;

public class GameManager implements Program{
	// ������� 
	// ���ͷ� 3�� �ǹ̸�(���� ���� �ǹ� = ����� �̸��� �ٿ�) ��Ȯ�ϰ� �����ϱ� ����
	private static final int EXIT = 3;
	
	// �ٸ� �޼ҵ忡�� �Ź� ��ü�� �����ϴ°� ���ŷο���
	private Scanner sc = new Scanner(System.in);
	
	// ����� �����ϴ� ����Ʈ
	private ArrayList<RecordGame> list = new ArrayList<>();
	@Override 
	public void printMenu() {
		System.out.println("1. Play");
		System.out.println("2. Record");
		System.out.println("3. EXIT");
		System.out.print("Select Menu : ");
	}

	@Override
	public void run() {
		System.out.println("Program Start!!");
		
		int menu;
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
		
		}while(menu != EXIT);
		
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			playGame();
			break;
		case 2: 
			recordGame();
			break;
		case 3: 
			break;
		default:
			System.out.println("Wrong menu!");
		}
	}

	private void recordGame() {
		for(RecordGame tmp : list) {
			System.out.println(tmp);
		}
	}

	private void playGame() {
		int min = 1, max = 100;
		int num = min - 1;//1~100�� �ƴ� ������ �ʱ�ȭ �ϸ� ��. �ּҰ� -1�� �ؼ� �������� ���� �� ���� ��
		int random;
		//������ ���� ���� (�� ���)
		random = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(random);
		int count = 0;
		//�ݺ��� : ���⶧���� => �Է��� ������ ������ �ƴϸ� �ݺ�
		while(random != num) {
			//������ �Է�
			System.out.println("input(1~100) : ");
			num = sc.nextInt();

			//������ ������ ���Ͽ� �Ǻ�
			//num�� random���� ũ�� Down!,�ƴϰ� num�� random���� ������ Up!, �ƴϸ� Good!
			if(num > random) {
				System.out.println("Down!");
			}else if(num < random) {
				System.out.println("Up!");
			}else {
				System.out.println("Good!");
			}
			count++;
		}
		//��� : ���̵�(�Է�), �÷��� Ƚ��(������ �ϸ鼭 ��� : count)
		// ���̵� �Է�
		System.out.println("Record ID : ");
		String id = sc.next();
		
		// ��� �����ؼ� ������ �ǰ�?
		RecordGame rec = new RecordGame(id, count);
		list.add(rec);
		//sort();
		list.sort(new Comparator<RecordGame>() {

			@Override
			public int compare(RecordGame o1, RecordGame o2) {
				return o1.getCount() - o2.getCount();
			
			}
		});
	}

	// �������� �̿�
	private void sort() {
		for(int i = 0; i < list.size()-1;i++) {
			for (int j=0; j < list.size() -1; j++) {
				if(list.get(j).getCount() > list.get(j + 1).getCount()) {
					RecordGame tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}	
			}
		}
	}
}
	