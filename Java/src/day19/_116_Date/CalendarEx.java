package day19._116_Date;

import java.util.Calendar;
import java.util.Date;

// 이럴때 이런 예제를 쓴다 ㅡ 정도만 기억하면됨
// (그정도도 모르겠는데?? 왜 그냥 진행해????)

// 이런 예제가 있구나......

public class CalendarEx {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		int year = cal.get(Calendar.YEAR);// get(1)
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+ "-" + month + "-" + day);
		
		// Date객체를 Calendar 객체로
		Date date = new Date(); // 현재시간
		cal = Calendar.getInstance();
		cal.setTime(date);
		
		// Calendar객체를 Date 객체로
		cal = Calendar.getInstance();
		//Date(밀리초) 생성자는 1970년 1월1일0시를 기준으로 밀리초 만큼 흐른뒤의 날짜로 초기화.....뭔 ㄱ소리야
		Date date2 = new Date(cal.getTimeInMillis());
		
		// 1970년 1월 1일을 기준으로 1000ms흐른 날짜 객체를 생성 => 1초
		// 09시 : 1초 흘렀는데 9시간이 추가된 이유는 한국시간대 이기 때문... 한국시간은 UTC+9
		date2 = new Date(1000);
		System.out.println(date2);
	}

}
