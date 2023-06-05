package day5_03_SwitchEx;

import java.util.Scanner;

public class _2_SeasonEx {

	public static void main(String[] args) {
		// 월을 입력받아 입력받은 월의 계절을 출력하세요.
		// 3, 4, 5 : 봄 / 6, 7, 8 : 여름 / 9, 10, 11 : 가을 / 12, 1, 2 : 겨울 / 그 외 : 잘못된 월
		
		int month;
		Scanner sc = new Scanner(System.in);
		
		// 월을 입력
		System.out.println("월을 입력하세요 : "); 
		month = sc.nextInt();
		
		/* if(month == 1) { //같다에서 변수쪽 부분이 (변수)로 들어가고, ~~~~ 가 case 뒤로 들어간다.
		
		}
		
		Switch(month) 
		case 1
	
	*/
		//월에 따른 계절을 출력(Switch문으로)
		switch(month ) {
		// month가 1, 2, 12 일때 12의 실행문이 실행되어 겨울이 출력
		// 1의 실행문이 없고, break문도 없음
		// 2의 실행문이 없고, break문도 없음
		case 1 : case 2 : case 12 : // case 1, 2, 12: // JDK 7버전 이후로 가능(우리는 최신버전 사용중이라 가능함)
			System.out.println("겨울"); // << 는 12의 실행문임. 1 과 2는 break가 없어서 넘어넘어 간것.
			break;
		case 3 : case 4 : case 5 :
			System.out.println("봄");
			break;
		case 6 : case 7 : case 8 :
			System.out.println("여름");
			break;
		case 9 : case 10 : case 11:
			System.out.println("겨울");
			break;
		}
//		switch(month) {
//		case 1 : month = 3;
//		case 2 : month = 4;
//		case 3 : month = 5;
//			System.out.println(month + "월은 봄입니다.");
//			break;
//		case 4 : month = 6;
//		case 5 : month = 7;
//		case 6 : month = 8;
//			System.out.println(month + "월은 여름입니다.");
//			break;
//		case 7 : month = 9;
//		case 8 : month = 10;
//		case 9 : month = 11;
//			System.out.println(month + "월은 가을입니다.");
//			break;
//		case 10 : month = 12;
//		case 11 : month = 1;
//		case 12 : month = 2;
//			System.out.println(month + "월은 겨울입니다.");
//			break;
//		default : 
//			System.out.println("잘못된 월입니다.");
//		}
		
		sc.close();
		
				
	}

}
