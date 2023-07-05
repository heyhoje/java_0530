package day25.tc.student.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.tc.student.vo.Student;

public class StudentController4 {
	
	int menu;
	//String name, num, major;
	List<Student> list = new ArrayList<>();
	//Student tmp;
	
	Scanner sc = new Scanner(System.in);
	private final static int EXIT = 3;
	
	public void run() throws ClassNotFoundException {
		int menu;
		String fileName = "src/day25/tc.student/student.txt";
		load(fileName);
		do {
			// 메뉴 출력
			printMenu();
			
			
			// 메뉴 선택(메뉴를 입력받음) : Scanner 필요
			menu = sc.nextInt();
			
			// 선택된 메뉴에 따른 기능을 실행
			runMenu(menu);
			
		}while(menu != EXIT);
		save(fileName);
		sc.close();
	}
	
	private void save(String fileName) {
		// 학생 정보를 저장 => 리스트 => 하나씩 꺼내서 저장
		// 저장 => (코드 -> 파일) OutputStream
		// 객체단위로 저장 => objectOutputStream
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
				// 절대경로 : D:\\.student / 상대정보(프로젝트 기준)
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				// 모든 보조스트림은 기반스트림이 필요하다
				for(Student tmp : list) {
					oos.writeObject(tmp);
					//public class Student implements Serializable {
					//** add generated sirialversionUID
				}
		} catch (IOException e) {
			e.printStackTrace();
			}
	}

	private void load(String fileName) throws ClassNotFoundException {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			while(true) {
				try {
					Student tmp = (Student)ois.readObject();
					list.add(tmp);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
			// 예외를 이용해서 파일읽기를 마무리 / IOException이 부모클래스라 위에 배치
		} catch(EOFException e) {
			System.out.println("불러오기 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}		System.out.println(list);
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	private void printMenu() { // 매개변수 : 고정된 내용 => 없음
		System.out.println("메뉴");
		System.out.println("1. 학생등록");
		System.out.println("2. 학생확인");
		System.out.println("3. 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	private void runMenu(int menu) { 
		// 해당하는 값을 바로 변경하면 x, 사용하면 => 메개변수로
		// 지역변수
		String num, name, major;
		Student tmp;
		switch(menu){
		case 1: // 학생 등록
			// 학생정보 입력 - 학번 이름 학과
			insertStudent();
			
			break;
			
		case 2: // 학생 전체를 확인
			print();	
			
			break;
		case 3:
			System.out.println("시스템을 종료합니다");
			break;
		default:
		}
		
		
	}
	
	public void insertStudent() {
		String num, name, major;
		Student tmp;
		
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
		//System.out.println(list);
	}
	
	public void print() {
		for(Student tmp2 : list) {
			System.out.println(tmp2);
		}
	}	
}
