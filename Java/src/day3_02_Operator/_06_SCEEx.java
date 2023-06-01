package day3_02_Operator;

public class _06_SCEEx {
	
	public static void main(String[] args) {
		String str = "abc";//null
		System.out.println("Is " + str + " equal to abc? " + (str != null && str.equals("abc")));
		
		String str = null;
		//str이 null이기 때문에 str.xx으로 되어 있는 모든 곳에서 에러가 발생
		//그런데 && 연산자 앞에서 null 체크하는 코드가 먼저 있기 때문에 
		//null 인 경우에 앞부분이 거짓이 되서 뒷부분이 문제가 되는 코드를 실행하지 않아서 무사히 넘어감(SCE: 단락회로평가)
		System.out.println("Is " + str + " equal to abc? " + (str != null && str.equals("abc")));// 컴퓨터가 없지 않다(있다) && 컴퓨터 전원을 켜라?
		// 아래 코드는 위 코드에서 순서만 변경한 코드로, 문제가 되는 코드를 먼저 실행하기 때문에 에러(예외)까 발생
		System.out.println("Is " + str + " equal to abc? " + (str.equals("abc") && str != null));// 컴퓨터가 없는데, && 컴퓨터 전원을 켜라??
	}

}
