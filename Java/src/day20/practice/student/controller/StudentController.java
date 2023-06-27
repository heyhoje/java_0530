package day20.practice.student.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day20._122_collection.Student;

public class StudentController implements Program {
	
	private final static int EXIT = 4;
	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<Student> list = new ArrayList<Student>(); // �л��� �����ϱ� ���� list
	
	@Override
	public void run() {
		System.out.println("���α׷� ����!");
		
		int menu;
		
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				
				runMenu(menu);
			}catch(InputMismatchException e) {
				menu = EXIT -1;// ���� �޴��� �ƴ� �ƹ� �޴��� �߰�
				sc.nextLine();// �տ��� �߸� �Է��� ������ ����� / �� �ؽ�Ʈ������..?��
				System.out.println("�Է��� �߸��Ǿ����ϴ�.");
			}
		}while(menu != EXIT);
	}
	
	@Override
	public void printMenu() {
		System.out.println("�޴�");
		System.out.println("1. �л� �߰�");
		System.out.println("2. �л� ����");
		System.out.println("3. �л� ����");
		System.out.println("4. ���α׷� ����");
		System.out.print("�޴��� �����ϼ��� : ");
	}

	@Override
	public void runMenu(int menu) {
		System.out.println("��� ���� ��");
		switch(menu) {
		case 1: //�л� �߰�
			insertStudent();
			break;
		case 2: // �л� ����
			updateStudent();
			break;
		case 3: // �л� ���� 
			deleteStudent();
			break;
		case 4: 
			System.out.println("���α׷� ����");
			break;
		default:
			System.out.println("�߸��� �޴��Դϴ�.");
		}
	}

	private void deleteStudent() {
		// ������ �л� ������ �Է�(�г�, ��, ��ȣ) << �̰ŷθ� equals�� �Ǻ��ϱ�� ���߱� ����
		System.out.println("�г� : ");
		int grade = sc.nextInt();
		System.out.println("�� : ");
		int classNum = sc.nextInt();
		System.out.println("��ȣ : ");
		int number = sc.nextInt();
		
		// ������ �л� ������ �̿��Ͽ� �л� ��ü�� ����
		Student tmp = new Student(grade, classNum, number, null);
		
		// ������ �õ��ؼ� �����ϸ� �����ߴٰ�, �����ϸ� �����ߴٰ� �˷��ֱ�
		if(list.remove(tmp)) {
			//���� ����! remove == true
			System.out.println("���� ����");
			return;
		}
		System.out.println("���� ����");
	}

	private void updateStudent() {
		// ������ �л��� ������ �Է�(�г�, ��, ��ȣ) << �̰ŷθ� equals�� �Ǻ��ϱ�� ���߱� ����
		System.out.println("�г� : ");
		int grade = sc.nextInt();
		System.out.println("�� : ");
		int classNum = sc.nextInt();
		System.out.println("��ȣ : ");
		int number = sc.nextInt();
		
		// ������ �л��� �ִ��� ������ Ȯ��
		// ���л� ��ü�� ����!
		Student tmp = new Student(grade, classNum, number, null);
		int index = list.indexOf(tmp); // �л������� �����Ҷ�, index�� �̿��Ϸ���
		// ������ ���� or �߰��Ұ��� Ȯ�� �� �߰�
		if(index == -1) {
			System.out.println("������Ʈ ����");
			return;
		}
		
		// ������ �л� ������ �Է�(�ٽ� �� �Է�. �г�, ��, ��ȣ, �̸�)
		System.out.println("�г� : ");
		grade = sc.nextInt();
		System.out.println("�� : ");
		classNum = sc.nextInt();
		System.out.println("��ȣ : ");
		number = sc.nextInt();
		sc.nextLine(); // number�� �Է��ϰ� �� ��, ���Ϳ� ���� ������ ó���ϱ� ����
		String name = sc.nextLine();
		
		// �л� ������ ����
		// �� ������ �л� ������ �̹� �ִ� �л����� Ȯ��
		// ������ ������ �̿��Ͽ� �л� ��ü�� ����
		tmp = new Student(grade, classNum, number, name);
		// �г�, ��, ��ȣ�� ��ġ�ϴ� �л��� �ִ��� Ȯ���ؼ� ������ ����
		if(list.contains(tmp)) {
			System.out.println("������Ʈ ����");
			return;
		}
		list.get(index).update(grade, classNum, number, name); // �����������������
		//���ּҸ� �ƴϱ� �ٷ� �ٲ���� // create �ؼ� StudentC Ŭ������ ������ �Է�(this.)
		System.out.println("������Ʈ ����");
	}

	private void insertStudent() {
		// �߰��� �л��� ������ �Է�(�г�, ��, ��ȣ, �̸�)
		System.out.println("�г� : ");
		int grade = sc.nextInt();
		System.out.println("�� : ");
		int classNum = sc.nextInt();
		System.out.println("��ȣ : ");
		int number = sc.nextInt();
		sc.nextLine(); // number�� �Է��ϰ� �� ��, ���Ϳ� ���� ������ ó���ϱ� ����
		String name = sc.nextLine();
		
		// �Է¹��� ������ �̿��Ͽ� �л� ��ü�� ����  
		Student std = new Student(grade, classNum, number, name);
		// �л�����Ʈ�� �߰�
		// �ش� �л��� �ִ��� ������ Ȯ��(�г�, ��, ��ȣ�� üũ)�ؼ� ������ �߰�
		if(!list.contains(std)) { // contains => equals�� �������̵� �ߴٴ� �����Ͽ�
			list.add(std);
			System.out.println("�л� �Է� ����!");
			return; // �ؿ� else���� �Ⱦ�� ���� 
		}
		// �߰� �����ϸ� �߰��ߴٰ�, �����ϸ� �����ߴٰ� �ܼ�â�� �˷��ֱ�
		System.out.println("�л� �Է� ����!");
		
	} 
}
