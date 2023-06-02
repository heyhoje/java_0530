package day3.homework;

import java.util.Scanner;

public class Answer2 {

	public static void main(String[] args) {
		//숫자를 입력받아서 했다면, m이라는 문자열을 받아서 처리하는 문제
		//문자열을 받아서 처리할 수 있는지 확인하는 문제
		
		/*Ex1. 성별(M:남성, W:여성)을 입력받아 여성인지 확인하는 코드를 작성하세요.
		input gender : M
		Are you a women? false
		
		input gender : W
		Are you a women? true
		*/
		// 1. 문자 2. 문자열 을 입력받는방법
		
		//문자열로 어떻게 하는지 
		String gender;//필요한 변수선언
		System.out.println("input gender : "); // 출력
		Scanner scan = new Scanner(System.in); //입력받아야하니까
		// gender = scan.next().charAt(0); // 빈문자열이 들어가지 않도록 //빈문자열은 존재가능 "", 빈문자는 불가능'' 
										// next(); 가능 / nextLine(); 불가능
		gender = scan.next();
		
		// boolean result = gender == 'M' ? false : true; / m이아닌 모든 문자를 여성으로 인식할 수 있음
		boolean result = gender.equals("W") ? true : false; //문자열 equals
		System.out.println("Are you a women? " + result);//출력문구

		
		scan.close();
	}

}
