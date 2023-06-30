package day23._151_stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

// ��ݽ�Ʈ�� + ������Ʈ�� : ����� �߰��Ѵ�.
// �̷� ����� �ִ�. ��� ������ ���
public class _3_StreamEx3 {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("test.txt")){
			BufferedInputStream bis = new BufferedInputStream(fis);
			InputStreamReader isr = new InputStreamReader(bis);
			// ��ݽ�Ʈ�� + ������Ʈ�� : ����� �߰��Ѵ�. 
			
			char ch[] = new char[1024];
			while(isr.read(ch) != -1) {
				System.out.println(ch);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
