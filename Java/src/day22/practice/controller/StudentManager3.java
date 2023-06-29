package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import day22.practice.vo.Student;

// 람다식으로 작업해보기
// 람다식 우선순위를 미루더라도, 나중에 꼭 공부해보기
// >> Stream으로 작업

public class StudentManager3 implements Program{
// 3. 기존에 작성한 학생 정보 출력 프로그램에 Stream을 적용해보세요.
	
	//private StudentManager3 student = new StudentManager3(); //자기자신을 생성하면 안됨.
	
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
		Stream<Student> stream = list.stream(); // Stream 
		switch(menu) {
		case 1: //학생 전체 출력
			stream.forEach(std->System.out.println(std));
			break;
			
		// 람다식 안에는 지역변수를 쓸수있지만, 상수만 쓸 수 있다. 
		// final을 붙여서 상수화 하면 쓸 수 있음
			
		case 2: // 학생 학년 출력
			// 검색할 학년 입력
			System.out.println("grade : ");
			final int grade1 = sc.nextInt();
			
			stream
			/* filter는 매개변수로 Predicate 인터페이스의 객체가 필요
			 * Predicate를 구현한 익명클래스를 람다식으로 만든 후에 객체를 생성해서 전달
			 * (std는 매개변수 이름이기 때문에 다른 이름으로 수정해도 무관)*/
				.filter(std -> std.getGrade() == grade1)
				.forEach(std->System.out.println(std));
			break;
			
		case 3: // 학생 검색 출력
			// 검색할 학년, 반, 번호 입력
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
