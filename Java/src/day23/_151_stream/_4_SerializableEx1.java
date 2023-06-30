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
			// ��� ������Ʈ���� ��ݽ�Ʈ���� �ʿ��ϴ�
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
			// ���ܸ� �̿��ؼ� �����б⸦ ������ / IOException�� �θ�Ŭ������ ���� ��ġ
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
//    �� add generated serial version Id
	private static final long serialVersionUID = 2641035021389845412L;
	
	// ���� ������ ����� ���� ����Ŭ�����θ� ������
	// ���� Ŭ������ ������ �����������.
	// ������ ���ƾ߸� ����ȭ/������ȭ�� ����
	private int grade, classNum, num;
	private String name;
	private transient String registerId; // transient : ������ȭ���� ���ܵǴ� Ű����. �� �ִ� ����
}