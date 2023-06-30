package day23._151_stream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

// 기반스트림 + 보조스트림 : 기능을 추가한다.
// 이런 기능이 있다. 라는 정도만 기억
public class _3_StreamEx3 {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("test.txt")){
			BufferedInputStream bis = new BufferedInputStream(fis);
			InputStreamReader isr = new InputStreamReader(bis);
			// 기반스트림 + 보조스트림 : 기능을 추가한다. 
			
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
