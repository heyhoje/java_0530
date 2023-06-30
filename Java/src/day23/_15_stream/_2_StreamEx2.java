package day23._15_stream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 입출력도 테스트 끝나고 다시 해야겠다 ^^^^^^^^^^ 
// 문자 입출력 스트림
public class _2_StreamEx2 {

	public static void main(String[] args) {
		// 파일에 문자들을 씀
		try(FileWriter fw = new FileWriter("test.txt")){
			for(int i = 0; i < 5; i++) {
				fw.write("안녕합시다" + i + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 파일에 쓰여있는 문자들을 읽어옴
		
		try(FileReader fr = new FileReader("test.txt")){
			char ch[] = new char[10]; 
			// new char[1024] 배열을 충분히 크게만들면, 한번에 다 출력해서 나머지 떨거지가 없다..?
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
