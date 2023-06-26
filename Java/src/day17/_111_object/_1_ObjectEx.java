package day17._111_object;

import java.util.Objects;
import lombok.Data;

public class _1_ObjectEx {

	// 1. toString : �߿����� ������, ������
	// 2. equals() : ��¥ �߿�! �ʼ�!
	// 4. Clone() ���� : �˾Ƶθ� ����
	
	public static void main(String[] args) throws CloneNotSupportedException { // +Ŭ�� ����ó��
		System.out.println("-----pt1-----");
		Point1 pt1 = new Point1(10, 20);
		System.out.println(pt1); // day17.object.Point1@1ddc4ec2
		System.out.println(pt1.toString()); // ����� ����. 
						  // ��
		System.out.println("-----pt1/pt11-----");
		Point1 pt11 = new Point1(10, 20);
		System.out.println(pt1 == pt11); // ��ǥ�� ���� / �ּҴ� �ٸ�
		System.out.println(pt1.equals(pt11)); // true! @Data ������ �������̵� �Ǽ� ���� �ּҰ��� ��
		
		System.out.println("-----pt2-----");
		Point2 pt2 = new Point2(30, 40);
		System.out.println(pt2);
		
		System.out.println("-----pt2/pt21-----");
		Point2 pt21 = new Point2(30, 40);
		System.out.println(pt2 == pt21);
		System.out.println(pt2.equals(pt21)); // false! @Data �������̵� ���ؼ�. �ּҰ��� �ٸ�.
											  // equals�� �������̵� �ؼ� true�� �ٲ�. 
		
		System.out.println("-----clone����-----");
		//Clone()�� �̿��ؼ� ������ ����� ��
		Point2 pt22 = (Point2)pt2.clone(); // Ŭ�� ����Ÿ�� Object! �ٿ�ĳ���� => (Ŭ������)�� �ݵ�� �߰�
		// �ּҰ� �ٸ�����!
		System.out.println(pt2 == pt22);
		// �� ��ü�� ���ٰ� �Ǻ�!!
		System.out.println(pt2.equals(pt22)); // true! ������ ����� �Ʊ� ������
		System.out.println(pt22); // pt2�� ����! Point2 [x=30, y=40]
	}

}
// 1. toString
@Data 
// toString(), equals(), hashcode()�� �������̵�
// getter, setter�� �ڵ� ����
class Point1 {
	private int x, y;
	
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}

// 4. Clone() ����
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
	public String toString() { // ��ü���� Ȯ���Ҷ� �����ϰ� ����!!!!!!!!! 
		return "Point2 [x=" + x + ", y=" + y + "]"; // ��Ŭ�� + source + 'generate toString'
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	// 2. equals
	@Override
	public boolean equals(Object obj) { // ��Ŭ�� > source > generate hash() and equals()
		// �ּҸ� ��(�� ��ü�� ���� �ּ� == �Ű����� obj), 
		// �ּҰ� ������ ���� ��ü�� ����
		if (this == obj)
			return true;
		
		// obj ���� ��ü(����ִ�x) �ʹ� ���� �� ���� false!
		if (obj == null)
			return false;
		
		// �� Ŭ������ ���� ��ü�� Ŭ������ �ٸ� ���. �񱳸� ���� false!
		// ��Ȳ�� ���� ���ϴ� �ڵ�� ���� �� ����. 
		if (getClass() != obj.getClass())
			return false;
		
		// ���� ��ü�� Ŭ������ ���� Ŭ������ ���(Point2�� ???)
		Point2 other = (Point2) obj;
		// ������� ���ؼ� ���� �������� Ȯ��! 
		return x == other.x && y == other.y;
	}
	
	// 4. Clone() + ����ó��
	public Object clone() throws CloneNotSupportedException { // +����ó��
		return super.clone();
	}
}