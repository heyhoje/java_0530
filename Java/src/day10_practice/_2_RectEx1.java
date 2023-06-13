package day10_practice;

public class _2_RectEx1 {

	public static void main(String[] args) {
		Rect1 r = new Rect1(0,0,10,10);
		r.print(); // �簢�� ����
		r.move(10,10);
		r.print();
			
		r.resize(10,10,20,20);
		r.print();
			
		r.resize(0,0,30,30);
		r.print();
	
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
	 * �Ű����� : ����(�簢���� ���̱� ������, �������� �̹� �˰�����)
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
