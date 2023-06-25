package day18.controller;

import java.util.Scanner;

public class ImgEx implements Program {

		// 2. 파일명을 입력받아 파일이 이미지인지 확인하는 코드를 작성하세요.
		// 이미지 확장자 : jpg, bmp, png(더 있지만 간단하게 3개만 체크)
		/* input : dog.jpg
		 * => dog.jpg : [출력] Image
		 * input : dog.exe
		 * => dog.exe : [출력] Not image
		 * */
		
		private Scanner sc = new Scanner(System.in);
		private static final int EXIT = 2;
		private static final String imgs[] = {"jpg", "bmp", "png"};
	

	@Override
	public void run() {
		int menu;
		
		do {// 1. 메뉴 출력
			printMenu();
			menu = sc.nextInt();
			System.out.println("----------");
			// 2. 메뉴 실행
			runMenu(menu);
		} while(menu != EXIT);
		
		sc.close();
	}

	@Override
	public void printMenu() {
		System.out.println("----------");
		System.out.println("1. 파일명 입력");
		System.out.println("2. 종료");
		System.out.print("메뉴를 선택하세요 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
			InputFileName();
			break;
		case 2:
			System.out.println("종료!");
			break;
		default:
			System.out.println("잘못된 메뉴입니다!");
		}
	}

	private void InputFileName() {
		// 파일명 입력
		System.out.print("파일명을 입력하세요 : ");
		sc.nextLine();
		String fileName = sc.nextLine();
		// 확장자 추출
		// 오른쪽부터 시작해서 처음 . 의 위치 찾기
		int index = fileName.lastIndexOf('.');
		// 오른쪽에서 첫 점부터 끝까지 확장자 추출
		String suffix = fileName.substring(index+1);
		// 확장자가 이미지이면
		if(checkImage(suffix)) {
			System.out.println(fileName + " : Image");
		}else {
			System.out.println(fileName + " : Not image");
		}
		
	}
	
	// 확장자가 이미지인지 아닌지 알려주는 메소드
	private boolean checkImage(String suffix) {
		for(String img : imgs) {
			if(img.equals(suffix)) {
				return true;
			}
		}
		return false;
	}
}

// 	String fileName;
//	 Scanner sc = new Scanner(System.in);
//	 System.out.print("파일명을 입력하세요 : ");
//	 fileName = sc.nextLine();
//
//	 String str = fileName;
// 	String regex1 = "[\\w\\.]jpg$";
// 	String regex2 = "[\\w\\.]bmp$";
// 	String regex3 = "[\\w\\.]png$";
//
// 	boolean result1 = Pattern.matches(regex1, str);
// 	boolean result2 = Pattern.matches(regex2, str);
// 	boolean result3 = Pattern.matches(regex3, str);
// 	if (result1 == true||result2 == true||result3 == true) {
// 		System.out.println(str + " : Image!");
// 	}else {
//		System.out.println(str + " : Not image!");
//	 }
//
// 	sc.close();