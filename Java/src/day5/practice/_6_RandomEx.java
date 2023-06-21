package day5.practice;

public class _6_RandomEx {

	public static void main(String[] args) {
		// 반복문 예제는 아니고, 과제에 필요한 개념
		// min부터 max 사이의 랜덤한 정수를 만드는 코드를 작성하세요.
		// Math.random() : 0이상 1미만(1포함x)의 실수를 랜덤으로 생성
		System.out.println(Math.random());
		// 0 <= random < 1
		// 0 *(max - min + 1) <= r *(max - min + 1) < 1 *(max - min + 1) // 0이아닌 양수를 곱하면 부등호 그대로 유지
		// 0 <= r *(max - min + 1) < (max - min + 1) 
		// 0 + min <= r*(max - min + 1) + min < (max - min + 1) + min
		// min <= r *(max - min + 1) + min < max + 1
		
		//☆
		int min = 1, max = 10;
		int random = (int)(Math.random() * (max - min + 1) + min); // double + 어떤 수 = double => 랜덤한 정수로 만들기 위해 소수점 날리기
		// ㄴ 이 코드만 기억해....☆ 																//(int)로 형변환
		System.out.println(random);
	}

}
