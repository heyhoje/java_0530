package day2._02_Operator;

public class _02_IncreaseOperator {

	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		System.out.println("작업 전 : " + num1 + "(전위형), " + num2 + "(후위형)");
		// 전위형은 먼저 증가를 하고 동작, num1을 증가시킨후 작업중 문자열과 더함
		// 후위형은 먼저 동작을 하고 증가, num2를 앞의 문자열과 더한 후에 num2를 증가시킴
		System.out.println("작업 중 : " + ++num1 + "(전위형), " + num2++ + "(후위형)");
		System.out.println("작업 후 : " + num1 + "(전위형), " + num2 + "(후위형)");

		System.out.println("---------------------------");
		num1 = num2 = 10;
		System.out.println("작업 전 : " + num1 + "(전위형), " + num2 + "(후위형)");
		++num1;
		System.out.println("작업 중 : " + num1 + "(전위형), " + num2 + "(후위형)");
		++num2;
		System.out.println("작업 후 : " + num1 + "(전위형), " + num2 + "(후위형)");
	}

}
