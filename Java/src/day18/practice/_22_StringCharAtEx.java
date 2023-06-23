package day18.practice;

import java.util.Scanner;

public class _22_StringCharAtEx {

	public static void main(String[] args) {
		// 2. ���� �ҹ��ڷ� �� ���ڿ��� �Է¹޾� ���ĺ��� ���� � �ִ��� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
		/* input : hello world
		 * a : 0 => 0���� ��� ����
		 * d
		 * e
		 * h
		 * l
		 * o
		 * r
		 * w
		 */
		
		// ���߹ݺ����� ���� �ʰ� �迭�� �����ؼ� ����
		Scanner sc = new Scanner(System.in);
		int alphabet[] = new int[26]; // �� ���ĺ� ������ �����ϴ� �迭. 
									  // 0���� : a�� ����, 1���� : b�� ����
		
		//�Է�
		System.out.print("input : ");
		String str = sc.nextLine();
		
		// �ݺ� : ���ڿ� ���̸�ŭ
			// ���ڿ��� �ѱ��ھ� �����ͼ� ���ĺ��� Ȯ���Ͽ� ���ĺ� ������ ����
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i); // �Ϳ� �̰� �̷��� ���°ſ���?
			// ch�� ���ĺ� �ҹ����� ���, 0���� 25������ ���� ����
			int distance = ch - 'a'; // a -a = 0, b -a = 1,

			// ���� �ҹ��ڰ� �ƴ� ���,
			if(distance < 0 || distance > 25) {
				continue; // �׳� �ǳʶ�.
			}
			// �´� ���, 
			alphabet[distance]++;
		}
		// ���ĺ� ���� �߰� 
		for (int i = 0; i < alphabet.length; i++) {
			
			if(alphabet[i] == 0) {
				continue; // i�������� 0�̸� �ǳʶڴ�.
			}
			System.out.println((char)('a'+ i) + " : " + alphabet[i]); // a ~ z ���� �� ���
		}
				sc.close();
		
	}

}
