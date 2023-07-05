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
	
	// 클래스 안에서 선언된 변수 = 멤버변수
	// 1. 멤버변수
	private String num, name, major;
	
	// 2. 생성자
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
		return "학번 : " + num + ", \n이름 : " + name + ", \n전공 : " + major + "";
	}
	
	
	
	
}
