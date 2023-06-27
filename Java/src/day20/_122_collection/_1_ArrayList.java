package day20._122_collection;

import java.util.ArrayList;
import java.util.Iterator;

// 데이터 추가(add) & 삭제(remove)
public class _1_ArrayList {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		// 1부터 5까지 차례대로 추가
		for (int i = 1; i <= 5; i++) {
			list.add(i); // 정수 i가 박싱으로 Integer클래스의 객체가 된 후 list에 추가
		}
		
		// 1을 더 추가
		
		list.add(1); // 중복을 허용하기 때문에 1 추가 됨! 
		System.out.println(list);
		
		// 1을 제거
		System.out.println("----------");
		list.remove((Integer)1); // 1번지 값 -> Integer로 박싱, 
								 // 첫번째 만나는 1을 제거하고, 제거가 되어 true를 반환
		System.out.println(list);
		// 1번지에 있는 값/객체를 제거(3을 제거)
		System.out.println("---------");
		Integer num = list.remove(1); // 1번지에 있는 요소를 제거하고 제거한 요소를 반환
		System.out.println(num);
		System.out.println(list);
		System.out.println("----------");
		System.out.println(list.size());// size : (현재) 저장된 객체 수를 출력. 저장 가능한 최대 객체 수가 아님
		// 배열에서는 내가 저장한 객체 수와 전체 배열의 수가 다를 수 있음. 
		
		// 일반. List는 특정 번지에 접근할 수 있어서, get()을 이용하여 반복문을 활용할 수 있다.
		// >> 배열에 있는 값 한줄로 출력
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		// 향상된 for문. List와 Set 모두 가능
		for(int tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		// Iterator(다음에 나올 map에서 필요. 기억)
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) { // hasNext : 다음 요소가 있는지 없는지 묻는것
			Integer tmp = it.next(); // 있으면 꺼내와서 출력. 없으면 종료
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		// Set은 번지가 없기때문에 '향상된 for문'이나 'Iterator'를 사용해야함
		System.out.println("----------");
		// 요소를 찾을 때 쓰는 contains, indexOf
		System.out.println(list.contains(1)); // list.contains() : List에 1이 있는지 없는지 확인
		System.out.println(list.indexOf(1)); // list.indexOf() : List에 1이 몇번지에 있는지 확인
		
		
	}

}
