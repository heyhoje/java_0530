package day23._151_stream;

import java.io.File;
import java.io.IOException;

// File 클래스 : 파일 개념을 추상화. 
// 파일 자체의 경로나 정보를 알 수 있고, 파일 또는 폴더를 생성할 수 있음
public class _5_FileEx {

	public static void main(String[] args) {
		File file = new File("test.txt");
		try {
			// 해당 파일 또는 폴더가 존재하지 않고, 
			// 이름에 . 이 들어가면(확장자가 존재하면) 파일을 생성!!
			if(!file.exists() && file.getName().contains(".")) {
				file.createNewFile();
				System.out.println("Create File!");
			}
			
			// 해당 파일/폴더가 존재하지 않고,
			// 이름에 . 이 안들어가면(확장자가 없으면) 폴더를 생성!!
			if(!file.exists() && !file.getName().contains(".")) {
				file.mkdir();
				System.out.println("Create Directory!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
