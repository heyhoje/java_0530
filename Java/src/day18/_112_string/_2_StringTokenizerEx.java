package day18._112_string;

import java.util.StringTokenizer;

public class _2_StringTokenizerEx {

	public static void main(String[] args) {
		
		String fruits = "apple,orange,banana";
		
		StringTokenizer st = new StringTokenizer(fruits, ",");
		
		// hasMoreToken : 다음 토큰이 있는지 없는지 알려줌. 없다는건 끝났다는 의미
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());// nextToken : 토큰을 가져옴
		}
		
	}
	
}
