package day3_02_Operator;

public class _05_LogicalEx {

	public static void main(String[] args) {
		// && and연산자는 둘다 참이어야함
		int score = 95;//75, 85, 95
		//성적이 80점 이상이고, 90점 미만인가? << 문제를 코드로 만드는게 어려움. 말을 최대한 내가 알고있는 연산자로, 단계별로 풀어쓰는 연습필요
		//score가 80보다 크거나 작다 && score가 90보다 작다.
		System.out.println(score + "점은 B학점인가? " + (score >= 80 && score < 90));
		
		// ! not연산자
		// 20세 이상이면 성인
		int age = 21;
		boolean isAdult = age >= 20;
		//age살은 미성년자인가? -> 성인이 아님
		System.out.println(age + "살은 미성년자인가? : " + !isAdult);// is not adult.
		
		// || or연산자는 하나만 참이어도 됨
		//주민등록증은 있고, 운전면허증은 없음.
		boolean hasIdCard = true;//true, false
		boolean hasDriversLicense = false;
		//토익을 볼 수 있을까?(주민등록증이 있거나 운전면허증이 있으면 볼 수 있음)
		System.out.println("토익시험을 볼 수 있는가? : " + (hasIdCard || hasDriversLicense));
		
	}

}
