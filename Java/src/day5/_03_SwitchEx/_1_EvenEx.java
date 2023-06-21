package day5._03_SwitchEx;

public class _1_EvenEx {

	public static void main(String[] args) {
		//홀짝 예제를 Switch 문으로
		
		int num = 4; 
		
		//Switch(num); // int 범위만큼. 0 ~ 많은 수 다 따져줘야함
		
		// num을 2로 나눈 나머지 값을 이용
		switch(num % 2) {// 조건식이 아닌 일반식이나, 나머지연산이나 변수 입력
		case 0 : 
			System.out.println(num + "은/는 짝수");
			break;
		default:
			System.out.println(num + "은/는 홀수");
		}
	}

}
