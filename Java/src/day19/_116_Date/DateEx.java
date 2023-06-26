package day19._116_Date;

// 필요할때 가져다쓰기, 외울필요 없음
// 못채운거 채울 필요는 있음 ㅠ 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateEx {

	public static void main(String[] args) throws ParseException {
		// 현재 시간을 Date 객체로 생성
		// 시간대 정보 지정
		Date now = new Date();
		System.out.println(now);
		
		//Date 객체 => 문자열로(보기 편하게 하기 위해)
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd EE요일 HH:mm:ss");
		String str = format.format(now);
		System.out.println(str);
		
				
		// 문자열 => Date 객체로
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		str = "2023-06-27 18:00:00";
		Date date = format.parse(str);
		System.out.println(date);
		
		// sout("설명이 필요한부분 일단 채워둠")
		
		// Date 객체에서 시간대를 출력하는 예제
		date = new Date();
		// 원하는 포맷 지정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss zzzz");
		
		// 시간대 정보 지정. 시스템에서 제공하는 기본값
		ZoneId zondId = ZoneId.systemDefault();
		
		// Date 격체를 ZonedDateTime으로 변환
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), zoneId);
		
		// 시간대 정보를 포함하여 문자열로 변환
		String formattedDateTime = zonedDateTime.format(formatter);
		
		// 결과 출력
		System.out.println(formattedDateTime);
	}

}
