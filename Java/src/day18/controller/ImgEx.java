package day18.controller;

import java.util.Scanner;

public class ImgEx implements Program {

		// 2. ���ϸ��� �Է¹޾� ������ �̹������� Ȯ���ϴ� �ڵ带 �ۼ��ϼ���.
		// �̹��� Ȯ���� : jpg, bmp, png(�� ������ �����ϰ� 3���� üũ)
		/* input : dog.jpg
		 * => dog.jpg : [���] Image
		 * input : dog.exe
		 * => dog.exe : [���] Not image
		 * */
		
		private Scanner sc = new Scanner(System.in);
		private static final int EXIT = 2;
		private static final String imgs[] = {"jpg", "bmp", "png"};
	

	@Override
	public void run() {
		int menu;
		
		do {// 1. �޴� ���
			printMenu();
			menu = sc.nextInt();
			System.out.println("----------");
			// 2. �޴� ����
			runMenu(menu);
		} while(menu != EXIT);
		
		sc.close();
	}

	@Override
	public void printMenu() {
		System.out.println("----------");
		System.out.println("1. ���ϸ� �Է�");
		System.out.println("2. ����");
		System.out.print("�޴��� �����ϼ��� : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: 
			InputFileName();
			break;
		case 2:
			System.out.println("����!");
			break;
		default:
			System.out.println("�߸��� �޴��Դϴ�!");
		}
	}

	private void InputFileName() {
		// ���ϸ� �Է�
		System.out.print("���ϸ��� �Է��ϼ��� : ");
		sc.nextLine();
		String fileName = sc.nextLine();
		// Ȯ���� ����
		// �����ʺ��� �����ؼ� ó�� . �� ��ġ ã��
		int index = fileName.lastIndexOf('.');
		// �����ʿ��� ù ������ ������ Ȯ���� ����
		String suffix = fileName.substring(index+1);
		// Ȯ���ڰ� �̹����̸�
		if(checkImage(suffix)) {
			System.out.println(fileName + " : Image");
		}else {
			System.out.println(fileName + " : Not image");
		}
		
	}
	
	// Ȯ���ڰ� �̹������� �ƴ��� �˷��ִ� �޼ҵ�
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
//	 System.out.print("���ϸ��� �Է��ϼ��� : ");
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