package day23._151_stream;

import java.io.File;
import java.io.IOException;

// File Ŭ���� : ���� ������ �߻�ȭ. 
// ���� ��ü�� ��γ� ������ �� �� �ְ�, ���� �Ǵ� ������ ������ �� ����
public class _5_FileEx {

	public static void main(String[] args) {
		File file = new File("test.txt");
		try {
			// �ش� ���� �Ǵ� ������ �������� �ʰ�, 
			// �̸��� . �� ����(Ȯ���ڰ� �����ϸ�) ������ ����!!
			if(!file.exists() && file.getName().contains(".")) {
				file.createNewFile();
				System.out.println("Create File!");
			}
			
			// �ش� ����/������ �������� �ʰ�,
			// �̸��� . �� �ȵ���(Ȯ���ڰ� ������) ������ ����!!
			if(!file.exists() && !file.getName().contains(".")) {
				file.mkdir();
				System.out.println("Create Directory!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
