package day19._117_format;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	public static void main(String[] args) {
		int price = 10000; // => 10,000 출력하고 싶음
		DecimalFormat df = new DecimalFormat("###,###"); //정수 3자리마다 , 를 추가
		String str1 = df.format(price);
		System.out.println(str1);
		
		df  = new DecimalFormat("000,000");
		String str2 = df.format(price);
		System.out.println(str2); // 010,000 : 빈자리를 0으로 채움
		
		
		
		
	}

}
