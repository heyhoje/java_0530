package day25.test;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	public static void main(String[] args) {
		// List 인터페이스는 List 인터페이스를 구현한 구현클래스 ArrayList의 객체를 관리할 수 있다.
		// 다형성때문에 상관없음
		
		// List는 제네릭 클래스 = 사용하는 방법을 기억!!
		// 멤버의 타입이 정해져있지 않고, 객체를 생성할 때 정해지는 클래스
		
		// 제네릭 클래스는 <>에 클래스명이 들어가야함. 기본자료형 int(x) => 래퍼 클래스를 이용
		List<Integer> list = new ArrayList<>(); 
		list.add(1);
		list.add(2);
	}

}
