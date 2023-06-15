package day11_array;

//�ȵǴ°� ���ƴµ�(. -> ,) �����Ҹ��� �𸣰���

public class _4_ArrayCopyEx2 {

	public static void main(String[] args) {
		// int�迭�� �ƴ� ���� �ڷ�������
//		String names[] = new String[5];
//		
//		names[0] = "ȫ�浿";
//		names[1] = "�Ӳ���";
//
//		//���� for�� (�ڷ��� ������ : �迭�̸�)
//		for (String name : names) {
//			System.out.println(name);
//		}
		//Point �迭
		Point pointArr[] = new Point[5];
		
		pointArr[0] = new Point(0,0);
		pointArr[1] = new Point(10,10);
		pointArr[2] = new Point(3,4);
		pointArr[3] = new Point(6,8);
		pointArr[4] = new Point(-5,-5);
	
	
		//���� for��(
		for(Point pt : pointArr) {
			pt.print();
		}
	
		//�����ϱ� ���� �迭(2�� ����� ����)
		Point pointArr2[] = new Point[5];
	
		//pointArr�� �ִ� ������ pointArr2�� ����
		System.arraycopy(pointArr, 0, pointArr2, 0, pointArr.length);
		//pointArr2�� �ִ� ù��° ���� 100,0���� �̵�
		pointArr2[0].move(100,0);
	
		System.out.println("---------");
		//���� for��
		for(Point pt : pointArr) {
			pt.print();
		}
	
		for(int i = 0; i < pointArr.length; i++) {
			// pointArr2[i] = pointArr[i]; // ���� ����, �̰� �ƴ϶�
			pointArr2[i] = new Point(pointArr[i]); // ���� ���� / ���ο� ��ü�� ���� ��¼�� �ؾ���..........
	
		}
		
		pointArr2[0].move(-100, -100);
	
		System.out.println("---------");
		for(Point pt : pointArr) {
			pt.print();
		}
}
	
	
}
class Point{
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	

	//���� ������
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
