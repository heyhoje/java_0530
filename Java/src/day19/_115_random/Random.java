package day19._115_random;

// import java.util.Random �ƾƾƾ� ���ϴ��� ������ nextInt�� ���� ���ִپƾ�
import java.util.Random;

public class Random {

	public static void main(String[] args) {
		/*min ~ max ������ ������ ���� : Math.random �̿�*/
		
		int min = 1, max = 9;
		int r = (int)(Math.random()*(max - min + 1) + min);
		System.out.println(r);
		
		/* min ~ max ������ ������ ���� : Random Ŭ���� �̿�*/
		// import Random 
		Random random = new Random(); // �Ź� �ٸ� ���ڰ�(����ð�)�� �̿��ϱ� ������ ������ �Ź� �޶���  
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
	}

}
