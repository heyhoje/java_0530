package review_0706.bassballGame;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import array.Array;
import day25.tc.student.vo.Student;

public class BassballGameEx {
	public static void main(String[] args) {
		// 1. 숫자 야구 게임을 구현하세요
		// 1 ~ 9 사이의 중복되지 않은 세 수를 맞추는 게임
		// 규칙 : 
		/* B : 같은 숫자가 있지만 위치가 다름
		 * S : 같은 숫자가 있고 위치가 같음
		 * 3O : 일치하는 숫자가 하나도 없음
		 * => 3S를 만드는게 목적!
		 */
		
		// 1. 맞춰야할 숫자 3개를 랜덤으로 생성(중복x)!
		int com[] = new int[3];
		int user[] = new int[3];
		
		int min = 1, max = 9;
		int strike = 0;
		int ball = 0;
		int gameCount = 0;
		
 		// 랜덤한 정수 3개
		Scanner sc = new Scanner(System.in);
		
		//load(fileName);
		System.out.println("야구 게임 시작!");
		Array.createRandomArray(min, max, com);
		Array.printArray(com);

		// 2+3. 반복문(여러번 입력하고 판별해야함)
		do {
			System.out.println("숫자 3개를 입력하세요");
			System.out.print("user : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			
			if(Array.arrayCheck(user)) {
				System.out.println("중복된 수를 입력하지 마세요!");
				continue;
			}
			
			// 3. 판별!
			strike = 0; 
			ball = 0;
			
			strike = strike(com, user);
			System.out.println("S : "  + strike);
			
			ball = ball(com, user);
			System.out.println("B : " + ball);
			
			gameCount++; // * 
			System.out.println("도전 횟수 : " + gameCount+ "회"); // *

			printResult(strike, ball);
			
			
		} while(strike < 3);
		
		System.out.println("Good!");
		System.out.println("총 도전 횟수 : " + gameCount + "회"); // *
		//save(fileName);
		sc.close();
	}
	
	


	//메소드1: strike 판별
	public static int strike(int arr1[], int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0 ;
		}
		
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	
	// 메소드2 : ball 판별
	public static int ball(int arr1[], int arr2[]) {
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		
		int count = 0;
		
		for(int tmp : arr1) {
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1, arr2);	
	}
	
	//메소드3 : 스트라이크와 볼의 개수가 주어지면 결과 출력
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.println(strike + "S");
		}
		if(ball != 0) {
			System.out.println(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.println("3OUT");
		}
		System.out.println();
	}
	
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
//	private static void save() {
//		try(
//			FileOutputStream fos = new FileOutputStream(fileName);
//				// 절대경로 : D:\\.student / 상대정보(프로젝트 기준)
//			ObjectOutputStream oos = new ObjectOutputStream(fos)){
//				// 모든 보조스트림은 기반스트림이 필요하다
//				for(Student tmp : list) {
//					oos.writeObject(tmp);
//					//public class Student implements Serializable {
//					//** add generated sirialversionUID
//				}
//		} catch (IOException e) {
//			e.printStackTrace();
//			}		
//	}
//
//
//	private static void load() {
//		try(ObjectInputStream ois 
//				= new ObjectInputStream(new FileInputStream(fileName))){
//			while(true) {
//				try {
//					Student tmp = (Student)ois.readObject();
//					list.add(tmp);
//				} catch (ClassNotFoundException e) {
//					e.printStackTrace();
//				}
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("불러올 파일이 없습니다.");
//			// 예외를 이용해서 파일읽기를 마무리 / IOException이 부모클래스라 위에 배치
//		} catch(EOFException e) {
//			System.out.println("불러오기 완료");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		System.out.println(list);		
//	}
//
}
