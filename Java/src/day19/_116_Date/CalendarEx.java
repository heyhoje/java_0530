package day19._116_Date;

import java.util.Calendar;
import java.util.Date;

// �̷��� �̷� ������ ���� �� ������ ����ϸ��
// (�������� �𸣰ڴµ�?? �� �׳� ������????)

// �̷� ������ �ֱ���......

public class CalendarEx {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		int year = cal.get(Calendar.YEAR);// get(1)
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+ "-" + month + "-" + day);
		
		// Date��ü�� Calendar ��ü��
		Date date = new Date(); // ����ð�
		cal = Calendar.getInstance();
		cal.setTime(date);
		
		// Calendar��ü�� Date ��ü��
		cal = Calendar.getInstance();
		//Date(�и���) �����ڴ� 1970�� 1��1��0�ø� �������� �и��� ��ŭ �帥���� ��¥�� �ʱ�ȭ.....�� ���Ҹ���
		Date date2 = new Date(cal.getTimeInMillis());
		
		// 1970�� 1�� 1���� �������� 1000ms�帥 ��¥ ��ü�� ���� => 1��
		// 09�� : 1�� �귶�µ� 9�ð��� �߰��� ������ �ѱ��ð��� �̱� ����... �ѱ��ð��� UTC+9
		date2 = new Date(1000);
		System.out.println(date2);
	}

}
