package day23._15_stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

// [byte 舘是稽 督析聖 石壱 床澗 森薦]
public class _1_StreamEx1 {

	public static void main(String[] args) {
		/* test.txt澗 雌企 井稽. 奄層精 覗稽詮闘 虹希亜 奄層
		 * 嬢巨辞 達生虞姥推...?? java.jik ??
		 * day鳶徹走 源壱 <固 是拭 java拭辞 ctrl+N -> file -> test.txt 督析 蓄亜>馬檎
		 * 督析戚 持奄奄 凶庚拭 File not found 庚薦亜 背衣喫(嬬車但 搾嬢像)
		 * */
		
		/*
		 * FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} finally {
			// 覗稽益轡 曽戟 穿, 紫遂梅揮 督析聖 丸焼爽澗 拙穣. 拝析魁
			if(fis != null) {
				try {
					fis.close(); // 暁!!!!!! 潤虞錘球 try.catch 廃企推!!!!!ばばばばばば
					// 督析引 淫恵吉 坪球澗 伸壱 丸焼操醤背辞 掩嬢霜 呪鉱拭鉱拭.........蒸企推....
					// 照床檎 照吃猿?????
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/ // 是人 焼掘税 坪球亜 旭陥.
		Scanner sc = new Scanner(System.in);
		// [byte 舘是稽 督析聖 石壱 床澗 森薦]
		// 2. 督析聖 床澗 森薦
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
		
		// 1. 督析聖 石澗 森薦 
		try (FileInputStream fis2 = new FileInputStream("test.txt")){
			int data;
			while((data = fis2.read()) != -1) {
				System.out.println((char)data);
			} // 収切稽 脊径梅走幻 庚切伸稽 石嬢身 => 安税 舛呪葵聖 鋼発
			// => (char) 稽 莫痕発. char : 2byte. 
			// '廃越' 焼什徹坪球稽 煽舌, ,,,,,,,,,,,, FileInputStream精 1byte
			// FileInputStream 廃越戚 凹走澗 衣引亜 降持拝 呪 赤陥 >> Reader稽 蟹掻拭
			
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
