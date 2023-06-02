package day4_03_IfEx2;

public class _3_EvenNumberEx2 {

	public static void main(String[] args) {
		//홀짝 판별 예제를 조건 연산자를 이용하여 작성
		
		int num = 3;
		String result;
		result = num % 2 == 0 ? "짝수" : "홀수";
		System.out.println(num + "은 " + result + "이다.");
	}

}
