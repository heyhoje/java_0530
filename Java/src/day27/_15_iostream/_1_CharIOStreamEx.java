package day27._15_iostream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _1_CharIOStreamEx {

	public static void main(String[] args) {
		//���� ������ �о���� ����
		try(FileReader fr = new FileReader("file.txt")){
			char buffer[] = new char[1024];
			while(fr.read(buffer) != -1) {
				System.out.print(buffer);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found!");
		} catch (IOException e) {
			System.out.println("Exception!");
		}
		
		// ���� ������ ���� ����
		// FileWriter������(���ϸ�, �̾�� ����) : �̾�� ���ΰ� true�̸� �̾ �ۼ���
		// FileWriter������(���ϸ�) : �̾�� ���ΰ� false�� ����
		try(FileWriter fw = new FileWriter("file.txt", true)){
			String str = "Hello world!\n";
			fw.write(97);
			String str2 = "Hi. Java!\n";
			fw.write(100);
			
		} catch (IOException e) {
			System.out.println("Exception!");
		}
	}

}
