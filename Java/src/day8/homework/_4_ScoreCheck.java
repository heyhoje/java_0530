package day8.homework;

public class _4_ScoreCheck {

	public static void main(String[] args) {
		int score =70;
		// String grade;
		if (score < 0 || score > 100) {
			System.out.println("Wrong Score");
		}else if (score >= 90 && score <= 100) {
			System.out.println("A 입니다");
		}else if (score >= 80 && score < 90) {
			System.out.println("B 입니다");
		}else if (score >= 70 && score < 80) {
			System.out.println("C 입니다");
		}else if (score >= 60 && score < 70) {
			System.out.println("D 입니다");
		}else if (score < 60) {
			System.out.println("F 입니다");
	
		}
	}
}
