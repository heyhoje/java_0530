package day27.attendance.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day26.Library.vo.LoanBrowsing;
import day27.attendance.vo.Attendance;
import day27.attendance.vo.AttendanceBook;
import day27.attendance.vo.Student;

public class AttendanceController {

	Scanner sc = new Scanner(System.in);
	
	// 출석부 객체 생성
	private AttendanceBook book = new AttendanceBook();
	//List<Student> studentList = new ArrayList<>();
	
	private final static int EXIT = 4;
	
	public void printMenu() {
		System.out.println("---------");
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 출석 체크");
		System.out.println("3. 출석부 확인");
		System.out.println("4. 종료");
		System.out.println("메뉴 선택 : ");
		System.out.println("---------");
	}
	
	public void run() {
		int menu;
		String fileName = "src/day27/attendance/attendancebook.txt";
				
		load(fileName);
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
		save(fileName);
		
		sc.close();
	}
	

	public void runMenu(int menu) {
		switch(menu) {
		case 1: // 학생등록
			insertStudent();
			break;
		case 2: // 출석 여부
			attendanceCheck();
			break;
		case 3: // 출석부 확인
			printAttendance();
			break;
		case 4: // 종료
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다. ");
		}
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 메소드1 : 학생 등록
	private void insertStudent() {
		// 정보 입력 (학번, 이름)
		System.out.print("학번 : ");
		String num = sc.next();
		
		sc.nextLine(); 
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		// 출석부에 새 학생을 추가
		// 입력받은 정보를 이용하여 학생 객체를 생성
		Student std = new Student(num, name);
		
		// 생성된 학생 객체를 (출석부에) 추가
		boolean insertSuccess = book.insertStudent(std); // << 출석부가
		// 추가에 성공하면 성공했다고, 실패하면 실패했다고 출력
		if(insertSuccess) {
			System.out.println("학생 정보 등록 성공");
		}else {
			System.out.println("학생 정보 추가 실패");
		}
//		// * 입력 정보를 이용, 학생 객체 생성
//		
//		if(studentList.contains(student)) {
//			System.out.println("이미 등록된 학번입니다. 확인해주세요");
//			return;
//		}
//		
//		// * 학생 리스트에 학생 객체를 추가
//		studentList.add(student);
//		System.out.println(studentList);
	}

	// 메소드2 : 출석 여부
	private void attendanceCheck() {
		// 날짜 입력
		System.out.print("날짜(yyyy-MM-dd) : ");
		String dateStr = sc.next();
		
		// 날짜가 제대로 입력됐는지 체크
		// SimpleDateFormat을 이용
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					try {
				date = format.parse(dateStr);
			} catch (ParseException e) {
				System.out.println("날짜 형식이 아닙니다.");
				return;
			}
		
		// 출석부에서 학생 정보들을 가져와서 저장
		// => 출석부에 학생정보들을 가져오도록 추가 작업
		List<Student> stdList = book.getStdList();
		// 반복문
		for(Student tmp : stdList) {
		// 학생정보 출력, 출석여부 입력
			// 학생정보를 출력
			System.out.print(tmp + " : ");
			// 학생의 출결을 입력(O or X)
			char state;
			do {
				state = sc.next().charAt(0);
			}while(state != 'O' && state != 'X');
			
			// 출석부에 체크
			// 학생정보, 출결을 이용하여 '출석 객체'를 생성
			// 나중에 학생 삭제 기능이 추가되어도 기존 출석 기록은 삭제되면 안되기 때문에
			// 복사 생성자를 이용(new Student(tmp) >> class Student 복사생성자)
			Attendance attendance = new Attendance(date, new Student(tmp), state); 			
			// 출석부에 출석 객체를 추가
			// AttendanceBook에 출석 객체가 주어지면 '출석 명단에 추가'하는 작업
			if(!book.insertAttendance(attendance)) {
				System.out.println("이미 등록된 출석입니다.");
			}else {
				System.out.println("출석체크를 했습니다.");
			}
		}
		System.out.println(book.getList()); // test용
	}

	// 메소드3 : 출석부 확인 
	private void printAttendance() {
		// 출석부에 있는 모든 출석 정보를 확인
		book.printAttendance(); // 출석부한테 맡기자!!
		// 날짜
		// 학생정보
		
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 저장과 불러오기 소스코드
	private void save(String fileName) {
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
				// 절대경로 : D:\\.student / 상대정보(프로젝트 기준)
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				// 모든 보조스트림은 기반스트림이 필요하다
			oos.writeObject(book);
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}

	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			book = (AttendanceBook)ois.readObject();
			
		} catch (FileNotFoundException e) {
			System.out.println("불러올 파일이 없습니다.");
			// 예외를 이용해서 파일읽기를 마무리 / IOException이 부모클래스라 위에 배치
		} catch(EOFException e) {
			System.out.println("불러오기 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("AttendanceBook 클래스를 찾을 수 없습니다.");
		}	
	} // ==> 인풋 아웃풋 다 썼으면 vo클래스에 Serializable 해주러 가야함@!!
	
}
