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
		// 1. ���� �߱� ������ �����ϼ���
		// 1 ~ 9 ������ �ߺ����� ���� �� ���� ���ߴ� ����
		// ��Ģ : 
		/* B : ���� ���ڰ� ������ ��ġ�� �ٸ�
		 * S : ���� ���ڰ� �ְ� ��ġ�� ����
		 * 3O : ��ġ�ϴ� ���ڰ� �ϳ��� ����
		 * => 3S�� ����°� ����!
		 */
		
		// 1. ������� ���� 3���� �������� ����(�ߺ�x)!
		int com[] = new int[3];
		int user[] = new int[3];
		
		int min = 1, max = 9;
		int strike = 0;
		int ball = 0;
		int gameCount = 0;
		
 		// ������ ���� 3��
		Scanner sc = new Scanner(System.in);
		
		//load(fileName);
		System.out.println("�߱� ���� ����!");
		Array.createRandomArray(min, max, com);
		Array.printArray(com);

		// 2+3. �ݺ���(������ �Է��ϰ� �Ǻ��ؾ���)
		do {
			System.out.println("���� 3���� �Է��ϼ���");
			System.out.print("user : ");
			for(int i = 0; i < user.length; i++) {
				user[i] = sc.nextInt();
			}
			
			if(Array.arrayCheck(user)) {
				System.out.println("�ߺ��� ���� �Է����� ������!");
				continue;
			}
			
			// 3. �Ǻ�!
			strike = 0; 
			ball = 0;
			
			strike = strike(com, user);
			System.out.println("S : "  + strike);
			
			ball = ball(com, user);
			System.out.println("B : " + ball);
			
			gameCount++; // * 
			System.out.println("���� Ƚ�� : " + gameCount+ "ȸ"); // *

			printResult(strike, ball);
			
			
		} while(strike < 3);
		
		System.out.println("Good!");
		System.out.println("�� ���� Ƚ�� : " + gameCount + "ȸ"); // *
		//save(fileName);
		sc.close();
	}
	
	


	//�޼ҵ�1: strike �Ǻ�
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
	
	// �޼ҵ�2 : ball �Ǻ�
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
	
	//�޼ҵ�3 : ��Ʈ����ũ�� ���� ������ �־����� ��� ���
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
	
//�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�
//	private static void save() {
//		try(
//			FileOutputStream fos = new FileOutputStream(fileName);
//				// ������ : D:\\.student / �������(������Ʈ ����)
//			ObjectOutputStream oos = new ObjectOutputStream(fos)){
//				// ��� ������Ʈ���� ��ݽ�Ʈ���� �ʿ��ϴ�
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
//			System.out.println("�ҷ��� ������ �����ϴ�.");
//			// ���ܸ� �̿��ؼ� �����б⸦ ������ / IOException�� �θ�Ŭ������ ���� ��ġ
//		} catch(EOFException e) {
//			System.out.println("�ҷ����� �Ϸ�");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}		System.out.println(list);		
//	}
//
}
