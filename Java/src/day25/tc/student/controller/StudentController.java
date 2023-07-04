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
			// 메뉴 출력
			//printMenu();
			System.out.println("메뉴");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생확인");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			
			// 메뉴 선택(메뉴를 입력받음) : Scanner 필요
			menu = sc.nextInt();
			
			// 선택된 메뉴에 따른 기능을 실행
			//runMenu(menu);
			switch(menu){
			case 1: // 학생 등록
				// 학생정보 입력 - 학번 이름 학과
				// 학번(문자열, 공백 없는)
				System.out.print("학번 : ");
				num = sc.next();
				// 이름(문자열, 공백 있는)
				System.out.print("이름 : ");
				sc.nextLine();
				name = sc.nextLine();
				// 학과(문자열, 공백 있는)
				System.out.print("학과 : ");
				major = sc.nextLine();
			
				// 학생정보 리스트에 저장
				// 입력한 정보를 이용하여 학생 객체를 생성
				tmp = new Student(num,name, major);
				
				// 리스트에 (학생 객체를) 추가
				list.add(tmp);
				System.out.println(list);
				
				break;
			case 2: // 학생 전체를 확인
				for(Student tmp2 : list) {
					System.out.println(tmp2);
				}
				break;
			case 3:
				System.out.println("시스템을 종료합니다");
				break;
			default:
			}
		}while(menu != EXIT);
		sc.close();
	}
	
}
