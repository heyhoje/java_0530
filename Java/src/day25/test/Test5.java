package day25.test;

import java.util.HashSet;
import java.util.Set;

public class Test5 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		
		// 메소드 add는 Collection인터페이스에 있다.
		// Collection 인터페이스의 자식으로 List와 Set이 있음. 그래서 add메소드 둘다 사용 가능.
		set.add(1);
		set.add(2);
		
		/*
		for(int i = 0; i<set.size(); i++) {
			// get은 list에 있는 메소드. Set에는 없는 메소드다(에러!!!)
			System.out.println(set.get(i));
		}
		*/
		for(Integer tmp : set) {
			System.out.println(tmp);
		}
	}
}

// 나 list, set 나오는 부분 다 모르나본데... 
