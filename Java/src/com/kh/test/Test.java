package com.kh.test;

import java.util.Scanner;

public class Test {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("���ڿ��� �Է����ּ��� : ");
			String str = sc.next();
			
			if(str == "exit") {
				System.out.println("���α׷��� �����մϴ�. ");
				break;
			}else { 
			System.out.println(str.length() + "���� �Դϴ�");
			break;
			}
				
		}
	}

}

//			
//			if(str == "exit") 
//				break;
//			} else {
//				System.out.println(str.length() + "���� �Դϴ�.");
//				break;
//			}
//			System.out.println("���α׷��� �����մϴ�");
//			