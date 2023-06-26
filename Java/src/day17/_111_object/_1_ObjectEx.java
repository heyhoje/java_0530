package day17._111_object;

import java.util.Objects;
import lombok.Data;

public class _1_ObjectEx {

	// 1. toString : 중요하진 않지만, 유용함
	// 2. equals() : 진짜 중요! 필수!
	// 4. Clone() 복사 : 알아두면 좋음
	
	public static void main(String[] args) throws CloneNotSupportedException { // +클론 예외처리
		System.out.println("-----pt1-----");
		Point1 pt1 = new Point1(10, 20);
		System.out.println(pt1); // day17.object.Point1@1ddc4ec2
		System.out.println(pt1.toString()); // 결과가 같다. 
						  // ㄴ
		System.out.println("-----pt1/pt11-----");
		Point1 pt11 = new Point1(10, 20);
		System.out.println(pt1 == pt11); // 좌표는 같음 / 주소는 다름
		System.out.println(pt1.equals(pt11)); // true! @Data 때문에 오버라이딩 되서 같은 주소값이 됨
		
		System.out.println("-----pt2-----");
		Point2 pt2 = new Point2(30, 40);
		System.out.println(pt2);
		
		System.out.println("-----pt2/pt21-----");
		Point2 pt21 = new Point2(30, 40);
		System.out.println(pt2 == pt21);
		System.out.println(pt2.equals(pt21)); // false! @Data 오버라이딩 안해서. 주소값이 다름.
											  // equals로 오버라이딩 해서 true로 바뀜. 
		
		System.out.println("-----clone복사-----");
		//Clone()을 이용해서 복제가 제대로 됨
		Point2 pt22 = (Point2)pt2.clone(); // 클론 리턴타입 Object! 다운캐스팅 => (클래스명)을 반든시 추가
		// 주소가 다르지만!
		System.out.println(pt2 == pt22);
		// 두 객체가 같다고 판별!!
		System.out.println(pt2.equals(pt22)); // true! 복제가 제대로 됐기 떄문에
		System.out.println(pt22); // pt2랑 같다! Point2 [x=30, y=40]
	}

}
// 1. toString
@Data 
// toString(), equals(), hashcode()는 오버라이딩
// getter, setter는 자동 생성
class Point1 {
	private int x, y;
	
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

// 4. Clone() 복사
class Point2 implements Cloneable{
	private int x, y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
//	public String toString() {
//		return "(" + x + ", " + y + ")";
//	}

	@Override
	public String toString() { // 객체정보 확인할때 유용하게 쓰임!!!!!!!!! 
		return "Point2 [x=" + x + ", y=" + y + "]"; // 우클릭 + source + 'generate toString'
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	// 2. equals
	@Override
	public boolean equals(Object obj) { // 우클릭 > source > generate hash() and equals()
		// 주소를 비교(내 객체의 정보 주소 == 매개변수 obj), 
		// 주소가 같으면 같은 객체를 공유
		if (this == obj)
			return true;
		
		// obj 없는 객체(비어있는x) 와는 비교할 수 없음 false!
		if (obj == null)
			return false;
		
		// 내 클래스와 비교할 객체의 클래스가 다른 경우. 비교를 안함 false!
		// 상황에 따라 비교하는 코드로 만들 수 있음. 
		if (getClass() != obj.getClass())
			return false;
		
		// 비교할 객체의 클래스가 같은 클래스인 경우(Point2로 ???)
		Point2 other = (Point2) obj;
		// 멤버들을 비교해서 각각 같은지를 확인! 
		return x == other.x && y == other.y;
	}
	
	// 4. Clone() + 예외처리
	public Object clone() throws CloneNotSupportedException { // +예외처리
		return super.clone();
	}
}