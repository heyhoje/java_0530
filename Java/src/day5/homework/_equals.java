package day5.homework;

public class _equals {

	public static void main(String[] args) {
		String str1 = new String ("abc");
		String str2 = "abc";
		System.out.println(str1 == str2); // false : 주소값을 비교했기 때문에 false
		// 객체를 == 로 비교하는 것은 주소값
		
		System.out.println(str1.equals(str2)); // true : equals 라는 메소드는 주소값 1,2가 아닌 실제값 "abc" 를 비교
		
	}

}
