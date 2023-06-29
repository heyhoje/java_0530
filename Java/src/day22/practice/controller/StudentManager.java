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
		System.out.println("1. 학년 전체 출력");
		System.out.println("2. 학생 학년 출력");
		System.out.println("3. 학생 검색 출력");
		System.out.println("4. 종료");
		System.out.print("메뉴를 선택해주세요 : ");
	}


	@Override
	public void runMenu(int menu) {
		int grade = 1, classNum =1, num =1;
		switch(menu) {
		case 1: //학생 전체 출력
			printAll();
			break;
			
		case 2: // 학생 학년 출력
			// 검색할 학년 입력
			System.out.println("grade : ");
			grade = sc.nextInt();
			
			printGrade(grade);
			break;
			
		case 3: // 학생 검색 출력
			// 검색할 학년, 반, 번호 입력
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
			System.out.println("잘못된 메뉴입니다.");
		}		
	}
	
	// 메소드1 : 학생 전체 정보 출력
	private void printAll() {
		for(Student tmp : list) {
			System.out.println(tmp);
		}
	}
	
	// 메소드2 : 학생 학년 출력
		private void printGrade(int grade) {
			for(Student tmp : list) {
				if(tmp.getGrade() == grade) {
				System.out.println(tmp);
				}
			}
		}
		
	// 메소드3 : 학생 검색 출력	
	private void printSearch(int grade, int classNum, int num) {
		for(Student tmp : list) {
//			if(grade == tmp.getGrade() 
//				&& classNum == tmp.getClassNum() 
//				&& num == tmp.getNum()) 
			if (tmp.equals(new Student(grade, classNum, num, ""))) {
				//Student 에서 equals설정하고 입력하면 한줄로 끝낼 수 있따
			System.out.println(tmp);
			}
		}
	}
}
