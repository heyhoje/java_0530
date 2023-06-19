package day13.homework.run;

import day13.homework.controler.VocabularyNoteController;

public class Run {

	public static void main(String []args) {
		VocabularyNoteController controller = new VocabularyNoteController();
		// 단어장 프로그램을 run이 실행해준다. 
		controller.run(); // controller에 있는 run메소드만 호출하면 끝
	}

}
