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
class Point{
	//�������
	// x��ǥ, y��ǥ
	private int x, y;
	
	// ������
	public Point() {}
	// ������ �����ε�. x,y��ǥ�� �־������� ��ü�� �ʱ�ȭ
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	// getter�� setter (�޼��忡 ����)
	/* getter
	 * public ����Ÿ�� get������() {
	 * 				return ������;
	 * }
	 * get�������� �������� ù ���ڸ� �빮�ڷ�
	 * ����Ÿ���� ������ �ڷ���
	 * 
	 * setter
	 * public void set������(�ڷ��� ������) {
	 * 				this.������ = ������;
	 * }
	 * */
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	//�޼���
	/**���� ��ǥ�� ����ϴ� �޼���
	 * �Ű����� : ����.
	 * ����Ÿ�� : ���� => void
	 * �޼���� : print
	 */
	public void print() {
		System.out.println("" + x + "," + y + "px");
	}
	
	/**�־��� x,y��ǥ�� �̵��ϴ� �޼���
	 *  =>������� x,y�� �־��� x,y�� �����ϴ� �޼���
	 * �Ű����� : �־��� x,y => int x,int y
	 * ����Ÿ�� : ���� => void
	 * �޼���� : move
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
	

