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
			// �޴� ���
			printMenu();
			
			
			// �޴� ����(�޴��� �Է¹���) : Scanner �ʿ�
			menu = sc.nextInt();
			
			// ���õ� �޴��� ���� ����� ����
			runMenu(menu);
			
		}while(menu != EXIT);
		save(fileName);
		sc.close();
	}
	
	private void save(String fileName) {
		// �л� ������ ���� => ����Ʈ => �ϳ��� ������ ����
		// ���� => (�ڵ� -> ����) OutputStream
		// ��ü������ ���� => objectOutputStream
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
				// ������ : D:\\.student / �������(������Ʈ ����)
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				// ��� ������Ʈ���� ��ݽ�Ʈ���� �ʿ��ϴ�
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
			System.out.println("�ҷ��� ������ �����ϴ�.");
			// ���ܸ� �̿��ؼ� �����б⸦ ������ / IOException�� �θ�Ŭ������ ���� ��ġ
		} catch(EOFException e) {
			System.out.println("�ҷ����� �Ϸ�");
		} catch (IOException e) {
			e.printStackTrace();
		}		System.out.println(list);
	}
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	private void printMenu() { // �Ű����� : ������ ���� => ����
		System.out.println("�޴�");
		System.out.println("1. �л����");
		System.out.println("2. �л�Ȯ��");
		System.out.println("3. ����");
		System.out.print("�޴� ���� : ");
	}
	
	private void runMenu(int menu) { 
		// �ش��ϴ� ���� �ٷ� �����ϸ� x, ����ϸ� => �ް�������
		// ��������
		String num, name, major;
		Student tmp;
		switch(menu){
		case 1: // �л� ���
			// �л����� �Է� - �й� �̸� �а�
			insertStudent();
			
			break;
			
		case 2: // �л� ��ü�� Ȯ��
			print();	
			
			break;
		case 3:
			System.out.println("�ý����� �����մϴ�");
			break;
		default:
		}
		
		
	}
	
	public void insertStudent() {
		String num, name, major;
		Student tmp;
		
		// �й�(���ڿ�, ���� ����)
		System.out.print("�й� : ");
		num = sc.next();
		// �̸�(���ڿ�, ���� �ִ�)
		System.out.print("�̸� : ");
		sc.nextLine();
		name = sc.nextLine();
		// �а�(���ڿ�, ���� �ִ�)
		System.out.print("�а� : ");
		major = sc.nextLine();
		
		// �л����� ����Ʈ�� ����
		// �Է��� ������ �̿��Ͽ� �л� ��ü�� ����
		tmp = new Student(num,name, major);
					
		// ����Ʈ�� (�л� ��ü��) �߰�
		list.add(tmp);
		//System.out.println(list);
	}
	
	public void print() {
		for(Student tmp2 : list) {
			System.out.println(tmp2);
		}
	}	
}
