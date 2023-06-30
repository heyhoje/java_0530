package day23.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class _1_OutputStreamEx1 {

	public static void main(String[] args) {
		// 1. ������ 1���� 10���� ���Ͽ� �����ϴ� �ڵ带 �ۼ��ϼ���(���ϸ��� output1.txt)
		try(FileOutputStream fos = new FileOutputStream("output1.txt")){
			for(int i = 1+48; i <= 10+48; i++) {
				fos.write(i);
			}
			System.out.println("File wirter Success!!");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try(
			FileOutputStream fos = new FileOutputStream("output2.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeChars("Hello\n");
			for(int i = 1; i <= 10;i++) {
				oos.writeInt(i); // ���� ���ϴ� Ÿ������ �� �� �ִ�. 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

//		try(FileOutputStream fos = new FileOutputStream("output1.txt")){
//			for(int i = 1; i <= 10; i++) {
//				fos.write(i);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}