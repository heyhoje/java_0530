package day23.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class _2_InputStreamEx1 {

	public static void main(String[] args) {
		try(FileInputStream fis = new FileInputStream("output1.txt")){
			int data;
			while( (data = fis.read()) != -1) {
				System.out.print((char)data);
			}
			/*do{
			 * 	data = fis.read();
			 * 	if(data == -1){
			 * 		break;
			 * 	}
			 * 	sysout(data)
			 * }while(true)
			 * */
			System.out.println("File reader success!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(
			FileInputStream fis = new FileInputStream("output2.txt");
			ObjectInputStream ois = new ObjectInputStream(fis)){
			System.out.println(ois.readLine());
			for(int i = 1; i <= 10;i++) {
				System.out.print(ois.readInt()); 
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
