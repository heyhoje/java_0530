package day7_041_ContinueEx;

public class _1_EvenNumberEx {

	public static void main(String[] args) {
		// continue���� �̿��� 10 ���� ¦�� ��� ����
		
		int i;
		for(i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
//		System.out.println("---------");
//		i = 0;
//		for(i = 1; i <=10; i++) {
//			continue; // �ٷ� ���������� �̵�, �Ʒ� i��¹����� �̵����� �ʴ´�.
//			System.out.println(i);
//		}
		
		System.out.println("----2-----");
		i = 0;
		for(i = 1; i <=10; i++) {
			if(i % 2 != 0) {
			continue; 
			}
			System.out.println(i);
			
		}
		
//		System.out.println("---------");
//		i = 1;
//		while(i <= 10) {
//			if(i % 2 != 0) {
//				continue; // i�� �������� �ʰ� 1�� ���·� ��� �Դٰ��ٸ� �Ѵ�.
//			}
//			System.out.println(i);
//			++i;
//		}
		System.out.println("----3-----");
		i = 1;
		while(i <= 10) {
			if(i % 2 != 0) {
				i++;
				continue; // i�� �������� �ʰ� 1�� ���·� ��� �Դٰ��ٸ� �Ѵ�.
			}
			System.out.println(i);
			++i;
		}
		
		System.out.println("----4-----");
		i = 0;
		while( ++i <= 10) { // �������� ���ǹ��� ���Ե��־ ���ѷ����� ������ �ʰ� ��������
			if(i % 2 != 0) {
				
				continue; // i�� �������� �ʰ� 1�� ���·� ��� �Դٰ��ٸ� �Ѵ�.
			}
			System.out.println(i);
			++i;
		}
	}

}
