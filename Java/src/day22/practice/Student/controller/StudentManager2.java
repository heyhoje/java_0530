package day22.practice.Student.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day22.practice.Student.vo.Student;

// ���ٽ����� �۾��غ���
// ���ٽ� �켱������ �̷����, ���߿� �� �����غ���

public class StudentManager2 implements Program{

	
	// private StudentManager2 student = new StudentManager2(); // �ڱ��ڽ��� �����ϸ� �ȵ�.
	
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
		switch(menu) {
		case 1: //�л� ��ü ���
			print(s->true);
			break;
			
		// ���ٽ� �ȿ��� ���������� ����������, ����� �� �� �ִ�. 
		//final�� �ٿ��� ���ȭ �ϸ� �� �� ����
			
		case 2: // �л� �г� ���
			// �˻��� �г� �Է�
			System.out.println("grade : ");
			final int grade1 = sc.nextInt();
			
			print(s->s.getGrade() == grade1); // �л������� �־����� true
			break;
			
		case 3: // �л� �˻� ���
			// �˻��� �г�, ��, ��ȣ �Է�
			System.out.print("grade : ");
			final int grade2 = sc.nextInt();
			System.out.print("class : ");
			final int classNum2 = sc.nextInt();
			System.out.print("number : ");
			final int num2 = sc.nextInt();
			
			print(s->s.equals(new Student(grade2, classNum2, num2, "")));
			break;
			
		case 4: 
			break;
			
		default: 
			System.out.println("�߸��� �޴��Դϴ�.");
		}		
	}
	
	private void print(Predicate<Student> p) {
		for(Student tmp : list) {
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}		
	}
}
