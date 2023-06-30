package day23._151_stream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

public class _4_SerializableEx1 {

	public static void main(String[] args) {
		Student std1 = new Student(1, 1, 1, "Hong");
		Student std2 = new Student(1, 1, 2, "Lim");
		
		try(
			FileOutputStream fos = new FileOutputStream("student.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
			// 모든 보조스트림은 기반스트림이 필요하다
				oos.writeObject(std1);
				oos.writeObject(std2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<Student> list = new ArrayList<>();
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream("student.txt"))){
			while(true) {
				try {
					Student tmp = (Student)ois.readObject();
					list.add(tmp);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			// 예외를 이용해서 파일읽기를 마무리 / IOException이 부모클래스라 위에 배치
		} catch(EOFException e) {
			System.out.println("File Read Complete!!");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		System.out.println(list);
	}
}

@Data
@AllArgsConstructor
class Student implements Serializable{ 
//    ㄴ add generated serial version Id
	private static final long serialVersionUID = 2641035021389845412L;
	
	// 딱히 구현할 기능은 없고 구현클래스로만 만들면됨
	// 현재 클래스의 버전을 관리해줘야함.
	// 버전이 같아야만 직렬화/역직렬화가 가능
	private int grade, classNum, num;
	private String name;
	private transient String registerId; // transient : 역직렬화에서 제외되는 키워드. 가 있다 정도
}