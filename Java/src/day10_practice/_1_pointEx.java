package day10_practice;

//_1_pointEx ����Ʈ Ŭ���� ���鿡�� �����صα�

public class _1_pointEx {

	public static void main(String[] args) {
		// ��ǥ�� ���� �����ϴ� Ŭ������ ����� �׽�Ʈ�ϴ� �ڵ带 �ۼ��ϼ���.
		// �ʿ��� �Ӽ��� ����� �����ؼ� �߰��غ�����(��: �׸��� �ϴ��� ��ǥ)
		Point pt1 = new Point();
		pt1.print();
		pt1.move(10, 20);
		pt1.print();
		
		Point pt2 = new Point(30, 40);
		pt2.print();
		
	}
}

// ��ǥ�� ���� �����ϴ� Ŭ����
	/* Ŭ������ ���������ڰ� public���� �� �� �ִ� ����
	 * - ���ϸ�� Ŭ�������� ���ƾ� public�� ���� �� �ִ�.
	 * - ���� ��Ű���� ���� �̸��� Ŭ������ ������ �ȵ�
	 * */
class Rect1 {
	// �������
	/* ���� ���� �� x��ǥ, ���� ���� �� y��ǥ
	 * ������ �Ʒ��� �� x��ǥ, ������ �Ʒ� �� y��ǥ*
	 */
	private int leftUpX, leftUpY;
	private int rightDownX, rightDownY;
	
	// ������ �� public
	public Rect1(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		this.leftUpX = leftUpX;
		this.leftUpY = leftUpY;
		this.rightDownX = rightDownX;
		this.rightDownY = rightDownY;
	}
	
	// getter, setter
	// ����, ���⼭�� �ش� ����� �ʿ����� ����
		
	
	//�޼���
	/** ��� : ���� ��ǥ�� ����ϴ� ���
	 * �Ű����� : ����(�� ��ǥ�̱� ������ �̹� �˰�����)
	 * ����Ÿ�� : ����(����ϸ� ���̱� ������ �˷��ٰ� ����
	 * �޼ҵ�� : print
	 */
	public void print() {
		System.out.println("" + x + ", " + y + "px");
	}
	
	/** ��� : �־��� x, y��ǥ�� �̵��ϴ� �޼ҵ�(��ǥ ����)
	 * => ������� x, y�� �־��� x, y�� �����ϴ� �޼ҵ�
	 * �Ű����� : �־��� x, y => int x, int y
	 * ����Ÿ�� : ���� => void
	 * ��ex) setteró��
	 * �޼ҵ�� : move
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
	

