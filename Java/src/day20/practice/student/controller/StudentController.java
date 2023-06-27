package day20.practice.student.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day20._122_collection.Student;

public class StudentController implements Program {
	
	private final static int EXIT = 4;
	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<Student> list = new ArrayList<Student>(); // 학생을 관리하기 위한 list
	
	@Override
	public void run() {
		System.out.println("프로그램 시작!");
		
		int menu;
		
		do {
			try {
				printMenu();
				menu = sc.nextInt();
				
				runMenu(menu);
			}catch(InputMismatchException e) {
				menu = EXIT -1;// 종료 메뉴가 아닌 아무 메뉴를 추가
				sc.nextLine();// 앞에서 잘못 입력한 내용을 비워줌 / 왜 넥스트라인이..?ㅜ
				System.out.println("입력이 잘못되었습니다.");
			}
		}while(menu != EXIT);
	}
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴를 선택하세요 : ");
	}

	@Override
	public void runMenu(int menu) {
		System.out.println("기능 실행 중");
		switch(menu) {
		case 1: //학생 추가
			insertStudent();
			break;
		case 2: // 학생 수정
			updateStudent();
			break;
		case 3: // 학생 삭제 
			deleteStudent();
			break;
		case 4: 
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}

	private void deleteStudent() {
		// 삭제할 학생 정보를 입력(학년, 반, 번호) << 이거로만 equals를 판별하기로 정했기 때문
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int classNum = sc.nextInt();
		System.out.println("번호 : ");
		int number = sc.nextInt();
		
		// 삭제할 학생 정보를 이용하여 학생 객체를 생성
		Student tmp = new Student(grade, classNum, number, null);
		
		// 삭제를 시도해서 성공하면 성공했다고, 실패하면 실패했다고 알려주기
		if(list.remove(tmp)) {
			//삭제 성공! remove == true
			System.out.println("삭제 성공");
			return;
		}
		System.out.println("삭제 실패");
	}

	private void updateStudent() {
		// 수정할 학생의 정보를 입력(학년, 반, 번호) << 이거로만 equals를 판별하기로 정했기 때문
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int classNum = sc.nextInt();
		System.out.println("번호 : ");
		int number = sc.nextInt();
		
		// 수정할 학생이 있는지 없는지 확인
		// ㄴ학생 객체를 생성!
		Student tmp = new Student(grade, classNum, number, null);
		int index = list.indexOf(tmp); // 학생정보를 수정할때, index를 이용하려고
		// 없으면 종료 or 추가할건지 확인 후 추가
		if(index == -1) {
			System.out.println("업데이트 실패");
			return;
		}
		
		// 수정될 학생 정보를 입력(다시 다 입력. 학년, 반, 번호, 이름)
		System.out.println("학년 : ");
		grade = sc.nextInt();
		System.out.println("반 : ");
		classNum = sc.nextInt();
		System.out.println("번호 : ");
		number = sc.nextInt();
		sc.nextLine(); // number를 입력하고 난 뒤, 엔터에 의한 공백을 처리하기 위해
		String name = sc.nextLine();
		
		// 학생 정보를 수정
		// ㄴ 수정될 학생 정보가 이미 있는 학생인지 확인
		// 수정될 정보를 이용하여 학생 객체를 생성
		tmp = new Student(grade, classNum, number, name);
		// 학년, 반, 번호가 일치하는 학생이 있는지 확인해서 있으면 종료
		if(list.contains(tmp)) {
			System.out.println("업데이트 실패");
			return;
		}
		list.get(index).update(grade, classNum, number, name); // 어려웡어어어어엉ㅇㅇㅇ
		//ㄴ주소를 아니까 바로 바꿔버림 // create 해서 StudentC 클래스에 생성자 입력(this.)
		System.out.println("업데이트 성공");
	}

	private void insertStudent() {
		// 추가할 학생의 정보를 입력(학년, 반, 번호, 이름)
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int classNum = sc.nextInt();
		System.out.println("번호 : ");
		int number = sc.nextInt();
		sc.nextLine(); // number를 입력하고 난 뒤, 엔터에 의한 공백을 처리하기 위해
		String name = sc.nextLine();
		
		// 입력받은 정보를 이용하여 학생 객체를 생성  
		Student std = new Student(grade, classNum, number, name);
		// 학생리스트에 추가
		// 해당 학생이 있는지 없는지 확인(학년, 반, 번호만 체크)해서 없으면 추가
		if(!list.contains(std)) { // contains => equals를 오버라이딩 했다는 전재하에
			list.add(std);
			System.out.println("학생 입력 성공!");
			return; // 밑에 else쓰기 싫어서래 ㅋㅋ 
		}
		// 추가 성공하면 추가했다고, 실패하면 실패했다고 콘솔창에 알려주기
		System.out.println("학생 입력 실패!");
		
	} 
}
