package day25.tc.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.tc.student.vo.Student;

public class StudentController {
	
	int menu;
	String name, num, major;
	List<Student> list = new ArrayList<>();
	Student tmp;
	
	Scanner sc = new Scanner(System.in);
	private final static int EXIT = 3;
	
	public void run() {
		int menu;
		do {
			// �޴� ���
			//printMenu();
			System.out.println("�޴�");
			System.out.println("1. �л����");
			System.out.println("2. �л�Ȯ��");
			System.out.println("3. ����");
			System.out.print("�޴� ���� : ");
			
			// �޴� ����(�޴��� �Է¹���) : Scanner �ʿ�
			menu = sc.nextInt();
			
			// ���õ� �޴��� ���� ����� ����
			//runMenu(menu);
			switch(menu){
			case 1: // �л� ���
				// �л����� �Է� - �й� �̸� �а�
				// �й�(���ڿ�, ���� ����)
				System.out.print("�й� : ");
				num = sc.next();
				// �̸�(���ڿ�, ���� �ִ�)
				System.out.print("�̸� : ");
				sc.nextLine();
				name = sc.nextLine();
				// �а�(���ڿ�, ���� �ִ�)
				System.out.print("�а� : ");
				major = sc.nextLine();
			
				// �л����� ����Ʈ�� ����
				// �Է��� ������ �̿��Ͽ� �л� ��ü�� ����
				tmp = new Student(num,name, major);
				
				// ����Ʈ�� (�л� ��ü��) �߰�
				list.add(tmp);
				System.out.println(list);
				
				break;
			case 2: // �л� ��ü�� Ȯ��
				for(Student tmp2 : list) {
					System.out.println(tmp2);
				}
				break;
			case 3:
				System.out.println("�ý����� �����մϴ�");
				break;
			default:
			}
		}while(menu != EXIT);
		sc.close();
	}
	
}
