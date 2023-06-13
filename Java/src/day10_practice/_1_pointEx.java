package day10_practice;

//_1_pointEx 포인트 클래스 깃헙에서 복사해두기

public class _1_pointEx {

	public static void main(String[] args) {
		// 좌표의 점을 관리하는 클래스를 만들고 테스트하는 코드를 작성하세요.
		// 필요한 속성과 기능을 생각해서 추가해보세요(예: 그림판 하단의 좌표)
		Point pt1 = new Point();
		pt1.print();
		pt1.move(10, 20);
		pt1.print();
		
		Point pt2 = new Point(30, 40);
		pt2.print();
		
	}
}

// 좌표의 점을 관리하는 클래스
	/* 클래스의 접근제어자가 public으로 올 수 있는 조건
	 * - 파일명과 클래스명이 같아야 public을 붙일 수 있다.
	 * - 같은 패키지에 같은 이름의 클래스가 있으면 안됨
	 * */
class Rect1 {
	// 멤버변수
	/* 왼쪽 위의 점 x좌표, 왼쪽 위의 점 y좌표
	 * 오른쪽 아래의 점 x좌표, 오른쪽 아래 점 y좌표*
	 */
	private int leftUpX, leftUpY;
	private int rightDownX, rightDownY;
	
	// 생성자 는 public
	public Rect1(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		this.leftUpX = leftUpX;
		this.leftUpY = leftUpY;
		this.rightDownX = rightDownX;
		this.rightDownY = rightDownY;
	}
	
	// getter, setter
	// 생략, 여기서는 해당 기능이 필요하지 않음
		
	
	//메서드
	/** 기능 : 현재 좌표를 출력하는 기능
	 * 매개변수 : 없음(내 좌표이기 때문에 이미 알고있음)
	 * 리턴타입 : 없음(출력하면 끝이기 때문에 알려줄게 없음
	 * 메소드명 : print
	 */
	public void print() {
		System.out.println("" + x + ", " + y + "px");
	}
	
	/** 기능 : 주어진 x, y좌표로 이동하는 메소드(좌표 수정)
	 * => 멤버변수 x, y를 주어진 x, y로 수정하는 메소드
	 * 매개변수 : 주어진 x, y => int x, int y
	 * 리턴타입 : 없음 => void
	 * ㄴex) setter처럼
	 * 메소드명 : move
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
	

