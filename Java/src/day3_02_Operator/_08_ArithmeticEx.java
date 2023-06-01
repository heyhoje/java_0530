package day3_02_Operator;

public class _08_ArithmeticEx {
	public static void main(String[] args) {
		//
		/* byte + 정수나 char + 정수는 결과가 int여서 byte나 char에 바로 저장할 수 없음
		 * 자료형 변환을 이용해서 저장해야 한다.
		 */
		byte num1 = 3;// num1에 3이라는 값을 저장하고
		//num1 = num1 + 5;// 오른쪽 값이 int 가 되버려서 왼쪽 byte에 저장할 수 없다. 
		num1 = (byte)(num1 + 5);
		
		char ch = 'A';
		System.out.println(ch);
		ch = (char)(ch + 1); //오른쪽이 int가 됨.
		System.out.println(ch);
		
		int num2 = 3;
		num2 = (int)(num2 + 4.0); // 정수 + 실수 = '실수'로 변환됨
		System.out.println(num2); // 어디에 저장하냐에 따라 형변환이 필요할 수도, 안필요할 수도 있다. 
	}

}
