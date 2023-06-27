package day20._122_collection;

import java.util.HashSet;

public class _2_SetEx {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		System.out.println(set);
		
		set.remove(10);
		System.out.println(set);
		System.out.println(set.contains(20));
		// set.indexOf 순서롤 보장하지 않기 때문에, contains는 제공하지만 indexOf는 안됨 
		System.out.println(set.size());
		
		// 로또, 숫자야구게임에 적용할 수 있음
	}

}
