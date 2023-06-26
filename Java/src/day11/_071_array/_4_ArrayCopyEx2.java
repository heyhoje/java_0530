package day11._071_array;

//?•ˆ?˜?Š”ê±? ê³ ì³¤?Š”?°(. -> ,) ë¬´ìŠ¨?†Œë¦°ì? ëª¨ë¥´ê² ìŒ

public class _4_ArrayCopyEx2 {

	public static void main(String[] args) {
		// intë°°ì—´?´ ?•„?‹Œ 'ì°¸ì¡° ?žë£Œí˜•'?œ¼ë¡?
//		String names[] = new String[5];
//		
//		names[0] = "?™ê¸¸ë™";
//		names[1] = "?ž„êº½ì •";
//
//		//?–¥?ƒ?œ forë¬? (?žë£Œí˜• ë³??ˆ˜ëª? : ë°°ì—´?´ë¦?)
//		for (String name : names) {
//			System.out.println(name);
//		}
		
		// Point ë°°ì—´
		Point pointArr[] = new Point[5];
		
		pointArr[0] = new Point(0,0);
		pointArr[1] = new Point(10,10);
		pointArr[2] = new Point(3,4);
		pointArr[3] = new Point(6,8);
		pointArr[4] = new Point(-5,-5);
	
	
		// ?–¥?ƒ?œ forë¬?(
		for(Point pt : pointArr) {
			pt.print();
		}
	
		// ë³µì‚¬?•˜ê¸? ?œ„?•œ ë°°ì—´(2ë¥? ë§Œë“¤ê¸? ?œ„?•´)
		Point pointArr2[] = new Point[5];
	
		// pointArr?— ?žˆ?Š” ? ?“¤?„ pointArr2?— ë³µì‚¬
		System.arraycopy(pointArr, 0, pointArr2, 0, pointArr.length); // ?–•?? ë³µì‚¬
		// pointArr2?— ?žˆ?Š” ì²«ë²ˆì§? ? ?„ 100,0?œ¼ë¡? ?´?™
		pointArr2[0].move(100,0);
	
		System.out.println("----Arr2 move-----");
		//?–¥?ƒ?œ forë¬?
		for(Point pt : pointArr) {
			pt.print();
		}
	
		// >>> ?–•?? ë³µì‚¬ë¥? ?–ˆê¸? ?–„ë¬¸ì—  arr1?˜ 0ë²ˆì?ê°? (100,0)?´ ?œê±´ê????
		
		for(int i = 0; i < pointArr.length; i++) {
			// pointArr2[i] = pointArr[i]; // ?–•?? ë³µì‚¬, ?´ê²? ?•„?‹ˆ?¼
			pointArr2[i] = new Point(pointArr[i]); // ê¹Šì? ë³µì‚¬ / ?ƒˆë¡œìš´ ê°ì²´ë¥? ë§Œë“¤?–´?„œ??? ?–´ì©Œêµ¬??? ?•´?•¼?•¨..........
	
		}
		
		pointArr2[0].move(-100, -100); // ?ƒˆë¡œìš´ ë°°ì—´ê³µê°„?„ ë§Œë“¤?–´?„œ arr2?˜ 0ë²ˆì? ê°’ì„ ?˜®ê¸´ê²ƒ?´ê¸? ?•Œë¬¸ì—
	
		System.out.println("---------"); // arr1?˜ ë°°ì—´ ê°’ì? ë³??•¨?´ ?—†?‹¤. ?¼?Š” ê²ƒì´ ë§žì„ê¹Œìš”? 
		for(Point pt : pointArr) { 
			pt.print();
		}
}
	
// class Point ?´?ž˜?Š¤?˜ ? •ë³´ë?? ê·¸ë?ë¡? ë³µì‚¬?•´???„œ ?œ„?˜ ?˜ˆ? œ?— ?™œ?š©?•œê²?
}
class Point{
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	

	//ë³µì‚¬ ?ƒ?„±?ž
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
