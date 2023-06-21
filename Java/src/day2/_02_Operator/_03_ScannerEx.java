package day2._02_Operator;

import java.util.Scanner;

public class _03_ScannerEx {

	public static void main(String[] args) {
		//System.in : 표준입력
		//표준 입력을 이용해서 스캐너를 생성
		Scanner scan = new Scanner(System.in); // 콘솔에서 입력받으려면 꼭 기억해야하는 클래스?무엇?
	
		System.out.println("정수를 입력해주세요.");
		
		int num1 = scan.nextInt();//scan이라는 객체에서 정수를 입력받음
		System.out.println(num1);
		
		System.out.println("실수를 입력해주세요.");
		double num2 = scan.nextDouble();//실수를 입력 받음
		System.out.println(num2);
		
		System.out.println("문자열1을 입력하세요.");
		scan.nextLine();//
		String str1 = scan.nextLine();//스페이스를 포함한 문자열 한줄을 읽어옴(마지막 입력한 엔터 포함)
		System.out.println(str1);
		
		System.out.println("문자열2를 입력하세요.");
		String str2 = scan.next();//첫 번째 문자부터 읽어와서 다음 공백(엔터, 스페이스)가 오기 전까지 읽어옴
		System.out.println(str2);
		
		System.out.println("문자를 입력하세요.");
		char ch = scan.next().charAt(0);//next()를 이용하여 한 단어를 읽어오고 읽어온 단어의 첫글자를 가져옴 << String 클래스에서 자세한 설명
		System.out.println(ch);	
		
		
		scan.close();//close() 로 닫지 않아도 크게 문제는 없지만 안쓰면 주의표시가 생김
	}

}
