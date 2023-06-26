package day19._12_exception;

public class _2_NullPointerExceptionEx {

	public static void main(String[] args) {
		/* NullPointerException
		 * - 객체가 null인 상태로 메소드, 멤버를 호출하는 경우 발생
		 * */
		
		 String str = null;
		//String str = "abc";
//		System.out.println(str.substring(0));
		 test(str);
	}
	
	/* 메소드를 만들 때 매개변수의 null 체크를 반드시 하는게 좋*/
	public static void test(String str) {
		System.out.println(str.substring(0));
	}

}
