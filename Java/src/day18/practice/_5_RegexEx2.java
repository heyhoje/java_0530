package day18.practice;

import java.util.regex.Pattern;

public class _5_RegexEx2 {

	public static void main(String[] args) {
		// 5. �Է¹��� ���ڿ��� http:// �Ǵ� https://�� �����ϴ��� Ȯ���ϴ� ����ǥ������ �ۼ��غ�����
		String str = "http://www.naver.com";
		String regex = "^https?://[a-zA-Z\\.]+$";
		
		boolean result = Pattern.matches(regex, str); // (����ǥ����, ���ڿ�) ���� �ٲ�� �ȵ�
		System.out.println(str + " : " + result);
	
	}

}
