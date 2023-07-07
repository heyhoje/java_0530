package com.kh.test;

import java.util.Scanner;

public class Test {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		while(true) {
			System.out.print("문자열을 입력해주세요 : ");
			String str = sc.next();
			
			if(str == "exit") {
				System.out.println("프로그램을 종료합니다. ");
				break;
			}else { 
			System.out.println(str.length() + "글자 입니다");
			break;
			}
				
		}
	}

}

//			
//			if(str == "exit") 
//				break;
//			} else {
//				System.out.println(str.length() + "글자 입니다.");
//				break;
//			}
//			System.out.println("프로그램을 종료합니다");
//			