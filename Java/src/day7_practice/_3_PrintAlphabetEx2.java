package day7_practice;

public class _3_PrintAlphabetEx2 {

	public static void main(String[] args) {
		/* 3. 다음과 같이 출력되는 코드를 작성하세요.
		 * a
		 * ab
		 * abc
		 * abcd
		 * ...
		 * abcdefg_xyz
		 */
		
		/* 외부반복문
		 * 반복횟수 : end는 'a'부터 시작해서 'z'까지, 1씩 증가
		 * 규칙성 : 'a'부터 end까지 출력
		 * 반복문 종료 후 : 없음
		 * */
		int i, j;
		char ch = 'a';
		for(i = 0; i < 26; i++) {
			/* 내부반복문
			 * 반복횟수 : end는 'a'부터 시작해서 'z'까지, 1씩 증가
			 * 규칙성 : 'a'부터 end까지 출력
			 * 반복문 종료 후 : 없음
			 * */
			for(j = 0; j < i+1; j++) {
				System.out.print((char)(ch + j));
			}
			System.out.println();

		}
			System.out.println();
		System.out.println("---강사님 답안---");
		
		char end;
		for(end = 'a'; end <= 'z'; end++) {
			for(ch = 'a'; ch <= end; ch++) {
				System.out.print(ch);
			}
			System.out.println();
		}
		System.out.println("---창의적 답안---");
		ch = 'a';
		for(i = 0; i < 26; i++) {
			/* 내부반복문
			 * 반복횟수 : end는 'a'부터 시작해서 'z'까지, 1씩 증가
			 * 규칙성 : 'a'부터 end까지 출력
			 * 반복문 종료 후 : 없음
			 * */
			for(j = 0; j < i+1; j++) {
				System.out.print((char)(ch + i)); // 내부반복문안에 i를 넣으면, a bb ccc 이렇게 진행됨
			}
			System.out.println();
		}
		
	}

}
