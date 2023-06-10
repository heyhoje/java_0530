package day2_01_variable;

public class CastEx {

	public static void main(String[] args) {
		//3.14는 double형 리터럴이기 때문에 int에 저장할 수 없다. 강제형변환을 해야함.
		int pi = (int) 3.14;
		
		//3은 int형 리터럴이기 때문에 double형 변수에 저장할 수 있음(자동형변환)
		double num1 = 3;
		
		//123L은 long형 리터럴이기 때문에 int에 저장할 수 없음(강제형변환)
		//실제 데이터 분실이 없어도 타입에 맞게 강제형변환을 해야 함.
		int num2 = (int) 123L;
		
		System.out.println(pi);
		System.out.println(num1);
		System.out.println(num2);
		
		// 무슨 소린지 해석할 수 없지만,, 나누기(/)를 할때는 소수점 이하가 발생할 수 있기 때문에 (double) 로 형변환 해줘야한다.
		// 1/2�� 臾몃����� 臾몄��媛� ��吏�留� ������ 寃곌낵媛��� �산린 ���댁�� (媛�����蹂���) 
		// �������쇰� ����湲�(/)
		System.out.println((double)1/2);
	}

}
