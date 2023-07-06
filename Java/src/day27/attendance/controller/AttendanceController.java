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
	
	// �⼮�� ��ü ����
	private AttendanceBook book = new AttendanceBook();
	//List<Student> studentList = new ArrayList<>();
	
	private final static int EXIT = 4;
	
	public void printMenu() {
		System.out.println("---------");
		System.out.println("�޴�");
		System.out.println("1. �л� ���");
		System.out.println("2. �⼮ üũ");
		System.out.println("3. �⼮�� Ȯ��");
		System.out.println("4. ����");
		System.out.println("�޴� ���� : ");
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
		case 1: // �л����
			insertStudent();
			break;
		case 2: // �⼮ ����
			attendanceCheck();
			break;
		case 3: // �⼮�� Ȯ��
			printAttendance();
			break;
		case 4: // ����
			System.out.println("���α׷��� �����մϴ�.");
			break;
		default:
			System.out.println("�߸��� �޴��Դϴ�. ");
		}
	}
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	// �޼ҵ�1 : �л� ���
	private void insertStudent() {
		// ���� �Է� (�й�, �̸�)
		System.out.print("�й� : ");
		String num = sc.next();
		
		sc.nextLine(); 
		System.out.print("�̸� : ");
		String name = sc.nextLine();
		
		// �⼮�ο� �� �л��� �߰�
		// �Է¹��� ������ �̿��Ͽ� �л� ��ü�� ����
		Student std = new Student(num, name);
		
		// ������ �л� ��ü�� (�⼮�ο�) �߰�
		boolean insertSuccess = book.insertStudent(std); // << �⼮�ΰ�
		// �߰��� �����ϸ� �����ߴٰ�, �����ϸ� �����ߴٰ� ���
		if(insertSuccess) {
			System.out.println("�л� ���� ��� ����");
		}else {
			System.out.println("�л� ���� �߰� ����");
		}
//		// * �Է� ������ �̿�, �л� ��ü ����
//		
//		if(studentList.contains(student)) {
//			System.out.println("�̹� ��ϵ� �й��Դϴ�. Ȯ�����ּ���");
//			return;
//		}
//		
//		// * �л� ����Ʈ�� �л� ��ü�� �߰�
//		studentList.add(student);
//		System.out.println(studentList);
	}

	// �޼ҵ�2 : �⼮ ����
	private void attendanceCheck() {
		// ��¥ �Է�
		System.out.print("��¥(yyyy-MM-dd) : ");
		String dateStr = sc.next();
		
		// ��¥�� ����� �Էµƴ��� üũ
		// SimpleDateFormat�� �̿�
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					try {
				date = format.parse(dateStr);
			} catch (ParseException e) {
				System.out.println("��¥ ������ �ƴմϴ�.");
				return;
			}
		
		// �⼮�ο��� �л� �������� �����ͼ� ����
		// => �⼮�ο� �л��������� ���������� �߰� �۾�
		List<Student> stdList = book.getStdList();
		// �ݺ���
		for(Student tmp : stdList) {
		// �л����� ���, �⼮���� �Է�
			// �л������� ���
			System.out.print(tmp + " : ");
			// �л��� ����� �Է�(O or X)
			char state;
			do {
				state = sc.next().charAt(0);
			}while(state != 'O' && state != 'X');
			
			// �⼮�ο� üũ
			// �л�����, ����� �̿��Ͽ� '�⼮ ��ü'�� ����
			// ���߿� �л� ���� ����� �߰��Ǿ ���� �⼮ ����� �����Ǹ� �ȵǱ� ������
			// ���� �����ڸ� �̿�(new Student(tmp) >> class Student ���������)
			Attendance attendance = new Attendance(date, new Student(tmp), state); 			
			// �⼮�ο� �⼮ ��ü�� �߰�
			// AttendanceBook�� �⼮ ��ü�� �־����� '�⼮ ��ܿ� �߰�'�ϴ� �۾�
			if(!book.insertAttendance(attendance)) {
				System.out.println("�̹� ��ϵ� �⼮�Դϴ�.");
			}else {
				System.out.println("�⼮üũ�� �߽��ϴ�.");
			}
		}
		System.out.println(book.getList()); // test��
	}

	// �޼ҵ�3 : �⼮�� Ȯ�� 
	private void printAttendance() {
		// �⼮�ο� �ִ� ��� �⼮ ������ Ȯ��
		book.printAttendance(); // �⼮������ �ñ���!!
		// ��¥
		// �л�����
		
	}
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	// ����� �ҷ����� �ҽ��ڵ�
	private void save(String fileName) {
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
				// ������ : D:\\.student / �������(������Ʈ ����)
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				// ��� ������Ʈ���� ��ݽ�Ʈ���� �ʿ��ϴ�
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
			System.out.println("�ҷ��� ������ �����ϴ�.");
			// ���ܸ� �̿��ؼ� �����б⸦ ������ / IOException�� �θ�Ŭ������ ���� ��ġ
		} catch(EOFException e) {
			System.out.println("�ҷ����� �Ϸ�");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("AttendanceBook Ŭ������ ã�� �� �����ϴ�.");
		}	
	} // ==> ��ǲ �ƿ�ǲ �� ������ voŬ������ Serializable ���ַ� ������@!!
	
}
