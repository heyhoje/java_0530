package day25.tc.student.vo;

import java.io.Serializable;

//import lombok.AllArgsConstructor;
//import lombok.Data;

//@AllArgsConstructor
//@Data
public class Student implements Serializable {
	
	/** add generated sirialversionUID
	 */
	private static final long serialVersionUID = -3893767269811563720L;
	
	// Ŭ���� �ȿ��� ����� ���� = �������
	// 1. �������
	private String num, name, major;
	
	// 2. ������
	public Student(String num, String name, String major) {
		super();
		this.num = num;
		this.name = name;
		this.major = major;
	}

	// 3. getter, setter 
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String toString() {
		return "�й� : " + num + ", \n�̸� : " + name + ", \n���� : " + major + "";
	}
	
	
	
	
}
