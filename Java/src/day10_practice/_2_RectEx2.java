package day10_practice;

import java.awt.Point;

// ����Ʈ Ŭ������ ��� ����

public class _2_RectEx2 {

	public static void main(String[] args) {
//		Rect1 r = new Rect1(0,0,10,10);
//		r.print(); // �簢�� ����
//		r.move(10,10);
//		r.print();
//			
//		r.resize(10,10,20,20);
//		r.print();
//			
//		r.resize(0,0,30,30);
//		r.print();
		
		System.out.println("----R2 start!----");
		Rect2 r2 = new Rect2(new Point(0,0), new Point(10,10));
		r2.print();
		r2.move(10,10);
		r2.print();
		r2.resize(10,10,20,20);
		r2.print();
		r2.resize(0, 0, 30, 30);
		r2.print();
		
	}

}

class Rect2 {
	// �������
	private Point leftUp, rightDown;

	// ������
	public Rect2(Point leftUp, Point rightDown) {
		this.leftUp = leftUp;
		this.rightDown = rightDown;
	}
	
	public Rect2(int leftUpX, int leftUpY, int rightDownX, int rightDownY) {
		leftUpX = new Point(leftUpX, leftUpY);
		rightDownX = new Point(rightDownX, rightDownY);
	}
	
	//�޼ҵ�
	/** ��� : �簢�� ������ ����ϴ� �޼ҵ�
	 * �Ű����� : ����(�簢���� ���̱� ������, �������� �̹� �˰�����)
	 * ����Ÿ�� : ����(����ϸ� ���̱� ������ �˷��ٰ� ����) => void
	 * �޼ҵ�� : print
	 */
	public void print() {
		System.out.println("------�簢�� ����------");
		System.out.println("Left Up point : ");
		leftUp.print();
		System.out.println("Right Down point : ");
		rightDown.print();
	}
	
	/** ��� : �簢���� �̵���Ű�� �޼ҵ�(��ǥ ����)
	 * �Ű����� : �̵���ų ���� ���� �� => int x, int y
	 * ����Ÿ�� : (���� �ٲٴ� ��) ���� => void
	 * �޼ҵ�� : move
	 * ���� 0.0			10.10
	 *     ���� 10.10			20.20
	 */
	public void move(int x, int y) {
		int dx = leftUp.getX() - x; // �̵��� x��ǥ �Ÿ� , -10
		int dy = leftUp.getY() - y; // �̵��� y��ǥ �Ÿ� , -10
		leftUp.move(x, y);
		rightDown.move(rightDown.getX() - dx, rightDown.getY - dy);
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
		leftUp.move(x, y);
		rightDown.move(x+w, y+h);
	}
}