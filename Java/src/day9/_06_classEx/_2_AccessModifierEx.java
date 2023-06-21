package day9._06_classEx;

import day9._06_classEx2.B;

public class _2_AccessModifierEx {

	public static void main(String[] args) {
		// 접근 제어자
		A a = new A();
		B b = new B(); // 같은 패키지가 아니어서 찾을 수 없음 >> import >> ctrl+shift_o
		
		// num3은 접근제어자가 public
		// AccessModifier 클래스와 A클래스는 같은 패키지에 있는 클래스
		// AccessModifier 클래스와 B클래스는 같은 패키지에 없는 클래스
		// num3은 접근제어자가 public, 같은 패키지이든 아니든 상관 없음
		a.num3 = 10; // ctrl+spacebar : 쓸수 있는 멤버변수? 같은걸 보여줌
		b.num3 = 20;
		
		// num2는 접근제어자가 defualt(생략됨)
		// 다른 패키지에 있는 B 클래스의 객체에 있는 num2는 접근이 안됨
		a.num2 = 10;
		// b.num2 = 20;
		
		// num1은 접근제어자가 private.
		// 같은 패키지이든 아니든, 다른 클래스에서 접근할 수 없다
		// a.num1 = 10;
		// setter를 통해 값을 변경 
		a.setNum1(10);
		// getter를 통해 값을 가져옴
		System.out.println(a.getNum1());
		// b.num1 = 20;
		
	}

}


class A{
	private int num1;
	int num2;
	public int num3;
	
	/** 클래스 A의 객체정보 중 num1을 출력하는 매소드
	 * 매개변수 : 없음 -> 이미 내가 알고 있는 내 정보 num1이기 때문에
	 * 리턴타입 : 없음 -> void
	 * 메소드명 : print
	 */
	 
	public void print() {
		//num1은 private이기 때문에 같은 A클래스의 메소드에서 호출될 수 있다.
		// 이미 알고있는 내 정보를 활용하는 경우, 매개변수로 전달받지 않아도됨.
		System.out.println(num1); // 가능
	}
	
	// private으로 된 num1에 접근하기 위해서 getter를 추가
	public int getNum1() {
		return num1;
	}
	
	// private으로 된 num1의 값을 변경하기 위해서 Setter를 추가
	public void setNum1(int _num1) {
		num1 = _num1;
	}
}