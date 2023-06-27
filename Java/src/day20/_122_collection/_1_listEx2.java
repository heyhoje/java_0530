package day20._122_collection;

import java.util.ArrayList;

// 학생정보 리스트
public class _1_listEx2 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1, 1, 1, "홍길동"));
		list.add(new Student(1, 1, 2, "가길동"));
		list.add(new Student(1, 1, 3, "나길동"));
		list.add(new Student(1, 1, 4, "다길동"));
		list.add(new Student(1, 1, 5, "라길동"));
		
		System.out.println(list); // Student > @toString 임포트 추가
		
		/* remove 메소드는 'Object's'클래스의 equals'를 호출(Objects.equals(A,B))해서 true인 경우에만 삭제! 
		 * => A가 자기 자신, B가 삭제하려는 객체
		 * => A와 B의 클래스가 다르면 false를 리턴
		 * => A와 B의 클래스가 같으면 A.equals(B)를 호출해서 결과를 리턴 
		 * Student 클래스에 equals를 오버라이딩 하지 않으면, Student 클래스의 equals는 주소를 비교
		 * => 학년, 반, 번호, 이름은 같지만, new StudentC 새로 객체를 만들었기 때문에 주소가 다름
		 * => 서로 다른 객체로 판별해서 삭제제가 안됨.... */
		//list.remove(new StudentC(1, 1, 1, "홍길동"));
		System.out.println(list); // 삭제가 안됨
		
		// ㄴ 컬렉션프레임워크, list, set, map에서 삭제할때 equals를 활용함
		// contains, indexOf도 Objects.equals를 호출해서 같은 객체를 찾음
		System.out.println(list.contains(new Student(1,1,1,"홍길동")));
		System.out.println(list.indexOf(new Student(1,1,1,"홍길동")));
		
	}

}
