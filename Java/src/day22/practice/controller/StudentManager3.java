package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import day22.practice.vo.Student;

// ���ٽ����� �۾��غ���
// ���ٽ� �켱������ �̷����, ���߿� �� �����غ���
// >> Stream���� �۾�

public class StudentManager3 implements Program{
// 3. ������ �ۼ��� �л� ���� ��� ���α׷��� Stream�� �����غ�����.
	
	//private StudentManager3 student = new StudentManager3(); //�ڱ��ڽ��� �����ϸ� �ȵ�.
	
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
		Stream<Student> stream = list.stream(); // Stream 
		switch(menu) {
		case 1: //�л� ��ü ���
			stream.forEach(std->System.out.println(std));
			break;
			
		// ���ٽ� �ȿ��� ���������� ����������, ����� �� �� �ִ�. 
		// final�� �ٿ��� ���ȭ �ϸ� �� �� ����
			
		case 2: // �л� �г� ���
			// �˻��� �г� �Է�
			System.out.println("grade : ");
			final int grade1 = sc.nextInt();
			
			stream
			/* filter�� �Ű������� Predicate �������̽��� ��ü�� �ʿ�
			 * Predicate�� ������ �͸�Ŭ������ ���ٽ����� ���� �Ŀ� ��ü�� �����ؼ� ����
			 * (std�� �Ű����� �̸��̱� ������ �ٸ� �̸����� �����ص� ����)*/
				.filter(std -> std.getGrade() == grade1)
				.forEach(std->System.out.println(std));
			break;
			
		case 3: // �л� �˻� ���
			// �˻��� �г�, ��, ��ȣ �Է�
			System.out.print("grade : ");
			final int grade2 = sc.nextInt();
			System.out.print("class : ");
			final int classNum2 = sc.nextInt();
			System.out.print("number : ");
			final int num2 = sc.nextInt();
			
			stream
				.filter(std -> std.equals(new Student(grade2, classNum2, num2, null)))
				.forEach(std -> System.out.println(std));
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
