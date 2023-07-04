package day25.test;

import java.util.ArrayList;
import java.util.List;

public class Test3 {

	public static void main(String[] args) {
	
		//list와 hashSet은 
		// HashSet은 List의 구현클래스가 아니기 때문에(조카뻘) HashSet의 객체를 List가 관리할 수 없다.
		//List<Integer> list = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		
		// 3은 int. 3이 자동으로 박싱되서 Integer의 객체로 저장
		// (박싱 - wrapper클래스 객체로 /언박싱 - 빼주는거)
		list.add(3);
		list.add((int)4);
		// 5를 직접 박싱으로 Integer의 객체로 변환 후 저장
		list.add((Integer)5);
				
		// >> 셋다 가능함!
			
	}
}
