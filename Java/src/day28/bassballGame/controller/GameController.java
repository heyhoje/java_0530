package day28.bassballGame.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import day27.attendance.vo.AttendanceBook;
import day28.bassballGame.vo.BaseballGame;
import day28.bassballGame.vo.Record;

public class GameController {

	Scanner sc = new Scanner(System.in);
	private BaseballGame bbGame;
	private List<Record> recordList = new ArrayList<>(); // *��ü ����-> ��ü ���� ����Ʈ �����ϰ�
	
	
	public void run() {
		int menu;
		String fileName = "baseball.txt";
		load(fileName);
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != 3);
		save(fileName);
	}

	

	private void printMenu() {
		System.out.println("-----------");
		System.out.println("MENU");
		System.out.println("1. Play");
		System.out.println("2. Record");
		System.out.println("3. Exit");
		System.out.println("Select : ");
		System.out.println("-----------");
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1: 
			play();
			break;
		case 2:
			recordGame();
			break;
		case 3:
			System.out.println("EXIT");
			break;
		default: 
			System.out.println("Wrong Menu!");
		}
	}

	// �޼ҵ�1 : ���� �÷���
	private void play() {
		// ���� �� ����
		bbGame = new BaseballGame();
		
		// ���⶧���� �ݺ�
		List<Integer> user = new ArrayList<>();
		int count = 0;
		do {
			// ����ڰ� �Է�
			System.out.println("user : ");
			for(int i = 0; i < 3; i++) {
				user.add(sc.nextInt());
			}
			// �Է��� ���� ���ӿ� �־��ְ�, 
			// �Է��� ���� �ߺ��ǰų� ������ �Ѿ�� '�߸��� ��'�Է��ߴٰ� ��� 
			if(!bbGame.setUser(user)) {
				System.out.println("Duplicated or Out of bounds");
				continue; // ������ �ݺ����� �����??�� �ǹ�???
			}
			// ��� ���
			bbGame.printResult();
			user.clear();
			count++;
			
		}while(bbGame.getStrike() != 3);
		// ��ϰ��� (��������x)
		System.out.print("input name : ");
		String name = sc.next();
		Record record = new Record(name, count); // *��ϵ��� ������ ����Ʈ ���鷯 ��������!
		recordList.add(record);
	}

	// �޼ҵ�2 : ���� ����
	private void recordGame() {
		Collections.sort(recordList, (o1,o2)->{
			return o1.getCount() - o2.getCount(); // �� ���°ɱ�... �����Ѵٸ�.....
		});
		recordList.stream().forEach(r->System.out.println(r));
	}
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
	// ����� �ҷ����� �ҽ��ڵ�
	private void save(String fileName) {
		try(
				FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(recordList);
			} catch (IOException e) {
				e.printStackTrace();
			}					
	}

	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			recordList = (List<Record>)ois.readObject(); // recordList�� ����
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			// ���ܸ� �̿��ؼ� �����б⸦ ������ / IOException�� �θ�Ŭ������ ���� ��ġ
		} 
//		catch(EOFException e) {
//			System.out.println("Load success");
//		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}	
	} // ==> ��ǲ �ƿ�ǲ �� ������ voŬ������ Serializable ���ַ� ������@!!		

}
