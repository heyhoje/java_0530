package com.kh.test;

import java.util.ArrayList;

public class Mycollection {
	public void test() {
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		list.add(new Fruit("���", "����"));
		list.add(new Fruit("�޷�", "�ʷ�"));
		list.add(new Fruit("����", "����"));
		list.add("���ִ� ����");
		
		for(int i = 0; i <= list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
