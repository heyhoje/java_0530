package com.kh.test.model.vo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Food implements Serializable{

	private static final long serialVersionUID = -2059979293952303196L;
	
	private String name;
	private int Kcal;
	
	public Food(String name, int kcal) {
		this.name = name;
		Kcal = kcal;
	}

	@Override
	public String toString() {
		return "음식 이름 : " + name + ", 칼로리 : " + Kcal;
	}
	
	String fileName = "src/com.kh.test/model.vo/Food.txt";
	
	List<Food> foodList = new ArrayList<>();
	list.add(new Food("사과", 20));
	
	
	private void saveFood(String fileName) {
		try(
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)){
				for(Food tmp : foodList) {
					oos.writeObject(tmp);
				}
		} catch (IOException e) {
			e.printStackTrace();
			}		
	}
}
