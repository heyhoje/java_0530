package day22.practice.Student.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day22.practice.Student.vo.Student;

// 람다식으로 작업해보기
// 람다식 우선순위를 미루더라도, 나중에 꼭 공부해보기

public class StudentManager2 implements Program{

	
	// private StudentManager2 student = new StudentManager2(); // 자기자신을 생성하면 안됨.
	
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
		switch(menu) {
		case 1: //학생 전체 출력
			print(s->true);
			break;
			
		// 람다식 안에는 지역변수를 쓸수있지만, 상수만 쓸 수 있다. 
		//final을 붙여서 상수화 하면 쓸 수 있음
			
		case 2: // 학생 학년 출력
			// 검색할 학년 입력
			System.out.println("grade : ");
			final int grade1 = sc.nextInt();
			
			print(s->s.getGrade() == grade1); // 학생정보가 주어지면 true
			break;
			
		case 3: // 학생 검색 출력
			// 검색할 학년, 반, 번호 입력
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
			System.out.println("잘못된 메뉴입니다.");
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
