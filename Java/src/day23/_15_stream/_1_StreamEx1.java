package day23._15_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

// [byte ������ ������ �а� ���� ����]
public class _1_StreamEx1 {

	public static void main(String[] args) {
		/* test.txt�� ��� ���. ������ ������Ʈ ������ ����
		 * ��� ã���󱸿�...?? java.jik ??
		 * day��Ű�� ���� <�� ���� java���� ctrl+N -> file -> test.txt ���� �߰�>�ϸ�
		 * ������ ����� ������ File not found ������ �ذ��(�ܼ�â �����)
		 * */
		
		/*
		 * FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} finally {
			// ���α׷� ���� ��, ����ߴ� ������ �ݾ��ִ� �۾�. ���ϳ�
			if(fis != null) {
				try {
					fis.close(); // ��!!!!!! ����� try.catch �Ѵ��!!!!!�ФФФФФ�
					// ���ϰ� ���õ� �ڵ�� ���� �ݾ�����ؼ� ����� ���ۿ��ۿ�.........�����....
					// �Ⱦ��� �ȵɱ�?????
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/ // ���� �Ʒ��� �ڵ尡 ����.
		Scanner sc = new Scanner(System.in);
		// [byte ������ ������ �а� ���� ����]
		// 2. ������ ���� ����
		try(FileOutputStream fos = new FileOutputStream("test.txt")){
			for(int i = 0; i < 5; i++) {
				System.out.print("input : ");
				char ch = sc.next().charAt(0);
				fos.write(ch);
			}
			
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found!!!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// 1. ������ �д� ���� 
		try (FileInputStream fis2 = new FileInputStream("test.txt")){
			int data;
			while((data = fis2.read()) != -1) {
				System.out.println((char)data);
			} // ���ڷ� �Է������� ���ڿ��� �о�� => ���� �������� ��ȯ
			// => (char) �� ����ȯ. char : 2byte. 
			// '�ѱ�' �ƽ�Ű�ڵ�� ����, ,,,,,,,,,,,, FileInputStream�� 1byte
			// FileInputStream �ѱ��� ������ ����� �߻��� �� �ִ� >> Reader�� ���߿�
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("----------");
		System.out.println(1);
		System.out.println('1');
		System.out.println((int)'1');
		System.out.println("----------");
	}
}
