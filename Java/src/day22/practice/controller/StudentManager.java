package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import day22.practice.vo.Student;

public class StudentManager implements Program{

	
	// private StudentManager student = new StudentManager();
	
	private List<Student> list = Arrays.asList(
			new Student(1,1,1,"Hong"),
			new Student(1,1,2,"Ling"),
			new Student(2,1,1,"Park"),
			new Student(3,1,1,"Lee"),
			new Student(3,3,2,"Kim")
		);
	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4;
	
	
	@Override
	public void run() {
		int menu;
		
		do {
			printMenu();
			
			menu = sc.nextInt();
			
			runMenu(menu);
			
		} while(menu != EXIT);
		
		sc.close();
	}
	
	@Override
	public void printMenu() {
		System.out.println("1. �г� ��ü ���");
		System.out.println("2. �л� �г� ���");
		System.out.println("3. �л� �˻� ���");
		System.out.println("4. ����");
		System.out.print("�޴��� �������ּ��� : ");
	}


	@Override
	public void runMenu(int menu) {
		int grade = 1, classNum =1, num =1;
		switch(menu) {
		case 1: //�л� ��ü ���
			printAll();
			break;
			
		case 2: // �л� �г� ���
			// �˻��� �г� �Է�
			System.out.println("grade : ");
			grade = sc.nextInt();
			
			printGrade(grade);
			break;
			
		case 3: // �л� �˻� ���
			// �˻��� �г�, ��, ��ȣ �Է�
			System.out.print("grade : ");
			grade = sc.nextInt();
			System.out.print("class : ");
			classNum = sc.nextInt();
			System.out.print("number : ");
			num = sc.nextInt();
			
			printSearch(grade, classNum, num);
			break;
			
		case 4: 
			break;
			
		default: 
			System.out.println("�߸��� �޴��Դϴ�.");
		}		
	}
	
	// �޼ҵ�1 : �л� ��ü ���� ���
	private void printAll() {
		for(Student tmp : list) {
			System.out.println(tmp);
		}
	}
	
	// �޼ҵ�2 : �л� �г� ���
		private void printGrade(int grade) {
			for(Student tmp : list) {
				if(tmp.getGrade() == grade) {
				System.out.println(tmp);
				}
			}
		}
		
	// �޼ҵ�3 : �л� �˻� ���	
	private void printSearch(int grade, int classNum, int num) {
		for(Student tmp : list) {
//			if(grade == tmp.getGrade() 
//				&& classNum == tmp.getClassNum() 
//				&& num == tmp.getNum()) 
			if (tmp.equals(new Student(grade, classNum, num, ""))) {
				//Student ���� equals�����ϰ� �Է��ϸ� ���ٷ� ���� �� �ֵ�
			System.out.println(tmp);
			}
		}
	}
}
