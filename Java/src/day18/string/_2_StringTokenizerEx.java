package day18.string;

import java.util.StringTokenizer;

public class _2_StringTokenizerEx {

	public static void main(String[] args) {
		
		String fruits = "apple,orange,banana";
		
		StringTokenizer st = new StringTokenizer(fruits, ",");
		
		// hasMoreToken : ���� ��ū�� �ִ��� ������ �˷���. ���ٴ°� �����ٴ� �ǹ�
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());// nextToken : ��ū�� ������
		}
		
	}
	
}
