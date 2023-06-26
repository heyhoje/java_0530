package day19._117_format;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	public static void main(String[] args) {
		int price = 10000; // => 10,000 ����ϰ� ����
		DecimalFormat df = new DecimalFormat("###,###"); //���� 3�ڸ����� , �� �߰�
		String str1 = df.format(price);
		System.out.println(str1);
		
		df  = new DecimalFormat("000,000");
		String str2 = df.format(price);
		System.out.println(str2); // 010,000 : ���ڸ��� 0���� ä��
		
		
		
		
	}

}
