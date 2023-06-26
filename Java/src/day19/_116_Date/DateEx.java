package day19._116_Date;

// �ʿ��Ҷ� �����پ���, �ܿ��ʿ� ����
// ��ä��� ä�� �ʿ�� ���� �� 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) throws ParseException {
		// ���� �ð��� Date ��ü�� ����
		// �ð��� ���� ����
		Date now = new Date();
		System.out.println(now);
		
		//Date ��ü => ���ڿ���(���� ���ϰ� �ϱ� ����)
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd EE���� HH:mm:ss");
		String str = format.format(now);
		System.out.println(str);
		
				
		// ���ڿ� => Date ��ü��
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		str = "2023-06-27 18:00:00";
		Date date = format.parse(str);
		System.out.println(date);
		
		// sout("������ �ʿ��Ѻκ� �ϴ� ä����")
		
		// Date ��ü���� �ð��븦 ����ϴ� ����
		date = new Date();
		// ���ϴ� ���� ����
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss zzzz");
		
		// �ð��� ���� ����. �ý��ۿ��� �����ϴ� �⺻��
		ZoneId zondId = ZoneId.systemDefault();
		
		// Date ��ü�� ZonedDateTime���� ��ȯ
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
		
		// �ð��� ������ �����Ͽ� ���ڿ��� ��ȯ
		String formattedDateTime = zonedDateTime.format(formatter);
		
		// ��� ���
		System.out.println(formattedDateTime);
	}

}
