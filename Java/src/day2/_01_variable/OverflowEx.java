package day2._01_variable;

public class OverflowEx {

	public static void main(String[] args) {
		byte num = 127;
		++num;//num에 1을 증가
		System.out.println(num);// 오버플로우가 발생
		
		num = -128;
		--num;
		System.out.println(num);// 언더플로우가 발생
	}

}
