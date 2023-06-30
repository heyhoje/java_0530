package day23._15_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// ����µ� �׽�Ʈ ������ �ٽ� �ؾ߰ڴ� ^^^^^^^^^^ 
// ���� ����� ��Ʈ��
public class _2_StreamEx2 {

	public static void main(String[] args) {
		// ���Ͽ� ���ڵ��� ��
		try(FileWriter fw = new FileWriter("test.txt")){
			for(int i = 0; i < 5; i++) {
				fw.write("�ȳ��սô�" + i + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ���Ͽ� �����ִ� ���ڵ��� �о��
		
		try(FileReader fr = new FileReader("test.txt")){
			char ch[] = new char[10]; 
			// new char[1024] �迭�� ����� ũ�Ը����, �ѹ��� �� ����ؼ� ������ �������� ����..?
			int len;
			while((len = fr.read(ch)) != -1) {
				for(int i = 0; i < len; i++) {
					System.out.print(ch[i]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
