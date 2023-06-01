package day3_02_Operator;

public class _07_ConditionalEx {

	public static void main(String[] args) {
		//나이가 20살 이상이면 성인adult, 아니면 미성년자minor 를 출력하는 코드를 작성하세요.
		int age = 30;
		String str;
		
		str = age > 20 ? "adult" : "minor";
		System.out.println(age + " years old is a " + str);
	}

}
