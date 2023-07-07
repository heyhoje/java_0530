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
	private List<Record> recordList = new ArrayList<>(); // *객체 생성-> 객체 담을 리스트 생성하고
	
	
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

	// 메소드1 : 게임 플레이
	private void play() {
		// 랜덤 수 생성
		bbGame = new BaseballGame();
		
		// 맞출때까지 반복
		List<Integer> user = new ArrayList<>();
		int count = 0;
		do {
			// 사용자가 입력
			System.out.println("user : ");
			for(int i = 0; i < 3; i++) {
				user.add(sc.nextInt());
			}
			// 입력한 값을 게임에 넣어주고, 
			// 입력한 값이 중복되거나 범위가 넘어가면 '잘못된 값'입력했다고 출력 
			if(!bbGame.setUser(user)) {
				System.out.println("Duplicated or Out of bounds");
				continue; // 나가서 반복문을 계속함??의 의미???
			}
			// 결과 출력
			bbGame.printResult();
			user.clear();
			count++;
			
		}while(bbGame.getStrike() != 3);
		// 기록관리 (개수제한x)
		System.out.print("input name : ");
		String name = sc.next();
		Record record = new Record(name, count); // *기록들을 관리할 리스트 만들러 위로위로!
		recordList.add(record);
	}

	// 메소드2 : 게임 저장
	private void recordGame() {
		Collections.sort(recordList, (o1,o2)->{
			return o1.getCount() - o2.getCount(); // 왜 빼는걸까... 정렬한다며.....
		});
		recordList.stream().forEach(r->System.out.println(r));
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 저장과 불러오기 소스코드
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
			recordList = (List<Record>)ois.readObject(); // recordList로 변경
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			// 예외를 이용해서 파일읽기를 마무리 / IOException이 부모클래스라 위에 배치
		} 
//		catch(EOFException e) {
//			System.out.println("Load success");
//		} 
		catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class Not Found");
		}	
	} // ==> 인풋 아웃풋 다 썼으면 vo클래스에 Serializable 해주러 가야함@!!		

}
