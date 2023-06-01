package day3.homework;

import java.util.Scanner;

public class Ex2_if {

	public static void main(String[] args) {
		// 성별(M:남성,W:여성)를 입력받아 M이면 남성을, W이면 여성을 출력하는 코드를 작성하세요. if문 이용
		
		Scanner sc = new Scanner(System.in);
		String WOMEN = "W";
		String MAN = "M";
		String result = "";
		
		while(true) {
			System.out.println("input gender : ");
			String gender = sc.next();

			if(WOMEN.equals(gender)) {
				result = "women";
			}
			
			if(MAN.equals(gender)) {
				result = "man";
			}
			
			System.out.println("Are you a woman? " + result);
			
//			String m = "man";
//			String w = "woman";
//			String result = true;
//			if(result == m) { // gender == "M" -> "M" //// "W" -> "W"
//				System.out.println("Are you a woman? " + result); //  Are you a woman? M / W
//				
//			}
	
		}
	}

}

/*Scanner sc = new Scanner(System.in);
System.out.println("Input score : ");
int score = sc.nextInt(); 

String result = score >= 60 ? "pass" : "fail";// in result 媛� ���� String 蹂���濡� 諛����쇳��(pass/fail�� 媛��쇰� 諛����쇳�댁��)
System.out.println("Do you pass " + score + " points? : " + result);

sc.close();
*/