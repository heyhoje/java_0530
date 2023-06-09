package day11._071_array;

//???๊ฑ? ๊ณ ์ณค??ฐ(. -> ,) ๋ฌด์จ?๋ฆฐ์? ๋ชจ๋ฅด๊ฒ ์

public class _4_ArrayCopyEx2 {

	public static void main(String[] args) {
		// int๋ฐฐ์ด?ด ?? '์ฐธ์กฐ ?๋ฃํ'?ผ๋ก?
//		String names[] = new String[5];
//		
//		names[0] = "?๊ธธ๋";
//		names[1] = "?๊บฝ์ ";
//
//		//?ฅ?? for๋ฌ? (?๋ฃํ ๋ณ??๋ช? : ๋ฐฐ์ด?ด๋ฆ?)
//		for (String name : names) {
//			System.out.println(name);
//		}
		
		// Point ๋ฐฐ์ด
		Point pointArr[] = new Point[5];
		
		pointArr[0] = new Point(0,0);
		pointArr[1] = new Point(10,10);
		pointArr[2] = new Point(3,4);
		pointArr[3] = new Point(6,8);
		pointArr[4] = new Point(-5,-5);
	
	
		// ?ฅ?? for๋ฌ?(
		for(Point pt : pointArr) {
			pt.print();
		}
	
		// ๋ณต์ฌ?๊ธ? ?? ๋ฐฐ์ด(2๋ฅ? ๋ง๋ค๊ธ? ??ด)
		Point pointArr2[] = new Point[5];
	
		// pointArr? ?? ? ?ค? pointArr2? ๋ณต์ฌ
		System.arraycopy(pointArr, 0, pointArr2, 0, pointArr.length); // ??? ๋ณต์ฌ
		// pointArr2? ?? ์ฒซ๋ฒ์ง? ? ? 100,0?ผ๋ก? ?ด?
		pointArr2[0].move(100,0);
	
		System.out.println("----Arr2 move-----");
		//?ฅ?? for๋ฌ?
		for(Point pt : pointArr) {
			pt.print();
		}
	
		// >>> ??? ๋ณต์ฌ๋ฅ? ?๊ธ? ?๋ฌธ์  arr1? 0๋ฒ์?๊ฐ? (100,0)?ด ?๊ฑด๊????
		
		for(int i = 0; i < pointArr.length; i++) {
			// pointArr2[i] = pointArr[i]; // ??? ๋ณต์ฌ, ?ด๊ฒ? ???ผ
			pointArr2[i] = new Point(pointArr[i]); // ๊น์? ๋ณต์ฌ / ?๋ก์ด ๊ฐ์ฒด๋ฅ? ๋ง๋ค?ด???? ?ด์ฉ๊ตฌ??? ?ด?ผ?จ..........
	
		}
		
		pointArr2[0].move(-100, -100); // ?๋ก์ด ๋ฐฐ์ด๊ณต๊ฐ? ๋ง๋ค?ด? arr2? 0๋ฒ์? ๊ฐ์ ?ฎ๊ธด๊ฒ?ด๊ธ? ?๋ฌธ์
	
		System.out.println("---------"); // arr1? ๋ฐฐ์ด ๊ฐ์? ๋ณ??จ?ด ??ค. ?ผ? ๊ฒ์ด ๋ง์๊น์? 
		for(Point pt : pointArr) { 
			pt.print();
		}
}
	
// class Point ?ด??ค? ? ๋ณด๋?? ๊ทธ๋?๋ก? ๋ณต์ฌ?ด??? ?? ?? ? ??ฉ?๊ฒ?
}
class Point{
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	

	//๋ณต์ฌ ??ฑ?
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
