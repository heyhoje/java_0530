package day7_practice;

public class _22_PrintEx {

	public static void main(String[] args) {
		// 콘솔 출력을 위해 
		// Println() : 원하는 값을 출력한 후 엔터까지 입력
		System.out.println("abc");
		System.out.println('a');
		System.out.println(1);
		
		// Print() : 원하는 값을 출력, 한 줄에 입력함. (\n : 엔터)
		System.out.print("abc");
		System.out.print('a');
		System.out.print(1);
		
		System.out.println();
				
		// printf() : 문자열 형태로 만들어서 원하는 값을 출력. 서식문자를 이용
		// 이런게 있다~ 정도만 기억
		System.out.printf("String : %s\n", "abc");
		System.out.printf("Integer : %d\n", 1);
		System.out.printf("Char : %c\n", 'a');
		System.out.printf("double : %.2f\n", 3.12345678798675);
	}

}
