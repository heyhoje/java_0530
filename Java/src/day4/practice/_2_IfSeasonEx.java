package day4.practice;

import java.util.Scanner;

public class _2_IfSeasonEx {

	public static void main(String[] args) {
		// 월을 입력받아 입력받은 월의 계절을 출력하세요.
		// 3, 4, 5 : 봄 / 6, 7, 8 : 여름 / 9, 10, 11 : 가을 / 12, 1, 2 : 겨울 / 그 외 : 잘못된 월 
		
		int month; // 변수선언
		//String Season;
		Scanner scan = new Scanner(System.in); // 입력 = 스캐너
		System.out.println("input month : "); // 안내문구 : 월을 입력하세요.
		month = scan.nextInt(); // 여기까지는 많이했죠? 이정도는 할 수 있죠? ㅇㅇ넵
		
		// if문은 참/거짓 으로 판별되야함. <비교> 또는 <논리연산자>가 들어가야한다 // 같다(==) 연산자도 써야함
		//0 ~ 13 까지 테스트해보기 
		if(month == 3 || month == 4 || month == 5) { // 크다작다로 가야할까???   //Type mismatch: cannot convert from int to boolean
													// The operator == is undefined for the argument type(s) boolean, int
			System.out.println(month + "월은 봄입니다.");
		}else if (month == 6 || month == 7 || month == 8) {
			System.out.println(month + "월은 여름입니다.");
		}else if (month == 9 || month == 10 || month == 11) {
			System.out.println(month + "월은 가을입니다.");
		}else if (month == 12 || month == 1 || month == 2) {
			System.out.println(month + "월은 겨울입니다.");
		}else {
			System.out.println("잘못된 월입니다.");
		}
		
		System.out.println("--------------------");
		if (month >= 4 && month <= 5) { // 봄 : 3이거나(==같거나) 4이거나 5이거나 (3이상이고 5이하이면)
			System.out.println(month + "월은 봄입니다.");
		}else if (month == 12 || (month >= 1 && month <= 2)) {// 겨울 : (월이 12이거나, 월이 1이상이고 2이하이면)
			System.out.println(month + "월은 겨울입니다."); // 논리연산자는 우선순위가 없어서 (동작순서에따라) 앞에서부터 묶을경우 문제가 될 수 있다.
														// 먼저 실행해야할 연산자에 괄호를 쳐주는게 좋다. 
			// 논리연산자에서 서로 다른 연산자가 섞여있는 경우, 괄호를 쳐서 작업해주는게 좋다!
		}
		
		
	}

}
