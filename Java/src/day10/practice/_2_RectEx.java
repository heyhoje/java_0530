package day10.practice;

public class _2_RectEx {

	public static void main(String[] args) {
		Rect1 r = new Rect1(0,0,10,10);
		r.print(); // �簢�� ����
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

// �簢���� 4���� ���� 4���� ������ �̷��������. ���� �� ���ϸ� 360��.
// => �� 4���� ��� ����. x 1-4, y 1-4
// => ������ ���� - ������ ��. �� 2��
// => �� 1�� - ����, ����

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
	/** ��� : �簢�� ������ ����ϴ� �޼ҵ�
	 * �Ű����� : ����(�簢���� '��'�̱� ������, �� ������ �̹� �˰�����)
	 * ����Ÿ�� : ����(����ϸ� ���̱� ������ �˷��ٰ� ����) => void
	 * �޼ҵ�� : print
	 */
	public void print() {
		System.out.println("------�簢�� ����------");
		System.out.println("Left Up point : " + leftUpX + ", " + leftUpY);
		System.out.println("Right Down point : " + rightDownX + ", " + rightDownY);
	}
	
	/** ��� : �簢���� �̵���Ű�� �޼ҵ�(��ǥ ����)
	 * �Ű����� : �̵���ų ���� ���� �� => int x, int y
	 * ����Ÿ�� : (���� �ٲٴ� ��) ���� => void
	 * �޼ҵ�� : move
	 * ���� 0.0			10.10
	 *     ���� 10.10			20.20
	 */
	public void move(int x, int y) {
		int dx = leftUpX - x; // �̵��� x��ǥ �Ÿ� , -10
		int dy = leftUpY - y; // �̵��� y��ǥ �Ÿ� , -10
		leftUpX = x;
		leftUpY = y;
		rightDownX = rightDownX - dx;// 10 - -10 = 20
		rightDownY = rightDownY - dy;
	}
	
	/** �簢���� ũ�⸦ �����ϴ� �޼ҵ�
	 * �Ű����� : ����� �簢���� ���� ���� x,y��ǥ��
	 * 			����, ���ΰ� �־����� �簢���� ũ�⸦ �����ϴ� �޼ҵ�
	 * 			=> int x, int y, int w, int h
	 * ����Ÿ�� : (���� �ٲٴ°�) ���� => void
	 * �޼ҵ�� : resize
	 */
	public void resize(int x, int y, int w, int h) {
		leftUpX = x;
		leftUpY = y;
		rightDownX = x + w;
		rightDownY = y + h;
	}
}

class Rect2{
	// �������
	private Point leftUp, rightDown;
	
	// ������
	public Rect2(Point leftUp, Point rightDown) {
		this.leftUp = leftUp;
		this.rightDown = rightDown;
		
	}
	
	//�޼ҵ�
	/** ��� : �簢�� ������ ����ϴ� �޼ҵ�
	 * �Ű����� : ����
	 * ����Ÿ�� : ���� => void 
	 * �޼ҵ�� : print
	 */
	public void print() {
		System.out.println("----Rect2-----");
		System.out.println("LeftUp point : " );
		leftUp.print();
		System.out.println("RightDown point : ");
		rightDown.print();
		
	}

	/** ��� : �簢���� �̵���Ű�� �޼ҵ�
	 * �Ű����� : �̵���ų ���� ���� �� => int x, int y
	 * ����Ÿ�� : ���� => void
	 * �޼ҵ�� : move
	 * 0,0				10,10
	 * 		10,10				20,20
	 */
	
	public void move(int x, int y) {
		int dx = leftUp.getX() -x; //�̵��� x��ǥ �Ÿ�, -10
		int dy = leftUp.getY() -y; // �̵��� y��ǥ �Ÿ�, -10
		leftUp.move(x, y);
		rightDown.move(rightDown.getX() - dx, rightDown.getY() - dy);
	}
	
	/**��� : �簢���� ũ�⸦ �����ϴ� �޼ҵ�
	 * �Ű����� : ����� �簢���� ���� ���� x, y��ǥ��
	 * 			����, ���ΰ� �־����� �簢���� ũ�⸦ �����ϴ� �޼ҵ�
	 * 			=> int x, int y, int w, int h
	 * ����Ÿ�� : ���� => void
	 * �޼ҵ�� : resize
	 */
	public void resize(int x, int y, int w, int h) {
		leftUp.move(x,y);
		rightDown.move(x+w,y+h);
	}
}
