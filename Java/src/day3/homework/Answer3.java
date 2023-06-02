package day3.homework;

import java.util.Scanner;

public class Answer3 {

	public static void main(String[] args) {
		//성별(M:남성,W:여성)를 입력받아 M이면 남성을, W이면 여성을 출력하는 코드를 작성하세요. if문 이용
		
		//문자로
		char gender;
		System.out.println("input gender : ");
		Scanner scan = new Scanner(System.in);
		gender = scan.next().charAt(0);//문자하나 입력받기 / .charAt(0);
		String result = "";//출력문이 두개 있는게 싫으면
				
		//조건연산자 >> if 문으로
		if (gender == 'M') { // if(gender.equals(Man)) 도 똑같은건가? 위에 MAN, WOMAN, result 변수 선언 안해도되나?? 
			// a = b 가 아니고, 문자열이 '같다'는 '=='
			//System.out.println("Are you a woman? " + "man");
			result = "man";
		}
		
		if (gender == 'W') {
			//System.out.println("Are you a woman? " + "woman");
			result = "woman";
		}
		
		System.out.println("Are you a woman? " + result); // 출력문에 뒤에만 다르기 때문에 result 를 선언해봄
		
		
		
		scan.close();
		
	}

}
