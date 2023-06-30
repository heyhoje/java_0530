package day23._15_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

// [byte 단위로 파일을 읽고 쓰는 예제]
public class _1_StreamEx1 {

	public static void main(String[] args) {
		/* test.txt는 상대 경로. 기준은 프로젝트 폴더가 기준
		 * 어디서 찾으라구요...?? java.jik ??
		 * day패키지 말고 <맨 위에 java에서 ctrl+N -> file -> test.txt 파일 추가>하면
		 * 파일이 생기기 때문에 File not found 문제가 해결됨(콘솔창 비어짐)
		 * */
		
		/*
		 * FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} finally {
			// 프로그램 종료 전, 사용했던 파일을 닫아주는 작업. 할일끝
			if(fis != null) {
				try {
					fis.close(); // 또!!!!!! 써라운드 try.catch 한대요!!!!!ㅠㅠㅠㅠㅠㅠ
					// 파일과 관련된 코드는 열고 닫아줘야해서 길어질 수밖에밖에.........없대요....
					// 안쓰면 안될까?????
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/ // 위와 아래의 코드가 같다.
		Scanner sc = new Scanner(System.in);
		// [byte 단위로 파일을 읽고 쓰는 예제]
		// 2. 파일을 쓰는 예제
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
		
		// 1. 파일을 읽는 예제 
		try (FileInputStream fis2 = new FileInputStream("test.txt")){
			int data;
			while((data = fis2.read()) != -1) {
				System.out.println((char)data);
			} // 숫자로 입력했지만 문자열로 읽어옴 => 걔의 정수값을 반환
			// => (char) 로 형변환. char : 2byte. 
			// '한글' 아스키코드로 저장, ,,,,,,,,,,,, FileInputStream은 1byte
			// FileInputStream 한글이 깨지는 결과가 발생할 수 있다 >> Reader로 나중에
			
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
