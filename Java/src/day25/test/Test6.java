package day25.test;

public class Test6 {

	public static void main(String[] args) {
		//평균 예제
				int kor = 100, eng = 90, math = 34;
				// 실수를 정수형 변수에 저장하려고 했기 때문에 에러발생(자동형변환x)
				// int 를 double로 수정
				double avg = (kor + eng + math)/3.0;
				System.out.println("평균 : " + avg);
	}

}

// 아 평균구하기는 쉽지쉽지easy
