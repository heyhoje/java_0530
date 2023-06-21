package day4.practice;

import java.util.Scanner;

public class _6_IfScoreEx {

	public static void main(String[] args) {
		//성적을 입력받아 성적에 맞는 학점을 출력하는 코드를 작성하세요
//		90이상 ~100이하 : A
//		80이상 ~ 90미만 : B
//		70이상 ~ 80미만 : C
//		60이상 ~ 70미만 : D
//		60미만 : F
//		0보다 작거나 100보다 큰 경우 : wrong score
		
		int score;
		Scanner sc = new Scanner(System.in); // 스캐너는 기본. 복붙. 많이써보면 노력안해도 익숙해짐
		System.out.println("성적을 입력하세요.");
		score = sc.nextInt();
		
		if(score < 0 || score > 100) {
			System.out.println("wrong score!");
		} else if (score >= 90) { // && score <= 100) <- 100이하도 안써도 됐음(위에서 100이상을 쳐냈기 때문에)
			System.out.println(score + "점은 A학점 입니다.");
		} else if (score >= 80) {
			System.out.println(score + "점은 B학점 입니다.");
		} else if (score >= 70) {
			System.out.println(score + "점은 C학점 입니다.");
		} else if (score >= 60) {
			System.out.println(score + "점은 D학점 입니다.");
		} else if (score < 60) {
			System.out.println(score + "점은 F학점 입니다.");
		}
			
		
		
		
	}

}
