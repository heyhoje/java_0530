package day2._01_variable;

public class StringEx {

	public static void main(String[] args) {
		/* String 클래스는 문자열을 수정하는게 아니라 새로 생성 */
		String str1 = null;
		String str2 = "";
		String str3 = "A"; // char ch = 'A';와 다름. 문자열 vs 문자
		String str4 = "안녕하세요.";
		System.out.println(str1); // null이라는 문자열이 아님. 비어있는경우, null 일 경우 그대로 출력.
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);
			
	}

}
