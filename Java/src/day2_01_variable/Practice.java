package day2_01_variable;

public class Practice {

	public static void main(String[] args) {
		//1. 아래 코드에서 잘못된 부분을 찾아 수정하세요.
		// char ch1 = "A";
		char ch1 = 'A';
		System.out.println(ch1);
		
		//2. 국어, 영어, 수학 성적을 입력하여 평균을 구하려 한다. 이때 필요한 변수들을 선언하세요.
		//int kor, eng, math / 정수형 변수
		//double, float avg / 실수형 변수
		int koreaScore = 100;
		int englishScore = 85;
		int mathScore = 90;
		double average = (koreaScore + englishScore + mathScore)/3;
		System.out.println(average);

	}

}
