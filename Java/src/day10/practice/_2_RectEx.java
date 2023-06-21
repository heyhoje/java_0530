package day10.practice;

public class _2_RectEx {

	public static void main(String[] args) {
		Rect1 r = new Rect1(0,0,10,10);
		r.print(); // 사각형 정보
		r.move(10,10);
		r.print();
			
		r.resize(10,10,20,20);
		r.print();
			
		r.resize(0,0,30,30);
		r.print();
		
		System.out.println();
		System.out.println("[R2 start!]");
		
		Rect2 r2 = new Rect2(new Point(0,0), new Point(10,10));
		r2.print();
		r2.move(10,10);
		r2.print();
		r2.resize(10, 10, 20, 20);
		r2.print();
		r2.resize(0, 0, 30, 30);
		r2.print();
	}
}

// 사각형은 4개의 점과 4개의 변으로 이루어져있지. 각을 다 더하면 360도.
// => 점 4개를 찍고 연결. x 1-4, y 1-4
// => 점에서 시작 - 점으로 끝. 점 2개
// => 점 1개 - 가로, 세로

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
	/** 기능 : 사각형 정보를 출력하는 메소드
	 * 매개변수 : 없음(사각형이 '나'이기 때문에, 내 정보라 이미 알고있음)
	 * 리턴타입 : 없음(출력하면 끝이기 때문에 알려줄게 없음) => void
	 * 메소드명 : print
	 */
	public void print() {
		System.out.println("------사각형 정보------");
		System.out.println("Left Up point : " + leftUpX + ", " + leftUpY);
		System.out.println("Right Down point : " + rightDownX + ", " + rightDownY);
	}
	
	/** 기능 : 사각형을 이동시키는 메소드(좌표 수정)
	 * 매개변수 : 이동시킬 왼쪽 위의 점 => int x, int y
	 * 리턴타입 : (값을 바꾸는 것) 없음 => void
	 * 메소드명 : move
	 * 왼위 0.0			10.10
	 *     오아 10.10			20.20
	 */
	public void move(int x, int y) {
		int dx = leftUpX - x; // 이동한 x좌표 거리 , -10
		int dy = leftUpY - y; // 이동한 y좌표 거리 , -10
		leftUpX = x;
		leftUpY = y;
		rightDownX = rightDownX - dx;// 10 - -10 = 20
		rightDownY = rightDownY - dy;
	}
	
	/** 사각형의 크기를 변경하는 메소드
	 * 매개변수 : 변경된 사각형의 왼쪽 위의 x,y좌표와
	 * 			가로, 세로가 주어지면 사각형의 크기를 변경하는 메소드
	 * 			=> int x, int y, int w, int h
	 * 리턴타입 : (값을 바꾸는것) 없음 => void
	 * 메소드명 : resize
	 */
	public void resize(int x, int y, int w, int h) {
		leftUpX = x;
		leftUpY = y;
		rightDownX = x + w;
		rightDownY = y + h;
	}
}

class Rect2{
	// 멤버변수
	private Point leftUp, rightDown;
	
	// 생성자
	public Rect2(Point leftUp, Point rightDown) {
		this.leftUp = leftUp;
		this.rightDown = rightDown;
		
	}
	
	//메소드
	/** 기능 : 사각형 정보를 출력하는 메소드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void 
	 * 메소드명 : print
	 */
	public void print() {
		System.out.println("----Rect2-----");
		System.out.println("LeftUp point : " );
		leftUp.print();
		System.out.println("RightDown point : ");
		rightDown.print();
		
	}

	/** 기능 : 사각형을 이동시키는 메소드
	 * 매개변수 : 이동시킬 왼쪽 위의 점 => int x, int y
	 * 리턴타입 : 없음 => void
	 * 메소드명 : move
	 * 0,0				10,10
	 * 		10,10				20,20
	 */
	
	public void move(int x, int y) {
		int dx = leftUp.getX() -x; //이동한 x좌표 거리, -10
		int dy = leftUp.getY() -y; // 이동한 y좌표 거리, -10
		leftUp.move(x, y);
		rightDown.move(rightDown.getX() - dx, rightDown.getY() - dy);
	}
	
	/**기능 : 사각형의 크기를 변경하는 메소드
	 * 매개변수 : 변경된 사각형의 왼쪽 위의 x, y좌표와
	 * 			가로, 세로가 주어지면 사각형의 크기를 변경하는 메소드
	 * 			=> int x, int y, int w, int h
	 * 리턴타입 : 없음 => void
	 * 메소드명 : resize
	 */
	public void resize(int x, int y, int w, int h) {
		leftUp.move(x,y);
		rightDown.move(x+w,y+h);
	}
}
