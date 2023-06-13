package day10_copy;

// 별거 아닌거 같지만 꼭 이해하고 넘어가야함. 참조형 변수
//

public class _1_CopyEx {

	public static void main(String[] args) {
		/* 기본 자료형으로 된 변수는 값을 복사하더라도 '값만' 복사되기 때문에
		 * 공유가 된다 (얕은 복사)
		 */
		int num1 = 10;
		int num2 = num1;
		System.out.println(num1 + " , " + num2);
		num2 = 30; // num1 기본형 자료형은 변하지 않음
		System.out.println(num1 + " , " + num2);
		
		System.out.println("=========");
		
		A a1 = new A();
		A a2 = a1;
		System.out.println(a1.num1 + " , " + a2.num1);
		a2.num1 = 20;
		System.out.println(a1.num1 + " , " + a2.num1);
		
		/* 참조 변수를 복사하려면 복사 생성자를 이용하여 객체를 생성한 후
		 * 멤버 변수들을 복사하려는 객체의 멤버변수로 초기화 
		 * (깊은 복사) 한쪽이 바뀌어도 내용이 안바뀜
		 */
		System.out.println("=========");
		A a3 = new A(a1);
		System.out.println(a1.num1 + " , " + a3.num1);
		a3.num1 = 50;
		System.out.println(a1.num1 + " , " + a3.num1);
		
	}

}

class A {
	public int num1;
	public A() {}
	
	// 복사 생성자
	public A(A a) {
		num1 = a.num1;
	}

}
