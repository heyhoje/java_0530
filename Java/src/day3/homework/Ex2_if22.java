package day3.homework;

import java.util.Scanner;

public class Ex2_if22 {

	public static void main(String[] args) {
		// 성별(M:남성,W:여성)를 입력받아 M이면 남성을, W이면 여성을 출력하는 코드를 작성하세요. if문 이용
		
		Scanner sc = new Scanner(System.in);
		String WOMAN = "W";
		String MAN = "M";
		String result = "";
		
			System.out.println("input gender : ");
			String gender = sc.next();
			
			if(gender.equals(WOMAN)) {
				result = "woman";
			}
		
			if(gender.equals(MAN)) {
				result = "man";
			}
		
			System.out.println("Are you a women? " + result);
		
	}

}