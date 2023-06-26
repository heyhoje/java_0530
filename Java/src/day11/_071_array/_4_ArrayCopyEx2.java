package day11._071_array;

//?��?��?���? 고쳤?��?��(. -> ,) 무슨?��린�? 모르겠음

public class _4_ArrayCopyEx2 {

	public static void main(String[] args) {
		// int배열?�� ?��?�� '참조 ?��료형'?���?
//		String names[] = new String[5];
//		
//		names[0] = "?��길동";
//		names[1] = "?��꺽정";
//
//		//?��?��?�� for�? (?��료형 �??���? : 배열?���?)
//		for (String name : names) {
//			System.out.println(name);
//		}
		
		// Point 배열
		Point pointArr[] = new Point[5];
		
		pointArr[0] = new Point(0,0);
		pointArr[1] = new Point(10,10);
		pointArr[2] = new Point(3,4);
		pointArr[3] = new Point(6,8);
		pointArr[4] = new Point(-5,-5);
	
	
		// ?��?��?�� for�?(
		for(Point pt : pointArr) {
			pt.print();
		}
	
		// 복사?���? ?��?�� 배열(2�? 만들�? ?��?��)
		Point pointArr2[] = new Point[5];
	
		// pointArr?�� ?��?�� ?��?��?�� pointArr2?�� 복사
		System.arraycopy(pointArr, 0, pointArr2, 0, pointArr.length); // ?��?? 복사
		// pointArr2?�� ?��?�� 첫번�? ?��?�� 100,0?���? ?��?��
		pointArr2[0].move(100,0);
	
		System.out.println("----Arr2 move-----");
		//?��?��?�� for�?
		for(Point pt : pointArr) {
			pt.print();
		}
	
		// >>> ?��?? 복사�? ?���? ?��문에  arr1?�� 0번�?�? (100,0)?�� ?��건�????
		
		for(int i = 0; i < pointArr.length; i++) {
			// pointArr2[i] = pointArr[i]; // ?��?? 복사, ?���? ?��?��?��
			pointArr2[i] = new Point(pointArr[i]); // 깊�? 복사 / ?��로운 객체�? 만들?��?��??? ?��쩌구??? ?��?��?��..........
	
		}
		
		pointArr2[0].move(-100, -100); // ?��로운 배열공간?�� 만들?��?�� arr2?�� 0번�? 값을 ?��긴것?���? ?��문에
	
		System.out.println("---------"); // arr1?�� 배열 값�? �??��?�� ?��?��. ?��?�� 것이 맞을까요? 
		for(Point pt : pointArr) { 
			pt.print();
		}
}
	
// class Point ?��?��?��?�� ?��보�?? 그�?�? 복사?��???�� ?��?�� ?��?��?�� ?��?��?���?
}
class Point{
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	

	//복사 ?��?��?��
	public Point(Point pt) {
		x = pt.x;
		y = pt.y;
	}
	
	public void print() {
		System.out.println(x + " , " + y);
	}
	
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
