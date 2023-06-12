package day3_practice;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		/* 성적을 입력받아 입력받은 성적이 60점이상인지 확인하는 코드를 작성하세요. 
		input score : 
		65
		[결과출력] Do you pass 65 points? true
		
		/int score = 65;
		/int grade = 60;
		/System.out.println(score >= grade);
		��
		input score : 
		45
		Do you pass 45 points? false
		/score = 45;
		/System.out.println();*/
		
		Scanner sc = new Scanner(System.in);//왜자꾸 스캐너를 쓰는지 모르겠음. 근데 객체생성처럼 그냥 외워야하는듯
		System.out.println("Input score : ");
		int score = sc.nextInt();
		
		boolean result = score >= 60; //참거짓이 갈리기 때문에 boolean
		System.out.println("Do you pass " + score + " points? : " + result);
		
		sc.close();
		
		

	}

}
